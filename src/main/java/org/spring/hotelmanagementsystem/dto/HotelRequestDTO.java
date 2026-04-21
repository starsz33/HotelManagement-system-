package org.spring.hotelmanagementsystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelRequestDTO {
    private String name;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private String email;
    private Integer starRating;
}
