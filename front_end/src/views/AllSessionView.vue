<script setup>
import axios from "axios";
import {onMounted, ref} from "vue";
import {RouterLink, RouterView} from "vue-router";

const sessions = ref([]);
const genreFilter = ref(null);
const ageLimitFilter = ref(null);
const languageFilter = ref(null);
const timeFilter = ref(null);
const number = ref(0);

const fetchSessions = () => {
  const params = {};
  if (genreFilter.value) {
    params.genre = genreFilter.value;
  }
  if (ageLimitFilter.value) {
    params.ageLimit = ageLimitFilter.value;
  }
  if (languageFilter.value) {
    params.language = languageFilter.value;
  }
  if (timeFilter.value) {
    params.time = languageFilter.value;
  }

  axios.get("/api", { params })
      .then(response => {
        if (response.data) {
          sessions.value = response.data;
        }
      })
      .catch(error => {
        console.error("Error fetching sessions:", error);
      });
};

onMounted(fetchSessions);
const applyFilters = () => {
  fetchSessions();
};

function increment() {
  number.value++;
}

function decrement() {
  if (number.value > 0) {
    number.value--;
  }
}
function formatTime(timeString) {
  const date = new Date(timeString);
  return `${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}`;
}


</script>
<template>
  <div class="about">
    <div class="filters">
      <div>
        <label for="genre">Genre:</label>
        <input id="genre" v-model="genreFilter" @input="applyFilters" />
      </div>
      <div>
        <label for="ageLimit">Age Limit:</label>
        <input id="ageLimit" type="number" v-model="ageLimitFilter" @input="applyFilters" />
      </div>
      <div>
        <label for="language">Language:</label>
        <input id="language" v-model="languageFilter" @input="applyFilters" />
      </div>
      <div>
        <label for="time">Time:</label>
        <input id="time" v-model="timeFilter" @input="applyFilters" />
      </div>
      <div class="buttons">
        <button @click="increment">Add +1</button>
        <button @click="decrement">Remove -1</button>
        <p>Current User: {{ number }}</p>
        <div class="button">
        <RouterLink :to="{ name: 'suggestedMovies', params: { profileId: number }}">
          Check suggested movies
        </RouterLink>
        </div>
      </div>
    </div>

    <div class="sessions">
      <div v-for="session in sessions" class="session">
        <router-link :to="{ name: 'session', params: { sessionId: session.sessionId }}">
          <div class="title">{{ session.movie.title }}</div>
          <div>{{ formatTime(session.time) }}</div>
          <div>Genre: {{ session.movie.genre }}</div>
          <div>Movie Rating: {{ session.movie.rating }}</div>
          <div>Language: {{ session.language }}</div>
        </router-link>
      </div>
    </div>
  </div>
  <router-view/>
</template>

<style scoped>
@media (min-width: 1024px) {
  .about {
    display: flex;
    align-items: center;
  }

  .filters {
    margin-bottom: 10px;
  }

  .filters div {
    margin-right: 10px;
  }

  .session {
    padding: 10px;
    background-color: #f3f2f2;
    margin: 10px;
  }

  .sessions {
    border: 3px solid #ffffff;
    background-color: #ffffff;
    display: flex;
    flex-direction: column;
    min-width: 500px;
  }
  .title {
    font-size: 30px;
    font-weight: bold;
  }
  .button {
    background-color: #f3f2f2;
  }
  .buttons {
    margin-top: 30px
  }
}
</style>
