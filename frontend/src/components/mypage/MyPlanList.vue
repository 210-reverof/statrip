<template>
  <div class="myplan-list">
    <div class="contents-block">
      <br>
      <h1>마이 페이지</h1>
      <h5>나의 계획</h5>
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
        @click="$router.push({ name: 'hotspotAdd' })"
        >글쓰기</b-button
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
export default {
  name: "MyPlanList",
  components: {
    PlanCard,
  },
  data: function () {
    return {
      perPage: 2,
      currentPage: 1,
      plans: [],
    };
  },
  created() {
    this.plans = this.$route.params.items;
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
