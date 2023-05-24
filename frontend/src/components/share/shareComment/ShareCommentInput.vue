<template>
  <div>
    <b-row>
      <b-textarea class="text-area" placeholder="댓글을 입력하세요" v-model="comment.content">
      </b-textarea>
    </b-row>
    <b-row>
      <b-col class="btn-pos">
        <b-button class="btn-pos" squared variant="outline-info" @click="createComment">입력
        </b-button>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { addComment } from "@/api/comment";

export default {
  name: "ShareCommentInput",
  components: {},
  props: {
    shareId: {
      required: true
    },
  },
  data() {
    return {
      comment: {
        shareId: 0,
        content: ""
      }
    };
  },
  created() {
    this.comment.shareId = this.shareId;
  },
  methods: {
    createComment() {
      addComment(this.comment,this.handleDeleteSuccess, this.handleDeleteError
      )
    },
    handleDeleteSuccess() {
      window.location.reload();
    },
    handleDeleteError(error) {
      console.log(error);
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
  margin-left: 80%;
  margin-right: 2%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style>
