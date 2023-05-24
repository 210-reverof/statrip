<template>
  <div class="analysis-chart-box">
    <canvas :id="id" width="1000px" height="100px"></canvas>
  </div>
</template>

<script>
import { Chart, registerables } from "chart.js";
Chart.register(...registerables);

// 12:관광지 "#FF0000", // 빨강
// 14:문화시설 "#FFA500", // 주황
// 15:축제공연행사 "#FFFF00", // 노랑
// 25:여행코스, "#00FF00", // 초록
// 28:레포츠, "#0000FF", // 파랑
// 32:숙박, "#800080", // 보라
// 38:쇼핑, "#FF00FF",  // 분홍
// 39:음식점 "#888888"  // 회색
export default {
  name: "RecommendCard",
  props: {
    recommend: {},
  },
  data() {
    return {
      id: null,
      myChart: null,
    };
  },
  components: {},
  created() {
    if (this.recommend.userId) {
      this.id = this.recommend.userId;
    }
  },
  mounted() {
    if (this.id) {
      this.drawGraph(this.id, this.recommend);
    }
  },
  methods: {
    drawGraph(chartId, recommend) {
      const ctx = document.getElementById(chartId).getContext("2d");
      this.myChart = new Chart(ctx, {
        type: "bar",
        data: {
          labels: [recommend.userId],
          datasets: [
            {
              label: "관광지",
              backgroundColor: "#FF0000",
              data: [recommend.sightSeeing],
            },
            {
              label: "문화시설",
              backgroundColor: "#FFA500",
              data: [recommend.cultural],
            },
            {
              label: "축제공연행사",
              backgroundColor: "#FFFF00",
              data: [recommend.festival],
            },
            {
              label: "여행코스",
              backgroundColor: "#00FF00",
              data: [recommend.travelRoute],
            },
            {
              label: "레포츠",
              backgroundColor: "#0000FF",
              data: [recommend.leports],
            },
            {
              label: "숙박",
              backgroundColor: "#800080",
              data: [recommend.sleeping],
            },
            {
              label: "쇼핑",
              backgroundColor: "#FF00FF",
              data: [recommend.shopping],
            },
            {
              label: "음식점",
              backgroundColor: "#888888",
              data: [recommend.restaurant],
            },
          ],
        },
        options: {
          indexAxis: "y",
          maintainAspectRatio :false,
          title: {
            display: false,
            text: "Horizontal Stacked ChartJS",
          },
          plugins: {
            legend: {
              display: false,
            },
          },

          borderWidth: 1,
          responsive: true,
          scales: {
            x: { 
              display: false,
              stacked: true },
            y: { stacked: true },
          },
        },
      });
    },
  },
};
</script>

