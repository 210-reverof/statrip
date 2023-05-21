<template>
  <div class="plan-display">
    <button class="share-button">공유</button>
    <div class="exp-title">{{ plan.title }}</div>
    <div class="exp-desc">
      {{ plan.createdAt }}, {{ plan.userId }}
    </div>
    <div class="plan-info">여행지 개수 : 이동거리 : 1</div>
    <div class="scroll-container">
      <plan-item v-for="attraction in plan.attractions" :key="attraction.id" :plan="attraction"></plan-item>
    </div>
  </div>
</template>
  
<script>
import PlanItem from "@/components/plan/side/PlanItem.vue";

export default {
  name: "PlanDisplay",
  props: {
    plan: {
      type: Object,
      required: true
    }
  },
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

.share-button {
  width: 80%;
  text-align: center;
  margin-top: 20px;
  font-size: 20px;
  padding: 8px;
  font-weight: bold;
  color: rgb(240, 255, 248);
  background-color: rgb(84, 198, 166);
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.share-button:hover {
  background-color: skyblue;
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
  