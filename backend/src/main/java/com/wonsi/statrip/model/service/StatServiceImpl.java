package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.StatDto;
import com.wonsi.statrip.model.dto.TypeCountDto;
import com.wonsi.statrip.model.repository.StatRepository;
import com.wonsi.statrip.model.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatServiceImpl implements StatService{
    @Autowired
    private SqlSession sqlSession;
    @Override
    public StatDto getStat(String userId) throws Exception {
        List<TypeCountDto> map = sqlSession.getMapper(StatRepository.class).getTotalCountByType(userId);
        StatDto dto = new StatDto();
        dto.setUserId(userId);

        // 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점)
        int sum = 0;
        for (TypeCountDto t : map) {
            if (dto.getFirstType() == 0) dto.setFirstType(t.getTypeId());
            else if (dto.getSecondType() == 0) dto.setSecondType(t.getTypeId());
            sum += t.getCnt();
            if (t.getTypeId() == 12) dto.setSightSeeing(t.getCnt());
            else if (t.getTypeId() == 14) dto.setCultural(t.getCnt());
            else if (t.getTypeId() == 15) dto.setFestival(t.getCnt());
            else if (t.getTypeId() == 25) dto.setTravelRoute(t.getCnt());
            else if (t.getTypeId() == 28) dto.setLeports(t.getCnt());
            else if (t.getTypeId() == 32) dto.setSleeping(t.getCnt());
            else if (t.getTypeId() == 38) dto.setShopping(t.getCnt());
            else if (t.getTypeId() == 39) dto.setRestaurant(t.getCnt());
        }
        if (sum == 0) return dto;

        for (TypeCountDto t : map) {
            if (t.getTypeId() == 12) dto.setSightSeeingPercent((double)t.getCnt() / sum);
            else if (t.getTypeId() == 14) dto.setCulturalPercent((double)t.getCnt() / sum);
            else if (t.getTypeId() == 15) dto.setFestivalPercent((double)t.getCnt() / sum);
            else if (t.getTypeId() == 25) dto.setTravelRoutePercent((double)t.getCnt() / sum);
            else if (t.getTypeId() == 28) dto.setLeportsPercent((double)t.getCnt() / sum);
            else if (t.getTypeId() == 32) dto.setSleepingPercent((double)t.getCnt() / sum);
            else if (t.getTypeId() == 38) dto.setShoppingPercent((double)t.getCnt() / sum);
            else if (t.getTypeId() == 39) dto.setRestaurantPercent((double)t.getCnt() / sum);
        }
        return dto;
    }

    @Override
    public List<StatDto> getRecommend(String userId) throws Exception {
        List<StatDto> recommends = new ArrayList<>();
        List<String> users = sqlSession.getMapper(UserRepository.class).userList();
        StatDto first = null;
        StatDto second = null;
        StatDto my = getStat(userId);

        for (String u : users) {
            if (u.equals(userId)) continue;

            StatDto curr = getStat(u);
            if (first == null) {
                first = curr;
                continue;
            }
            if (second == null) {
                second = curr;
                continue;
            }

            double sim = calcSimilarity(my, curr);
            if (sim > calcSimilarity(my, first)) {
                second = first;
                first = curr;
            } else if (sim > calcSimilarity(my, second)) {
                second = curr;
            }
        }

        recommends.add(first);
        recommends.add(second);
        return recommends;
    }

    private static double calcSimilarity(StatDto statDto1, StatDto statDto2) {
        double val1 = Math.sqrt(
                Math.pow(statDto1.getSightSeeingPercent(), 2) +
                        Math.pow(statDto1.getCulturalPercent(), 2) +
                        Math.pow(statDto1.getFestivalPercent(), 2) +
                        Math.pow(statDto1.getTravelRoutePercent(), 2) +
                        Math.pow(statDto1.getLeportsPercent(), 2) +
                        Math.pow(statDto1.getSleepingPercent(), 2) +
                        Math.pow(statDto1.getShoppingPercent(), 2) +
                        Math.pow(statDto1.getRestaurantPercent(), 2)
        );

        double val2 = Math.sqrt(
                Math.pow(statDto2.getSightSeeingPercent(), 2) +
                        Math.pow(statDto2.getCulturalPercent(), 2) +
                        Math.pow(statDto2.getFestivalPercent(), 2) +
                        Math.pow(statDto2.getTravelRoutePercent(), 2) +
                        Math.pow(statDto2.getLeportsPercent(), 2) +
                        Math.pow(statDto2.getSleepingPercent(), 2) +
                        Math.pow(statDto2.getShoppingPercent(), 2) +
                        Math.pow(statDto2.getRestaurantPercent(), 2)
        );

        double mulVal = statDto1.getSightSeeingPercent() * statDto2.getSightSeeingPercent() +
                statDto1.getCulturalPercent() * statDto2.getCulturalPercent() +
                statDto1.getFestivalPercent() * statDto2.getFestivalPercent() +
                statDto1.getTravelRoutePercent() * statDto2.getTravelRoutePercent() +
                statDto1.getLeportsPercent() * statDto2.getLeportsPercent() +
                statDto1.getSleepingPercent() * statDto2.getSleepingPercent() +
                statDto1.getShoppingPercent() * statDto2.getShoppingPercent() +
                statDto1.getRestaurantPercent() * statDto2.getRestaurantPercent();

        if (val1 * val2 == 0) return 0;
        return mulVal / (val1 * val2);
    }
}
