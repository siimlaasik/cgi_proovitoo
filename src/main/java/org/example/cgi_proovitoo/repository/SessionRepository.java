package org.example.cgi_proovitoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    Session findBySessionId(Integer id);
}
