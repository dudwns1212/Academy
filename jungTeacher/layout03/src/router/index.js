import { createRouter, createWebHistory } from 'vue-router'
import AnimalList from '../views/AnimalList.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'animal-list',
      component: AnimalList,
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue'),
    },
    {
      path: '/add',
      name: 'add',
      component: () => import('../views/AnimalAdd.vue'),
    },
  ],
})

export default router
