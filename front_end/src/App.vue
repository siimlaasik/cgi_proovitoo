<script setup>
import { RouterLink, RouterView } from 'vue-router'
import router from "@/router";
import {onMounted, ref} from "vue";
import axios from "axios";

</script>

<template>
  <div id="app">
    <router-view />
  </div>

</template>

<style scoped>
header {
  line-height: 1.5;
}


@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }


  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
  .session {
    padding: 10px;
    background-color: #7d8fb0;
    margin: 10px;
  }
  .sessions {
    border: 3px solid #f3f2f2;
    background-color: #b89696;
    display: flex;
    flex-direction: column;
    min-width: 500px;
  }
}
</style>
