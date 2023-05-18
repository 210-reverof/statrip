<template>
  <div class="auth-login">
    <h2>Login</h2>
    <h5>로그인</h5>
    <hr />
    <div class="form-size">
      <b-row >
        <b-col cols="9">
          <div class="form-group">
            <label for="username">ID</label>
            <input
              type="text"
              class="form-control"
              id="username"
              v-model="username"
            />
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input
              type="password"
              class="form-control"
              id="password"
              v-model="password"
            />
          </div>
        </b-col>
        <b-col cols="3" >
            <div class="btn-pos">
          <div class="login-btn" @click="submit()">Login</div>
            </div>
        </b-col>
      </b-row>
      <h6 class="join-link" @click="$router.push('/auth/joina')">
      아직 회원이 아니신가요?
    </h6>
    <hr>
    <div>
        <b-row>
            <b-col>간편로그인</b-col>
            <b-col>아이콘</b-col>
            <b-col>아이콘</b-col>
            <b-col>아이콘</b-col>
        </b-row>
    </div>
    </div>

    
  </div>
</template>


<script>
export default {
  name: "AuthLogin",
  data() {
    return {
      id: "",
      password: "",
      username: "",
    };
  },
  methods: {
    submitForm() {
      this.id = "";
      this.password = "";
    },
    submit() {
        console.log("llllllllll")
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

.form-size{
  margin: 0 auto;
    width: 30%;
    height: 600px;
}

.form-group{
    text-align: left;
}

.btn-pos{
    margin-top: 28px;
}

.login-btn {
  border: 1px solid;
  height: 129px;
  max-width: 150px;
  border-color: #323F30;
  background-color: #323F30;
  border-radius: 5%;
  text-align: center;
  color: white;
  font-size: 20px;
  padding : 50px 0;
}
.login-btn:hover{
     opacity: 1.0;
  background-color: #375432;
  cursor: pointer;
}
</style>