package org.spring.hotelmanagementsystem.dto;

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
public class BookingResponseDTO {
    private Long id;
    private BigDecimal totalPrice;
    private String status;
    private Integer roomNumber;
    private String hotelName;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
