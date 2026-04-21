package org.spring.hotelmanagementsystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingRequestDTO {
    private Long roomId;         // ← which room to book
    private Long guestId;        // ← which guest is booking
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
