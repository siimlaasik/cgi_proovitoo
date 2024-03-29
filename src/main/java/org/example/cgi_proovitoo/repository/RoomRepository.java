package org.example.cgi_proovitoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findByRoomId(Integer id);
}
