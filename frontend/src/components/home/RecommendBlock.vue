<template>
  <div class="recommend-block">
    <h3>Recommended Travelers</h3>
    <div class="recommend-card-container">
      <recommend-card v-for="(recommend, idx) in recommends" :key="idx" :recommend="recommend" />
    </div>
    <p v-if="!userInfo" class="recommendation-info">로그인 후 친구 추천을 받을 수 있습니다.</p>
  </div>
</template>
<script>
import RecommendCard from "@/components/home/RecommendCard.vue";
import { getMyRecommend } from "@/api/user";
import { mapState } from "vuex";
const userStore = "userStore";
export default {
  name: "RecommendBlock",
  components: {
    RecommendCard,
  },
  data() {
    return {
      recommends: [],
      data: [],
    };
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
  },
  created() {
    if (this.userInfo) {
      getMyRecommend(
        ({ data }) => {
          this.recommends = data;
        },
        (error) => console.log(error)
      );
    }
  },
};
</script>

<style>
.recommend-block h3 {
  color: #1a4213;
  font-size: 40px;
  font-weight: bold;
  padding-top: 100px;
}

.recommend-card-container {
  margin: 0 auto;
  width: 1000px;
  padding-bottom: 100px;
}
</style>
