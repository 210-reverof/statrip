<template>
  <div class="plan-card" @click="moveViewPlan()">
    <div class="card-background">
      <user-tag class="user-tag"></user-tag>
      <b-row class="my-row">
        <b-col class="card-col" cols="3" v-for="item in lists" :key="item.id">
          <img class="thumbnail" :src="item.img" />
        </b-col>
      </b-row>
      <b-row class="content-row">
        <div class="left-align">
          <p>여행지 개수: 3 최소 이동 거리: 1234km</p>
        </div>
        <div class="right-align">
          <p>2021.03.17</p>
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
  computed: {
    lists() {
      const route = this.plan.route;
      return route.slice(0,3);
    },
  },
  methods: {
    moveViewPlan(){
      console.log("click");
      this.$router.push({name:'viewPlan'});
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
}

.user-tag {
  padding: 30px;
  padding-top: 40px;
}

.my-row{
  margin: 0 auto;

}

.card-col {
  width: 450px;
  height: 300;
  margin: 0 auto;
}

.thumbnail {
  width: 100%;
  margin: 30px auto;
}

.content-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.left-align {
  text-align: left;
  margin-left: 60px;
  margin-bottom: 20px;
}

.right-align {
  text-align: right;
  margin-right: 60px;
  margin-bottom: 20px;
}
</style>
