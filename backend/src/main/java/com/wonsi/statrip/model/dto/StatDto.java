package com.wonsi.statrip.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatDto {
    // 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점)
    private String userId;
    private int sightSeeing = 0;
    private int cultural = 0;
    private int festival = 0;
    private int travelRoute = 0;
    private int leports = 0;
    private int sleeping = 0;
    private int shopping = 0;
    private int restaurant = 0;
    private double sightSeeingPercent = 0;
    private double culturalPercent = 0;
    private double festivalPercent = 0;
    private double travelRoutePercent = 0;
    private double leportsPercent = 0;
    private double sleepingPercent = 0;
    private double shoppingPercent = 0;
    private double restaurantPercent = 0;
    private int firstType = 0;
    private int secondType = 0;

    public StatDto() {}

    public StatDto(String userId, int sightSeeing, int cultural, int festival, int travelRoute, int leports, int sleeping, int shopping, int restaurant) {
        this.userId = userId;
        this.sightSeeing = sightSeeing;
        this.cultural = cultural;
        this.festival = festival;
        this.travelRoute = travelRoute;
        this.leports = leports;
        this.sleeping = sleeping;
        this.shopping = shopping;
        this.restaurant = restaurant;
    }
}
