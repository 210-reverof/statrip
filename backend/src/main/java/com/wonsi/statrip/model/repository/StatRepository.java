package com.wonsi.statrip.model.repository;

import com.wonsi.statrip.model.dto.TypeCountDto;

import java.util.List;

public interface StatRepository {
    List<TypeCountDto> getTotalCountByType(String userId) throws Exception;
    List<TypeCountDto> getRealCountByType(String userId) throws Exception;
}
