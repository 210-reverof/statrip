<template>
    <div class="user-item">
        <hr class="hr-line" />
        <div class="info-row">
            <user-tag class="tag" :userId="user.userId"></user-tag>
            <p class="user-name">{{ user.name }}</p>
            <p class="user-email">{{ user.email }}</p>
            <follow-button :userId="user.userId"></follow-button>
        </div>
        <hr class="hr-line" />
    </div>
</template>
  
<script>
import UserTag from "@/components/common/UserTag.vue";
import FollowButton from "@/components/common/FollowButton.vue";

export default {
    name: "UserItem",
    components: {
        UserTag,
        FollowButton
    },
    props: {
        user: {
            required: true,
        },
    },
    data() {
        return {

        }
    },
    created() {
    },
    methods: {
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
</style>
  