<template>
  <div class="recommend-block">
    <h3>Recommended Travelers</h3>
    <div class="recommend-card-container">
      <!-- <recommend-card
        v-for="(recommend, idx) in recommends"
        :key="idx"
        :recommend="recommend"
      /> -->
      <recommend-card :recommend="recommends[0]"></recommend-card>
      <recommend-card :recommend="recommends[1]"></recommend-card>
    </div>
  </div>
</template>
<script>
import RecommendCard from "@/components/home/RecommendCard.vue";
import { getMyRecommend, getRecommend } from "@/api/user";
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
      data: [
        {
          userId: "wonyoung",
          sightSeeing: 24,
          cultural: 5,
          festival: 0,
          travelRoute: 0,
          leports: 11,
          sleeping: 0,
          shopping: 2,
          restaurant: 0,
          sightSeeingPercent: 0.43636363636363634,
          culturalPercent: 0.08333333333333333,
          festivalPercent: 0.0,
          travelRoutePercent: 0.0,
          leportsPercent: 0.0,
          sleepingPercent: 0.0,
          shoppingPercent: 0.03225806451612903,
          restaurantPercent: 0.0,
          firstType: 12,
          secondType: 14,
        },
        {
          userId: "rony",
          sightSeeing: 4,
          cultural: 0,
          festival: 11,
          travelRoute: 0,
          leports: 0,
          sleeping: 0,
          shopping: 24,
          restaurant: 2,
          sightSeeingPercent: 0.0,
          culturalPercent: 0.0,
          festivalPercent: 0.0,
          travelRoutePercent: 0.0,
          leportsPercent: 0.0,
          sleepingPercent: 0.0,
          shoppingPercent: 0.0,
          restaurantPercent: 0.0,
          firstType: 0,
          secondType: 0,
        },
      ],
    };
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
  },
  created() {
    console.log("staaaaaaaart-------------");
    if (this.userInfo) {
      getMyRecommend(
        ({ data }) => {
          this.recommends = data;
          if (this.recommends.length > 2) {
            this.recommends = this.recommends.slice(0, 2);
          }
        },
        (error) => console.log(error)
      );
    } else {
      getRecommend(
        ({ data }) => {
          this.recommends = data;
          if (this.recommends.length > 2) {
            this.recommends = this.recommends.slice(0, 2);
          }
        },
        (error) => console.log(error)
      );
    }
    if(this.recommends.length==0){
      this.recommends = this.data;
          if (this.recommends.length >= 2) {
            this.recommends = this.recommends.slice(0, 2);
          }
    }
    console.log(this.recommends);
    console.log(this.recommends.length);
    console.log("bloooooooooooock");
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
  /* display: flex; */
  /* justify-content: center;
  align-items: center;
  flex-wrap: wrap; */
  margin: 0 auto;
  width: 1000px;
  padding-bottom: 100px;
}
</style>