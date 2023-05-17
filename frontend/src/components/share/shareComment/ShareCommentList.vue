<template>
  <div>
    <b-row>
      <b-col>
        <div class="backgorund-green">
            <share-comment-input :user="user"></share-comment-input >
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <div v-for="item in comments" :key="item.id" class="comment-list-align">
          <hr />
          <share-comment-item :detail="item"></share-comment-item>
        </div>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import ShareCommentItem from "./ShareCommentItem.vue";
import ShareCommentInput from "./ShareCommentInput.vue";
export default {
  name: "ShareCommentList",
  components: {
    ShareCommentItem,
    ShareCommentInput,
  },
  data() {
    return {
      user: "currentuser",
      comments: [
        {
          writer: "u1",
          content: "꿀잼",
          regitdate: "2023-05-07",
          regittime: "16:26",
        },
        {
          writer: "u2",
          content: "노잼",
          regitdate: "2023-05-07",
          regittime: "16:27",
        },
        {
          writer: "me",
          content: "굿굿",
          regitdate: "2023-05-07",
          regittime: "16:28",
        },
      ],
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped>

.backgorund-green{
  background-color: #EAF3E8;
  padding: 1%;
  margin-left: 5%;
  margin-right: 5%;
}
.comment-list-align{
  padding: 1%;
  margin-left: 5%;
  margin-right: 5%;

}
</style>