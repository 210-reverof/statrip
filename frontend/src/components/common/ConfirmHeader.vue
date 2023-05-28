<template>
  <header :class="{'custom-header-onboard': isOnBoard, 'custom-header': !isOnBoard}">
    <b-navbar type="dark">
      <b-navbar-brand @click="updateOnBoard(true)" :to="{ path: '/' }">
        <img src="@/assets/common/logo_white.png" style="max-width: 100px; max-height: 60px; padding-left: 20px;" class="mr-2" />
      </b-navbar-brand>
      <b-nav class="ml-auto">
        <a @click="navigate('/home')" class="nav-link">FEED</a>
        <a @click="navigate('/plan')" class="nav-link">PLAN</a>
        <a @click="navigate('/hotspot')" class="nav-link">HOT SPOT</a>
        <a @click="navigate('/share')" class="nav-link">SHARE</a>
        <a @click="navigate('/mypage')" class="nav-link">MY PAGE</a>
        <button v-if="userInfo" class="nav-link logout-button" @click="doLogout">LOGOUT</button>
        <a @click="navigate('/auth')" v-else class="nav-link">LOGIN</a>
      </b-nav>
    </b-navbar>
  </header>
</template>

<script>
import { mapState, mapActions } from "vuex";
const userStore = "userStore";
const routerStore = "routerStore";

export default {
  name: "ConfirmHeader",
  props: {
    onBoard: {
      type: Boolean,
      required: true
    }
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
    ...mapState(routerStore, ["isOnBoard"]),
  },
  methods: {
    ...mapActions(userStore, ["userLogout"]),
    ...mapActions(routerStore, ["setOnBoard"]),

    navigate(path) {
      if (this.$route.path !== path) {
        this.$router.push(path).catch(()=>{});
      }
    },
    doLogout() {
      this.userLogout(this.userInfo.userId);
      this.updateOnBoard(false);
      alert("로그아웃 되었습니다");
    },
    updateOnBoard(isOnBoard) {
      this.setOnBoard(isOnBoard);
      console.log(isOnBoard);
    },
  },
};
</script>

<style scoped>
.custom-header {
  background-color: #323F30; /* 기본 배경색 */
  font-family: 'Hahmlet', sans-serif;
  padding-top: 10px;
  padding-bottom: 10px;
}

.custom-header-onboard {
  background-color: transparent; /* 배경색 투명으로 설정 */
  font-family: 'Hahmlet', sans-serif;
  padding-top: 10px;
  padding-bottom: 10px;
}
.nav-link {
  color: white;
  text-decoration: none;
}

.logout-button {
  background-color: transparent;
  text-decoration: none;
  font-weight: 600;
  border: none;
}

.router-link-active.nav-link {
  color: grey;
}
</style>
