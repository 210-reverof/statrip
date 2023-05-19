<template>
  <div id="doughnut-chart">
    <div class="box">
      <div class="title">도넛 그래프 샘플</div>
      <div class="chart">
        <doughnut-chart></doughnut-chart>
      </div>
    </div>
  </div>
</template>

<script>
import DoughnutChart from "./DoughnutChart.vue";

export default {
  name: "DoughnutChartGraph",
  type: "doughnut",
  components: {
    DoughnutChart
  },
   data() {
    return {}
   }
}
</script>