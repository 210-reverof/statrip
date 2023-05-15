<template>
    <div class="home">
        <top-block></top-block>
        <hot-spot-block></hot-spot-block>
    </div>
</template>

<script>
import TopBlock from '@/components/home/TopBlock.vue';
import HotSpotBlock from '@/components/home/HotSpotBlock.vue';

export default {
  name: "HomeView",
  components: {
    TopBlock,
    HotSpotBlock
  }
};

</script>
