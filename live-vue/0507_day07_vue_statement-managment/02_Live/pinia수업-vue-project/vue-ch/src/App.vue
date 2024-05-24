<script setup>
  import { useCounterStore } from '@/stores/counter'

  const store = useCounterStore()
  console.log(store)
  console.log(store.count)
  console.log(store.quartCount)
  
</script>

<template>
  <h1>Jihye Oi</h1>

  <!-- state -->
  <p>state: {{ store.count }}</p>

  <!-- getters -->
  <p>getters: {{ store.quartCount }}</p>

  <!-- action -->
  <button @click="store.increment()">+1</button>

</template>

<style scoped>

</style>
