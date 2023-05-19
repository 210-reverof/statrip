package com.wonsi.statrip.model.dto.plan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanAttrDto {
    boolean visited;
    int number;
    int contentId;
    int contentTypeId;	// 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점)
    String overview;
    String title;
    String addr1;
    String firstImage;
    int sidoCode;
    String sidoName;
    int gugunCode;
    String gugunName;
    double latitude;
    double longitude;

    public PlanAttrDto(boolean visited, int number, int contentId, int contentTypeId, String overview, String title,
                        String addr1, String firstImage, int sidoCode, String sidoName, int gugunCode, String gugunName,
                        double latitude, double longitude) {
        this.visited = visited;
        this.number = number;
        this.contentId = contentId;
        this.contentTypeId = contentTypeId;
        this.overview = overview;
        this.title = title;
        this.addr1 = addr1;
        this.firstImage = firstImage;
        this.sidoCode = sidoCode;
        this.sidoName = sidoName;
        this.gugunCode = gugunCode;
        this.gugunName = gugunName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "PlanAttrDto [visited=" + visited + ", number=" + number + ", contentId=" + contentId + ", title="
                + title + ", latitude=" + latitude + "]";
    }

}
