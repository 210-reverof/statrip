<template>
  <b-container class="mt-3" >
    <div>
      <b-row>
        <b-col>
          <h2>Share</h2>
          <h5>자신이 자랑하고싶은 여행 경로를 공유해주세요</h5>
          <hr>
        </b-col>
      </b-row>
      <b-row>
        <b-col cols="6" v-for="(article, index) in articles" :key="index">
          <share-card></share-card>
        </b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
import ShareCard from '@/components/home/ShareCard.vue';
export default {
  name: "ShareList",
  components: {
    ShareCard
  },
  data: function () {
    return {
      articles: [
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:2, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:3, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:4, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:5, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:6, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:7, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:8, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:9, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
      ]
    }
  },
  created() {},
  methods: {},
};
</script>

<style scoped>


.col-style {
  margin: 5%;
  margin-bottom: 10%;
  padding-bottom: 5%;
  border-radius: 1%;
	border-width: 1px;
	border-color: #b0b0b0;
  border-style: solid;
  box-shadow: 1px 1px 10px #b0b0b0;
}
.img-style {
  text-align: center;
  margin-top:10px;
  margin-bottom:10px;
  width: 90%;
  height: auto;
  border: 1;
}

</style>
