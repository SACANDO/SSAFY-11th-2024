import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import YoutubeView from '@/views/YoutubeView.vue'
import BoardView from '@/views/BoardView.vue'

import BoardCreate from '@/components/board/BoardCreate.vue'
import BoardList from '@/components/board/BoardList.vue'
import BoardUpdate from '@/components/board/BoardUpdate.vue'
import BoardDetail from '@/components/board/BoardDetail.vue'

import KakaoView from '@/views/KakaoView.vue'

import TmdbView from '@/views/TmdbView.vue'
import TmdbPopular from '@/components/tmdb/TmdbPopular.vue'
import TmdbTopRated from '@/components/tmdb/TmdbTopRated.vue'
import UserLogin from '@/components/user/UserLogin.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/youtube',
      name: 'youtube',
      component: YoutubeView
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      children: [
        {
          path: '',
          name: 'boardList',
          component: BoardList
        },
        {
          path: 'create',
          name: 'boardCreate',
          component: BoardCreate
        },
        {
          path: 'update',
          name: 'boardUpdate',
          component: BoardUpdate
        },
        {
          path: ':id',
          name: 'boardDetail',
          component: BoardDetail
        },
      ]
    },
    {
      path: "/kakao",
      name: "kakao",
      component: KakaoView
    },
    {
      path: "/tmdb",
      name: "tmdb",
      component: TmdbView,
      children: [
        {
          path: "popular",
          name: "tmdbPopular",
          component: TmdbPopular
        },
        {
          path: "toprated",
          name: "tmdbTopRated",
          component: TmdbTopRated
        }
      ]
    },
    {
      path: "/login",
      name: "login",
      component: UserLogin
    }
  ]
})

export default router
