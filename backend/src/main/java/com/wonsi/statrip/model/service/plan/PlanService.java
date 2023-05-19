package com.wonsi.statrip.model.service.plan;

import com.wonsi.statrip.model.dto.plan.PlanDto;
import com.wonsi.statrip.model.dto.plan.PlanResDto;

import java.util.List;

public interface PlanService {
    List<PlanResDto> selectMyList(String userId) throws Exception;

    void insertPlan(PlanDto planDto) throws Exception;

    void updatePlan(PlanDto planDto) throws Exception;
    void deletePlan(int planId) throws Exception;

    PlanResDto selectPlan(int palnId) throws Exception;

}
