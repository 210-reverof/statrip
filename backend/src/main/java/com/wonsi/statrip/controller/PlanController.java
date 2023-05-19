package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.plan.PlanDto;
import com.wonsi.statrip.model.dto.plan.PlanResDto;
import com.wonsi.statrip.model.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    PlanService planService;

    @GetMapping("/")
    public List<PlanResDto> list(String userId) throws Exception {
        List<PlanResDto> list = planService.selectMyList(userId);
        return list;
    }

    @PostMapping("/")
    public void insert(@RequestBody Map<String, Object> requestBody) throws Exception {
        String userId = (String) requestBody.get("userId");
        List<Integer> attrids = (List<Integer>) requestBody.get("attractions");
        String title = (String) requestBody.get("title");

        planService.insertPlan(new PlanDto(userId, title, attrids));
    }

    @PutMapping("/")
    public void update(@RequestBody PlanDto planDto) throws Exception {
        planService.updatePlan(planDto);
    }

    @DeleteMapping("/{planId}")
    public void delete(@PathVariable("planId") int planId) throws Exception {
        planService.deletePlan(planId);
    }

    @GetMapping("/{planId}")
    public PlanResDto view(@PathVariable("planId") int planId) throws Exception {
        PlanResDto routeDto = planService.selectPlan(planId);
        return routeDto;
    }
}
