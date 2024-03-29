<script setup>
import {ref} from "vue";
import {RouterLink, RouterView} from "vue-router";

const number = ref(0);
function increment() {
  number.value++;
}

function decrement() {
  if (number.value > 0) {
    number.value--;
  }
}


</script>

<template>
  <div class="container">
    <div>
      <button @click="increment">Add +1</button>
      <button @click="decrement">Remove -1</button>
    </div>
    <p>Current Number: {{ number }}</p>
    <div class="button">
      <RouterLink :to="{ name: 'seats', params: { sessionId: $route.query.sessionId }, query: { ticketNr: number }}">
        Go to Seats
      </RouterLink>
    </div>

    <router-view/>
  </div>
</template>

<style scoped>
.container{
  margin-top: 20px;
}
.button {
  background-color: #f3f2f2;
}
</style>