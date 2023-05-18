<template>
  <div class="contents-block">
    <h2>Share</h2>
    <h5>자신이 자랑하고싶은 여행 경로를 공유해주세요</h5>
    <hr />
    <div class="block-tmp-size">
        <div @click="moveViewPlan()"><plan-card></plan-card></div>
        <b-row>
          <div class="content-left">{{item.content}}</div>
          <hr>
        </b-row>
        <share-comment-list></share-comment-list>
    </div>
    <b-row>
        <b-col cols="10"></b-col>
        <b-col cols="2">
            <b-button squared variant="outline-info" @click="$router.push({name: 'shareList'})"
            >뒤로가기
            </b-button>
            </b-col>
    </b-row>
  </div>
</template>

<script>

import PlanCard from '@/components/home/PlanCard.vue'
import ShareCommentList from './shareComment/ShareCommentList.vue';

export default {
  name: "ShareDetail",
  components: {
    PlanCard,
    ShareCommentList
  },
  data: function () {
    return {
      item: {},
    };
  },
  created() {
    this.item = this.$route.params.item;
    // item.id로 경로 불러와서 경로 다 찍어주기
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
.contents-block {
  max-width: 1800px;
  justify-content: center;
  margin: 0 auto;
}

.block-tmp-size{
    widows: 50%;
}

.content-left{
  text-align :left;
  padding-left: 5%;
  padding-right: 5%;
  margin-bottom: 5%;
}
</style>
