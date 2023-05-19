<template>
  <div class="hot-spot-block" align="center">
    <div class="card-panel">
      <div>
        <h3 style="color: white; font-size: 40px; padding: 30px">Hot Spot</h3>
        <div class="card-carousel-wrapper">
          <button class="card-carousel--nav__left" @click="moveCarousel(-1)" :disabled="atHeadOfList"></button>
          <div class="card-carousel">
            <div class="card-carousel--overflow-container">
              <div class="card-carousel-cards" :style="{ transform: 'translateX(' + currentOffset + 'px)' }">
                <div class="card-carousel--card" v-for="item in items" :key="item.id">
                  <hot-spot-card :item="item"></hot-spot-card>
                </div>
              </div>
            </div>
          </div>
          <button class="card-carousel--nav__right" @click="moveCarousel(1)" :disabled="atEndOfList"></button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import HotSpotCard from './HotSpotCard.vue';

export default {
  name: "HotSpotBlock",
  components: {
    HotSpotCard
  },
  data() {
    return {
      currentOffset: 0,
      windowSize: 4,
      paginationFactor: 340,
      items: [
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 2,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 3,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 4,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 5,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
        {
          id: 6,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x400?text=No-image",
          likes: "12",
        },
      ],
    };
  },
  computed: {
    atEndOfList() {
      return (
        this.currentOffset <=
        this.paginationFactor * -1 * (this.items.length - this.windowSize)
      );
    },
    atHeadOfList() {
      return this.currentOffset === 0;
    },
  },
  methods: {
    moveCarousel(direction) {
      if (direction === 1 && !this.atEndOfList) {
        this.currentOffset -= this.paginationFactor;
      } else if (direction === -1 && !this.atHeadOfList) {
        this.currentOffset += this.paginationFactor;
      }
    },
  },
};
</script>

<style scoped>
.card-panel {
  margin-top: -200px;
  width: 1500px;
  height: 700px;
}

.card-panel h3 {
  color: #ffffff; 
  font-size: 40px; 
  font-weight: bold;
}

.card-carousel-wrapper {
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 20px 0 40px;
}

.card-carousel {
  display: flex;
  justify-content: center;
  width: 1320px;
  height: 600px;
}

.card-carousel--overflow-container {
  overflow: hidden;
}

.card-carousel--nav__left,
.card-carousel--nav__right {
  width: 40px;
  height: 40px;
  border-top: 3px solid var(--vue-teal);
  border-right: 3px solid var(--vue-teal);
  cursor: pointer;
  margin: 0 20px;
  background-color: transparent;
  transition: transform 150ms linear;
}

.card-carousel--nav__left {
  rotate: 45deg;
}

.card-carousel--nav__right {
  rotate: 225deg;
}

.card-carousel--nav__left[disabled],
.card-carousel--nav__right[disabled] {
  opacity: 0.2;
  border-color: black;
}

.card-carousel-cards {
  display: flex;
  transition: transform 150ms ease-out;
  transform: translatex(0px);
}

.card-carousel--card {
  margin: 0 20px;
  cursor: pointer;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.4);
  z-index: 4;
  margin-bottom: 2px;
}

.card-carousel--card:first-child {
  margin-left: 0;
}

.card-carousel--card:last-child {
  margin-right: 0;
}

</style>
