<template>
  <div class="mypage">
    <h1>마이 페이지</h1>
    <doughnut-chart-graph></doughnut-chart-graph>
  </div>
</template>

<script>
import DoughnutChartGraph from "../components/mypage/DoughnutChartGraph.vue";

export default {
  name: "MyPageView",
  components: {
    DoughnutChartGraph
  },
  data() {
    return {
    };
  },
};
</script>
