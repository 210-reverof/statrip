<template>
    <div class="share-card">
        <div class="col-style">
            <b-row class="share-header">
              <b-col cols="8">
                <user-tag class="user-tag"></user-tag>
              </b-col>
              <b-col cols="4" >
                <like-tag class="user-tag" :is-liked="true" :number="5"></like-tag>
              </b-col>
            </b-row>
            <img src="http://placehold.it/300x200?text=No-image" class="img-style"><br>
            <b-row>
              <b-col cols="8">
                article.content
              </b-col>
              <b-col cols="4">
                article.regitdate
              </b-col>
            </b-row>
          </div>
    </div>
</template>

<script>
import UserTag from '@/components/common/UserTag.vue';
import LikeTag from "@/components/common/LikeTag.vue";

export default {
    name: "ShareCard",
    components: {
        LikeTag,
        UserTag
    },
    methods: {
        hoverEffect() {
            this.$refs.card.style.opacity = 0.5;
        }
    }
}
</script>

<style scope>

.share-card:hover {
  opacity: 0.8;
}
.share-header {
  margin: auto;
}
.user-tag {
  margin: auto;
}
.col-style {
  margin: 5%;
  margin-bottom: 10%;
  padding-bottom: 5%;
  border-radius: 1%;
	border-width: 1px;
	border-color: #b0b0b0;
  border-style: solid;
  box-shadow: 1px 1px 10px #b0b0b0;
}
.img-style {
  text-align: center;
  margin-top:10px;
  margin-bottom:10px;
  width: 90%;
  height: auto;
  border: 1;
}
</style>