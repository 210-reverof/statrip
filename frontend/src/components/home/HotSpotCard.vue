<template>
    <div class="hot-spot-card" style="width: 300px; height: 400px; background-color: yellowgreen;">
    </div>
</template>

<script>
export default {
    name: "HotSpotCard",
    methods: {
        hoverEffect() {
            this.$refs.card.style.opacity = 0.5;
        }
    }
}
</script>

<style>
.hot-spot-card:hover {
  opacity: 0.8;
}
</style>