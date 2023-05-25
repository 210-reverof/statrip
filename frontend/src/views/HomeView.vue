<template>
    <div class="home">
        <top-block></top-block>
        <hot-spot-block></hot-spot-block>
        <plan-block></plan-block>
        <recommend-block></recommend-block>
        <word-cloud></word-cloud>
        <real-radar-chart-graph></real-radar-chart-graph>
    </div>
</template>

<script>
import TopBlock from '@/components/home/TopBlock.vue';
import HotSpotBlock from '@/components/home/HotSpotBlock.vue';
import PlanBlock from '@/components/home/PlanBlock.vue';
import RecommendBlock from '@/components/home/RecommendBlock.vue';
import WordCloud from '@/components/common/WordCloud.vue'
import RealRadarChartGraph from "@/components/common/RealRadarChartGraph.vue";

export default {
  name: "HomeView",
  components: {
    TopBlock,
    HotSpotBlock,
    PlanBlock,
    RecommendBlock,
    WordCloud,
    RealRadarChartGraph
  }
};

</script>