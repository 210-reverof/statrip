package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.StatDto;
import com.wonsi.statrip.model.dto.plan.AttractionDto;
import com.wonsi.statrip.model.dto.response.CloudDto;
import com.wonsi.statrip.model.dto.response.CountDto;
import com.wonsi.statrip.model.dto.response.GraphDto;

import java.util.List;

public interface StatService {
    StatDto getStat(String userId) throws Exception;
    List<StatDto> getRecommend(String userId) throws Exception;
	StatDto getExpStat(String userId) throws Exception;
	CountDto getCount(String userId) throws Exception;
	GraphDto getGraph() throws Exception;
	List<CloudDto> getCloud() throws Exception;
}
