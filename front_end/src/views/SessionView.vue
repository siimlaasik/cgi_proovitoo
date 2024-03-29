<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";
import {RouterLink, RouterView, useRoute} from "vue-router";
const session = ref();

onMounted(() => {
  const route = useRoute();
  const sessionId = route.params.sessionId;
  axios.get(`/api/session/${sessionId}`)
      .then(response => {
        if (response.data) {
          console.log(response.data);
          session.value = response.data;
        }
      })
      .catch(error => {
        console.error("Error fetching sessions:", error);
      });
});
function formatTime(timeString) {
  const date = new Date(timeString);
  return `${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}`;
}

</script>

<template>
  <div class="session-details">
    <h1>Session Details</h1>
    <div v-if="session">
      <p class="title">Movie Title: {{ session.movie.title }}</p>
      <p>{{ formatTime(session.time) }}</p>
      <p>Movie Rating: {{ session.movie.rating }}</p>
      <p>Room id: {{ session.room.roomId }}</p>
    </div>
    <div v-else>
      <p>Loading session data...</p>
    </div>
    <div class="button">
      <RouterLink :to="{ name: 'ticket', params: { sessionId: $route.query.sessionId }}">BUY TICKET</RouterLink>
    </div>
    <router-view/>
  </div>
</template>

<style scoped>
.title {
  font-size: 30px;
  font-weight: bold;
}
.button {
  background-color: #f3f2f2;
}
</style>