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
          labels: [
            "Eating",
            "Drinking",
            "Sleeping",
            "Designing",
            "Coding",
            "Cycling",
            "Running",
          ],
          datasets: [
            {
              label: "My First Dataset",
              data: [65, 59, 90, 81, 56, 55, 40],
              fill: true,
              backgroundColor: "rgba(255, 99, 132, 0.2)",
              borderColor: "rgb(255, 99, 132)",
              pointBackgroundColor: "rgb(255, 99, 132)",
              pointBorderColor: "#fff",
              pointHoverBackgroundColor: "#fff",
              pointHoverBorderColor: "rgb(255, 99, 132)",
            },
            {
              label: "My Second Dataset",
              data: [28, 48, 40, 19, 96, 27, 100],
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
          plugins: {
            legend: {
              display: true,
              position: "bottom",
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
    this.fillData("chart2", ["중립", "중립 아님", "모름"], [50, 20, 30]);
  },
  data() {
    return {
      myChart: null,
    };
  },
};
</script>