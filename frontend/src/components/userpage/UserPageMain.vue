<template>
  <div class="userpage">
    <div class="contents-block">
      <hr />
      <div>
        <div>
<div>
            <h1>{{ user.userId }}</h1>
            <doughnut-chart-graph :userId="user.userId" class="chart-size"></doughnut-chart-graph>
          </div>          
          <div class="data-block">
            <h3>팔로잉 수 : {{followCnt.followingCnt}}</h3>
            <h3>팔로워 수 : {{followCnt.followerCnt}}</h3>
            <h3>전체 게시글 수</h3>
            <h3>전체 받은 하트</h3>
          </div>
        </div>
      </div>
      <hr />
      <div>
        <div>
          <b-row class="center" id="my-row">
            <b-col class="card-col" cols="3" v-for="item in hotspotitems" :key="item.id">
              <hot-spot-card :item="item"></hot-spot-card>
            </b-col>
          </b-row>
        </div>
        <b-row class="center">
          <h5
            @click="
              $router.push({
                name: 'userHotspotList',
                params: { items: hotspotitems, userId: userId },
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
              <plan-card v-for="plan in planitems" :key="plan.id" :plan="plan"></plan-card>
            </div>
          </b-row>
        </div>
        <b-row class="center">
          <h5
            @click="
              $router.push({
                name: 'userPlanList',
                params: { items: planitems, userId: userId },
              })
            "
          >
            더보기
          </h5>
        </b-row>
        <hr />
        <b-row class="center">
          <!-- 카드 하나씩을 출력하며 각 카드에 클릭 이벤트를 달아줌. id값만 넘어가기 때문에 moveDetail로 넘어간 shareDetail에서는 별도의 get을 통해 게시글에 들어갈 plan을 받아줘야 함 -->
          <b-col cols="6" v-for="item in shareitems" :key="item.name" @click="moveDetail(item.id)">
            <share-card class="card-size" :detail="item"></share-card>
          </b-col>
        </b-row>
        <b-row class="center">
          <h5
            @click="
              $router.push({
                name: 'userShareList',
                params: { items: shareitems, userId: userId },
              })
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
import DoughnutChartGraph from "@/components/common/DoughnutChartGraph.vue";
import HotSpotCard from "@/components/home/HotSpotCard.vue";
import PlanCard from "@/components/home/PlanCard.vue";
import ShareCard from "@/components/home/ShareCard.vue";
import { followUserCnt } from "@/api/user";
import { getPlanUserList } from "@/api/plan";

export default {
  name: "UserPageMain",
  components: {
    DoughnutChartGraph,
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
      hotspotitems: [],
      planitems: [],
      shareitems: [],
      perPage: 4,
      twoPage: 2,
      currentPage: 1,
      stat: {
        sightSeeing: 0,
        cultural: 0,
        festival: 0,
        travelRoute: 0,
        leports: 0,
        sleeping: 0,
        shopping: 0,
        restaurant: 0
      }
    };
  },
  created() {
    this.user.userId = this.$route.params.userId;
    this.getFollowCnt();
    this.getPlanList();

  },
  methods: {
    moveViewPlan() {
      this.$router.push({ name: "viewPlan" });
    },
    moveDetail(id) {
      console.log(id);
      this.$router.push({ name: "shareDetail", params: { id: id } });
    },
    async getFollowCnt() {
      followUserCnt( this.user.userId,
        ({ data }) => this.followCnt = data,
        (error) => console.log(error)
      );
    },
    async getPlanList() {
      getPlanUserList(this.user.userId,
      ({data}) => this.planitems = data.slice(0,3),
      (error) => console.log(error)
      );
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
</style>
