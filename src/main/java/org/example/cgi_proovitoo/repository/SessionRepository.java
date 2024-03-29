package org.example.cgi_proovitoo.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    @EntityGraph(attributePaths = {"room", "movie"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT s FROM Session s WHERE s.sessionId = :id")
    Session findBySessionId(Integer id);

    @Query("SELECT s FROM Session s JOIN FETCH s.movie JOIN FETCH s.room")
    List<Session> findAllSessionsWithMoviesAndRooms();

    @Query("SELECT s FROM Session s JOIN FETCH s.movie m JOIN FETCH s.room WHERE m.genre = :genre")
    List<Session> findAllByMovieGenre(String genre);

    @Query("SELECT s FROM Session s JOIN FETCH s.movie m JOIN FETCH s.room WHERE m.ageLimit >= :ageLimit")
    List<Session> findAllByMovieAgeLimit(Integer ageLimit);

    @Query("SELECT s FROM Session s JOIN FETCH s.movie JOIN FETCH s.room")
    List<Session> findAllByLanguage(String language);

    @Query("SELECT s FROM Session s JOIN FETCH s.movie JOIN FETCH s.room")
    List<Session> findAllByTimeAfter(LocalDateTime time);

    @Query("SELECT s FROM Session s " +
            "JOIN FETCH s.movie m " +
            "JOIN SessionGuest sg ON sg.sessionId = s.sessionId " +
            "WHERE sg.profileId = :profileId")
    List<Session> findAllSessionsByProfileId(Integer profileId);

}
