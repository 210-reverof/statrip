<template>
  <div class="contents-block">
    <h2>Hot Spots</h2>
    <h5>나만의 핫스팟을 인증샷과 함께 자랑해주세요</h5>
    <hr />
    <div>
      <div style="text-align:left">경로 입력</div>
      <!-- <plan-card></plan-card> -->
      <b-form-select
        v-model="rootselected"
        :options="rootoptions"
      ></b-form-select>

      <div class="mt-3">
        <h4>선택됨: <strong>{{ rootselected }}</strong></h4>
      </div>
    </div>
    <div>
      <div style="text-align:left">관광지 선택</div>
      <b-form-select
        v-model="attrselected"
        :options="attroptions"
      ></b-form-select>

      <div class="mt-3">
        <h4>선택됨: <strong>{{ attrselected }}</strong></h4>
      </div>
    </div>

    <hr />

    <div class="center">
      <div class="img-upload-form">
        <div v-if="images" class="w-full h-full flex items-center">
          <img class="img" :src="images" alt="image" @click="reset()" />
          누르면 취소
        </div>
        <div v-else class="img-upload" @click="clickInputTag()">
          <input
            ref="image"
            id="input"
            type="file"
            name="image"
            accept="image/*"
            multiple="multiple"
            @change="uploadImage()"
            hidden
          />
          <svg
            class="w-8 h-8"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
            />
          </svg>
          눌러서 추가
        </div>
      </div>
    </div>
    <div>사진 추가</div>
    <b-button class="btn-pos" squared variant="outline-danger" @click="$router.push({ name: 'hotspotList' })">뒤로가기</b-button>
    <b-button class="btn-pos" squared variant="outline-info" @click="$router.push({name: 'hotspotList'})">글쓰기</b-button>
  </div>
</template>

<script>
// https://arikong.tistory.com/22
//해당 사용자의 모든 계획들 불러와서 rootption에 넣고
//rootselect가 선택되면 해당 계획의 모든 관광지들을 attroption에 넣어야 함

// import PlanCard from '@/components/home/PlanCard.vue'

export default {
  name: "HotspotAdd",
  components: {
    // PlanCard
  },
  data() {
    return {
      images: "",
      rootselected: null,
      rootoptions: [
        { value: null, text: "Please select an option" },
        { value: "a", text: "This is First option" },
        { value: "b", text: "Selected Option" },
        { value: { C: "3PO" }, text: "This is an option with object value" },
        { value: "d", text: "This one is disabled", disabled: true },
      ],
      attrselected: null,
      attroptions: [
        { value: null, text: "Please select an option" },
        { value: "a", text: "This is First option" },
        { value: "b", text: "Selected Option" },
        { value: { C: "3PO" }, text: "This is an option with object value" },
        { value: "d", text: "This one is disabled", disabled: true },
      ],
    };
  },
  created() {},
  methods: {
    uploadImage: function () {
      let form = new FormData();
      let image = this.$refs["image"].files[0];

      form.append("image", image);
      this.images = require("./king.png");
      console.log(this.images);
      // axios.post('/upload', form, {
      //     header: { 'Content-Type': 'multipart/form-data' }
      // }).then( ({data}) => {
      //   this.images = data
      // })
      // .catch( err => console.log(err))
    },
    clickInputTag: function () {
      this.$refs["image"].click();
      console.log(this.images);
    },
    reset() {
      this.images = "";
    },
  },
};
</script>

<style scoped>
.contents-block {
  max-width: 1500px;
  justify-content: center;
  margin: 0 auto;
}
.center {
  display: flex;
  justify-content: center;
  margin: 0 auto;
}

.img-upload-form {
  width: 32%;
  height: 32%;
  border: 2pt;
  border-style: dotted;
  border-color: blue;
}
.img {
  width: 100%;
  height: 100%;
}

.img-upload {
  width: 100%;
  height: 100%;
  align-items: center;
  justify-items: center;
  cursor: pointer;
}

.img-upload:hover {
  background-color: pink;
}
</style>
