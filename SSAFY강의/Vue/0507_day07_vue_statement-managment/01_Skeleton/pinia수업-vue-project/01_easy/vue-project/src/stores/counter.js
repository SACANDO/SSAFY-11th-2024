import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// store: defineStore <- 그 자체
// 중앙 저장소 
// 모든 컴포넌트가 공유하는 상태, 기능 등이 작성됨
export const useCounterStore = defineStore('counter', () => {
  
  // state 
  // 반응형 데이터 (상태)
  // ref() == state
  const count = ref(11)

  // getters 
  // 계산된 값
  // computed() === getters
  const doubleCount = computed(() => count.value * 2)
  const tripleCount = computed(() => count.value * 3)


  // actions 
  // 메서드 
  // 메서드 그 자체가 action
  function increment() {
    count.value++
  }

  return { 
    count, 
    doubleCount, 
    tripleCount,
    increment }
})
