import './assets/style.css'
// piniaPluginPersistedState
import piniaPluginPersistedState from 'pinia-plugin-persistedstate'

// pinia import 
import { createPinia} from 'pinia'
import { createApp } from 'vue'
import App from './App.vue'


const app = createApp(App)
// pinia persisted state
const pinia = createPinia()

// app.use(createPinia())

// createPinia('app') -> mount('#app) 
// createApp(App).use(createPinia()).mount('#app')


pinia.use(piniaPluginPersistedState)
app.use(pinia)
app.mount('#app')
