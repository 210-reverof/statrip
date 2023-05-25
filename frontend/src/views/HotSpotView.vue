<template>
  <div class="hotspot">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "HotSpotView",
};
</script>

<style scoped>
.hotspot{
  min-height: 500px;
}
</style>