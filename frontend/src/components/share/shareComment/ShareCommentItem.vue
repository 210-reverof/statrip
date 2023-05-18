<template>
  <div>
    <b-row>
      <b-col> <user-tag></user-tag></b-col>
    </b-row>
    <b-row class="comment-content">{{detail}}</b-row>
  </div>
</template>

<script>
import UserTag from '@/components/common/UserTag.vue';

export default {
  name: "ShareCommentItem",
  components:{
    UserTag
  },
  props:{
    detail:Object,
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
.comment{
  /* margin-left: 1%;
  margin-right: 1%; */
}

.comment-content{
  margin-left: 3%;
  margin-right: 3%;
}
</style>
