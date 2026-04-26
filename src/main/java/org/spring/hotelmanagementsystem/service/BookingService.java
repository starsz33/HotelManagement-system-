package org.spring.hotelmanagementsystem.service;

import org.spring.hotelmanagementsystem.dto.BookingRequestDTO;
import org.spring.hotelmanagementsystem.dto.BookingResponseDTO;

import java.util.List;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO);
    BookingResponseDTO getBookingById(Long id);
    List<BookingResponseDTO> getAllBookings();
    List<BookingResponseDTO> getBookingsByGuest(Long guestId);
    BookingResponseDTO cancelBooking(Long id);
}
