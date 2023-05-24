<template>
  <div class="contents-block">
    <h2>Share</h2>
    <h5>자신이 자랑하고싶은 여행 경로를 공유해주세요</h5>
    <hr>
    <div>
      <div @click="moveViewPlan()"><plan-card :plan="plan"></plan-card></div>
      <h2>{{article.title}}</h2>
        <b-row>
          <div class="content-left">{{article.content}}</div>
          
        </b-row>
        <hr>
        <share-comment-list :shareId="article.articleNo"></share-comment-list>
    </div>
    <b-row>
        <b-button  class="btn-pos" squared variant="outline-info" @click="$router.push({name: 'shareList'})"
            >뒤로가기
        </b-button>
    </b-row>
  </div>
</template>

<!-- {
  "articleNo": 55,
  "userId": "ssafy",
  "planId": 48,
  "title": "ㅎㅎ",
  "content": "ㅎㅎㅎ",
  "hit": 1,
  "createdAt": "2023-05-22 14:56:51",
  "likeCnt": 0,
  "thumbnail": null
} -->

<script>
import PlanCard from '@/components/home/PlanCard.vue'
import ShareCommentList from './shareComment/ShareCommentList.vue';
import { getArticle } from "@/api/share";
import { getPlan } from "@/api/plan";

export default {
  name: "ShareDetail",
  components: {
    PlanCard,
    ShareCommentList
  },
  data: function () {
    return {
      article: {
        articleNo: 0,
      },
      plan: {
        userId:""
      }
    };
  },
  created() {
    this.article.articleNo = this.$route.params.articleNo;
    getArticle( this.article.articleNo,
      ({data}) => {
        this.article = data;
        getPlan( this.article.planId,
          ({data}) => { 
            this.plan = data;
            if (this.plan.attractions.length > 0) this.plan.img1 = this.plan.attractions[0].firstImage;
            if (this.plan.attractions.length > 1) this.plan.img2 = this.plan.attractions[1].firstImage;
            if (this.plan.attractions.length > 2) this.plan.img3 = this.plan.attractions[2].firstImage;
          }
        ), (error) => console.log(error)
      },
      (error) => console.log(error)
    );
    
  },
  methods: {
    moveViewPlan(){
      this.$router.push({name:'viewPlan'});
    },

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
