<template>
  <div class="realRadalChart">
    <canvas id="realRadalChart" width="500px" height="500px"></canvas>
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
      console.log(labels + " " + dataset);
      const ctx = document.getElementById(chartId).getContext("2d");
      this.myChart = new Chart(ctx, {
        type: "radar",
        data: {
          labels: [
            "관광지",
            "문화시설",
            "축제공연행사",
            "여행코스",
            "레포츠",
            "숙박",
            "쇼핑",
            "음식점",
            // 12:관광지 "#FF0000", // 빨강
// 14:문화시설 "#FFA500", // 주황
// 15:축제공연행사 "#FFFF00", // 노랑
// 25:여행코스, "#00FF00", // 초록
// 28:레포츠, "#0000FF", // 파랑
// 32:숙박, "#800080", // 보라
// 38:쇼핑, "#FF00FF",  // 분홍
// 39:음식점 "#888888"  // 회색
          ],
          datasets: [
            {
              label: "여성",
              data: [165, 459, 190, 281, 656, 355, 540, 431],
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
              data: [228, 248, 540, 219, 456, 247, 640, 221],
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
          scales: {
            r: {
              // display: false,
              color: "#55EBCD",
              ticks: {
                backdropColor: "#FAEBCD",
              },
            },
          },
          plugins: {
            legend: {
              display: true,
              position: "bottom",
              color: "#FAEBCD",
              labels: {
                boxWidth: 7,
                padding: 10,
                usePointStyle: true,
                pointStyle: "circle",
                font: {
                  size: 11,
                },
              },
              fullSize: false,
              align: "center",
            },
            tooltip: {
              boxWidth: 10,
              bodyFont: { size: 10 },
              backgroundColor: "#55EBCD",
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
              borderWidth: 3,
            },
          },
          animation: {
            duration: 1000,
          },
        },
      });
    },
  },
  mounted() {
    //chartname, labels, dataset
    this.fillData(
      "realRadalChart",
      ["중립", "중립 아님", "모름"],
      [50, 20, 30]
    );
  },
  data() {
    return {
      myChart: null,
    };
  },
};
</script>

<style scoped>
.realRadalChart{
  margin: 3% auto;
  width: 90%;
  height: 90%;
}
</style>