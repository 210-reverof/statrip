<template>
    <div>
        <h2>카카오맵 보기</h2>
        <div id="map"></div>
    </div>
</template>

<script>
export default {
    name: "KakaoMap",
    components: {},
    data() {
        return {
            map:null
        };
    },
    created() {
        console.log(process.env.VUE_APP_KAKAO_KEY);
    },
    mounted(){
        if(window.kakao && window.kakao.maps){
            this.loadMap();
        }
        else{
            this.loadScript();
        }
    },
    methods: {
        loadScript(){
            const script = document.createElement("script");
            // script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey="+process.env.VUE_APP_KAKAO_KEY+"&autoload=false";
            script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=16f6cc9334d56036de512a858997f912&autoload=false";
            script.onload = () => window.kakao.maps.load(this.loadMap);
            document.head.appendChild(script);
        },
        loadMap(){
            const container = document.getElementById('map');
            const options = {
                center: new window.kakao.maps.LatLng(33.450701, 126.570667),
                level: 3
            };
            this.map = new window.kakao.maps.Map(container, options);
        }
    },
};
</script>

<style scoped>
#map{
    width: 800px;
    height: 400px;
    margin: auto;
}
</style>