<template>
  <div class="plan-add">
    <plan-display :planItemList="planItemList" @delete-click="deletePlan"
    @dragged="draggedItem"></plan-display>
    <div class="map-block">
      <kakao-map ref="kakaomap" :planItemList="planItemList" @marker-click="addPlanToMarker"></kakao-map>
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
import { mapState, } from "vuex";
const attractionStore = "attractionStore";

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
    addPointToMap(plan) {
      console.log("addPointToMap");
      console.log(plan);
      this.planItemList.push(plan);

      // this.$refs.kakaomap.addPoint(plan);
    },
    addPlanToMarker(plan) {
      console.log("addPlanToMarker");
      console.log(plan);
      this.planItemList.push(plan);

      // this.$refs.kakaomap.addPoint(plan);
    },
    deletePlan(index){
      console.log("deletePlan");
      this.planItemList.splice(index, 1);
    },
    draggedItem(attractionList){
      console.log("draggedPlan" + attractionList);
      this.planItemList = attractionList
    }
  },
  computed:{
    ...mapState(attractionStore, ["sidos", "guguns", "attractions"]),
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
