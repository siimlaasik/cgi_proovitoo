package org.example.cgi_proovitoo.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "session_guest")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class SessionGuest {
    @Column(name = "session_id")
    private Integer sessionId;
    @Id
    @Column(name = "profile_id")
    private Integer profileId;
    @Column(name = "seat_nr")
    private Integer seatNumber;
    @Column(name = "row_nr")
    private Integer row;
    @Column(name = "user_id")
    private Integer user;
}


