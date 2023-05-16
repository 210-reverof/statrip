// 임시라 나중에 지우기
<template>
  <div align="center">
    <b-row class="share-header">
      <b-col cols="8">
        <user-tag class="user-tag"></user-tag>
      </b-col>
      <b-col cols="4"> - </b-col>
    </b-row>
    <b-row>
      <b-col clos="1"></b-col>
      <b-col cols="3" v-for="item in items" :key="item.name">
        <img :src="item.img" />
      </b-col>
      
      <b-col clos="1"></b-col>
    </b-row>
    <b-col cols="8"> 여행지 개수 </b-col>
    <b-col cols="4"> 거리 </b-col>
  </div>
</template>

<script>
import UserTag from "@/components/common/UserTag.vue";

export default {
  name: "ShareBlockTmp",
  components: {
    UserTag,
  },
  data() {
    return {
      perPage: 6,
      currentPage: 1,
      items: [
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 2,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 3,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
      ],
    };
  },
};
</script>

<style scoped>

.center {
  justify-content: center;
  margin: 0 auto;
}

</style>
