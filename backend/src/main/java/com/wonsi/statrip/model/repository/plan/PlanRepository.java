package com.wonsi.statrip.model.repository.plan;

import com.wonsi.statrip.model.dto.plan.PlanAttrDto;
import com.wonsi.statrip.model.dto.plan.PlanDto;
import com.wonsi.statrip.model.dto.plan.PlanListResDto;
import com.wonsi.statrip.model.dto.plan.PlanResDto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PlanRepository {
    List<PlanListResDto> selectMyList(String userId) throws Exception;
    int insertPlan(PlanDto planDto) throws Exception;
    void insertPlanPresent1(@Param("planId") Integer planId, @Param("attractionId") Integer attractionId) throws Exception;
    void insertPlanPresent2(@Param("planId") Integer planId, @Param("attractionId") Integer attractionId) throws Exception;
    void insertPlanPresent3(@Param("planId") Integer planId, @Param("attractionId") Integer attractionId) throws Exception;
    void insertPlanAttrs(Integer planId, Integer attractionId, Integer ord) throws Exception;
    void updatePlan(PlanDto planDto) throws Exception;
    void deletePlan(int planId) throws Exception;
    void deletePlanRelation(int planId) throws Exception;
    void deleteShareByPlan(int planId) throws Exception;
    PlanResDto selectPlan(int planId) throws Exception;
    List<PlanAttrDto> selectPlanAttrs(int planId) throws Exception;
    List<Integer> getRelatedPlanIds(List<Integer> selectedAttrs, int size, String userId) throws Exception;
    List<PlanListResDto> AllList();
	List<PlanListResDto> followList(String userId);
}
