<template>
  <div class="recommend-block">
    <h3>Recommended Travelers</h3>
    <div class="recommend-card-container">
      <recommend-card v-for="recommend in recommends" :key="recommend" :recommend="recommend" />
    </div>
  </div>

</template>
<script>
import RecommendCard from '@/components/home/RecommendCard.vue';
import { getMyRecommend, getRecommend } from "@/api/stat";
import { mapState } from "vuex";
const userStore = "userStore";
export default {
  name: "RecommendBlock",
  components: {
    RecommendCard
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
  },
  created() {
    if (this.userInfo) {
      getMyRecommend();

    } else {
      getRecommend();
    }
  },
  data() {
    return {
      recommends: [1,2]
    }
  }
};
</script>

<style>
.recommend-block h3 {
  color: #1A4213; 
  font-size: 40px; 
  font-weight: bold;
  padding-top: 100px;
}

.recommend-card-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  padding-bottom: 100px;
}

</style>