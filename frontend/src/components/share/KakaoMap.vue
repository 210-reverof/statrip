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
    created() {},
    mounted(){
        if(window.kakao && window.kakao.map){
            this.loadMap();
        }
        else{
            this.loadScript();
        }
    },
    methods: {
        loadScript(){
            const script = document.getElement("script");
            script.src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7f1d9c7263f294dd3411aab9d1530c4e"
            script.onload = ()=> window.kakao.maps.load(this.loadMap);
            document.head.appendChild(script);
        },
        load(){
            const container = document.getElementById("map");
            const options = {
                center: new kakao.maps.LatLng(33.450701, 126.570667),
                level: 3
            };
            this.map = new kakao.maps.Map(container, options);
        }
    },
};
</script>

<style scoped>
#map{
    width: 80%;
    height: 400px;
}
</style>