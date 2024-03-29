package org.example.cgi_proovitoo.mapper;

import org.example.cgi_proovitoo.controller.dto.RoomSizeDto;
import org.example.cgi_proovitoo.repository.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room roomSizeDtotoRoom(RoomSizeDto roomSizeDto);
    RoomSizeDto roomToRoomSizeDto(Room room);
}
