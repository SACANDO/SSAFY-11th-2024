// main.js 에서 정석 소스들을 가져올 것!
import './assets/style.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'

const app = createApp(App)

app.use(createPinia())

app.mount('#app')

// createApp(App).use(createPinia()).mount('#app')
