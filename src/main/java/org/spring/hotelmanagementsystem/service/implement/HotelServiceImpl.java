package org.spring.hotelmanagementsystem.service.implement;

import lombok.RequiredArgsConstructor;
import org.spring.hotelmanagementsystem.dto.HotelRequestDTO;
import org.spring.hotelmanagementsystem.dto.HotelResponseDTO;
import org.spring.hotelmanagementsystem.exception.ResourceNotFoundException;
import org.spring.hotelmanagementsystem.mapper.HotelMapper;
import org.spring.hotelmanagementsystem.models.Hotel;
import org.spring.hotelmanagementsystem.repository.HotelRepository;
import org.spring.hotelmanagementsystem.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    public final HotelRepository hotelRepository;
    public final HotelMapper hotelMapper;

    @Override
    public HotelResponseDTO createHotel(HotelRequestDTO hotelRequestDTO){
        Hotel hotel=hotelMapper.toEntity(hotelRequestDTO);
        Hotel savedHotel=hotelRepository.save(hotel);
        return hotelMapper.toResponse(savedHotel);
    }
    @Override
    public HotelResponseDTO getHotelById(Long Id){
        Hotel hotel = hotelRepository.findById(Id).orElseThrow(() ->
                new ResourceNotFoundException("Hotel not found with id: " + Id));
        return hotelMapper.toResponse(hotel);
    }
    @Override
    public List<HotelResponseDTO> getAllHotels(){
        return hotelRepository.findAll().stream().map(hotelMapper::toResponse).collect(Collectors.toList());
    }
    @Override
    public HotelResponseDTO updateHotel(Long id, HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Hotel not found with id: " + id));
        hotelMapper.updateEntity(hotelRequestDTO, hotel);
        return hotelMapper.toResponse(hotelRepository.save(hotel));
    }
    @Override
    public void deleteHotel(Long id){
        if(!hotelRepository.existsById(id))throw
                new ResourceNotFoundException("Hotel not found"+ id);
        hotelRepository.deleteById(id);
    }
}
