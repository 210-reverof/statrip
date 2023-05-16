<template>
  <div id="doughnut-chart">
    <div class="box">
      <div class="title">과일 선호도 조사</div>
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