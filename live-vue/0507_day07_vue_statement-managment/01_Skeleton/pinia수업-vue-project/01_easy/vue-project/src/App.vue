<script setup>
  import {  useCounterStore } from '@/stores/counter'
  
  const store = useCounterStore()

  // state 참조 및 변경
  // stores/counter.js에 count가 정의되어 있음
  // SO!!! useCounterStore을 store 인스턴스로 만들어서 
  //  state 그 자체인 count에 접근해서 직접 읽고 쓸 수 있었다~
  //  주의) 만약 count가 state로 정의되지 않으면 컴포넌트에 추가 불가입니다.
  console.log(store.count)
  const newNumber = store.count + 1
  console.log(newNumber) // 12, store.count가 11이였어서

  // getters
  console.log(store.doubleCount)
  console.log(store.tripleCount)

  // actions 호출 
  // store.increment() // 없어도 잘 동작함
</script>

<template>
  <div>
    <!-- state -->
    <p>state: {{ store.count }}</p>

    <!-- getters -->
    <p>getters: {{ store.doubleCount }}</p>

    <!-- actions -->
    <button @click="store.increment()">+</button>
  </div>
</template>

<style scoped>

</style>
