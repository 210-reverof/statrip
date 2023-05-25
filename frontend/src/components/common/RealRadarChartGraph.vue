<template>
  <div class="analysis-chart-box">
    <canvas id="chart2" width="500px" height="500px"></canvas>
  </div>
</template>

<script>
import { Chart, registerables } from "chart.js";
Chart.register(...registerables);
import { getStatGraph } from "@/api/stat";

export default {
  name: "RealRadarChartGraph",
  components: {},
  data() {
    return {
      myChart: null,
      dataset: { boy: [], girl: [] },
    };
  },
  created() {
    this.getGraph();
  },
  mounted() {
    this.fillData("chart2", this.dataset);
  },
  methods: {
    async getGraph() {
      getStatGraph(
        ({ data }) => {
          console.log(data);
          data.boy.forEach(element => {
            this.dataset.boy.push(element)
          });
          data.girl.forEach(element => {
            this.dataset.girl.push(element)
          });
        },
        (error) => console.log(error)
      );
      console.log("this.dataset");
      console.log(this.dataset);
    },
    fillData(chartId, dataset) {
      console.log(dataset);
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
          ],
          datasets: [
            {
              label: "남성",
              data: dataset.boy,
              fill: true,
              backgroundColor: "rgba(54, 162, 235, 0.2)",
              borderColor: "rgb(54, 162, 235)",
              pointBackgroundColor: "rgb(54, 162, 235)",
              pointBorderColor: "#fff",
              pointHoverBackgroundColor: "#fff",
              pointHoverBorderColor: "rgb(54, 162, 235)",
            },
            {
              label: "여성",
              data: dataset.girl,
              fill: true,
              backgroundColor: "rgba(255, 99, 132, 0.2)",
              borderColor: "rgb(255, 99, 132)",
              pointBackgroundColor: "rgb(255, 99, 132)",
              pointBorderColor: "#fff",
              pointHoverBackgroundColor: "#fff",
              pointHoverBorderColor: "rgb(255, 99, 132)",
            },
          ],
        },
        options: {
          scales: {
            r: {
              ticks: {
                backdropColor: "#DCAD67",
              },
            },
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
};
</script>

<style scoped>
/* .analysis-chart-box{
  width: 90%;
  height: 90%;
  margin: 0 auto;
} */
</style>
