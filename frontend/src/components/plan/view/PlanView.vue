<template>
  <div class="plan-view">
    <plan-display :plan="plan" :curLength="curLength"></plan-display>
    <div class="map-block">
      <!-- {{plan.attractions}} -->
      <kakao-map ref="kakaomap" :kakaoMapType="2" :kakaoAttractions="plan.attractions"
      @current-length="CheckCurLength"></kakao-map>
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
        createdAt: "" ,
      },
      curLength:{}
    };
  },
  created() {
    const planId = this.$route.params.planId;
    getPlan(planId,
    ({data}) => {
      this.plan = data;
      // console.log(this.plan)
    },
    (error) => console.log(error));
  },
  methods: {
    CheckCurLength(curLength){
      this.curLength = curLength;
    }
  },
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
