package com.wonsi.statrip.model.repository.plan;

import com.wonsi.statrip.model.dto.plan.PlanDto;
import com.wonsi.statrip.model.dto.plan.PlanResDto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PlanRepository {
    List<PlanResDto> selectMyList(String userId) throws Exception;
    int insertPlan(PlanDto planDto) throws Exception;
    void insertPlanPresent1(@Param("planId") Integer planId, @Param("attractionId") Integer attractionId) throws Exception;
    void insertPlanPresent2(@Param("planId") Integer planId, @Param("attractionId") Integer attractionId) throws Exception;
    void insertPlanPresent3(@Param("planId") Integer planId, @Param("attractionId") Integer attractionId) throws Exception;
    void insertPlanAttrs(Integer planId, Integer attractionId, Integer ord) throws Exception;
    void updatePlan(PlanDto planDto) throws Exception;
    void deletePlan(int planId) throws Exception;
    PlanResDto selectPlan(int palnId) throws Exception;
}
