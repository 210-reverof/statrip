<template>
  <div
    class="hot-spot-card"
    :style="{ backgroundImage: 'url(' + this.item.img + ')' }"
    @click="cardClick"
  >
    <user-tag class="user-tag"></user-tag>
    <like-tag
      class="like-tag"
      :is-liked="true"
      :number="this.item.likes"
    ></like-tag>

    <b-modal v-model="show" class="custom-modal" size="sm" centered hide-header hide-footer>
      <b-row class="modal-content" ><img :src="item.img" class="modal-img" /></b-row>
      
      <user-tag class="modal-user"></user-tag>
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
}

.modal-user{
  position: absolute;
  top: -40%;
  left: 5%;
}

.close{
  position: absolute;
  top: -35%;
  right: 10%;
  background-color: aqua;
  width: 30px;
  height: 30px;
}
</style>
