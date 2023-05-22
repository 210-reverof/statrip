package com.wonsi.statrip.model.service.plan;

import com.wonsi.statrip.model.dto.plan.*;

import java.util.List;

public interface PlanService {
    List<PlanListResDto> selectMyList(String userId) throws Exception;

    void insertPlan(PlanDto planDto) throws Exception;

    void updatePlan(PlanDto planDto) throws Exception;
    void deletePlan(int planId) throws Exception;

    PlanResDto selectPlan(int planId) throws Exception;

    List<PlanResDto> getOverlayList(List<Integer> selectedAttrs, String userId) throws Exception;

	List<PlanListResDto> AllList();

	List<PlanListResDto> followList(String userId);


}
