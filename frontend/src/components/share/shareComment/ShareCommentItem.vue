<template>
  <div>
    <b-row class="header-row">
      <b-col>
        <user-tag :userId="detail.userId"></user-tag>
        {{ detail.createdAt }}
      </b-col>
      <b-col class="delete-col">
        <!-- 삭제 버튼을 오른쪽에 붙입니다 -->
        <b-button @click="deleteComment" variant="danger" size="sm">삭제</b-button>
      </b-col>
    </b-row>
    <b-row class="comment-content">{{ detail.content }}</b-row>
  </div>
</template>

<script>
import UserTag from "@/components/common/UserTag.vue";

export default {
  name: "ShareCommentItem",
  components: {
    UserTag,
  },
  props: {
    detail: Object,
  },
  created() {},
  methods: {
    deleteComment() {
      console.log("댓글 삭제 함수 호출");
    },
  },
};
</script>

<style scoped>
.header-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  border-radius: 5px;
  margin-bottom: 10px;
}

.delete-col {
  display: flex;
  justify-content: flex-end;
}

.comment-content {
  margin-left: 3%;
  margin-right: 3%;
}
</style>
