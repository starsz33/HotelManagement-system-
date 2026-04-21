package org.spring.hotelmanagementsystem.mapper;

import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.spring.hotelmanagementsystem.dto.RoomRequestDTO;
import org.spring.hotelmanagementsystem.dto.RoomResponseDTO;
import org.spring.hotelmanagementsystem.models.Room;

@Mapper(componentModel="spring")
public interface RoomMapper {
    Room toEntity(RoomRequestDTO roomRequestDTO);

    @Mapping(source = "hotel.id", target = "hotelId")
    @Mapping(source = "hotel.name", target = "hotelName")
    RoomResponseDTO toResponse(Room room);

}
