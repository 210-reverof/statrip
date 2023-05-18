<template>
  <div class="plan-display">
    <div class="exp-title">현재 여행 경로</div>
    <div class="exp-desc">지도에서 바로 여행지를 추가하세요. 특정 여행지를 삭제하려면 하단에 추가된 칸을 더블 클릭하세요 </div>
    <div class="plan-info">여행지 개수 : 1     최단 경로 : 1</div>
    <plan-item></plan-item>
  </div>
</template>

<script>
import PlanItem from "@/components/plan/side/PlanItem.vue";

export default {
  name: "PlanDisplay",
  components: {
    PlanItem,
  },
};
</script>

<style scoped>
.plan-display {
  width: 300px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.exp-title {
    width: 80%;
    text-align: left;
    padding-top: 20px;
    font-size: 20px;
    padding-bottom: 8px;
    font-weight: bold;
}

.exp-desc {
    width: 80%;
    text-align: left;
    font-size: 14px;
    padding-bottom: 16px;
}

.plan-info {
    width: 80%;
    text-align: left;
    font-size: 14px;
    padding-bottom: 8px;
    color: darkgreen;
    font-weight: 600;
}
</style>
