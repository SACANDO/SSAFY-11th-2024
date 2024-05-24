<template>
    <div>
        <TodoListItem 
            v-for="todo in store.todos"
            :key="todo.id"
            :my-todo = "todo"
        />
    </div>
</template>

<script setup>
    import TodoListItem from '@/components/TodoListItem.vue'

    // counter 활용
    import { useCounterStore } from '@/stores/counter'
    const store = useCounterStore() 
    // 사실 객체 store로 만들 필요 없지만 우리는 찍어볼거니깐 
    // console.log(store) // 파인애플 나옵니다! 귀여워요, 꼭 확인해보시길
</script>