<template>
  <div class="hot-spot-list">
    <div class="contents-block">
      <h2>Hot Spots</h2>
      <h5>나만의 핫스팟을 인증샷과 함께 자랑해주세요</h5>
      <hr />
      <div class="card-holder">
        <b-row
          id="my-row"
          :items="items"
          :per-page="perPage"
          :current-page="currentPage"
        >
          <b-col
            class="card-col"
            cols="3"
            v-for="item in lists"
            :key="item.name"
          >
            <hot-spot-card :item="item"></hot-spot-card>
          </b-col>
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
import HotSpotCard from "@/components/home/HotSpotCard.vue";
import { getHotspotList } from "@/api/hotspot";
export default {
  name: "HotspotList",
  components: {
    HotSpotCard,
  },
  data() {
    return {
      perPage: 8,
      currentPage: 1,
      items: [],
    };
  },
  created() {
    getHotspotList(
      ({ data }) => (this.items = data),
      (error) => console.log(error),
      console.log(this.items)
    );
  },
  mounted() {
    console.log(this.items)
  },
  computed: {
    lists() {
      const items = this.items;
      return items.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
    totalRows() {
      return this.items.length;
    },
  },
  methods: {},
};
</script>

<style scoped>
.hot-spot-list {
  justify-content: center;
}
.contents-block {
  justify-content: center;
  margin: 0 auto;
  width: 1500px;
}

.b-row {
  display: flex;
  justify-content: center;
}

.card-col {
  display: flex;
  justify-content: center;
  padding-bottom: 2%;
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
