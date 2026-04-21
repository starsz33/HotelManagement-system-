package org.spring.hotelmanagementsystem.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.spring.hotelmanagementsystem.dto.GuestRequestDTO;
import org.spring.hotelmanagementsystem.dto.GuestResponseDTO;
import org.spring.hotelmanagementsystem.models.Guest;
@Mapper(componentModel = "spring")
public interface GuestMapper {
    Guest toEntity(GuestRequestDTO guestRequestDTO);
    GuestResponseDTO toResponse(Guest guest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(GuestRequestDTO memberRequestDTO, @MappingTarget Guest guest);
}
