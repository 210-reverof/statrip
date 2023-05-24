<template>
  <div class="auth-login">
    <h2>Login</h2>
    <h5>로그인</h5>
    <hr />
    <div class="form-size">
      <b-row>
        <b-col cols="9">
          <div class="form-group">
            <label for="아이디">ID</label>
            <input type="text" class="form-control" id="username" v-model="user.userId" />
          </div>
          <div class="form-group">
            <label for="비밀번호">Password</label>
            <input type="password" class="form-control" id="password" v-model="user.password" />
          </div>
        </b-col>
        <b-col cols="3">
          <div class="btn-pos">
            <div class="login-btn" @click="confirm()">Login</div>
          </div>
        </b-col>
      </b-row>
      <h6 class="join-link" @click="$router.push('/auth/joina')">아직 회원이 아니신가요?</h6>
      <hr />
      <div>
        <b-row>
          <b-col>간편로그인</b-col>
          <b-col><img :src="require('@/assets/auth/login_naver.png')" width="40px" height="40px" /></b-col>
          <b-col><img :src="require('@/assets/auth/login_goole.png')" width="40px" height="40px" /></b-col>
          <b-col><img :src="require('@/assets/auth/login_kakao.png')" width="40px" height="40px" /></b-col>
        </b-row>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
const userStore = "userStore";

export default {
  name: "AuthLogin",
  data() {
    return {
      user: {
        userId: null,
        password: null,
      },
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(userStore, ["userConfirm", "getUserInfo"]),

    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");

      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "home" });
      }
    },
  },
};
</script>

<style scoped>
.auth-login {
  align-items: center;
  width: 80%;
  margin: 0 auto;
}

.join-link {
  margin-top: 60px;
  margin-bottom: 60px;
  text-decoration: underline;
  cursor: pointer;
}

.form-size {
  margin: 0 auto;
  width: 30%;
  height: 600px;
}

.form-group {
  text-align: left;
}

.btn-pos {
  margin-top: 28px;
}

.login-btn {
  border: 1px solid;
  height: 129px;
  max-width: 150px;
  border-color: #323f30;
  background-color: #323f30;
  border-radius: 5%;
  text-align: center;
  color: white;
  font-size: 20px;
  padding: 50px 0;
}
.login-btn:hover {
  opacity: 1;
  background-color: #375432;
  cursor: pointer;
}
</style>
