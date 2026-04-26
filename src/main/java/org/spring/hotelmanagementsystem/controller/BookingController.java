package org.spring.hotelmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.spring.hotelmanagementsystem.dto.BookingRequestDTO;
import org.spring.hotelmanagementsystem.dto.BookingResponseDTO;
import org.spring.hotelmanagementsystem.dto.RoomRequestDTO;
import org.spring.hotelmanagementsystem.dto.RoomResponseDTO;
import org.spring.hotelmanagementsystem.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
   private final BookingService bookingService;
    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
    @GetMapping("/guest/{guestId}")
    public ResponseEntity<List<BookingResponseDTO>> getBookingsByGuest(@PathVariable Long guestId) {
        return ResponseEntity.ok(bookingService.getBookingsByGuest(guestId));
    }
    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookingService.createBooking(bookingRequestDTO));
    }
    @PutMapping("/{id}/cancel")
    public ResponseEntity<BookingResponseDTO> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }
}
