<template>
    <div class="plan-block" align="center">
        <h3>New Plans</h3>
        <div class="plan-card-container">
            <plan-card v-for="plan in plans" :key="plan.id" :plan="plan" />
        </div>
    </div>
</template>
<script>
import PlanCard from "./PlanCard.vue";
import { getPlanList } from "@/api/plan";

export default {
    name: "PlanBlock",
    components: {
        PlanCard,
    },
    data() {
        return {
            plans: [],
        };
    },
    created() {
      getPlanList(
                ({ data }) => this.plans = data.slice(0,3),
                (error) => console.log(error)
            );
    },
    methods: {
    },
};
</script>

<style>
.plan-block {
    background-color: #e8f1e0;
    width: 100%;
    /* margin: 40px; */
}

.plan-block h3 {
    color: #1a4213;
    font-size: 40px;
    font-weight: bold;
    padding-top: 100px;
    padding-bottom: 60px;
}

.plan-card-container {
    padding-bottom: 100px;
}
</style>
