<template>
  <div
    class="hot-spot-card"
    :style="{ backgroundImage: 'url(' + this.item.img + ')' }"
    @click="cardClick"
  >
    <user-tag :userId="item.userId" class="hot-spot-user-tag"></user-tag>
    <like-tag
      class="hot-spot-like-tag"
      :is-liked="true"
      :number="this.item.likes"
    ></like-tag>

    <b-modal v-model="show" class="custom-modal" size="sm" centered hide-header hide-footer>
      <b-row class="modal-content" ><img :src="item.img" class="modal-img" /></b-row>
      
      <user-tag :userId="item.userId" class="modal-user"></user-tag>
      <div class="close" @click="show=false">X</div>
      
    </b-modal>
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
  data() {
    return {
      id: "",
      show: false,
      variants: ["primary", "secondary", "success"],
      bodyTextVariant: "dark",
    };
  },
  methods: {
    hoverEffect() {
      this.$refs.card.style.opacity = 0.5;
    },
    cardClick() {
      this.show = true;
      console.log(this.item.id);
    },
    close(){

    }
  },
  created() {
    this.id = this.item.id;
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
  display: flex;
  align-items: center;
  justify-content: center;
  width: 300px;
  height: 400px;
}

/* .custom-modal .modal-dialog{
  max-width: 60px;
  max-height: 100px;
} */
.modal-img{
  width: 600px;
  height: 800px;
  border-radius: 20px;
  margin-left: -50%;
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
