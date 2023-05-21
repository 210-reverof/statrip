<template>
  <div class="mypage">
    <div class="contents-block">
      <h1>마이 페이지</h1>
      <hr />
      <div>
        <div>
          <div>
            <b-tabs content-class="mt-3" align="center" class="chart-block">
              <b-tab title="취향">
                <h3>
                  사용자의 취향 분석 - 초기 설문 & 팔로우 목록 & 계획에 포함된
                  태그 합
                </h3>
                <doughnut-chart-graph class="chart-size"></doughnut-chart-graph>
              </b-tab>
              <b-tab title="경험">
                <h3>사용자의 경험 분석 - 인증한 경로에 한해서 태그 합</h3>
                <radar-chart-graph class="chart-size"></radar-chart-graph>
              </b-tab>
              <b-tab title="달력" active>
                <h2>
                  달력 - 달력에 여행 인증 기록 표시, 다른 색으로 계획 달성 체크
                  표시<br />
                  계획 달성률, 자주 방문하는 지역, 태그 표시
                </h2>
                <calender-graph></calender-graph>
              </b-tab>
            </b-tabs>
          </div>
          <div class="data-block">
            <h3>팔로잉 수 {{followCnt.followingCnt}}</h3>
            <h3>팔로워 수 {{followCnt.followerCnt}}</h3>
            <h3>전체 게시글 수</h3>
            <h3>전체 받은 하트</h3>
          </div>
        </div>
      </div>
      <hr />
      <div>
        <div>
          <b-row class="center" id="my-row">
            <b-col
              class="card-col"
              cols="3"
              v-for="item in hotspotlists"
              :key="item.id"
            >
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
              <plan-card
                v-for="plan in planlists"
                :key="plan.id"
                :plan="plan"
              ></plan-card>
            </div>
          </b-row>
        </div>
        <b-row class="center">
          <h5
            @click="
              $router.push({ name: 'myPlanList', params: { items: planitems } })
            "
          >
            더보기
          </h5>
        </b-row>
        <hr />
        <b-row class="center">
          <!-- 카드 하나씩을 출력하며 각 카드에 클릭 이벤트를 달아줌.
       id값만 넘어가기 때문에 moveDetail로 넘어간 shareDetail에서는 별도의 get을 통해 게시글에 들어갈 plan을 받아줘야 함 -->
          <b-col
            cols="6"
            v-for="item in sharelists"
            :key="item.name"
            @click="moveDetail(item.id)"
          >
            <!-- sharelist에 띄울 card의 모양에 들어가는 데이터의 리스트를 받아 출력 -->
            <share-card class="card-size" :detail="item"></share-card>
          </b-col>
        </b-row>
        <b-row class="center">
          <h5
            @click="
              $router.push({
                name: 'myShareList',
                params: { items: shareitems },
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
import RadarChartGraph from "@/components/common/RadarChartGraph.vue";
import CalenderGraph from "@/components/common/CalenderGraph.vue";
import HotSpotCard from "@/components/home/HotSpotCard.vue";
import PlanCard from "@/components/home/PlanCard.vue";
import ShareCard from "@/components/home/ShareCard.vue";

import { followCnt } from "@/api/user";

export default {
  name: "MyPageMain",
  components: {
    DoughnutChartGraph,
    RadarChartGraph,
    CalenderGraph,
    HotSpotCard,
    PlanCard,
    ShareCard,
  },
  data() {
    return {
      followCnt: {
        followingCnt: 0,
        followerCnt: 0,
      },
      perPage: 4,
      twoPage: 2,
      currentPage: 1,
      hotspotitems: [
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 2,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 3,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 4,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 5,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 6,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 7,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 8,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 9,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 10,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
      ],
      planitems: [
        {
          id: 1,
          route: [
            { id: 3, img: "http://placehold.it/300x200?text=No-image" },
            { id: 1, img: "http://placehold.it/300x200?text=No-image" },
            { id: 2, img: "http://placehold.it/300x200?text=No-image" },
          ],
          writer: "Jessica_jj",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 2,
          route: [
            { id: 3, img: "http://placehold.it/300x200?text=No-image" },
            { id: 1, img: "http://placehold.it/300x200?text=No-image" },
            { id: 2, img: "http://placehold.it/300x200?text=No-image" },
          ],
          writer: "Jessica_jj",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 3,
          route: [
            { id: 3, img: "http://placehold.it/300x200?text=No-image" },
            { id: 1, img: "http://placehold.it/300x200?text=No-image" },
            { id: 2, img: "http://placehold.it/300x200?text=No-image" },
          ],
          writer: "Jessica_jj",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
      ],
      shareitems: [
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 2,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 3,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
      ],
    };
  },
  created() {
    this.getFollowCnt();
  },
  computed: {
    hotspotlists() {
      const items = this.hotspotitems;
      return items.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
    planlists() {
      const items = this.planitems;
      return items.slice(
        (this.currentPage - 1) * this.twoPage,
        this.currentPage * this.twoPage
      );
    },
    sharelists() {
      const items = this.shareitems;
      return items.slice(
        (this.currentPage - 1) * this.twoPage,
        this.currentPage * this.twoPage
      );
    },
    hotspottotalRows() {
      return this.hotspotitems.length;
    },
  },
  methods: {
    async getFollowCnt() {
      followCnt(({data}) => this.followCnt = data, (error) => console.log(error));
    },
    moveViewPlan() {
      console.log("click");
      this.$router.push({ name: "viewPlan" });
    },
    moveDetail(id) {
      console.log(id);
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
</style>
