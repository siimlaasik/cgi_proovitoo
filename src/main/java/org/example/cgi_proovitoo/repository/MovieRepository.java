package org.example.cgi_proovitoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieId(Integer id);
}
