<template>
  <div class="contents-block">
    <h2>Share</h2>
    <h5>자신이 자랑하고싶은 여행 경로를 공유해주세요</h5>
    <hr>
    <div>
        <div @click="moveViewPlan()"><plan-card :plan="plan"></plan-card></div>
        <b-row>
          <div class="content-left">{{plan.content}}</div>
          
        </b-row>
        <hr>
        <share-comment-list></share-comment-list>
    </div>
    <b-row>
        <b-button  class="btn-pos" squared variant="outline-info" @click="$router.push({name: 'shareList'})"
            >뒤로가기
        </b-button>
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
      id:"",
      // plan은 id로 불러서 호출한 데이터
      plan: {
          id: 1,
          route:[{id:3, img: "http://placehold.it/300x200?text=No-image",},
           {id:1, img: "http://placehold.it/300x200?text=No-image",},
            {id:2, img: "http://placehold.it/300x200?text=No-image",},],
          writer: "Jessica_jj",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
    };
  },
  created() {
    this.id = this.$route.params.id;
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

.btn-pos{
    margin-top: 1%;
    margin-bottom: 5%;
    margin-left: 92%;
    margin-right: 1%;
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;
}


.content-left{
  text-align :left;
  padding-left: 5%;
  padding-right: 5%;
  margin-bottom: 5%;
}
</style>
