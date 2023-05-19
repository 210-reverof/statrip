<template>
  <div class="auth-login">
    <h2>JoinB</h2>
    <h5>회원가입</h5>
    <hr />
    <div class="form-size">
      <b-row>
        <b-col>
          <div class="form-group">
            <label for="usernickn">닉네임</label>
            <input
              type="text"
              class="form-control"
              id="usernickn"
              v-model="usernickn"
            />
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <div class="form-group">
            <label for="email">이메일</label>
            <input
              type="text"
              class="form-control"
              id="email"
              v-model="email"
            />
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-form-group label="gender">
            <b-form-radio-group
              id="gender"
              v-model="gender"
              :options="genderoptions"
              name="gender"
            ></b-form-radio-group>
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-form-group label="age">
            <b-form-radio-group
              id="age"
              v-model="ages"
              :options="ageoptions"
              name="age"
              plain
            ></b-form-radio-group>
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <div class="form-group">
            <label for="gender">거주지</label>
            <b-form-select
              v-model="addr"
              :options="addroptions"
              plain
            ></b-form-select>
          </div>
        </b-col>
      </b-row>
      <div>
        <div class="next-btn" @click="next()">회원가입</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AuthJoinB",
  data() {
    return {
      usernickn: "",
      email: "",
      gender: "",
      ages: "",
      addr: "서울",
      addroptions: [
        { value: "서울", text: "서울" },
        { value: "인천/경기", text: "인천/경기" },
        { value: "강원", text: "강원" },
        { value: "대전/충남", text: "대전/충남" },
      ],
      genderoptions: [
        { text: "남", value: "male" },
        { text: "여", value: "female" },
      ],
      ageoptions: [
        { text: "10대", value: "teen" },
        { text: "20대", value: "twenty" },
        { text: "30대", value: "thirty" },
        { text: "40대", value: "forty" },
        { text: "50대 이상", value: "fifty" },
      ],
    };
  },
  methods: {
    submitForm() {
      this.id = "";
      this.password = "";
    },
    submit() {
      console.log("authJoinB");
    },
    next() {
      console.log("next");
      console.log(this.usernickn);
      console.log(this.email);
      console.log(this.gender);
      console.log(this.ages);
      console.log(this.addr);
      this.$router.push("/auth/login");
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
}

.form-group {
  text-align: left;
}

.btn-pos {
  margin-top: 30px;
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
