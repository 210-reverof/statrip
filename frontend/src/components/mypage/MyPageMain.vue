<template>
  <div class="mypage">
    <div class="contents-block">
      <h1>마이 페이지</h1>
      <hr />
      <div>
        <div>
          <div class="graph-box">
            <b-tabs content-class="mt-3" align="center" class="chart-block">
              <b-tab title="취향">
                <h3>사용자의 취향 분석</h3>
                <doughnut-chart-graph :userId="user.userId" class="chart-size"></doughnut-chart-graph>
              </b-tab>
              <b-tab title="경험">
                <h3>사용자의 경험 분석</h3>
                <radar-chart-graph class="chart-size"></radar-chart-graph>
              </b-tab>
            </b-tabs>
          </div>
          <div class="data-block">
            <h5>팔로잉 수 {{ followCnt.followingCnt }}</h5>
            <h5>팔로워 수 {{ followCnt.followerCnt }}</h5>
            <h5>전체 게시글 수 {{ count.postCnt }}</h5>
            <h5>전체 받은 하트 {{ count.likeCnt }}</h5>
          </div>
        </div>
      </div>
      <hr />
      <div>
        <div>
          <b-row class="center" id="my-row">
            <b-col class="card-col" cols="3" v-for="item in hotspotlists" :key="item.id">
              <hot-spot-card :item="item"></hot-spot-card>
            </b-col>
          </b-row>
        </div>
        <b-row class="center">
          <h5
            @click="
              $router.push({
                name: 'myHotspotList',
                params: { items: hotspotitems },
              })
            "
          >
            더보기
          </h5>
        </b-row>
        <hr />
        <div>
          <b-row class="center" id="my-row">
            <div @click="moveViewPlan()">
              <plan-card v-for="plan in planlists" :key="plan.id" :plan="plan"></plan-card>
            </div>
          </b-row>
        </div>
        <b-row class="center">
          <h5 @click="$router.push({ name: 'myPlanList', params: { items: planitems } })">더보기</h5>
        </b-row>
        <hr />
        <b-row class="center">
          <b-col cols="6" v-for="item in sharelists" :key="item.name" @click="moveDetail(item.id)">
            <share-card class="card-size" :detail="item"></share-card>
          </b-col>
        </b-row>
        <b-row class="center">
          <h5
            @click="
              $router.push({ name: 'myShareList', params: { items: shareitems }})
            "
          >
            더보기
          </h5>
        </b-row>
        <hr />
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import DoughnutChartGraph from "@/components/common/DoughnutChartGraph.vue";
import RadarChartGraph from "@/components/common/RadarChartGraph.vue";
import HotSpotCard from "@/components/home/HotSpotCard.vue";
import PlanCard from "@/components/home/PlanCard.vue";
import ShareCard from "@/components/home/ShareCard.vue";

import { followCnt } from "@/api/user";
import { getPlanMyList } from "@/api/plan";
import { getMyCount } from "@/api/stat";
const userStore = "userStore";

export default {
  name: "MyPageMain",
  components: {
    DoughnutChartGraph,
    RadarChartGraph,
    HotSpotCard,
    PlanCard,
    ShareCard,
  },
  data() {
    return {
      user: {
        userId: "",
      },
      followCnt: {
        followingCnt: 0,
        followerCnt: 0,
      },
      count: {
        postCnt: 0,
        likeCnt: 0,
      },
      hotspotitems: [],
      planitems: [],
      shareitems: [],
      stat: {
        sightSeeing: 0,
        cultural: 0,
        festival: 0,
        travelRoute: 0,
        leports: 0,
        sleeping: 0,
        shopping: 0,
        restaurant: 0
      },
      perPage: 4,
      twoPage: 2,
      currentPage: 1,
    };
  },
  created() {
    this.user.userId = this.userInfo.userId;
    this.getFollowCnt();
    this.getPlanList();
    this.getMyCount();
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
    hotspotlists() {
      const items = this.hotspotitems;
      return items.slice((this.currentPage - 1) * this.perPage, this.currentPage * this.perPage);
    },
    planlists() {
      const items = this.planitems;
      return items.slice((this.currentPage - 1) * this.twoPage, this.currentPage * this.twoPage);
    },
    sharelists() {
      const items = this.shareitems;
      return items.slice((this.currentPage - 1) * this.twoPage, this.currentPage * this.twoPage);
    },
    hotspottotalRows() {
      return this.hotspotitems.length;
    },
  },
  methods: {
    async getFollowCnt() {
      followCnt(
        ({ data }) => (this.followCnt = data),
        (error) => console.log(error)
      );
    },
    async getPlanList() {
      getPlanMyList(({data}) => this.planitems = data.slice(0,3),
      (error) => console.log(error)
      );
    },
    async getMyCount() {
      getMyCount(
        ({ data }) => (this.count = data),
        (error) => console.log(error)
      );
    },
    moveViewPlan() {
      this.$router.push({ name: "viewPlan" });
    },
    moveDetail(id) {
      this.$router.push({ name: "shareDetail", params: { id: id } });
    },
    
  },
};
</script>

<style scoped>
.contents-block {
  max-width: 1500px;
  justify-content: center;
  margin: 0 auto;
}

.chart-block {
  border: 3px solid;
  border-color: #eaf3e8;
  border-radius: 7%;
  height: 750px;
}

.chart-size {
  height: 500px;
  width: auto;
}

.data-block {
  width: 50%;
  text-align: left;
  margin: 0 auto;
}

.center {
  justify-content: center;
}

/* hot-spot-list */
.card-col {
  display: flex;
  justify-content: center;
  padding-bottom: 2%;
}

/* share-card */
.card-size {
  width: 85%;
  margin: 60px auto;
}

.graph-box {
  margin-bottom: 20px;
}
</style>
