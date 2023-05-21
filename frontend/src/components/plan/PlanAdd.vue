<template>
  <div class="plan-add">
    <plan-display :planItemList="planItemList"></plan-display>
    <div class="map-block">
      <kakao-map ref="kakaomap"></kakao-map>
      <b-button v-b-toggle.sidebar-right class="search-bar-button"
        >여행지 검색</b-button
      >
      <plan-search @search-click="addPointToMap"></plan-search>
    </div>
  </div>
</template>

<script>
import KakaoMap from "@/components/plan/KakaoMap.vue";
import PlanDisplay from "@/components/plan/side/PlanDisplay.vue";
import PlanSearch from "@/components/plan/side/PlanSearch.vue";

export default {
  name: "PlanAdd",
  components: {
    KakaoMap,
    PlanDisplay,
    PlanSearch
  },
  data() {
    return {
      planItemList:[]
    };
  },
  methods: {
    addPointToMap(index, plan) {
      console.log("addPointToMap");
      console.log(index+" "+ plan);
      this.planItemList.push(plan);
      console.log(this.planItemList);

      // this.$refs.kakaomap.addPoint(plan);
    },
  },
};
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
  position: relative;
}

.search-bar-button {
  position: absolute;
  top: 10px;
  right: 10px;
  z-index: 2;
  background-color: rgb(66, 131, 77);
  border-color: rgb(76, 136, 85);
}

.sidebar-content {
  flex: 1; /* Make the sidebar content expand to fill the available space */
  display: flex;
  flex-direction: column;
}
</style>
