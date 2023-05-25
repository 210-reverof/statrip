<template>
  <div class="analysis-chart-box">
    <canvas id="chart2" width="500px" height="500px"></canvas>
  </div>
</template>

<script>
import { Chart, registerables } from "chart.js";
Chart.register(...registerables);

export default {
  name: "RealRadarChartGraph",
  components: {},
  methods: {
    fillData(chartId, labels, dataset) {
      console.log(labels +" "+dataset)
      const ctx = document.getElementById(chartId).getContext("2d");
      this.myChart = new Chart(ctx, {
        type: "radar",
        data: {
          // 12:관광지 "#FF0000", // 빨강
// 14:문화시설 "#FFA500", // 주황
// 15:축제공연행사 "#FFFF00", // 노랑
// 25:여행코스, "#00FF00", // 초록
// 28:레포츠, "#0000FF", // 파랑
// 32:숙박, "#800080", // 보라
// 38:쇼핑, "#FF00FF",  // 분홍
// 39:음식점 "#888888"  // 회색
          labels: [
            "관광지",
            "문화시설",
            "축제공연행사",
            "여행코스",
            "레포츠",
            "숙박",
            "쇼핑",
            "음식점"
          ],
          datasets: [
            {
              label: "여성",
              data: [65, 59, 90, 81, 56, 55, 40, 124],
              fill: true,
              backgroundColor: "rgba(255, 99, 132, 0.2)",
              borderColor: "rgb(255, 99, 132)",
              pointBackgroundColor: "rgb(255, 99, 132)",
              pointBorderColor: "#fff",
              pointHoverBackgroundColor: "#fff",
              pointHoverBorderColor: "rgb(255, 99, 132)",
            },
            {
              label: "남성",
              data: [28, 48, 40, 19, 96, 27, 100, 45],
              fill: true,
              backgroundColor: "rgba(54, 162, 235, 0.2)",
              borderColor: "rgb(54, 162, 235)",
              pointBackgroundColor: "rgb(54, 162, 235)",
              pointBorderColor: "#fff",
              pointHoverBackgroundColor: "#fff",
              pointHoverBorderColor: "rgb(54, 162, 235)",
            },
          ],
        },
        options: {
          scales:{
            r:{
              ticks:{
                backdropColor:"#DCAD67"
              }
            }
          },
          plugins: {
            legend: {
              display: true,
              position: "bottom",
              labels: {
                boxWidth: 10,
                padding: 10,
                usePointStyle: true,
                pointStyle: "circle",
                font: {
                  size: 13,
                },
              },
              fullSize: false,
              align: "center",
            },
            tooltip: {
              boxWidth: 15,
              bodyFont: { size: 15 },
            },
          },
          responsive: true,
          maintainAspectRatio: false,
          layout: {
            padding: {
              top: 20,
              bottom: 20,
            },
          },
          elements: {
            line: {
              borderWidth: 4,
            },
          },
          animation: {
            duration: 1500,
          },
        },
      });
    },
  },
  mounted() {
    this.fillData("chart2", ["중립", "중립 아님", "모름"], [50, 20, 30]);
  },
  data() {
    return {
      myChart: null,
    };
  },
};
</script>

<style scoped>
/* .analysis-chart-box{
  width: 90%;
  height: 90%;
  margin: 0 auto;
} */
</style>