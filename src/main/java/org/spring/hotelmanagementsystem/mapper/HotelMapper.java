package org.spring.hotelmanagementsystem.mapper;

import org.mapstruct.*;
import org.spring.hotelmanagementsystem.dto.GuestRequestDTO;
import org.spring.hotelmanagementsystem.dto.HotelRequestDTO;
import org.spring.hotelmanagementsystem.dto.HotelResponseDTO;
import org.spring.hotelmanagementsystem.models.Guest;
import org.spring.hotelmanagementsystem.models.Hotel;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    Hotel toEntity(HotelRequestDTO hotelRequestDTO);
    HotelResponseDTO toResponse(Hotel hotel);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(HotelRequestDTO hotelRequestDTO, @MappingTarget Hotel hotel);
}
