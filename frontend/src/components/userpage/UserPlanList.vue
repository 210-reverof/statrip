<template>
  <div class="userplan-list">
    <div class="contents-block">
      <h3>{{usernickn}}의 계획</h3>
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
        @click="$router.push({ name: 'home' })"
        >초기화면</b-button
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
import { getPlanUserList } from "@/api/plan";

export default {
  name: "UserPlanList",
  components: {
    PlanCard,
  },
  data () {
    return {
      userId:"",
      perPage: 2,
      currentPage: 1,
      plans: [],
    };
  },
  created() {
    this.plans = this.$route.params.items;
    this.userId = this.$route.params.userId;
    console.log(this,this.userId);
    getPlanUserList( this.userId,
        ({ data }) => {this.plans = data;
        console.log(this.plan);},
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
.userplan-list {
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
