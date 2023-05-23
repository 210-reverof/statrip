<template>
  <div class="analysis-chart-box">
    <canvas id="chart" width="500px" height="500px"></canvas>
  </div>
</template>

<script>
import { Chart, registerables } from 'chart.js';
import { getUserStat } from "@/api/stat";
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
  name: 'DoughnutChartGraph',
  props: ['userId'],
  components: {
  },
  created() {
    getUserStat(this.userId, ({data})=>{
      this.stat=data;
      console.log(this.stat);
      this.fillData('chart',this.stat);
    }, (error)=>console.log(error));
  },
  methods: {
    fillData(chartId, stat) {
      const ctx = document.getElementById(chartId).getContext('2d');
      this.myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
          labels: ["관광지", "문화시설", "축제공연행사", "여행코스", "레포츠", "숙박", "쇼핑", "음식점"],
          datasets: [
            {
              backgroundColor: ["#FF0000", "#FFA500", "#FFFF00", "#00FF00", "#0000FF", "#800080", "#FF00FF", "#888888"],
              data: [stat.sightSeeing, stat.cultural, stat.festival, stat.travelRoute, stat.leports, stat.sleeping, stat.shopping, stat.restaurant]
            }
          ]

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
                  size: 11
                }
              },
              fullSize: false,
              align: "center"
            },
            tooltip: {
              boxWidth: 10,
              bodyFont: { size: 10 }
            }
          },
          responsive: true,
          maintainAspectRatio: false,
          layout: {
            padding: {
              top: 20,
              bottom: 20
            }
          },
          elements: {
            arc: {
              borderWidth: 0.2
            }
          },
          animation: {
            duration: 1000
          }
        }
      })
    }
  },
  data() {
    return {
      myChart: null,
      // stat: {
      //   sightSeeing: 0,
      //   cultural: 0,
      //   festival: 0,
      //   travelRoute: 0,
      //   leports: 0,
      //   sleeping: 0,
      //   shopping: 0,
      //   restaurant: 0
      // }
    };
  }
};
</script>