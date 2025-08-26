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
      path: '/product2',
      name: 'product2',
      component: () => import('../views/Product2View.vue'),
    },
    {
      path: '/solution1',
      name: 'solution1',
      component: () => import('../views/Solution1View.vue'),
    },
    {
      path: '/solution2',
      name: 'solution2',
      component: () => import('../views/Solution2View.vue'),
    },
    {
      path: '/fee',
      name: 'fee',
      component: () => import('../views/FeeView.vue'),
    },
    {
      path: '/header',
      name: 'header',
      component: () => import('../views/HeaderView.vue'),
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
      path: '/doip',
      name: 'doip',
      component: () => import('../views/DoipView.vue'),
    },
    {
      path: '/info',
      name: 'info',
      component: () => import('../views/InfoView.vue'),
    },
    {
      path: '/call',
      name: 'call',
      component: () => import('../views/CallView.vue'),
    },
  ],
})

export default router
