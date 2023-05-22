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
      // linePath: [],
      attractionList: [],
      markers: [],
      curSelected: {},
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
      // this.linePath.push(
      //   new window.kakao.maps.LatLng(33.452344169439975, 126.56878163224233)
      // );
      // this.linePath.push(
      //   new window.kakao.maps.LatLng(33.452739313807456, 126.5709308145358)
      // );
      // this.linePath.push(
      //   new window.kakao.maps.LatLng(33.45178067090639, 126.5726886938753)
      // );
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
      this.drawLine(this.planItemList);
    },
    attractions() {
      console.log("map att " + this.attractions);

      this.markers = [];
      this.attractions.forEach((attraction) => {
        this.markers.push(this.makeMark(attraction));
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
    curSelected() {
      console.log("marker-click");
      this.$emit("marker-click", this.curSelected);
      // this.markerItemClick(this.curSelected)
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
      return { element, markerPosition, markerImage, content };
    },
    showMark(elements) {
      elements.forEach((element) => {
        var marker = new window.kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: element.markerPosition, // 마커의 위치
          image: element.markerImage,
        });
        var infowindow = new window.kakao.maps.InfoWindow({
          content: element.content, // 인포윈도우에 표시할 내용
        });
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
        window.kakao.maps.event.addListener(
          marker,
          "click",
          this.makeClickListener(element.element)
        );
      });
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
    makeClickListener(attraction) {
      return () => {
        console.log(attraction);
        this.curSelected = attraction;
      };
    },
    // markerItemClick(plan){
    //   console.log("marker-click");
    //   console.log(plan);
    //   this.$emit("marker-click", plan);
    // },

    // addPoint(lat, lng) {
    //   console.log(this.linePath);
    //   this.linePath.push(
    //     new window.kakao.maps.LatLng(33.45178067090639, 126.5)
    //   );
    //   console.log(lat, lng);
    //   console.log(this.linePath);
    // },
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
        disableDoubleClickZoom: true,
      };
      this.map = new window.kakao.maps.Map(container, options);

    },
    drawLine(route) {
      // console.log(1);
      const linePath = []
      route.forEach(element => {
        linePath.push(new window.kakao.maps.LatLng(element.latitude, element.longitude))
      });
      // 지도에 표시할 선을 생성합니다
      const polyline = new window.kakao.maps.Polyline({
        path: linePath, // 선을 구성하는 좌표배열 입니다
        strokeWeight: 5, // 선의 두께 입니다
        strokeColor: "#FFAE00", // 선의 색깔입니다
        strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: "solid", // 선의 스타일입니다
      });

      // 지도에 선을 표시합니다
      polyline.setMap(this.map);
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
