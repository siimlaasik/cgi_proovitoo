INSERT INTO movie (title, rating, genre, age_limit) VALUES
                                                        ('The Matrix', 8.5, 'Sci-Fi', 18),
                                                        ('Pulp Fiction', 9.0, 'Drama', 18),
                                                        ('The Shawshank Redemption', 9.3, 'Drama', 18),
                                                        ('Inception', 8.8, 'Sci-Fi', 12),
                                                        ('The Dark Knight', 9.0, 'Action', 12),
                                                        ('The Godfather', 9.2, 'Crime', 18),
                                                        ('Forrest Gump', 8.8, 'Drama', 12),
                                                        ('The Lord of the Rings: The Return of the King', 8.9, 'Adventure', 12),
                                                        ('The Lion King', 8.5, 'Animation', 0),
                                                        ('Titanic', 7.8, 'Romance', 12),
                                                        ('The Avengers', 8.0, 'Action', 12),
                                                        ('Jurassic Park', 7.9, 'Adventure', 12),
                                                        ('The Silence of the Lambs', 8.6, 'Thriller', 18),
                                                        ('Avatar', 7.8, 'Sci-Fi', 12),
                                                        ('The Social Network', 7.7, 'Drama', 12),
                                                        ('The Grand Budapest Hotel', 8.1, 'Comedy', 12);

INSERT INTO room (rows, seats_per_row) VALUES
                                           (10, 20),
                                           (8, 15),
                                           (12, 25),
                                           (10, 18),
                                           (6, 10);

INSERT INTO session (time, movie_id, room_id, language) VALUES
                                                            ('2023-10-15 13:00:00', 1, 1, 'English'),
                                                            ('2023-10-15 14:30:00', 2, 2, 'English'),
                                                            ('2023-10-16 15:45:00', 3, 3, 'English'),
                                                            ('2023-10-16 18:00:00', 4, 4, 'Russian'),
                                                            ('2023-10-16 19:30:00', 5, 5, 'Russian'),
                                                            ('2023-10-16 20:15:00', 6, 1, 'English'),
                                                            ('2023-10-16 21:00:00', 7, 2, 'English'),
                                                            ('2023-10-17 13:30:00', 8, 3, 'English'),
                                                            ('2023-10-17 14:45:00', 9, 4, 'Estonian'),
                                                            ('2023-10-17 16:00:00', 10, 5, 'Estonian'),
                                                            ('2023-10-25 17:30:00', 1, 1, 'English'),
                                                            ('2023-10-26 18:45:00', 2, 2, 'English'),
                                                            ('2023-10-27 20:00:00', 3, 3, 'English'),
                                                            ('2023-10-28 14:00:00', 4, 4, 'English'),
                                                            ('2023-10-29 15:15:00', 5, 5, 'English'),
                                                            ('2023-10-30 16:30:00', 6, 1, 'English');


INSERT INTO profile (first_name, last_name, password) VALUES
                                                          ('John', 'Doe', 'password123'),
                                                          ('Jane', 'Doe', 'abc123'),
                                                          ('Alice', 'Smith', 'qwerty'),
                                                          ('Bob', 'Johnson', 'letmein'),
                                                          ('Emily', 'Brown', 'pass123');

INSERT INTO session_guest (session_id, profile_id, seat_nr, row_nr) VALUES
                                                                        (1, 1, 5, 8),
                                                                        (2, 2, 7, 6),
                                                                        (3, 3, 3, 10),
                                                                        (4, 4, 9, 4),
                                                                        (5, 5, 4, 5),
                                                                        (6, 1, 10, 15),
                                                                        (7, 2, 12, 11),
                                                                        (8, 3, 6, 20),
                                                                        (9, 4, 15, 8),
                                                                        (10, 5, 8, 10),
                                                                        (11, 1, 5, 8),
                                                                        (12, 2, 7, 6),
                                                                        (13, 3, 3, 10),
                                                                        (14, 4, 9, 4),
                                                                        (15, 5, 4, 5),
                                                                        (16, 1, 8, 10),
                                                                        (17, 2, 10, 12),
                                                                        (18, 3, 12, 8),
                                                                        (19, 4, 5, 6),
                                                                        (20, 5, 9, 8);
