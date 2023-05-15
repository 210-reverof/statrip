<template>
    <div class="home">
        <top-block></top-block>
        <hot-spot-block></hot-spot-block>
        <plan-block></plan-block>
    </div>
</template>

<script>
import TopBlock from '@/components/home/TopBlock.vue';
import HotSpotBlock from '@/components/home/HotSpotBlock.vue';
import PlanBlock from '@/components/home/PlanBlock.vue';

export default {
  name: "HomeView",
  components: {
    TopBlock,
    HotSpotBlock,
    PlanBlock
  }
};

</script>
