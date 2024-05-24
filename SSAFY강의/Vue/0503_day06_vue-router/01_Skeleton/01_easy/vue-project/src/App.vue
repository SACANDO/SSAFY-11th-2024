<script setup>
  import { ref } from 'vue'
  import { RouterLink, RouterView } from 'vue-router'

  const userId = ref(1)
</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <nav>
        <!-- to attributes routes  -->
        <RouterLink :to="{ name: 'home' }">Home</RouterLink>
        <RouterLink :to="{ name: 'about' }">About</RouterLink>
        <RouterLink :to="{ name: 'login' }">Login</RouterLink>

        <!-- name routes with props  -->
        <!-- <RouterLink :to="{ name: 'home'}">Home</RouterLink> -->
        <!-- <RouterLink :to="{ name: 'about'}">About</RouterLink> -->
      </nav>
    </div>
  </header>
  <!-- main태그 지워주세요 -->
  <RouterView />
</template>

<style scoped>
  /* style 지워주세요 */
</style>
