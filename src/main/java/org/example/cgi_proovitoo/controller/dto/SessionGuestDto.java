package org.example.cgi_proovitoo.controller.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public record SessionGuestDto(Integer rows, Integer seatNrs, HashMap<Integer, HashSet<Integer>> takenSeats,
                              List<Integer> bestSeats, Integer bestRow) {
}
