<template>
  <div>
    <b-row>
      <b-textarea
        class="text-area"
        placeholder="댓글을 입력하세요"
        v-model="content"
      >
      </b-textarea>
    </b-row>
    <b-row>
      <b-col class="btn-pos">
        <b-button
          class="btn-pos"
          squared
          variant="outline-info"
          @click="createComment"
          >입력
        </b-button>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  name: "ShareCommentInput",
  components: {},
  props: {
    user: String,
  },
  data() {
    return {
      content: "",
    };
  },
  created() {},
  methods: {
    createComment() {
      console.log("댓글입력! : " + this.user + " : " + this.content);
      this.content = "";
    },
  },
};
</script>

<style scoped>
.text-area {
  height: 80px;
  margin-left: 1%;
  margin-right: 1%;
}

.btn-pos {
  margin-top: 1%;
  margin-left:80%;
  margin-right: 2%;
  overflow:hidden;
	text-overflow:ellipsis;
	white-space:nowrap;
}
</style>
