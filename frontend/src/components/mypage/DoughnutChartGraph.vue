<template>
  <div id="doughnut-chart">
    <div class="box">
      <div class="title">과일 선호도 조사</div>
      <div class="chart">
        <doughnut-chart
          ref="fruitChart"
          :chartData="chart.data"
          :options="chart.options"
          id="chart"
        ></doughnut-chart>
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
    return {
      donghnutChartOptions: {
        legend: { display: false }, // datasets의 labels를 선언함으로 생기는 legend를 비표시로
        cutoutPercentage: 85, // 차트의 굵기
        elements: {
          arc: {
            roundedCornersFor: 0
          },
          center: [
            {
              text: '60',
              font: 'bolder 4rem sans-serif',
              fillStyle: '#354abd'
            },
            {
              text: 'Point',
              font: 'bold 0.8rem sans-serif',
              fillStyle: '#222222'
            },
            {
              text: '昨日比＋5',
              font: 'bold 1rem sans-serif',
              fillStyle: '#222222'
            }
          ]
        }
      }
    }
  },
  computed: {
    datacollection() {
      return {
        labels: ['score', ''],
        datasets: [
          {
            data: [60, 40],
            backgroundColor: ['#ff0058', '#ff645a']
          }
        ]
      }
    }
  },
}
</script>