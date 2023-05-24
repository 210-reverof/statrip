<template>
    <div class="user-item">
        <hr class="hr-line"/>
        <div class="info-row">
            <user-tag class="tag" :userId="user.userId"></user-tag>
            <p>{{ user.name }}</p>
            <p>{{ user.email }}</p>
            <div v-if="doIFollow()" class="follow-btn">
            <button>follow</button>
            </div>
        </div>
        <hr class="hr-line"/>
    </div>
</template>

<script>
import UserTag from '@/components/common/UserTag.vue';
import { doIFollow } from "@/api/user";

export default {
    name: "UserItem",
    components: {
        UserTag
    },
    props: {
        user: {
            required:true
        }
    }
}
</script>

<style>
.hr-line {
    margin-bottom: 20px;
    margin-top: 10px;
}

.tag {
    margin-left: 20px;
}
</style>