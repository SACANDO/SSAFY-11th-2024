import './assets/style.css'
import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'

// const app = createApp(App)

createApp(App).use(createPinia()).mount('#app')

// createPinia()
// createApp(App).mount('#app')
