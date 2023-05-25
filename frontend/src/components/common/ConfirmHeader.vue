<template>
  <header :class="{'custom-header-onboard': isOnBoard, 'custom-header': !isOnBoard}">
    <b-navbar type="dark">
      <b-navbar-brand @click="updateOnBoard(true)" to="/">
        <img src="@/assets/common/logo_white.png" style="max-width: 100px; max-height: 60px; padding-left: 20px;" class="mr-2" />
      </b-navbar-brand>
      <b-nav class="ml-auto">
        <router-link @click="updateOnBoard(false)" to="/home" class="nav-link">FEED</router-link>
        <router-link @click="updateOnBoard(false)" to="/plan" class="nav-link">PLAN</router-link>
        <router-link @click="updateOnBoard(false)" to="/hotspot" class="nav-link">HOT SPOT</router-link>
        <router-link @click="updateOnBoard(false)" to="/share" class="nav-link">SHARE</router-link>
        <router-link @click="updateOnBoard(false)" to="/mypage" class="nav-link">MY PAGE</router-link>
        <button v-if="userInfo" class="nav-link logout-button" @click="doLogout">LOGOUT</button>
        <router-link @click="updateOnBoard(false)" v-else to="/auth" class="nav-link">LOGIN</router-link>
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
