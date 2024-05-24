<template>
    <div>
        <span>{{ myTodo.text }} - {{ myTodo.isDone }}</span>
    </div>
</template>

<script setup>
defineProps({
    myTodo: Object,
})
</script>