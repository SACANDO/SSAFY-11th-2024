`default로 프로젝트 생성 후 pinia추가`

1. `src/stores/counter.js` 폴더와 파일 생성

   ```
   import { ref, computed } from 'vue'
   import { defineStore } from 'pinia'


   export const useCounterStore = defineStore('counter', () => {

   // state
   const count = ref(0)

   // getters
   const doubleCount = computed(() => count.value * 2)


   // actions
   function increment() {
       count.value++
   }

   return {
       count,
       doubleCount,
       increment }
   })
   ```

2. `main.js`에서 코드 추가

   ```
    import { createPinia} from 'pinia'
    createApp(App).use(createPinia()).mount('#app')
   ```

3. `npm install pinia` 실행
