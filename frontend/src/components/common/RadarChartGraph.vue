<template>
  <div class="analysis-chart-box">
    <canvas id="chart2" width="500px" height="500px"></canvas> 
  </div>
</template>

<script>
import {Chart, registerables} from 'chart.js';
import { getRealStat } from "@/api/stat";
Chart.register(...registerables);

export default {
  name: 'RadarChartGraph',
  props: ['userId'],
  components: { 
  },
  created() {
    getRealStat(({data})=>{
      this.stat=data;
      this.fillData('chart2', this.stat);
    }, (error)=>console.log(error));
  },
  methods: {
    fillData(chartId, stat){
      const ctx = document.getElementById(chartId).getContext('2d');
      this.myChart = new Chart(ctx, {
        type:'doughnut',
        data:{
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
              bottom:20
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
  mounted() {  
    // this.fillData('chart2',['중립','중립 아님','모름'], [50, 20, 30]);

  },
  data(){
    return{
      stat: [0],
      myChart: null
    };
  }
};
</script>