import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', () => {
  // state
  const count = ref(11)

  // getters
  const quartCount = computed(() => count.value * 4)

  // actions
  function increment() {
    count.value++
  }
  return {
    count,
    quartCount,
    increment,
  }
})
