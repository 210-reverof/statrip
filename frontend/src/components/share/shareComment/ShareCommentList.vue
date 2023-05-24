<template>
  <div>
    <b-row>
      <b-col>
        <div class="backgorund-green" v-if="userInfo">
            <share-comment-input :shareId="shareId"></share-comment-input >
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <div v-for="item in comments" :key="item.id">
          <hr>
          <share-comment-item :detail="item"></share-comment-item>
        </div>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import ShareCommentItem from "./ShareCommentItem.vue";
import ShareCommentInput from "./ShareCommentInput.vue";
import { getComments } from "@/api/comment";
import { mapState } from "vuex";
const userStore = "userStore";

export default {
  name: "ShareCommentList",
  components: {
    ShareCommentItem,
    ShareCommentInput,
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
  },
  props:{
    shareId: {},
  },
  data() {
    return {
      comments: null,
    };
  },
  created() {
    getComments(this.shareId, 
    ({data}) => this.comments = data,
    (error) => console.log(error)
    )

  },
  methods: {},
};
</script>

<style scoped>

.backgorund-green{
  background-color: #EAF3E8;
  padding: 1%;
  /* margin-left: 5%;
  margin-right: 5%; */
}

</style>