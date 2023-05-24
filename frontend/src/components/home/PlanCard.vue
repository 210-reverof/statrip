<template>
  <div class="plan-card" @click="moveViewPlan(plan.planId)">
    <div class="card-background">
      <user-tag v-if="plan.userId !== ''" :userId="plan.userId" class="user-tag"></user-tag>
      <div class="title">{{plan.title}}</div>
      <b-row class="my-row">
        <b-col class="card-col" cols="3">
          <img class="thumbnail" :src="getValidImageUrl(plan.img1)" />
          <img class="thumbnail" :src="getValidImageUrl(plan.img2)" />
          <img class="thumbnail" :src="getValidImageUrl(plan.img3)" />
        </b-col>
      </b-row>
      <b-row class="content-row">
        <div class="left-align">
          <p>여행지 개수: {{plan.attractionCnt}} 최소 이동 거리: {{plan.attractionWeight}}m</p>
        </div>
        <div class="right-align">
          <p>{{plan.createdAt}}</p>
        </div>
      </b-row>
    </div>
  </div>
</template>

<script>
import UserTag from "../common/UserTag.vue";
export default {
  components: {
    UserTag,
  },
  props: {
    plan: {},
  },
  data() {
    return {
    };
  },
  created() {
  },
  methods: {
    moveViewPlan(planId){
      this.$router.push({ path: `/plan/view/${planId}`});
    },
    getValidImageUrl(imageUrl) {
      if (!imageUrl || imageUrl.trim() === "") {
        return "https://firebasestorage.googleapis.com/v0/b/pocket-sch.appspot.com/o/noimg-statrip.png?alt=media&token=6a8354d8-3533-4eee-9272-7d8a7e87302d"; 
      }
      return imageUrl;
    }

  },
};
</script>

<style scoped>
.plan-card {
  width: 1500px;
  margin: 40px auto;
}

.card-background {
  background-color: white;
  border-radius: 10px;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.3);
  padding: 20px 10px;
}

.user-tag {
  position: absolute;
  margin-left: 20px;
}

.my-row{
  margin: 0 auto;

}

.card-col {
  display: flex;
  justify-content: center; /* Center align the images horizontally */
  align-items: center; /* Center align the images vertically */
  width: 100%;
  margin: 0 auto;
}

.thumbnail {
  width: 400px;
  height: 300px;
  margin: 4px auto;
  padding: 20px;
}

.content-row {
  justify-content: space-between;
  align-items: center;
}

.left-align {
  text-align: left;
  margin-left: 60px;
  margin-bottom: 10px;
}

.right-align {
  text-align: right;
  margin-right: 60px;
  margin-bottom: 10px;
}

.title {
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  padding-top: 50px;
  padding-bottom: 5px;
}
</style>
