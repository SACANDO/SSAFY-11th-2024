<template>
    <div>
        <h2>TodoForm</h2>
        <div class="form-card">
            <!-- 양방향 바인딩 사용해서 반응형 변수로 할당 -->
            <!-- axios 배우면 이제 form으로 전송 가능. 지금은 못해용 -->
            <form @submit.prevent="createTodo(todoText)" ref="formElem">
                <input type="text" v-model="todoText" placeholder="오늘은 무엇을 하실건가요?">
                <input type="submit">
            </form>
        </div>
    </div>
</template>

<script setup>
    import { ref } from 'vue'
    import { useCounterStore } from '@/stores/counter'

    const todoText = ref('')

    // submit 이벤트가 발생 했을 때 사용자 입력 텍스트를 인자로 전달하여 store에 정의한 addTodo 액션 메서드를 호출
    const store = useCounterStore()

    
    const createTodo = function (todoText) {
        store.addTodo(todoText)
        // 아래 추가
        formElem.value.reset()
    }
    
    // 값이 추가되면 기존의 input 태그는 원상태로 닫아줘야죠
    const formElem = ref(null)
    
</script>

<style scoped>

</style>
