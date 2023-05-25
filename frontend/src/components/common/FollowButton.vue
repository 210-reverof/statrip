<template>
  <div class="follow-button" v-if="userInfo && userId != userInfo.userId">
    <div v-if="isFollowing" class="unfollow-btn">
      <button @click="unfollowUser()">Unfollow</button>
    </div>
    <div v-else class="follow-btn">
      <button @click="followUser()">Follow</button>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
const userStore = "userStore";
import { doIFollow, follow, unfollow } from "@/api/user";

export default {
  name: "FollowButton",
  computed: {
    ...mapState(userStore, ["userInfo"]),
  },
  components: {},
  props: {
    userId: {
      required: true,
    },
  },
  data() {
    return {
      isFollowing: false,
    };
  },
  created() {
    this.checkFollow();
  },
  methods: {
    checkFollow() {
      doIFollow(
        this.userId,
        ({ data }) => {
          this.isFollowing = data;
        },
        (error) => console.log(error)
      );
    },
    followUser() {
      follow(
        this.userId,
        () => {
          console.log("팔로우 성공");
          window.location.reload();
        },
        (error) => console.log(error)
      );
    },
    unfollowUser() {
      unfollow(
        this.userId,
        () => {
          console.log("언팔 성공");
          window.location.reload();
        },
        (error) => console.log(error)
      );
    },
  },
};
</script>

<style scoped>
.follow-btn button {
  background-color: #4caf50;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}

.unfollow-btn button {
  background-color: #dce8b3;
  color: rgb(27, 93, 48);
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}

.follow-btn button:hover {
  background-color: #45a049;
}
</style>
