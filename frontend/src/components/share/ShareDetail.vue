<template>
  <div class="contents-block">
    <h2>Share</h2>
    <h5>자신이 자랑하고싶은 여행 경로를 공유해주세요</h5>
    <hr />
    <div>
      <plan-card :plan="plan"></plan-card>
      <h2>{{ article.title }}</h2>
      <div class="btn-pos">♥ {{ article.likeCnt }} 👁{{ article.hit }}</div>
      <b-row>
        <div class="content-start">{{ article.content }}</div>
      </b-row>
      <b-row class="btn-pos">
        <div v-if="userInfo && userInfo.userId == article.userId">
          <b-button squared variant="outline-danger" @click="doDeleteArticle()">삭제</b-button>
        </div>
        <div v-if="userInfo">
          <b-button squared variant="outline-primary" @click="doLikeArticle()">좋아요</b-button>
        </div>
        <b-button squared variant="outline-info" @click="$router.push({ name: 'shareList' })">뒤로가기</b-button>
      </b-row>
      <hr />
      <share-comment-list :shareId="article.articleNo"></share-comment-list>
    </div>
  </div>
</template>

<script>
import PlanCard from "@/components/home/PlanCard.vue";
import ShareCommentList from "./shareComment/ShareCommentList.vue";
import { getArticle, deleteArticle, likeArticle, doILike } from "@/api/share";
import { getPlan } from "@/api/plan";
import { mapState } from "vuex";
const userStore = "userStore";

export default {
  name: "ShareDetail",
  components: {
    PlanCard,
    ShareCommentList,
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
  },
  data() {
    return {
      article: {
        articleNo: 0,
      },
      plan: {
        userId: "",
      },
    };
  },
  created() {
    this.article.articleNo = this.$route.params.articleNo;
    getArticle(
      this.article.articleNo,
      ({ data }) => {
        this.article = data;
        getPlan(
          this.article.planId,
          ({ data }) => {
            this.plan = data;
            if (this.plan.attractions.length > 0) this.plan.img1 = this.plan.attractions[0].firstImage;
            if (this.plan.attractions.length > 1) this.plan.img2 = this.plan.attractions[1].firstImage;
            if (this.plan.attractions.length > 2) this.plan.img3 = this.plan.attractions[2].firstImage;
          },
          (error) => console.log(error)
        );
      },
      (error) => console.log(error)
    );
  },
  methods: {
    moveViewPlan() {
      this.$router.push({ name: "viewPlan" });
    },
    doDeleteArticle() {
      deleteArticle(
        this.article.articleNo,
        ({ data }) => {
          if (data == "success") {
            this.handleDeleteSuccess();
          }
        },
        (error) => {
          console.error(error);
        }
      );
    },
    doLikeArticle() {
      doILike(
        this.article.articleNo,
        ({ data }) => {
          if (!data) {
            likeArticle(
              this.article.articleNo,
              ({ data }) => {
                if (data == "success") {
                  this.handleLikeSuccess();
                }
              },
              (error) => {
                console.error(error);
              }
            );
          } else {
            alert("이미 좋아요 표시한 게시물입니다");
          }
        },
        (error) => console.log(error)
      );
    },
    handleDeleteSuccess() {
      this.$router.push({ name: "shareList" });
    },
    handleLikeSuccess() {
      window.location.reload();
    },
  },
};
</script>

<style scoped>
.btn-pos {
  margin-top: 1%;
  margin-left: 80%;
  margin-right: 2%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.content-start {
  margin-left: 15%;
}
</style>
