package org.example.cgi_proovitoo.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "room")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "rows")
    private Integer rows;
    @Column(name = "seats_per_row")
    private Integer seatsPerRow;
}
