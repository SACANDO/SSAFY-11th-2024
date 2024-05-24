import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// store: defineStore <- 그 자체
// 중앙 저장소 
// 모든 컴포넌트가 공유하는 상태, 기능 등이 작성됨
export const useCounterStore = defineStore('counter', () => {
  
  // state 
  let id = 0

  // todo 판만들기
  const todos = ref([
    { id: id++, text: '할일 1', isDone: false },
    { id: id++, text: '할일 2', isDone: false },
  ])

  
  // actions 
  // todo create
  const addTodo = function(todoText) {
    todos.value.push({
      id: id++,
      text: todoText,
      isDone: false,
    })
    console.log('create done')
  }
  
  // todo delete
  const deleteTodo = function(todoId) {
    console.log(`${todoId} delete done`) 
    
    // 몇번을 지울 지, 그 todo의 인덱스를 구해서 
    const index = todos.value.findIndex((todo) => todo.id === todoId)
    // 잘라버리기
    todos.value.splice(index, 1)
  }
  
  // todo update
  const updateTodo = function(todoId) {
    console.log(`${todoId} update done`) 
    
    todos.value = todos.value.map((todo) => {
      if(todo.id === todoId) {
        todo.isDone = !todo.isDone
      }
      return todo
    })
  }
  
  // getters 

  // todo 다 한 개수 반환
  const doneTodosCount = computed(() => {
    return todos.value.filter((todo) => todo.isDone).length
  })


  return { 
    // don't forget your return!!
    todos, 
    addTodo,
    deleteTodo,
    updateTodo,
    doneTodosCount,
  }
}, { persist: true })
