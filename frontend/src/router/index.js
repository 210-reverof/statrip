import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

import store from "@/store";
import BlankView from "@/views/BlankView.vue";

Vue.use(VueRouter);

const onlyAuthUser = async (to, from, next) => {
  const checkUserInfo = store.getters["userStore/checkUserInfo"];
  const checkToken = store.getters["userStore/checkToken"];
  let token = sessionStorage.getItem("access-token");

  // if (router.currentRoute.path != from.path) {
    
  // }

  if (checkUserInfo != null && token) {
    await store.dispatch("userStore/getUserInfo", token);
  }
  if (!checkToken || checkUserInfo === null) {
    alert("로그인이 필요합니다");
    console.log(to.path + " ------> " + from.path);
    console.log("=======" + router.currentRoute.path + "=====");
    router.push({ name: "login" }).catch(()=>{});
    // @click="$router.push({ path: `/userpage/main/${userId}` }).catch(()=>{});
  } else {
    next();
  }
};

const routes = [
  {
    path: "/",
    name: "blank",
    component: BlankView,
  },
  {
    path: "/home",
    name: "home",
    component: HomeView,
  },
  {
    path: "/plan",
    name: "plan",
    component: () => import(/* webpackChunkName: "plan" */ "@/views/PlanView.vue"),
    redirect: "/plan/list",
    children: [
      {
        path: "list",
        name: "planList",
        beforeEnter: onlyAuthUser,
        component: () => import(/* webpackChunkName: "plan" */ "@/components/plan/PlanList.vue"),
      },
      {
        path: "add",
        name: "planAdd",
        beforeEnter: onlyAuthUser,
        component: () => import(/* webpackChunkName: "plan" */ "@/components/plan/PlanAdd.vue"),
      },
      {
        path: "view/:planId",
        name: "viewPlan",
        component: () =>
          import(/* webpackChunkName: "plan" */ "@/components/plan/view/PlanView.vue"),
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
        component: () => import(/* webpackChunkName: "share" */ '@/components/share/ShareList.vue'),
      },
      {
        path: 'detail/:articleNo',
        name: 'shareDetail',
        component: () => import(/* webpackChunkName: "share" */ '@/components/share/ShareDetail.vue'),
      },
      {
        path: 'write',
        name: 'shareWrite',
        beforeEnter: onlyAuthUser,
        component: () => import(/* webpackChunkName: "share" */ '@/components/share/ShareWrite.vue'),
      }
    ]
  },
  {
    path: "/hotspot",
    name: "hotspot",
    component: () => import(/* webpackChunkName: "hotspot" */ "@/views/HotSpotView.vue"),
    redirect: "/hotspot/list",
    children: [
      {
        path: "list",
        name: "hotspotList",
        component: () =>
          import(/* webpackChunkName: "hotspotList" */ "@/components/hotspot/HotspotList.vue"),
      },
      {
        path: "add",
        name: "hotspotAdd",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(/* webpackChunkName: "hotspotAdd" */ "@/components/hotspot/HotspotAdd.vue"),
      },
    ],
  },
  {
    path: "/mypage",
    name: "mypage",
    beforeEnter: onlyAuthUser,
    component: () => import(/* webpackChunkName: "mypage" */ "@/views/MyPageView.vue"),
    redirect: "/mypage/main",
    children: [
      {
        path: "main",
        name: "myPageMain",
        component: () =>
          import(/* webpackChunkName: "auth" */ "@/components/mypage/MyPageMain.vue"),
      },
      {
        path: "myhot",
        name: "myHotspotList",
        component: () =>
          import(/* webpackChunkName: "auth" */ "@/components/mypage/MyHotspotList.vue"),
      },
      {
        path: "myplan",
        name: "myPlanList",
        component: () =>
          import(/* webpackChunkName: "auth" */ "@/components/mypage/MyPlanList.vue"),
      },
      {
        path: "myshare",
        name: "myShareList",
        component: () =>
          import(/* webpackChunkName: "auth" */ "@/components/mypage/MyShareList.vue"),
      },
    ],
  },
  {
    path: "/userpage",
    name: "userpage",
    component: () => import(/* webpackChunkName: "auth" */ "@/views/UserPageView.vue"),
    redirect: "/userpage/main",
    children: [
      {
        path: "main/:userId",
        name: "userPageMain",
        component: () =>
          import(/* webpackChunkName: "auth" */ "@/components/userpage/UserPageMain.vue"),
      },
      {
        path: "userhot",
        name: "userHotspotList",
        component: () =>
          import(/* webpackChunkName: "auth" */ "@/components/userpage/UserHotspotList.vue"),
      },
      {
        path: "userplan",
        name: "userPlanList",
        component: () =>
          import(/* webpackChunkName: "auth" */ "@/components/userpage/UserPlanList.vue"),
      },
      {
        path: "usershare",
        name: "userShareList",
        component: () =>
          import(/* webpackChunkName: "auth" */ "@/components/userpage/UserShareList.vue"),
      },
      {
        path: "userlist/:follow/:userId",
        name: "userList",
        component: () =>
          import(/* webpackChunkName: "auth" */ "@/components/userpage/UserList.vue"),

      }
    ],
  },
  {
    path: "/auth",
    name: "auth",
    component: () => import(/* webpackChunkName: "auth" */ "@/views/AuthView.vue"),
    redirect: "/auth/login",
    children: [
      {
        path: "login",
        name: "login",
        component: () => import(/* webpackChunkName: "auth" */ "@/components/auth/AuthLogin"),
      },
      {
        path: "joina",
        name: "joina",
        component: () => import(/* webpackChunkName: "auth" */ "@/components/auth/AuthJoinA"),
      },
      {
        path: "joinb",
        name: "joinb",
        component: () => import(/* webpackChunkName: "auth" */ "@/components/auth/AuthJoinB"),
      },
    ],
  },
];

const router = new VueRouter({
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach((to, from, next) => {
  store.dispatch('routerStore/setOnBoard', false);
  next();
});

export default router;
