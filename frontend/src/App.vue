<template>
  <div id="app">
    <div v-if="isOnBoard" class="scroll-snap-wrapper">
      <confirm-header :onBoard="true" class="header1"></confirm-header>
      <vue-scroll-snap :fullscreen="true">
        <div class="item" style="background-color: #42b983">
          
        </div>
        <div class="item" style="background-color: coral">sss
          <word-cloud class="word-cloud"></word-cloud>
        </div>
        <div class="item" style="background-color: #faebcd">
          <div>
            <real-radar-chart-graph
              class="radar-chart"
            ></real-radar-chart-graph>
          </div>
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

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
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
  z-index: 1;
}

.footer-wrapper {
  bottom: 0;
  left: 0;
  width: 100%;
  z-index: 1;
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

.wordcloud {
  margin: 3% auto;
  width: 90%;
  height: 90%;
  z-index: 2;
}
</style>
