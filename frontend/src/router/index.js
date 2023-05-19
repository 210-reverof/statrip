import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import store from "@/store";

Vue.use(VueRouter)

const onlyAuthUser = async (to, from, next) => {
  const checkUserInfo = store.getters["userStore/checkUserInfo"];
  const checkToken = store.getters["userStore/checkToken"];
  let token = sessionStorage.getItem("access-token");
  console.log("로그인 처리 전", checkUserInfo, token);

  if (checkUserInfo != null && token) {
    console.log("토큰 유효성 체크하러 가자!!!!");
    await store.dispatch("userStore/getUserInfo", token);
  }
  if (!checkToken || checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    // next({ name: "login" });
    router.push({ name: "login" });
  } else {
    console.log("로그인 했다!!!!!!!!!!!!!.");
    next();
  }
};

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/plan',
    name: 'plan',
    component: () => import(/* webpackChunkName: "plan" */ '@/views/PlanView.vue'),
    redirect: "/plan/list",
    children: [
      {
        path: 'list',
        name: 'planList',
        beforeEnter: onlyAuthUser,
        component: () => import(/* webpackChunkName: "plan" */ '@/components/plan/PlanList.vue'),
      },
      {
        path: 'add',
        name: 'planAdd',
        component: () => import(/* webpackChunkName: "plan" */ '@/components/plan/PlanAdd.vue'),
      },
      {
        path: 'plan',
        name: 'viewPlan',
        component: () => import(/* webpackChunkName: "plan" */ '@/components/plan/view/PlanView.vue'),
      }
    ]
  },
  {
    path: '/hotspot',
    name: 'hotspot',
    component: () => import(/* webpackChunkName: "hotspot" */ '@/views/HotSpotView.vue'),
    redirect: "/hotspot/list",
    children:[
      {
        path: 'list',
        name: 'hotspotList',
        component: () => import(/* webpackChunkName: "hotspotList" */ '@/components/hotspot/HotspotList.vue'),
      },
      {
        path: 'add',
        name: 'hotspotAdd',
        component: () => import(/* webpackChunkName: "hotspotAdd" */ '@/components/hotspot/HotspotAdd.vue'),
      }
    ]
  },
  {
    path: '/share',
    name: 'share',
    component: () => import(/* webpackChunkName: "share" */ '@/views/ShareView.vue'),
    redirect: "/share/list",
    children:[
      {
        path: 'list',
        name: 'shareList',
        component: () => import(/* webpackChunkName: "question" */ '@/components/share/ShareList.vue'),
      },
      {
        path: 'detail',
        name: 'shareDetail',
        component: () => import(/* webpackChunkName: "question" */ '@/components/share/ShareDetail.vue'),
      }
    ]
  },
  {
    path: '/mypage',
    name: 'mypage',
    component: () => import(/* webpackChunkName: "mypage" */ '@/views/MyPageView.vue'),
    redirect: '/mypage/main',
    children:[
      {
        path: 'main',
        name: 'myPageMain',
        component: () => import(/* webpackChunkName: "auth" */ '@/components/mypage/MyPageMain.vue'),
      },
      {
        path: 'myhot',
        name: 'myHotspotList',
        component: () => import(/* webpackChunkName: "auth" */ '@/components/mypage/MyHotspotList.vue'),
      },
      {
        path: 'myplan',
        name: 'myPlanList',
        component: () => import(/* webpackChunkName: "auth" */ '@/components/mypage/MyPlanList.vue'),
      },
      {
        path: 'myshare',
        name: 'myShareList',
        component: () => import(/* webpackChunkName: "auth" */ '@/components/mypage/MyShareList.vue'),
      }
    ]
    


  },
  {
    path: '/auth',
    name: 'auth',
    component: () => import(/* webpackChunkName: "auth" */ '@/views/AuthView.vue'),
    redirect: "/auth/login",
    children:[
      {
        path: 'login',
        name: 'login',
        component: () => import(/* webpackChunkName: "auth" */ '@/components/auth/AuthLogin'),
      },
      {
        path: 'joina',
        name: 'joina',
        component: () => import(/* webpackChunkName: "auth" */ '@/components/auth/AuthJoinA'),
      },
      {
        path: 'joinb',
        name: 'joinb',
        component: () => import(/* webpackChunkName: "auth" */ '@/components/auth/AuthJoinB'),
      }
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
