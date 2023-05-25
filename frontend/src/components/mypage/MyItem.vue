<template>
    <div class="user-item">
        <hr class="hr-line" />
        <div class="info-row">
            <user-tag class="tag" :userId="user.userId"></user-tag>
            <p class="user-name">{{ user.name }}</p>
            <p class="user-email">{{ user.email }}</p>
            <div class="follow-button">
                <div v-if="isFollowing" class="unfollow-btn">
                    <button @click="unfollowUser()">Unfollow</button>
                </div>
                <div v-else class="follow-btn">
                    <button @click="followUser()">Follow</button>
                </div>
            </div>
        </div>
        <hr class="hr-line" />
    </div>
</template>
  
<script>
import UserTag from "@/components/common/UserTag.vue";
import { doIFollow, follow, unfollow } from "@/api/user";

export default {
    name: "MyItem",
    components: {
        UserTag,
    },
    props: {
        user: {
            required: true,
        },
    },
    data() {
        return {
            isFollowing: false
        }
    },
    created() {
        this.checkFollow();
    },
    methods: {
        checkFollow() {
            doIFollow(
                this.user.userId,
                ({ data }) => {
                    this.isFollowing = data;
                },
                (error) => console.log(error)
            );
        },
        followUser() {
            follow(
                this.user.userId,
                () => {
                    console.log("팔로우 성공");
                    window.location.reload();
                },
                (error) => console.log(error)
            );
        },
        unfollowUser() {
            unfollow(
                this.user.userId,
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
  
<style>
.user-name, .user-email {
  margin: 0 10px; /* Add margin to the left and right sides */
}

.info-row {
    display: flex;
    align-items: center;
}

.hr-line {
    margin-bottom: 20px;
    margin-top: 10px;
}

.tag {
    margin-left: 20px;
}

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
  