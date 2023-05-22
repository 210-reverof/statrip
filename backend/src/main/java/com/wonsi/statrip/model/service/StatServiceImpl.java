package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.StatDto;
import com.wonsi.statrip.model.dto.TypeCountDto;
import com.wonsi.statrip.model.dto.plan.AttractionDto;
import com.wonsi.statrip.model.repository.StatRepository;
import com.wonsi.statrip.model.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            sum += t.getCnt();
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
        return null;
    }
}
