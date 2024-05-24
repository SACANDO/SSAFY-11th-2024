// index.html에서 /src/assets/style.css 가져온 것과 동일
import './assets/style.css'

import { createApp } from 'vue'

// pinia 추가됨 
import { createPinia } from 'pinia'
import App from './App.vue'

const app = createApp(App)

// createPinia 추가됨
app.use(createPinia())

app.mount('#app')


// 만약 pinia를 설치하지 않았다면..? 아래를 우리가 직접 추가해줄 수 있다. 
// 하지만 비추
// import { createPinia } from 'pinia'
// app.use(createPiniamount()).mount('app')