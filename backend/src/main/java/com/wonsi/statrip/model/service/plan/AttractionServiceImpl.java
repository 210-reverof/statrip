package com.wonsi.statrip.model.service.plan;

import com.wonsi.statrip.model.dto.plan.AttractionDto;
import com.wonsi.statrip.model.dto.plan.GugunDto;
import com.wonsi.statrip.model.dto.plan.SidoDto;
import com.wonsi.statrip.model.service.plan.AttractionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {
    @Override
    public AttractionDto selectOne(int contentId) {
        return null;
    }

    @Override
    public List<AttractionDto> selectList(int sidoCode, int gugunCode, int[] types) {
        return null;
    }

    @Override
    public List<SidoDto> selectSidoList() {
        return null;
    }

    @Override
    public List<GugunDto> selectGugunList(int sidoCode) {
        return null;
    }

    @Override
    public List<AttractionDto> selectIdList(int[] types) {
        return null;
    }
}
