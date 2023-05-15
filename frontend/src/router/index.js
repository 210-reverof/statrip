import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/plan',
    name: 'plan',
    component: () => import(/* webpackChunkName: "plan" */ '@/views/PlanView.vue')
  },
  {
    path: '/hotspot',
    name: 'hotspot',
    component: () => import(/* webpackChunkName: "hotspot" */ '@/views/HotSpotView.vue'),
    redirect: "/hotspot/list",
    children:[
      {
        path: 'list',
        name: 'questionList',
        component: () => import(/* webpackChunkName: "question" */ '@/components/hotspot/HotspotList.vue'),
      }
    ]
  },
  {
    path: '/share',
    name: 'share',
    component: () => import(/* webpackChunkName: "share" */ '@/views/ShareView.vue')
  },
  {
    path: '/question',
    name: 'question',
    component: () => import(/* webpackChunkName: "question" */ '@/views/QuestionView.vue'),
    redirect: "/question/list",
    children:[
      {
        path: 'list',
        name: 'questionList',
        component: () => import(/* webpackChunkName: "question" */ '@/components/question/QuestionList.vue'),
      }
    ]
  },
  {
    path: '/mypage',
    name: 'mypage',
    component: () => import(/* webpackChunkName: "mypage" */ '@/views/MyPageView.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
