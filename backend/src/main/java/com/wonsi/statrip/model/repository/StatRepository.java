package com.wonsi.statrip.model.repository;

import com.wonsi.statrip.model.dto.TypeCountDto;
import com.wonsi.statrip.model.dto.response.CloudDto;
import com.wonsi.statrip.model.dto.response.CountDto;

import java.util.List;

public interface StatRepository {
    List<TypeCountDto> getTotalCountByType(String userId) throws Exception;
    List<TypeCountDto> getRealCountByType(String userId) throws Exception;
    int getPostCount(String userId);
	int getLikeCount(String userId);
	List<Integer> getCountByContents(int gender);
	List<CloudDto> getCloud();
	
}
