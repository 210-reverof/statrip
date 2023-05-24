<template>
  <div class="auth-login">
    <h2>Join</h2>
    <h5>회원가입</h5>
    <hr />
    <div class="form-size">
      <b-row>
        <b-col cols="9">
          <div class="form-group">
            <label for="username">아이디</label>
            <input
              type="text"
              class="form-control"
              id="username"
              v-model="id"
            />
          </div>
        </b-col>
        <b-col cols="3">
          <div class="btn-pos">
            <div class="login-btn" @click="submit()">중복확인</div>
          </div>
        </b-col>
        <b-col>
          <div class="form-group">
            <label for="password">비밀번호</label>
            <input
              type="password"
              class="form-control"
              id="password"
              v-model="password"
            />
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <div class="form-group">
            <label for="password">비밀번호 홧인</label>
            <input
              type="password"
              class="form-control"
              id="checkpassword"
              v-model="checkpassword"
            />
          </div>
        </b-col>
      </b-row>
      <div>
        <div class="next-btn" @click="next()">다음</div>
      </div>
    </div>
  </div>
</template>


<script>
import { isPossible } from '@/api/user';
export default {
  name: "AuthJoinA",
  data() {
    return {
      id: "",
      password: "",
      checkpassword: "",
      username: "",
      possible: false
    };
  },
  watch: {
    id() {
      this.possible = false;
    }
  },
  methods: {
    submitForm() {
      this.id = "";
      this.password = "";
    },
    submit() {
      console.log(this.id);
      isPossible(
        this.id,
        ({data}) => {
          console.log(data);
          if (data) {
            alert("사용 가능한 아이디입니다");
            this.possible = true;
          } else {
            alert("이미 있는 아이디입니다");
          }
        },
        (error) => {console.log(error)}
      );
      
    },
    next(){
      if (!this.possible) alert("중복 확인 해주세요");
      else if (this.password.length < 1 || this.password != this.checkpassword) alert("비밀번호를 확인해주세요");
      else this.$router.push({path: '/auth/joinb', query: { id: this.id, password: this.password }})
    }
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
  margin-top: 30px;
}

.login-btn {
  border: 1px solid;
  height: 40px;
  max-width: 100px;
  border-color: #88a484;
  background-color: #88a484;
  border-radius: 5%;
  text-align: center;
  color: white;
  font-size: 15px;
  padding: 9px 0;
}
.login-btn:hover {
  opacity: 1;
  background-color: #699a63;
  cursor: pointer;
}

.next-btn {
  border: 1px solid;
  height: 40px;
  max-width: 100px;
  border-color: #88a484;
  background-color: #88a484;
  border-radius: 5%;
  text-align: center;
  color: white;
  font-size: 15px;
  margin: 50px auto;
  padding: 9px 0;
}
.next-btn:hover {
  opacity: 1;
  background-color: #699a63;
  cursor: pointer;
}

</style>
