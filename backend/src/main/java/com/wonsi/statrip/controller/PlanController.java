package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.plan.PlanDto;
import com.wonsi.statrip.model.dto.plan.PlanListResDto;
import com.wonsi.statrip.model.dto.plan.PlanResDto;
import com.wonsi.statrip.model.service.JwtService;
import com.wonsi.statrip.model.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/plan")
public class PlanController {
	
	@Autowired
	private JwtService jwtService;

    @Autowired
    PlanService planService;

    @GetMapping
    public ResponseEntity<List<PlanListResDto>> list(HttpServletRequest request) throws Exception {
        String jwt = request.getHeader("access-token");
        if (!jwtService.checkToken(jwt)) return ResponseEntity.ok(planService.selectMyList("ssafy"));
    	String userId = jwtService.getUserId();
        List<PlanListResDto> list = planService.selectMyList(userId);
        return ResponseEntity.ok(list);
    }
    
    @PostMapping
	public ResponseEntity<String> insert(@RequestBody PlanDto planDto, HttpServletRequest request) throws Exception {
        String userId = jwtService.getUserId();
        planDto.setUserId(userId);
        System.out.println(planDto);
        planService.insertPlan(planDto);
    	
    	return ResponseEntity.ok("success");
    }

    @PutMapping
    public void update(@RequestBody PlanDto planDto) throws Exception {
        planService.updatePlan(planDto);
    }

    @DeleteMapping("/{planId}")
    public void delete(@PathVariable("planId") int planId) throws Exception {
        planService.deletePlan(planId);
    }

    @GetMapping("/{planId}")
    public PlanResDto view(@PathVariable("planId") int planId) throws Exception {
        PlanResDto PlanResDto = planService.selectPlan(planId);
        return PlanResDto;
    }
}
