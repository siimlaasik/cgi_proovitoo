package org.example.cgi_proovitoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionGuestRepository extends JpaRepository<SessionGuest, Integer> {

    List<SessionGuest> findAllByProfileId(Integer profileId);
}
