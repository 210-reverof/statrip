package com.wonsi.statrip.model.service.plan;

import com.wonsi.statrip.model.dto.plan.PlanDto;
import com.wonsi.statrip.model.dto.plan.PlanResDto;
import com.wonsi.statrip.model.repository.UserRepository;
import com.wonsi.statrip.model.repository.plan.PlanRepository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private SqlSession sqlSession;

    @Override
    public List<PlanResDto> selectMyList(String userId) throws Exception {
        return null;
    }

    @Override
    public void insertPlan(PlanDto planDto) throws Exception {
    	int cnt = sqlSession.getMapper(PlanRepository.class).insertPlan(planDto);
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
    public PlanResDto selectPlan(int palnId) throws Exception {
        return null;
    }
}
