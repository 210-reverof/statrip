<template>
  <div class="plan-view">
    <plan-display></plan-display>
    <div class="map-block">
      <kakao-map ref="kakaomap"></kakao-map>
    </div>
  </div>
</template>

<script>
import KakaoMap from "@/components/plan/KakaoMap.vue";
import PlanDisplay from "@/components/plan/view/PlanDisplay.vue";

export default {
  name: "PlanView",
  components: {
    KakaoMap,
    PlanDisplay
  },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
.plan-view {
  display: flex;
  width: 100%;
}

.plan-display {
  min-width: 200px; /* 왼쪽 컴포넌트의 최소 너비 설정 */
}

.map-block {
  flex: 1;
  position: relative;
}</style>
