<template>
  <div class="share-list">
    <div class="contents-block">
      <h3>{{ usernickn }}의 공유 계획</h3>

      <b-row id="my-row" :items="items" :per-page="perPage" :current-page="currentPage">
        <b-col class="col-margin" cols="6" v-for="item in lists" :key="item.name" @click="moveDetail(item.id)">
          <share-card class="card-size" :detail="item"></share-card>
        </b-col>
      </b-row>
    </div>

    <b-button class="btn-pos" squared variant="outline-info">글쓰기</b-button>

    <b-pagination class="center" v-model="currentPage" :total-rows="totalRows" :per-page="perPage" aria-controls="my-row"></b-pagination>
  </div>
</template>

<script>
import ShareCard from "@/components/home/ShareCard.vue";
export default {
  name: "UserShareList",
  components: {
    ShareCard,
  },
  data: function () {
    return {
      perPage: 6,
      currentPage: 1,
      items: [],
    };
  },
  created() {
    this.items = this.$route.params.items;
    this.usernickn = this.$route.params.usernickn;
  },
  computed: {
    lists() {
      const items = this.items;
      // Return just page of items needed
      return items.slice((this.currentPage - 1) * this.perPage, this.currentPage * this.perPage);
    },
    totalRows() {
      return this.items.length;
    },
  },
  methods: {
    moveDetail(id) {
      console.log(id);
      this.$router.push({ name: "shareDetail", params: { id: id } });
    },
  },
};
</script>

<style scoped>
.share-list {
  justify-content: center;
}

.contents-block {
  max-width: 1500px;
  justify-content: center;
  margin: 0 auto;
}

.center {
  justify-content: center;
}

.card-size {
  width: 85%;
  margin: 60px auto;
}

.btn-pos {
  margin-left: 80%;
  margin-right: 2%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style>
