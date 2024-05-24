<script setup>
  import TodoForm from '@/components/TodoForm.vue'
  import TodoList from '@/components/TodoList.vue'

  import { useCounterStore } from '@/stores/counter'

  const store = useCounterStore()
</script>

<template>
  <h1>Todo Project</h1>
  <h2>완료한 Todo: {{ store.doneTodosCount }}</h2>
  <TodoList />
  <TodoForm />
  <!-- 껍데기 만들어놓고 반드시 실행시켜서 잘 보이는지 절대 확인필요 -->
</template>
