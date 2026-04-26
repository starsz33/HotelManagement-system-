package org.spring.hotelmanagementsystem.service.implement;

import lombok.RequiredArgsConstructor;
import org.spring.hotelmanagementsystem.dto.BookingRequestDTO;
import org.spring.hotelmanagementsystem.dto.BookingResponseDTO;
import org.spring.hotelmanagementsystem.exception.ResourceNotFoundException;
import org.spring.hotelmanagementsystem.exception.RoomNotAvailableException;
import org.spring.hotelmanagementsystem.mapper.BookingMapper;
import org.spring.hotelmanagementsystem.models.Booking;
import org.spring.hotelmanagementsystem.models.Guest;
import org.spring.hotelmanagementsystem.models.Room;
import org.spring.hotelmanagementsystem.repository.BookingRepository;
import org.spring.hotelmanagementsystem.repository.GuestRepository;
import org.spring.hotelmanagementsystem.repository.RoomRepository;
import org.spring.hotelmanagementsystem.service.BookingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) {
        // Step 1 - Find room
        Room room = roomRepository.findById(bookingRequestDTO.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Room not found with id: " + bookingRequestDTO.getRoomId()));

        // Step 2 - Check availability
        if (!room.isAvailable()) {
            throw new RoomNotAvailableException(
                    "Room " + room.getRoomNumber() + " is not available");
        }

        // Step 3 - Find guest
        Guest guest = guestRepository.findById(bookingRequestDTO.getGuestId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Guest not found with id: " + bookingRequestDTO.getGuestId()));

        // Step 4 - Calculate total price
        long nights = ChronoUnit.DAYS.between(
                bookingRequestDTO.getCheckInDate(),
                bookingRequestDTO.getCheckOutDate()
        );
        BigDecimal totalPrice = room.getPricePerNight()
                .multiply(BigDecimal.valueOf(nights));

        // Step 5 - Build booking object
        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setGuest(guest);
        booking.setCheckInDate(bookingRequestDTO.getCheckInDate());
        booking.setCheckOutDate(bookingRequestDTO.getCheckOutDate());
        booking.setTotalPrice(totalPrice);
        booking.setStatus("CONFIRMED");

        // Step 6 - Mark room as unavailable
        room.setAvailable(false);
        roomRepository.save(room);

        // Step 7 - Save and return
        Booking savedBooking = bookingRepository.save(booking);
        return bookingMapper.toResponseDTO(savedBooking);
    }
    @Override
    public BookingResponseDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Booking not found with id: " + id));
        return bookingMapper.toResponseDTO(booking);
    }
    @Override
    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll().stream().map(bookingMapper::toResponseDTO).collect(Collectors.toList());
    }
    @Override
    public List<BookingResponseDTO> getBookingsByGuest(Long guestId) {
        if (!guestRepository.existsById(guestId)) {
            throw new ResourceNotFoundException(
                    "guest not found with id: " + guestId);
        }
        return bookingRepository.findByGuestId(guestId)
                .stream()
                .map(bookingMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponseDTO cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Booking not found with id: " + id));
        booking.setStatus("CANCELLED");
        // Step 3 - Mark room as available again
        booking.getRoom().setAvailable(true);  // mark available again
        roomRepository.save(booking.getRoom());
        // Step 4 - Save and return
        return bookingMapper.toResponseDTO(bookingRepository.save(booking));

    }
}