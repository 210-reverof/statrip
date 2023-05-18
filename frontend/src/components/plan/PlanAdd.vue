<template>
    <div class="plan-add">
        <plan-display></plan-display>
        <div class="map-block">
            <kakao-map></kakao-map>
        </div>
    </div>
</template>

<script>
import KakaoMap from '@/components/share/KakaoMap.vue';
import PlanDisplay from './side/PlanDisplay.vue';

export default {
    name: "PlanAdd",
    components: {
        KakaoMap,
        PlanDisplay
    }
}
</script>

<style scoped>
.plan-add {
  display: flex;
  width: 100%;
}

.plan-display {
  min-width: 200px; /* 왼쪽 컴포넌트의 최소 너비 설정 */
}

.map-block {
  flex: 1;
}
</style>