<template>
  <div>
    <h2>Hot Spots</h2>
    <h5>나만의 핫스팟을 인증샷과 함께 자랑해주세요</h5>
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
    <div>
      사진 추가
    </div>
  </div>
</template>

<script>
// https://arikong.tistory.com/22

export default {
  name: "HotspotAdd",
  components: {},
  data() {
    return {
      images: "",
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
