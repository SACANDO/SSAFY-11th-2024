import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UserView from '../views/UserView.vue' // 상위로 거슬러 올라가야해서 ..
import LoginView from '../views/LoginView.vue' 

const isAuthenticated = false

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView, // 내일의 나, 그리고 내일의 
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/user/:id', // :id - 매개변수는 콜론으로 표시
      namd: 'user',
      component: UserView,
      // beforeEnter: (to, from) => {
      //   console.log(to)
      //   console.log(from)
      //   // to에는 이동할 URL인 user 라우트에 대한 정보가, from에는 현재 URL인 home 라우트에 정보가 들어 있음
      //   // 다른 경로에서 user 라우트를 탐색 했을 때 실행된 것
      // }
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
      // 이미 로그인 한 상태라면 LoginView 진입을 막고 HomeView로 이동 시키기
      // 전역 가드 활용 코드는 주석 처리 후 진행
      // beforeEnter: (to, from) => {
      //   // isAuthenticated가 false면 ?
      //   if (isAuthenticated === true) {
      //     console.log('이미 로그인 상태입니다.')
      //     return { name: 'home' }
      //   }
      //   else {
      //     console.log('index.js에 가서 isAuthenticated = true 고고')
      //   }
      // }
    }
  ]
})
// index.js
// router Globally Guard 예시 
// router.beforeEach((to, from) => {
//   console.log(to)
//   console.log(from)
//   return false // 현재 네비게이션 취소
//   // return {name:'about'} // About으로 이동시키기
// })

// router 로그인 관련예시
// router.beforeEach((to, from) => {
//   const isAuthenticated = false
  
//   // 1. isAuthenticated 가 false이면 login 안된 것
//   // 2. 이동하는 주소의 이름이 login이 아니면 아무 것도 행동 못하게 
//   // isAuthenticated 가 false이면 어떤 URL을 들어가도 LoginView가 보임
//   if (!isAuthenticated && to.name !== 'login') {
//     console.log('로그인이 필요합니다.')
//     return { name: 'login' }
//   }
// })

export default router
