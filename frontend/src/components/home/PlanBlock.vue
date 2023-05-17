<template>
  <div class="plan-block" align="center">
    <h3>New Plans</h3>
    <div class="plan-card-container">
      <plan-card v-for="plan in plans" :key="plan" :plan="plan" />
    </div>
  </div>
</template>
<script>
import PlanCard from './PlanCard.vue';

export default {
  name: "HotSpotBlock",
  components: {
    PlanCard
  },
  data() {
    return {
      plans: [1,2,3,4]
    }
  }
};
</script>

<style>
.plan-block {
  background-color: #E8F1E0;
  width: 100%;
  /* margin: 40px; */
}

.plan-block h3 {
  color: #1A4213; 
  font-size: 40px; 
  font-weight: bold;
  padding-top: 100px;
}

.plan-card-container {
  padding-bottom: 100px;
}

</style>