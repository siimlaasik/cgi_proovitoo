package org.example.cgi_proovitoo.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "movie")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieGenre {
    @Id
    @Column(name = "movie_id")
    private Integer movieId;
    @Id
    @Column(name = "genre_id")
    private Integer genreId;
}
