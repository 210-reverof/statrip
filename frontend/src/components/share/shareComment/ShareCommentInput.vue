<template>
  <div>
    <b-textarea placeholder="댓글을 입력하세요" v-model="content">
    </b-textarea>
    <b-button @click="createComment">댓글달기</b-button>
  </div>
</template>

<script>

export default {
  name: "ShareCommentInput",
  components: {},
  props:{
    user:String
  },
  data() {
    return {
      content: "",
    };
  },
  created() {},
  methods: {
    createComment(){
        console.log("댓글입력! : "+this.user+" : "+this.content);
    }
  },
};
</script>

<style scoped></style>
