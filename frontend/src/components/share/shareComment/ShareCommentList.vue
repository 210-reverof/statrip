<template>
    <div>
        <share-comment-input :user="user"></share-comment-input>
        <div v-for="item in comments" :key="item.id">
            <hr>
            <share-comment-item :detail="item"></share-comment-item> 
        </div>
    </div>
</template>

<script>
import ShareCommentItem from './ShareCommentItem.vue';
import ShareCommentInput from './ShareCommentInput.vue';
export default {
    name: 'ShareCommentList',
    components: {
        ShareCommentItem,
        ShareCommentInput
    },
    data() {
        return {
            user:"currentuser",
            comments:[
                {writer:'u1', content:'꿀잼', regitdate:'2023-05-07', regittime:'16:26'},
                {writer:'u2', content:'노잼', regitdate:'2023-05-07', regittime:'16:27'},
                {writer:'me', content:'굿굿', regitdate:'2023-05-07', regittime:'16:28'},
            ]
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped></style>