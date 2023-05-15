<template>
    <div class="hot-spot-card">
        <user-tag class="user-tag"></user-tag>
    </div>
</template>

<script>
import UserTag from '@/components/common/UserTag.vue';

export default {
    name: "HotSpotCard",
    components: {
        UserTag
    },
    methods: {
        hoverEffect() {
            this.$refs.card.style.opacity = 0.5;
        }
    }
}
</script>

<style scope>
.hot-spot-card {
    width: 300px; 
    height: 400px; 
    background-color: yellowgreen;
}

.hot-spot-card:hover {
  opacity: 0.8;
}

.user-tag {
    padding-top: 20px;
    padding-left: 40px;
}
</style>