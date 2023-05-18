<template>
  <div class="mypage">
    <div class="contents-block">
      <h1>마이 페이지</h1>
      <hr />
      <div><doughnut-chart-graph></doughnut-chart-graph></div>
      <div>
        <div class="card-holder">
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
        <b-row class="center"> 더보기 버튼 </b-row>
        <hr />
        <div class="card-holder">
          <b-row class="center" id="my-row">
            <div @click="moveViewPlan()">
              <plan-card v-for="plan in planlists" :key="plan.id" :plan="plan"></plan-card>
            </div>
              
          </b-row>
        </div>


        <b-row class="center"> 더보기 버튼 </b-row>
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
            <share-card :detail="item"></share-card>
          </b-col>
        </b-row>
        <b-row class="center"> 더보기 버튼 </b-row>
        <hr />
      </div>
    </div>
  </div>
</template>

<script>
import DoughnutChartGraph from "../components/mypage/DoughnutChartGraph.vue";
import HotSpotCard from "@/components/home/HotSpotCard.vue";
import PlanCard from "@/components/home/PlanCard.vue";
import ShareCard from "@/components/home/ShareCard.vue";

export default {
  name: "MyPageView",
  components: {
    DoughnutChartGraph,
    HotSpotCard,
    PlanCard,
    ShareCard
  },
  data() {
    return {
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
      planitems:[
        {
          id: 1,
          route:[{id:3, img: "http://placehold.it/300x200?text=No-image",},
           {id:1, img: "http://placehold.it/300x200?text=No-image",},
            {id:2, img: "http://placehold.it/300x200?text=No-image",},],
          writer: "Jessica_jj",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 2,
          route:[{id:3, img: "http://placehold.it/300x200?text=No-image",},
           {id:1, img: "http://placehold.it/300x200?text=No-image",},
            {id:2, img: "http://placehold.it/300x200?text=No-image",},],
          writer: "Jessica_jj",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 3,route:[{id:3, img: "http://placehold.it/300x200?text=No-image",},
           {id:1, img: "http://placehold.it/300x200?text=No-image",},
            {id:2, img: "http://placehold.it/300x200?text=No-image",},],
          writer: "Jessica_jj",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
      ],
      shareitems:[
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
  created() {},
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
    moveViewPlan(){
      console.log("click");
      this.$router.push({name:'viewPlan'});
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

.center {
  justify-content: center;
}

/* hot-spot-list */
.card-col {
  display: flex;
  justify-content: center;
  padding-bottom: 2%;
}
</style>
