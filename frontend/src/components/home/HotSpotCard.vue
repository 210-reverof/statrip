<template>
  <div
    class="hot-spot-card"
    :style="{ backgroundImage: 'url(' + this.item.img + ')' }"
    @click="cardClick"
  >
    <user-tag class="user-tag"></user-tag>
    <like-tag class="like-tag" :is-liked="true" :number="5"></like-tag>

  </div>
</template>

<script>
import UserTag from "@/components/common/UserTag.vue";
import LikeTag from "@/components/common/LikeTag.vue";

export default {
  name: "HotSpotCard",
  components: {
    UserTag,
    LikeTag,
  },
  props: {
    item: {
      type: Object,
      required: true,
    },
  },
  methods: {
    hoverEffect() {
      this.$refs.card.style.opacity = 0.5;
    },
    cardClick(){
      console.log(this.item.id)
    }
  },
  created() {},
};
</script>

<style scope>
.hot-spot-card {
  width: 300px;
  height: 400px;
}

.hot-spot-card:hover {
  opacity: 0.8;
}

.user-tag {
  padding-top: 20px;
  padding-left: 40px;
}

.like-tag {
  margin-left: 220px;
  margin-top: 300px;
}
</style>
