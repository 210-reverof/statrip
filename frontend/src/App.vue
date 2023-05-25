<template>
  <div id="app">
    <div v-if="isOnBoard" class="scroll-snap-wrapper">
      <confirm-header :isOnBoard="true" class="header1"></confirm-header>
      <vue-scroll-snap :fullscreen="true">
        <div class="item" style="background-color: #42b983">xxxxxxxxxxxxxx</div>
        <div class="item" style="background-color: coral">
          <word-cloud class="word-cloud"></word-cloud>
        </div>
        <div class="item" style="background-color: #faebcd">
          <div>
            <b-carousel
              id="carousel-fade"
              style="text-shadow: 0px 0px 2px #000"
              fade
              indicators
              img-width="1024"
              img-height="600"
            >
              <b-carousel-slide
                caption="First Slide"
                img-src="https://picsum.photos/1024/480/?image=10"
              >
                <real-radar-chart-graph
                  class="radar-chart"
                ></real-radar-chart-graph
              ></b-carousel-slide>
              <b-carousel-slide
                caption="Second Slide"
                img-src="https://picsum.photos/1024/480/?image=12"
              ></b-carousel-slide>
              <b-carousel-slide
                caption="Third Slide"
                img-src="https://picsum.photos/1024/480/?image=22"
              ></b-carousel-slide>
            </b-carousel>
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
  created() {
    this.setOnBoard(true);
    console.log("fullscreen");
  },
  computed: {
    ...mapState(routerStore, ["isOnBoard"]),
  },
  methods: {
    ...mapActions(routerStore, ["setOnBoard"]),
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

.word-cloud {
  width: 100%;
  height: 100%;
}

.radar-chart {
  width: 100%;
  height: 100%;
}
</style>
