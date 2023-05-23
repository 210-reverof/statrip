<template>
    <div class="contents-block">
        <h2>Share</h2>
        <h5>공유 게시글을 작성해주세요</h5>
        <hr>
        <div>
            <plan-card :plan="plan"></plan-card>
            <div class="title-input">
                <input v-model="article.title" placeholder="공유게시물 제목을 적어주세요">
            </div>
            <hr>
            <div class="content-input">
                <textarea v-model="article.content" placeholder="공유게시물 내용을 입력해주세요"></textarea>
            </div>
        </div>
        <b-row class="justify-content-end">
            <b-button class="btn" squared variant="outline-success" @click="shareBtn">
                작성 완료
            </b-button>
            <b-button class="btn" squared variant="outline-info" @click="$router.push({ name: 'shareList' })">
                뒤로가기
            </b-button>
        </b-row>
    </div>
</template>
  
<script>
import PlanCard from '@/components/home/PlanCard.vue'
import { addShareArticle } from "@/api/share";

export default {
    name: "ShareWrite",
    components: {
        PlanCard
    },
    data() {
        return {
            plan: {},
            article : {
                title: "",
                content: ""
            }
        };
    },
    created() {
        this.plan = this.$route.params.plan;
        if (this.plan.attractions.length > 0) this.plan.img1 = this.plan.attractions[0].firstImage;
        if (this.plan.attractions.length > 1) this.plan.img2 = this.plan.attractions[1].firstImage;
        if (this.plan.attractions.length > 2) this.plan.img3 = this.plan.attractions[2].firstImage;
    },
    methods: {
        async shareBtn() {
            this.article.planId = this.plan.planId;
            await addShareArticle( this.article
                ,console.log(this.article)
                , console.log("fail")
            );
            this.$router.push({ name: 'shareList' })
        }
        
    },
};
</script>
  
<style scoped>
.contents-block {
    max-width: 1800px;
    justify-content: center;
    margin: 0 auto;
}

.content-left {
    text-align: left;
    padding-left: 5%;
    padding-right: 5%;
    margin-bottom: 5%;
}

.title-input,
.content-input {
    width: 100%;
    margin-bottom: 10px;
}

input,
textarea {
    width: 100%;
    padding-left: 20px;
    padding-right: 20px;
}
</style>
  