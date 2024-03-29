package org.example.cgi_proovitoo.service.generator;

import lombok.Getter;
import lombok.Setter;
import org.example.cgi_proovitoo.controller.dto.SessionGuestDto;

import java.util.*;


@Getter
@Setter
public class SeatGenerator {
    private final Integer rows;
    private final Integer seatsPerRow;
    private final List<SessionGuestDto> sessionGuestDtos = new ArrayList<>();
    private final Random random;
    private final HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    private Integer bestRow;
    private List<Integer> bestSeats = new ArrayList<>();


    public SeatGenerator(Integer rows, Integer seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.random = new Random();
    }
    private void generateSeats() {
        fillMap();
        Random random = new Random();
        int numTakenSeats = random.nextInt((int)(rows * seatsPerRow * 0.1)) + (int)(rows * seatsPerRow * 0.6);
        int middleRow = rows / 2 + 1;

        for (int i = 0; i < numTakenSeats; i++) {
            int row = (int) (middleRow + random.nextGaussian() * rows / 6);
            row = Math.max(1, Math.min(rows, row));

            int middleSeat = seatsPerRow / 2 + 1;
            int seat = (int) (middleSeat + random.nextGaussian() * seatsPerRow / 6);
            seat = Math.max(1, Math.min(seatsPerRow, seat));

            map.get(row).add(seat);
        }
    }

    public void findBestSeats(int ticketNr) {
        int middleRow = rows / 2 + 1;
        int middleSeat = seatsPerRow / 2 + 1;
        bestRow = -1;
        int bestScore = Integer.MAX_VALUE;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= seatsPerRow - ticketNr + 1; j++) {
                int score = Math.abs(i - middleRow) + Math.abs(j - middleSeat);
                if (score < bestScore && areSeatsAvailable(i, j, ticketNr)) {
                    updateBestSeats(i, j, ticketNr);
                    bestScore = score;
                }
            }
        }
    }

    private boolean areSeatsAvailable(int row, int startSeat, int ticketNr) {
        for (int k = startSeat; k < startSeat + ticketNr; k++) {
            if (map.get(row).contains(k)) {
                return false;
            }
        }
        return true;
    }

    private void updateBestSeats(int row, int startSeat, int ticketNr) {
        bestRow = row;
        bestSeats.clear();
        for (int k = startSeat; k < startSeat + ticketNr; k++) {
            bestSeats.add(k);
        }
    }

    private void fillMap() {
        for (int i = 1; i <= rows; i++) {
            HashSet<Integer> set = new HashSet<>();
            map.put(i, set);
        }
    }

    public SessionGuestDto generateDto(Integer tickerNr) {
        generateSeats();
        findBestSeats(tickerNr);
        return new SessionGuestDto(rows, seatsPerRow, map, bestSeats, bestRow);
    }
}
