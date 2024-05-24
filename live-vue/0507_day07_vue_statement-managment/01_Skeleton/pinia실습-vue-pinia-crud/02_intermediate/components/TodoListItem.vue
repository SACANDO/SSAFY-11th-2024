<template>
    <div>
        <!-- <h2>TodoListItem</h2> -->
        <div class="item-card">
            <span @click="store.updateTodo(myTodo.id)" :class="{'is-done': myTodo.isDone }">{{ myTodo.text }}</span>
            <button @click="store.deleteTodo(myTodo.id)">삭제</button>
        </div>
    </div>
</template>

<script setup>
    import { useCounterStore } from '@/stores/counter'

    const props = defineProps({
        myTodo: Object
    })

    const store = useCounterStore()

    // console.log(props)

</script>

<style scoped>
    .item-card {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content:start;

        margin-bottom: 0.5rem;
    }

    .item-card > button {
        margin-left: 0.5rem;
    }

    .is-done {
        text-decoration: line-through;
    }
</style>