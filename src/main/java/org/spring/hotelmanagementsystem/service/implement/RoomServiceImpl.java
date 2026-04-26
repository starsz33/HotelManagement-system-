package org.spring.hotelmanagementsystem.service.implement;

import lombok.RequiredArgsConstructor;
import org.spring.hotelmanagementsystem.dto.RoomRequestDTO;
import org.spring.hotelmanagementsystem.dto.RoomResponseDTO;
import org.spring.hotelmanagementsystem.exception.ResourceNotFoundException;
import org.spring.hotelmanagementsystem.mapper.RoomMapper;
import org.spring.hotelmanagementsystem.models.Hotel;
import org.spring.hotelmanagementsystem.models.Room;
import org.spring.hotelmanagementsystem.repository.HotelRepository;
import org.spring.hotelmanagementsystem.repository.RoomRepository;
import org.spring.hotelmanagementsystem.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    public final RoomRepository roomRepository;
    public final RoomMapper roomMapper;
    public final HotelRepository hotelRepository;

    @Override
    public RoomResponseDTO createRoom(Long hotelId, RoomRequestDTO roomRequestDTO) {

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hotel not found with id: " + hotelId));
        Room room = roomMapper.toEntity(roomRequestDTO);
        room.setHotel(hotel);
        Room savedRoom = roomRepository.save(room);
        return roomMapper.toResponse(savedRoom);
    }

    @Override
    public RoomResponseDTO getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Room not found with id: " + id));
        return roomMapper.toResponse(room);
    }

    @Override
    public List<RoomResponseDTO> getRoomsByHotel(Long hotelId) {
        if (!hotelRepository.existsById(hotelId)) {
            throw new ResourceNotFoundException(
                    "Hotel not found with id: " + hotelId);
        }
        return roomRepository.findByHotelId(hotelId)
                .stream()
                .map(roomMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomResponseDTO> getAvailableRooms(Long hotelId) {
        if (!hotelRepository.existsById(hotelId)) {
            throw new ResourceNotFoundException(
                    "Hotel not found with id: " + hotelId);
        }
        return roomRepository.findByHotelIdAndAvailable(hotelId, true)
                .stream()
                .map(roomMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoomResponseDTO updateRoom(Long id, RoomRequestDTO roomRequestDTO) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Room not found with id: " + id));
        roomMapper.updateEntity(roomRequestDTO, room);
        return roomMapper.toResponse(roomRepository.save(room));
    }

    @Override
    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id))
            throw new ResourceNotFoundException(
                    "Room not found with id: " + id);
        roomRepository.deleteById(id);
    }

}

