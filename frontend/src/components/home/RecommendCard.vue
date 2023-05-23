<template>
  <div class="plan-card">
    <div class="card-background">
      <b-row>
        <canvas id="canvas" width="600" height="300"></canvas>
      </b-row>
    </div>
  </div>
</template>

<script>
import { Chart } from "chart.js";

export default {
  name: "RecommendCard",
  mounted() {
    var barChartDataHoriz = {
      labels: ["Income"],
      datasets: [
        {
          label: "Donors",
          backgroundColor: "#ff6384",
          data: [15],
        },
        {
          label: "Fundraisers",
          backgroundColor: "#36a2eb",
          data: [35],
        },
        {
          label: "Other",
          backgroundColor: "#ffce56",
          data: [50],
        },
      ],
    };

    var ctx = document.getElementById("canvas").getContext("2d");
    this.myBar = new Chart(ctx, {
      type: "horizontalBar",
      data: barChartDataHoriz,
      options: {
        title: {
          display: true,
          text: "Horizontal Stacked ChartJS",
        },
        tooltips: { mode: "label" },
        responsive: true,
        scales: {
          yAxes: [{ stacked: true }],
          xAxes: [{ stacked: true }],
        },
      },
    });
  },
};
</script>

<style scoped>
.plan-card {
  margin: 60px;
}

.card-background {
  background-color: #1a4213;
  border-radius: 10px;
  height: 300px;
  width: 1500px;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.3);
}

canvas {
  -moz-user-select: none;
  -webkit-user-select: none;
  -ms-user-select: none;
}

/* div {
  width: 600px;
  margin: 40px;
} */
</style>
