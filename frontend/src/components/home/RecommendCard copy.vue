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
import { Chart, registerables } from "chart.js";
Chart.register(...registerables);

export default {
  name: "RecommendCard",
  props: {
    recommend: {},
  },
  data() {
    return {
      myChart: null,
    };
  },
  components: {},
  // data() {
  //   return {
  //     myChart: null,
  //     // stat: {
  //     //  sightSeeingPercent: 0.43636363636363634,
  //     //  culturalPercent: 0.08333333333333333,
  //     //  festivalPercent: 0.0,
  //     //  travelRoutePercent: 0.0,
  //     //  leportsPercent: 0.0,
  //     //  sleepingPercent: 0.0,
  //     //  shoppingPercent: 0.03225806451612903,
  //     //  restaurantPercent: 0.0,
  //     // }
  //   };
  // },
  created() {
    this.drawColumnChart();
  },

  methods: {
    drawColumnChart() {
      var barOptions_stacked = {
        tooltips: {
          enabled: true,
        },
        hover: {
          animationDuration: 0,
        },
        scales: {
          xAxes: [
            {
              ticks: {
                beginAtZero: true,
                fontFamily: "'Open Sans Bold', sans-serif",
                fontSize: 11,
              },
              scaleLabel: {
                display: false,
              },
              gridLines: {},
              stacked: true,
            },
          ],
          yAxes: [
            {
              gridLines: {
                display: false,
                color: "#fff",
                zeroLineColor: "#fff",
                zeroLineWidth: 0,
              },
              ticks: {
                fontFamily: "'Open Sans Bold', sans-serif",
                fontSize: 11,
              },
              stacked: true,
            },
          ],
        },
        legend: {
          display: false,
        },

        animation: {
          onComplete: function () {
            var chartInstance = this.chart;
            var ctx = chartInstance.ctx;
            ctx.textAlign = "left";
            ctx.font = "9px Open Sans";
            ctx.fillStyle = "#fff";

            Chart.helpers.each(
              this.data.datasets.forEach(function (dataset, i) {
                var meta = chartInstance.controller.getDatasetMeta(i);
                Chart.helpers.each(
                  meta.data.forEach(function (bar, index) {
                    this.data = dataset.data[index];
                    if (i == 0) {
                      ctx.fillText(this.data, 50, bar._model.y + 4);
                    } else {
                      ctx.fillText(
                        this.data,
                        bar._model.x - 25,
                        bar._model.y + 4
                      );
                    }
                  }),
                  this
                );
              }),
              this
            );
          },
        },
        pointLabelFontFamily: "Quadon Extra Bold",
        scaleFontFamily: "Quadon Extra Bold",
      };
      var ctx = document.getElementById("canvas");
      this.myChart = new Chart(ctx, {
        type: "horizontalBar",
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
              data: this.recommend.sightSeeingPercent,
              backgroundColor: "#FF0000",
            },
            {
              data: this.recommend.culturalPercent,
              backgroundColor: "#FFA500",
            },
            {
              data: this.recommend.festivalPercent,
              backgroundColor: "#FFFF00",
            },
            {
              data: this.recommend.travelRoutePercent,
              backgroundColor: "#00FF00",
            },
            {
              data: this.recommend.leportsPercent,
              backgroundColor: "#0000FF",
            },
            {
              data: this.recommend.sleepingPercent,
              backgroundColor: "#800080",
            },
            {
              data: this.recommend.shoppingPercent,
              backgroundColor: "#FF00FF",
            },
            {
              data: this.recommend.restaurantPercent,
              backgroundColor: "#888888",
            },
          ],
        },

        options: barOptions_stacked,
      });
    },
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
