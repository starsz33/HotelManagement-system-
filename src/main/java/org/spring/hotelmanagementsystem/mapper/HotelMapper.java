package org.spring.hotelmanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.spring.hotelmanagementsystem.dto.HotelRequestDTO;
import org.spring.hotelmanagementsystem.dto.HotelResponseDTO;
import org.spring.hotelmanagementsystem.models.Hotel;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    Hotel toEntity(HotelRequestDTO hotelRequestDTO);
    HotelResponseDTO toResponse(Hotel hotel);

}
