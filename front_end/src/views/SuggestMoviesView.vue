<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";
import { useRoute } from "vue-router";

const movies = ref();
const route = useRoute();

onMounted(() => {
  const profileId = route.params.profileId;
  axios.get(`/api/${profileId}`)
      .then(response => {
        if (response.data) {
          console.log(response.data);
          movies.value = response.data;
        }
      })
      .catch(error => {
        console.error("Error fetching movie:", error);
      });
});
</script>

<template>
  <div>
    <h1>Suggested movies for you</h1>
    <div v-for="movie in movies" :key="movie.id">
      <h2>{{ movie.title }}</h2>
      <p><strong>Rating:</strong> {{ movie.rating }}</p>
      <p><strong>Genre:</strong> {{ movie.genre }}</p>
      <p><strong>Age Limit:</strong> {{ movie.ageLimit }}</p>
    </div>
    <div v-if="movies.length === 0">
      <p>No movies found.</p>
    </div>
  </div>
</template>


<style scoped>
/* Add scoped styles if needed */
</style>
