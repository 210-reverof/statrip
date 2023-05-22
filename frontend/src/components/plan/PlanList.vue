<template>
  <div class="myplan-list">
    <div class="contents-block">
      <h1>Plan</h1>
      <h5>최신 경로 목록</h5>
      <hr />
      <div class="card-holder">
        <b-row
          class="center"
          id="my-row"
          :plans="plans"
          :per-page="perPage"
          :current-page="currentPage"
        >
          <plan-card v-for="plan in lists" :key="plan.id" :plan="plan" />
        </b-row>
      </div>
      <b-button
        class="btn-pos"
        squared
        variant="outline-info"
        @click="$router.push({ name: 'planAdd' })"
        >경로 추가하기</b-button
      >
      <b-pagination
        class="center"
        v-model="currentPage"
        :total-rows="totalRows"
        :per-page="perPage"
        aria-controls="my-row"
      ></b-pagination>
    </div>
  </div>
</template>

<script>
import PlanCard from "@/components/home/PlanCard.vue";
import { getPlanAllList } from "@/api/plan";

export default {
  name: "PlanList",
  components: {
    PlanCard,
  },
  data: function () {
    return {
      perPage: 2,
      currentPage: 1,
      plans: []
    };
  },
  created() {
    getPlanAllList(
                ({ data }) => this.plans = data,
                (error) => console.log(error)
            );
  },
  computed: {
    lists() {
      const items = this.plans;
      return items.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
    totalRows() {
      return this.plans.length;
    },
  },
  methods: {},
};
</script>

<style scoped>
.myplan-list {
  justify-content: center;
}
.contents-block {
  justify-content: center;
  margin: 0 auto;
  width: 1500px;
}

.center {
  justify-content: center;
}

.b-pagination {
  display: flex;
  justify-content: center;
}

.btn-pos {
  margin-top: 1%;
  margin-bottom: 1%;
  margin-left: 92%;
  margin-right: 1%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style>
