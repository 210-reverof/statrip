package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.StatDto;
import com.wonsi.statrip.model.dto.plan.AttractionDto;

import java.util.List;

public interface StatService {
    StatDto getStat(String userId) throws Exception;
    List<StatDto> getRecommend(String userId) throws Exception;
}
