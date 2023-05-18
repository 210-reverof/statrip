<template>
    <div class="plan-display">
      <div class="exp-title">완전 예쁜 루트</div>
      <div class="exp-desc">
        2023.01.07, jessixas_tt
      </div>
      <div class="plan-info">여행지 개수 : 이동거리 : 1</div>
      <div class="scroll-container">
        <plan-item></plan-item>
        <plan-item></plan-item>
        <plan-item></plan-item>
        <plan-item></plan-item>
        <plan-item></plan-item>
      </div>
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
  .plan-items {
    height: 80px;
  }
  
  .scroll-container {
    width: 90%;
    max-height: 650px;
    overflow-y: auto;
  }
  </style>
  