<template>
  <div class="auth-login">
    <br>
    <h2>JoinB</h2>
    <h5>회원가입</h5>
    <hr />
    <div class="form-size">
      <b-row>
        <b-col>
          <div class="form-group">
            <label for="name" label-class="font-weight-bold">이름</label>
            <input type="text" class="form-control" id="name" v-model="join.name" />
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <div class="form-group">
            <label for="email" label-class="font-weight-bold">이메일</label>
            <input type="text" class="form-control" id="email" v-model="join.email" />
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-form-group label="gender" label-class="font-weight-bold">
            <b-form-radio-group id="gender" v-model="join.gender" :options="genderoptions" name="gender"></b-form-radio-group>
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-form-group label="age" label-class="font-weight-bold">
            <b-form-radio-group id="age" v-model="join.ageGroup" :options="ageoptions" name="age" plain></b-form-radio-group>
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-form-group label="여행 관심사 1" label-class="font-weight-bold">
            <b-form-radio-group id="age" v-model="join.type1" :options="typeoptions" name="type1" plain></b-form-radio-group>
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-form-group label="여행 관심사 2" label-class="font-weight-bold">
            <b-form-radio-group id="age" v-model="join.type2" :options="typeoptions" name="type2" plain></b-form-radio-group>
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <div class="form-group">
            <b-form-group label="거주지" for="gender" label-class="font-weight-bold"></b-form-group>
            <b-form-select v-model="join.addrGroup" :options="addroptions" plain></b-form-select>
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
import { join } from "@/api/user";
export default {
  name: "AuthJoinB",
  created() {
    this.join.userId = this.$route.query.id;
    this.join.password = this.$route.query.password;
  },
  data() {
    return {
      join: {
        userId: "",
        password: "",
        name: "",
        email: "",
        gender: "",
        ageGroup: "",
        addrGroup: "",
        type1: "",
        type2: "",
      },
      addroptions: [
        { value: "0", text: "서울" },
        { value: "1", text: "인천/경기" },
        { value: "2", text: "강원" },
        { value: "3", text: "대전/충남" },
        { value: "4", text: "충북" },
        { value: "5", text: "광주/전남" },
        { value: "6", text: "전북" },
        { value: "7", text: "부산/경남" },
        { value: "8", text: "대구/경북" },
      ],
      genderoptions: [
        { text: "남", value: "0" },
        { text: "여", value: "1" },
      ],
      ageoptions: [
        { text: "10대", value: "1" },
        { text: "20대", value: "2" },
        { text: "30대", value: "3" },
        { text: "40대", value: "4" },
        { text: "50대 이상", value: "5" },
      ],
      typeoptions: [
        { text: "관광지", value: "12" },
        { text: "문화시설", value: "14" },
        { text: "축제공연행사", value: "15" },
        { text: "여행코스", value: "25" },
        { text: "레포츠", value: "28" },
        { text: "숙박", value: "32" },
        { text: "쇼핑", value: "38" },
        { text: "음식점", value: "39" },
      ],
    };
  },
  methods: {
    submitForm() {
      this.id = "";
      this.password = "";
    },
    submit() {},
    next() {
      if (this.join.name == "" || this.join.email == "" || this.join.gender == "" || this.join.ageGroup == "" || this.join.addrGroup == "" || this.join.type1 == "" || this.join.type2 == "") alert("모든 항목을 입력하세요");
      else {
        console.log(this.join.name);
        console.log(this.join.email);
        console.log(this.join.gender);
        console.log(this.join.ageGroup);
        console.log(this.join.type1);
        console.log(this.join.type2);
        console.log(this.join.addrGroup);
        join(this.join, () =>
        { alert("회원가입이 완료되었습니다.");   this.$router.push("/auth/login");}, (error) => console.log(error));
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
