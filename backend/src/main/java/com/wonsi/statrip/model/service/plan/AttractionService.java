package com.wonsi.statrip.model.service.plan;

import com.wonsi.statrip.model.dto.plan.AttractionDto;
import com.wonsi.statrip.model.dto.plan.GugunDto;
import com.wonsi.statrip.model.dto.plan.SidoDto;

import java.util.List;

public interface AttractionService {
    AttractionDto selectOne(int contentId);
    List<AttractionDto> selectList(int sidoCode, int gugunCode, int[] types);
    List<SidoDto> selectSidoList();
    List<GugunDto> selectGugunList(int sidoCode);
    List<AttractionDto> selectIdList(int[] types);
}
