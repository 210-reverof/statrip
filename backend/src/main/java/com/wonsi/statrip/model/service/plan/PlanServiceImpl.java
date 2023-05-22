package com.wonsi.statrip.model.service.plan;

import com.wonsi.statrip.model.dto.plan.PlanAttrDto;
import com.wonsi.statrip.model.dto.plan.PlanDto;
import com.wonsi.statrip.model.dto.plan.PlanListResDto;
import com.wonsi.statrip.model.dto.plan.PlanResDto;
import com.wonsi.statrip.model.repository.UserRepository;
import com.wonsi.statrip.model.repository.plan.AttractionRepository;
import com.wonsi.statrip.model.repository.plan.PlanRepository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private SqlSession sqlSession;

    @Override
    public List<PlanListResDto> selectMyList(String userId) throws Exception {
        return sqlSession.getMapper(PlanRepository.class).selectMyList(userId);
    }

    @Override
    public void insertPlan(PlanDto planDto) throws Exception {
    	int cnt = sqlSession.getMapper(PlanRepository.class).insertPlan(planDto);


    	if (planDto.getAttractions().size() >= 1) sqlSession.getMapper(PlanRepository.class).insertPlanPresent1(planDto.getPlanId(), planDto.getAttractions().get(0));
    	if (planDto.getAttractions().size() >= 2) sqlSession.getMapper(PlanRepository.class).insertPlanPresent2(planDto.getPlanId(), planDto.getAttractions().get(1));
    	if (planDto.getAttractions().size() >= 3) sqlSession.getMapper(PlanRepository.class).insertPlanPresent3(planDto.getPlanId(), planDto.getAttractions().get(2));


    	for (int i = 0; i < planDto.getAttractions().size(); i++) {
    		sqlSession.getMapper(PlanRepository.class).insertPlanAttrs(planDto.getPlanId(), planDto.getAttractions().get(i), (i+1));
		}
    }

    @Override
    public void updatePlan(PlanDto planDto) throws Exception {

    }

    @Override
    public void deletePlan(int planId) throws Exception {

    }

    @Override
    public PlanResDto selectPlan(int planId) throws Exception {
        PlanResDto dto = sqlSession.getMapper(PlanRepository.class).selectPlan(planId);
        dto.setAttractions(sqlSession.getMapper(PlanRepository.class).selectPlanAttrs(planId));
        return dto;
    }

    @Override
    public List<PlanResDto> getOverlayList(List<Integer> selectedAttrs, String userId) throws Exception {
        List<Integer> ids = sqlSession.getMapper(PlanRepository.class).getRelatedPlanIds(selectedAttrs, selectedAttrs.size(), userId);
        List<PlanResDto> res = new ArrayList<>();
        for (Integer id : ids) {
            PlanResDto dto = new PlanResDto(id);
            dto.setAttractions(sqlSession.getMapper(PlanRepository.class).selectPlanAttrs(dto.getPlanId()));
            res.add(dto);
        }

        return res;
    }

	@Override
	public List<PlanListResDto> AllList() {
		return sqlSession.getMapper(PlanRepository.class).AllList();
	}

	@Override
	public List<PlanListResDto> followList(String userId) {
		return sqlSession.getMapper(PlanRepository.class).followList(userId);
	}
}
