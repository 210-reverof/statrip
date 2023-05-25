<template>
  <div id="app">
    <div v-if="isOnBoard" class="scroll-snap-wrapper">
      <confirm-header :onBoard="true" class="header1"></confirm-header>
      <vue-scroll-snap :fullscreen="true">
        <div class="item" style="background-color: #42b983">
          <div class="img-block">
            <b-row>
              <b-col cols=2
              ></b-col>
              <b-col cols=4
                ><img :src="require(`@/assets/fullscreen/giphy.gif`)"
              /></b-col>
              <b-col cols=4
                ><h1 style="margin: 30% auto; font-size: 55px; color:gold">
                  내 주위 <b>통계</b>로 보는 <br>
                  다채로운 <b>여행</b> 기록  
                </h1></b-col
              >
              <b-col cols=2
              ></b-col>
            </b-row>
          </div>
        </div>
        <div class="item" style="background-color: coral">
          <word-cloud class="wordcloud"></word-cloud>
        </div>
        <div class="item" style="background-color: #dcad67">
          <real-radar-chart-graph class="realradar"></real-radar-chart-graph>
        </div>
      </vue-scroll-snap>
    </div>
    <div v-else>
      <confirm-header :onBoard="false" class="header2"></confirm-header>
      <router-view></router-view>
      <common-footer></common-footer>
    </div>
  </div>
</template>

<script>
import VueScrollSnap from "vue-scroll-snap";
import CommonFooter from "./components/common/CommonFooter.vue";
import ConfirmHeader from "./components/common/ConfirmHeader.vue";
import WordCloud from "@/components/common/WordCloud.vue";
import RealRadarChartGraph from "@/components/common/RealRadarChartGraph.vue";
import { mapState, mapActions } from "vuex";
const routerStore = "routerStore";

export default {
  components: {
    ConfirmHeader,
    CommonFooter,
    WordCloud,
    RealRadarChartGraph,
    VueScrollSnap,
  },
  computed: {
    ...mapState(routerStore, ["isOnBoard"]),
  },
  methods: {
    ...mapActions(routerStore, ["setOnBoard"]),
  },
  created() {
    const isOnBoard = localStorage.getItem("isOnBoard");
    if (isOnBoard === null) {
      this.setOnBoard(true);
    } else {
      this.setOnBoard(isOnBoard === "true");
    }
  },
};
</script>

<style>
#app {
  font-family: 'Gowun Dodum', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.header1 {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 2;
}

.footer-wrapper {
  bottom: 0;
  left: 0;
  width: 100%;
  z-index: 2;
}

.scroll-snap-wrapper {
  margin-top: 100px;
  /* Adjust this value to give space for the header */
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.img-block {
  margin: 10% auto;
}
.wordcloud {
  width: 100%;
  height: 100%;
  margin: 0 auto;
}

.realradar {
  width: 80%;
  height: 80%;
  margin: 5% auto;
}
</style>
