<template>
  <div>
    <!-- <div>{{ attractionList }}</div> -->
    <div id="map"></div>
  </div>
</template>

<script>
import { mapState } from "vuex";
const attractionStore = "attractionStore";

export default {
  name: "KakaoMap",
  components: {},
  props: {
    planItemList: [],
  },
  data() {
    return {
      map: null,
      linePath: [],
      attractionList: [],
      markers: [],
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
  computed: {
    ...mapState(attractionStore, ["sidos", "attractions"]),
  },
  watch: {
    planItemList(newValue, oldValue) {
      console.log(newValue, oldValue);
      this.attractionList = newValue;

      // 지도 중심을 부드럽게 이동시킵니다
      // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
      var moveLatLon = new window.kakao.maps.LatLng(
        this.attractionList.at(-1).latitude,
        this.attractionList.at(-1).longitude
      );
      this.map.panTo(moveLatLon);
    },
    //작동 안함
    sidos() {
      this.markers.forEach((marker) => {
        marker.setMap(null);
      });
    },
    attractions() {
      console.log("map att " + this.attractions);

      this.markers = [];
      this.attractions.forEach((element) => {
        this.markers.push(this.makeMark(element));
      });
      this.showMark(this.markers);
      // for(var i = 0; i < this.attractions.length; i++){
      //   const eventItem = this.attractions[i].contentId;
      //   window.kakao.maps.event.addListener(this.markers[i], "click", function () {
      //     console.log("in "+ eventItem)
      //     // this.$emit("marker-click", i, this.attractions[i]);
      //   });
      // }
    },
  },
  methods: {
    makeMark(element) {
      var imageSrc =
          "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png", // 마커이미지의 주소입니다
        imageSize = new window.kakao.maps.Size(25, 25), // 마커이미지의 크기입니다
        imageOption = {}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

      if (element.contentTypeId == 12) {
        imageSrc = require(`@/assets/marker/marker_photo.png`);
      } else if (element.contentTypeId == 14) {
        imageSrc = require(`@/assets/marker/marker_his.png`);
      } else if (element.contentTypeId == 15) {
        imageSrc = require(`@/assets/marker/marker_party.png`);
      } else if (element.contentTypeId == 25) {
        imageSrc = require(`@/assets/marker/marker_trip.png`);
      } else if (element.contentTypeId == 28) {
        imageSrc = require(`@/assets/marker/marker_sports.png`);
      } else if (element.contentTypeId == 32) {
        imageSrc = require(`@/assets/marker/marker_bed.png`);
      } else if (element.contentTypeId == 38) {
        imageSrc = require(`@/assets/marker/marker_shop.png`);
      } else if (element.contentTypeId == 39) {
        imageSrc = require(`@/assets/marker/marker_food.png`);
      }
      const coordX = element.latitude;
      const coordY = element.longitude;
      // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
      var markerImage = new window.kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imageOption
        ),
        markerPosition = new window.kakao.maps.LatLng(coordX, coordY), // 마커가 표시될 위치입니다
        content = `<div style="height: 100px;width: 350px ">
                    <div style="background-color: #EAF3E8">${element.title}</div>
                        <div style="display: flex; flex-direction: row">
                            <img style="width: 115px; height: 75px" src=${element.firstImage}></img>
                            <div>
                                <span>${element.addr1}</span>
                            </div>
                        </div>
                    </div>
                </div>`;
      return { markerPosition, markerImage, content };
    },
    showMark(positions) {
      for (var i = 0; i < positions.length; i++) {
        // 마커를 생성합니다
        var marker = new window.kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: positions[i].markerPosition, // 마커의 위치
          image: positions[i].markerImage,
        });

        // 마커에 표시할 인포윈도우를 생성합니다
        var infowindow = new window.kakao.maps.InfoWindow({
          content: positions[i].content, // 인포윈도우에 표시할 내용
        });

        // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
        // 이벤트 리스너로는 클로저를 만들어 등록합니다
        // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
        window.kakao.maps.event.addListener(
          marker,
          "mouseover",
          this.makeOverListener(this.map, marker, infowindow)
        );
        window.kakao.maps.event.addListener(
          marker,
          "mouseout",
          this.makeOutListener(infowindow)
        );
        
      }
    },
    makeOverListener(map, marker, infowindow) {
      return function () {
        infowindow.open(map, marker);
      };
    },
    makeOutListener(infowindow) {
      return function () {
        infowindow.close();
      };
    },
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