package org.spring.hotelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HotelResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private String email;
    private Integer starRating;
}
