package org.spring.hotelmanagementsystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDTO {
    private String roomNumber;
    private String type;// SINGLE, DOUBLE, SUITE
    private BigDecimal pricePerNight;
    private boolean available;
    private Integer capacity;
}
