<template>
    <div>
        <kakao-map></kakao-map>
    </div>
</template>

<script>
import KakaoMap from './KakaoMap.vue';

export default {
    name: 'ViewPlan',
    components: {
        KakaoMap
    },
    data() {
        return {
            message: '',
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped>

</style>