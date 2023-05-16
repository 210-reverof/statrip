<script>
import { Doughnut, mixins } from 'vue-chartjs'
const { reactiveProp } = mixins

export default {
  extends: Doughnut,
  mixins: [reactiveProp],
  props: ['options'],
  data() {
    return {
      value: 60
    }
  },
  mounted() {
    const drawCenterText = chart => { // 센터에 글자를 그리기 위해
      if (chart.config.options.elements.center !== undefined) {
        const { width, height, ctx } = chart.chart
        ctx.restore()
        chart.config.options.elements.center.forEach((item, index) => {
          ctx.font = item.font
          ctx.fillStyle = item.fillStyle
          ctx.textBaseline = 'middle'

          const textX = Math.round((width - ctx.measureText(item.text).width) / 2)
          const textY = height / 2

          ctx.fillText(item.text, textX, textY + index * 40 - 10)
        })
        ctx.save()
      }
    }
    const setInfoForRoundedCorner = chart => {
      if (chart.config.options.elements.arc.roundedCornersFor !== undefined) {
        var arc = chart.getDatasetMeta(0).data[chart.config.options.elements.arc.roundedCornersFor]
        arc.round = {
          x: (chart.chartArea.left + chart.chartArea.right) / 2,
          y: (chart.chartArea.top + chart.chartArea.bottom) / 2,
          radius: (chart.outerRadius + chart.innerRadius) / 2,
          thickness: (chart.outerRadius - chart.innerRadius) / 2 - 1,
          backgroundColor: arc._model.backgroundColor
        }
      }
    }
    const drawRoundedCorner = chart => { // 그래프의 가장자리가 둥그스럼하게 하기 위해
      if (chart.config.options.elements.arc.roundedCornersFor !== undefined) {
        var ctx = chart.chart.ctx
        var arc = chart.getDatasetMeta(0).data[chart.config.options.elements.arc.roundedCornersFor]
        var startAngle = Math.PI / 2 - arc._view.startAngle
        var endAngle = Math.PI / 2 - arc._view.endAngle

        ctx.save()
        ctx.translate(arc.round.x, arc.round.y)
        console.log(arc.round.startAngle)
        ctx.fillStyle = arc.round.backgroundColor
        ctx.beginPath()
        ctx.arc(
          arc.round.radius * Math.sin(startAngle),
          arc.round.radius * Math.cos(startAngle),
          arc.round.thickness,
          0,
          2 * Math.PI
        )
        ctx.arc(
          arc.round.radius * Math.sin(endAngle),
          arc.round.radius * Math.cos(endAngle),
          arc.round.thickness,
          0,
          2 * Math.PI
        )
        ctx.closePath()
        ctx.fill()
        ctx.restore()
      }
    }
    this.addPlugin({
      id: 'centerText',
      afterDraw: drawCenterText
    })
    this.addPlugin({
      id: 'roundedCornerGraph',
      afterUpdate: setInfoForRoundedCorner,
      afterDraw: drawRoundedCorner
    })
    this.renderChart(this.chartData, this.options)
    this.htmlLegend = this.generateLegend()
  }
}
</script>