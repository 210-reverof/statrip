<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<script>
export default {
  name: "KakaoMap",
  components: {},
  data() {
    return {
      map: null,
      linePath: [],
    };
  },
  created() {},
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
      this.linePath.push(
        new window.kakao.maps.LatLng(33.452344169439975, 126.56878163224233)
      );
      this.linePath.push(
        new window.kakao.maps.LatLng(33.452739313807456, 126.5709308145358)
      );
      this.linePath.push(
        new window.kakao.maps.LatLng(33.45178067090639, 126.5726886938753)
      );
      this.drawLine1();
    } else {
      this.loadScript();
    }
  },
  methods: {
    addPoint(lat, lng) {
        console.log(this.linePath);
        this.linePath.push(
        new window.kakao.maps.LatLng(33.45178067090639, 126.5)
      );
      console.log(lat, lng);
      console.log(this.linePath);
    },
    loadScript() {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=16f6cc9334d56036de512a858997f912&autoload=false";
      // script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey="+process.env.VUE_APP_KAKAO_KEY+"&autoload=false";
      script.onload = () => window.kakao.maps.load(this.loadMap);
      document.head.appendChild(script);
    },
    loadMap() {
      const container = document.getElementById("map");
      const options = {
        center: new window.kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
      };
      this.map = new window.kakao.maps.Map(container, options);

      this.drawLine1();
      this.drawLine2();
    },
    drawLine1() {
      // console.log(1);
      // this.linePath = [
      //     new window.kakao.maps.LatLng(33.452344169439975, 126.56878163224233),
      //     new window.kakao.maps.LatLng(33.452739313807456, 126.5709308145358),
      //     new window.kakao.maps.LatLng(33.45178067090639, 126.5726886938753)
      // ];
      // 지도에 표시할 선을 생성합니다
      const polyline = new window.kakao.maps.Polyline({
        path: this.linePath, // 선을 구성하는 좌표배열 입니다
        strokeWeight: 5, // 선의 두께 입니다
        strokeColor: "#FFAE00", // 선의 색깔입니다
        strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: "solid", // 선의 스타일입니다
      });

      // 지도에 선을 표시합니다
      polyline.setMap(this.map);
    },
    drawLine2() {
      // console.log(2);
      const linePath1 = [
        new window.kakao.maps.LatLng(33.45254416, 126.56),
        new window.kakao.maps.LatLng(33.45293931, 126.57),
        new window.kakao.maps.LatLng(33.45198067, 126.57),
        new window.kakao.maps.LatLng(33.45178067090639, 126.5726886938753),
      ];
      // 지도에 표시할 선을 생성합니다
      const polyline1 = new window.kakao.maps.Polyline({
        path: linePath1, // 선을 구성하는 좌표배열 입니다
        strokeWeight: 5, // 선의 두께 입니다
        strokeColor: "#AAAE00", // 선의 색깔입니다
        strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: "solid", // 선의 스타일입니다
      });

      // 지도에 선을 표시합니다
      polyline1.setMap(this.map);
    },
  },
};
</script>

<style scoped>
#map {
  width: 100%;
  height: 800px;
  margin: auto;
}
</style>
