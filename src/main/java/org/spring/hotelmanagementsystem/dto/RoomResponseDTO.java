package org.spring.hotelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Builder;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDTO {
    private Long id;
    private String roomNumber;
    private String type;
    private BigDecimal pricePerNight;
    private boolean available;
    private Integer capacity;
    private Long hotelId;
    private String hotelName;
}
