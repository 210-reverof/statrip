package com.wonsi.statrip.model.dto.plan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionDto {
    private int contentId;
    private int contentTypeId;    // 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점)
    private String overview;
    private String title;
    private String addr1;
    private String firstImage;
    private int sidoCode;
    private String sidoName;
    private int gugunCode;
    private String gugunName;
    private double latitude;
    private double longitude;

    public AttractionDto() {
    }
}
