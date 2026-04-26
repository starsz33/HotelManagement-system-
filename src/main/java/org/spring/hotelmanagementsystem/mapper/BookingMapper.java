package org.spring.hotelmanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.spring.hotelmanagementsystem.dto.BookingRequestDTO;
import org.spring.hotelmanagementsystem.dto.BookingResponseDTO;
import org.spring.hotelmanagementsystem.models.Booking;
@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking toEntity(BookingRequestDTO dto);
    @Mapping(source = "room.roomNumber", target = "roomNumber")
    @Mapping(source = "room.hotel.name", target = "hotelName")
    @Mapping(expression = "java(booking.getGuest().getFirstName() + ' ' + booking.getGuest().getLastName())", target = "guestName")
    BookingResponseDTO toResponseDTO(Booking booking);
}
