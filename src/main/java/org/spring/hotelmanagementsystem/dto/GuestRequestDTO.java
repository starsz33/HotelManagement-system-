package org.spring.hotelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuestRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String nationality;
    private String passportNumber;
}
