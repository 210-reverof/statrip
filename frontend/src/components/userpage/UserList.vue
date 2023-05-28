<template>
    <div class="user-following">
        <div v-if="isFollowing == 'true'">
            <h2>Following</h2>
            <h5>{{ userId }} 팔로잉</h5>
        </div>
        <div v-else>
            <h2>Follower</h2>
            <h5>{{ userId }} 팔로워</h5>
        </div>
        <hr />
        <div class="list-body">
            <user-item v-for="user in userList" :key="user.userId" :user="user"></user-item>
        </div>
    </div>
</template>
  
<script>
import UserItem from "@/components/userpage/UserItem.vue";
import { getFollowing, getFollower } from "@/api/user";

export default {
    name: "UserList",
    data() {
        return {
            isFollowing: this.$route.params.follow,
            userId: this.$route.params.userId,
            userList: [],
        };
    },
    created() {
        if (this.isFollowing == "true") {
            getFollowing(this.userId,
                ({ data }) => { this.userList = data; },
                (error) => console.log(error));

        } else {
            getFollower(this.userId,
                ({ data }) => { this.userList = data; },
                (error) => console.log(error));
        }
    },
    methods: {
    },
    components: {
        UserItem
    }
};
</script>

<style>
.list-body {
    margin-left: 15%;
    margin-right: 15%;
}
</style>
  