<template>
  <div class="hot-spot-list">
    <div class="contents-block">
      <h2>Hot Spots</h2>
      <h5>나만의 핫스팟을 인증샷과 함께 자랑해주세요</h5>
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
            <hot-spot-card
              :imagePath="'https://via.placeholder.com/300x400'"
            ></hot-spot-card>
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
    </div>
  </div>
</template>

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
</style>

<script>
import HotSpotCard from "@/components/home/HotSpotCard.vue";
export default {
  name: "HotspotList",
  components: {
    HotSpotCard,
  },
  data: function () {
    return {
      perPage: 8,
      currentPage: 1,
      items: [
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 2,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 3,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 4,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 5,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 6,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 7,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 8,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 9,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 10,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
      ],
    };
  },
  created() {},
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
