package com.wonsi.statrip.model.repository.plan;

import com.wonsi.statrip.model.dto.plan.PlanDto;
import com.wonsi.statrip.model.dto.plan.PlanResDto;

import java.util.List;

public interface PlanRepository {
    List<PlanResDto> selectMyList(String userId) throws Exception;
    int insertPlan(PlanDto planDto) throws Exception;
    void insertPlanAttrs(Integer planId, Integer attractionId, Integer ord) throws Exception;
    void updatePlan(PlanDto planDto) throws Exception;
    void deletePlan(int planId) throws Exception;
    PlanResDto selectPlan(int palnId) throws Exception;
}
