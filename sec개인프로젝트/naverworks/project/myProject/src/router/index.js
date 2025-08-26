import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue'),
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('../views/RegisterView.vue'),
    },
    {
      path: '/product1',
      name: 'product1',
      component: () => import('../views/Product1View.vue'),
    },
    {
      path: '/fee',
      name: 'fee',
      component: () => import('../views/FeeView.vue'),
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: () => import('../views/MyPageView.vue'),
    },
    {
      path: '/mypage2',
      name: 'mypage2',
      component: () => import('../views/MyPage2View.vue'),
    },
    {
      path: '/call',
      name: 'call',
      component: () => import('../views/CallView.vue'),
    },
  ],
})

export default router
