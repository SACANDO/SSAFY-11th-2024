import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// store 
export const useCounterStore = defineStore('counter', () => { 
    // 저장소 ! 여기다가 모든 state, getters, actions을 정의하면된다
    // id 올려줄 것. 순서
    let id = 1

    // 내가 진짜 할일 들 
    const todos = ref([
        { id: id++, text: '보충하기', isDone: false },
        { id: id++, text: '점심먹기', isDone: false },
        { id: id++, text: '실습하기', isDone: false },
        { id: id++, text: '퇴근하기', isDone: false },
    ]) 

    // action
    const createTodo = function (todoText) { 
        todos.value.push({
            id: id++, 
            text: todoText,
            isDone: false,
        })
    } 

    return {
        todos,
        createTodo,
    }
})