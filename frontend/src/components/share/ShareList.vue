<template>
  <b-container class="mt-3" >
    <div>
      <b-row>
        <b-col>
          <h2>Share</h2>
          <h5>자신이 자랑하고싶은 여행 경로를 공유해주세요</h5>
          <hr>
        </b-col>
      </b-row>
      <b-row
        id="my-row"
        :items="items"
        :per-page="perPage"
        :current-page="currentPage"
      >
        <b-col cols="6" v-for="item in lists" :key="item.name">
            {{item.id}}
          <share-card></share-card>
        </b-col>
      </b-row>
    </div>
    <b-pagination
      class="center"
      v-model="currentPage"
      :total-rows="totalRows"
      :per-page="perPage"
      aria-controls="my-row"
    ></b-pagination>
  </b-container>
</template>

<script>
import ShareCard from '@/components/home/ShareCard.vue';
export default {
  name: "ShareList",
  components: {
    ShareCard
  },
  data: function () {
    return {
      perPage: 6,
      currentPage: 1,
      items: [
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:2, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:3, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:4, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:5, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:6, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:7, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:8, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
          {id:9, writer:'Jessica_jj', img:"http://placehold.it/300x200?text=No-image", likes:"12", content:"이 경로 진짜 짱짱 추천입니다", regitdate:"2023.03.03"},
      ]
    }
  },
  created() {},
  computed: {
    lists () {
      const items = this.items;
      // Return just page of items needed
      return items.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      )
    },
    totalRows () {
      return this.items.length
    }
  },
  methods: {},
};
</script>

<style scoped>


.center {
  justify-content: center;
}

.col-style {
  margin: 5%;
  padding: 5%;
}

</style>
