<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";
import { useRoute } from "vue-router";

const seats = ref();

onMounted(() => {
  const route = useRoute();
  const sessionId = route.params.sessionId;
  const ticketNr = route.query.ticketNr;

  axios.get(`/api/session/${sessionId}/seats?ticketNr=${ticketNr}`)
      .then(response => {
        if (response.data) {
          console.log(response.data);
          seats.value = response.data;
          console.log(seats.rows)
        }
      })
      .catch(error => {
        console.error("Error fetching sessions:", error);
      });
});

const isBestSeat = (row, seat) => {
  return seats.value.bestSeats.includes(seat) && seats.value.bestRow == row;
};

const isTakenSeat = (row, seat) => {
  return seats.value.takenSeats[row] && seats.value.takenSeats[row].includes(seat);
};

const isEmptySeat = (row, seat) => {
  return !isBestSeat(row, seat) && !isTakenSeat(row, seat);
};
</script>


<template>
  <div>
    <div v-if="seats" class="seat-grid">
      <div class="seat-row" v-for="row in seats.rows" :key="row">
        <div class="seat row-nr">{{ row }}</div>
        <div class="seat" v-for="seat in seats.seatNrs" :key="seat"
             :class="{ 'best-seat': isBestSeat(row, seat), 'taken-seat': isTakenSeat(row, seat), 'empty-seat': isEmptySeat(row, seat) }">
          {{ seat }}
        </div>
      </div>
    </div>
    <div v-else>
      Loading...
    </div>
  </div>
</template>


<style scoped>
.seat-grid {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.seat-row {
  display: flex;
  gap: 10px;
}

.seat {
  width: 40px;
  height: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px solid #ccc;
  cursor: pointer;
}

.best-seat {
  background-color: #ffd700; /* Yellow */
}

.taken-seat {
  background-color: #ff0000; /* Red */
}

.empty-seat {
  background-color: #00ff00; /* Green */
}

.row-nr {
  background-color: #dad3d3; /* Green */
}
</style>