CREATE TABLE movie (
                       movie_id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       rating FLOAT,
                       genre VARCHAR(255),
                       age_limit SMALLINT
);

CREATE TABLE room (
                      room_id SERIAL PRIMARY KEY,
                      rows INT NOT NULL,
                      seats_per_row INT NOT NULL
);

CREATE TABLE session (
                         session_id SERIAL PRIMARY KEY,
                         time DATE NOT NULL,
                         movie_id INT NOT NULL,
                         room_id INT NOT NULL,
                         language VARCHAR(20),
                         FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
                         FOREIGN KEY (room_id) REFERENCES room(room_id)
);


CREATE TABLE profile (
                         profile_id SERIAL PRIMARY KEY,
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         password VARCHAR(255) NOT NULL
);


CREATE TABLE session_guest (
                               session_id INT NOT NULL,
                               profile_id INT NOT NULL,
                               seat_nr INT NOT NULL,
                               row_nr INT NOT NULL,
                               PRIMARY KEY (session_id, profile_id, seat_nr, row_nr),
                               FOREIGN KEY (profile_id) REFERENCES profile(profile_id)
);
