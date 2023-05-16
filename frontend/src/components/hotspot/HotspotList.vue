<template>
  <b-container class="mt-3">
    <div>
      <b-row>
        <b-col>
          <h2>Hot Spots</h2>
          <h5>나만의 핫스팟을 인증샷과 함께 자랑해주세요</h5>
          <hr />
        </b-col>
      </b-row>
        {{currentPage}}
      <b-row
        id="my-table"
        :items="items"
        :per-page="perPage"
        :current-page="currentPage"
      >
        <b-col cols="3" v-for="item in lists" :key="item.name">
          <div class="col-style">
            {{item.id}}
            <hot-spot-card></hot-spot-card>
          </div>
        </b-col>
      </b-row>
    </div>
    <b-pagination
      class="center"
      v-model="currentPage"
      :total-rows="totalRows"
      :per-page="perPage"
      aria-controls="my-table"
    ></b-pagination>
  </b-container>
</template>

<script>
import HotSpotCard from "@/components/home/HotSpotCard.vue";
export default {
  name: "HotspotList",
  components: {
    HotSpotCard
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
