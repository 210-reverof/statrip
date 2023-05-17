<template>
  <div>
    <b-row>
      <b-col cols="2"> <user-tag></user-tag></b-col>
    </b-row>
    <b-row>{{detail}}</b-row>
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

<style scoped></style>
