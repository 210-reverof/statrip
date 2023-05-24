<template>
  <div
    class="hot-spot-card"
    @click="cardClick"
  >
    <user-tag :userId="tmp" class="hot-spot-user-tag"></user-tag>
    <like-tag
      class="hot-spot-like-tag"
      :is-liked="true"
      :number="this.item.likes"
    ></like-tag>

    <b-modal v-model="show" hide-backdrop centered hide-footer>
    <template #modal-title>
      <user-tag :userId="tmp" ></user-tag>
    </template>
    <div>
    <img :src="require(`@/img/${item.imgName}`)" class="modal-content" />
    </div>
  </b-modal>
    <img :src="require(`@/img/${item.imgName}`)"  class="backgroundImg"/>
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
    }
  },
  data() {
    return {
      // id: "",
      show: false,
      variants: ["primary", "secondary", "success"],
      bodyTextVariant: "dark",
      tmp: "tmp"
    };
  },
  methods: {
    hoverEffect() {
      this.$refs.card.style.opacity = 0.5;
    },
    cardClick() {
      this.show = true;
      console.log(this.item.articleNo);
    },
    close(){

    }
  },
  created() {
    // this.id = this.item.articleNo;
    console.log(this.item)
  },
};
</script>

<style scoped>
.hot-spot-card {
  width: 300px;
  height: 400px;
}

.hot-spot-card:hover {
  opacity: 0.8;
}

.backgroundImg{
  float: none;
  width: 100%;
  height: 100%;
  margin-top: -11%;
}

.hot-spot-user-tag {
  position: relative;
  margin-top: 0;
  margin-left: 5%;
  }

.hot-spot-like-tag {
  position: relative;
  margin-left: 90%;
  margin-top: -11%;
}

.modal-content {
  width: 100%;
  height: 100%;
  justify-content: center;
}

.modal-img{
  width: 400px;
  height: 500px;
  min-width: 400px;
  min-height: 500px;
  border-radius: 20px;
  margin: 0 auto;
}

.modal-user{
  position: absolute;
  top: -40%;
  left: -40%;
}

.close{
  position: absolute;
  top: -36%;
  right: -45%;
  width: 30px;
  height: 30px;
}
</style>
