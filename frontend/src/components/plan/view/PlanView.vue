<template>
  <div class="plan-view">
    <plan-display :plan="plan"></plan-display>
    <div class="map-block">
      <kakao-map ref="kakaomap"></kakao-map>
    </div>
  </div>
</template>

<script>
import KakaoMap from "@/components/plan/KakaoMap.vue";
import PlanDisplay from "@/components/plan/view/PlanDisplay.vue";

import { getPlan } from "@/api/plan"

export default {
  name: "PlanView",
  components: {
    KakaoMap,
    PlanDisplay
  },
  data() {
    return {
      message: "",
      plan: {
        planId: 0,
        userId: "",
        title: "",
        attractions: [],
        createdAt: "" 
      }
    };
  },
  created() {
    const planId = this.$route.params.planId;

    getPlan(planId,
    ({data}) => this.plan = data,
    (error) => console.log(error));
  },
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
