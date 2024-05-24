<template>
  <div>
    <h1>UserView입니다.</h1>
    <!-- $route.param 으로 가져오기 -->
    <p>{{ $route.params.id }} 번 유저입니다.</p>
    <p>{{ userId }} 번 유저입니다.</p>

    <button @click="goHome">집으로</button>

    <button @click="foreverAtHome">평생집에만있으세요...</button>

  </div>
</template>

<script setup>
  // composition API 방식!
  import { ref } from 'vue'
  import { useRoute, useRouter } from 'vue-router'

  const route = useRoute()
  const userId = ref(route.params.id) // $route.params.id 와 동일

  const router = useRouter()
  const goHome = () => {
    router.push({ name: 'home' })
  }

  const foreverAtHome = () => {
    router.replace({ name: 'home' })
  }
</script>


