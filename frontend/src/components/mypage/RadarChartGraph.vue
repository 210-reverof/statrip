<template>
  <div class="analysis-chart-box">
    <canvas id="chart2" width="500px" height="500px"></canvas> 
  </div>
</template>

<script>
import {Chart, registerables} from 'chart.js';
Chart.register(...registerables);

export default {
  name: 'RadarChartGraph',
  components: { 
  },
  methods: {
    fillData(chartId, labels, dataset){
      const ctx = document.getElementById(chartId).getContext('2d');
      this.myChart = new Chart(ctx, {
        type:'doughnut',
        data:{
          labels:labels,
          datasets:[
            {
              backgroundColor:[
                "#DD7445", "#DE9D11" , "#E0B8FF"
              ],
              data: dataset              
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
    this.fillData('chart2',['중립','중립 아님','모름'], [50, 20, 30]);

  },
  data(){
    return{
      myChart: null
    };
  }
};
</script>