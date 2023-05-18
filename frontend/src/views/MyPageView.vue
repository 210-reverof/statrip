<template>
  <div class="mypage">
    <div class="contents-block">
      <h1>마이 페이지</h1>
      <hr />
      <div><doughnut-chart-graph></doughnut-chart-graph></div>
      <div>
        <div class="card-holder">
          <b-row
            id="my-row"
            :hotspotitems="hotspotitems"
            :per-page="perPage"
            :current-page="currentPage"
          >
            <b-col
              class="card-col"
              cols="3"
              v-for="item in lists"
              :key="item.name"
            >
              <hot-spot-card :item="item"></hot-spot-card>
            </b-col>
          </b-row>
        </div>
        <b-row class="center"> 더보기 버튼 </b-row>
        <hr />
        <b-row class="center"> planblock 1줄 </b-row>
        <b-row class="center"> 더보기 버튼 </b-row>
        <hr />
        <b-row class="center"> sharecard 1줄 </b-row>
        <b-row class="center"> 더보기 버튼 </b-row>
        <hr />
      </div>
    </div>
  </div>
</template>

<script>
import DoughnutChartGraph from "../components/mypage/DoughnutChartGraph.vue";
import HotSpotCard from "@/components/home/HotSpotCard.vue";

export default {
  name: "MyPageView",
  components: {
    DoughnutChartGraph,
    HotSpotCard,
  },
  data() {
    return {
      perPage: 4,
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
          route:[{id:3}, {id:1}, {id:2},],
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 2,
          route:[{id:5}, {id:7}, {id:8},],
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 3,
          route:[{id:1}, {id:9}, {id:11}, {id:3},],
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
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
    lists() {
      const items = this.hotspotitems;
      return items.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
    totalRows() {
      return this.hotspotitems.length;
    },
  },
  methods: {},
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
