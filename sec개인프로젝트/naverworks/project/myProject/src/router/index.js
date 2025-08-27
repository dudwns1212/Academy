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
      path: '/product',
      name: 'product',
      component: () => import('../views/ProductDetailView.vue'),
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
    {
      path: '/detail',
      name: 'detail',
      component: () => import('../views/DetailView.vue'),
    },
    {
      path: '/postwrite',
      name: 'postwrite',
      component: () => import('../views/PostWriteView.vue'),
    },
    {
      path: '/edit',
      name: 'edit',
      component: () => import('../views/EditContent.vue'),
    },
  ],
})

export default router
