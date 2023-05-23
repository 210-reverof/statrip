package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.plan.PlanAttrDto;
import com.wonsi.statrip.model.dto.plan.PlanDto;
import com.wonsi.statrip.model.dto.plan.PlanListResDto;
import com.wonsi.statrip.model.dto.plan.PlanResDto;
import com.wonsi.statrip.model.service.JwtService;
import com.wonsi.statrip.model.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list/all")
    public ResponseEntity<List<PlanListResDto>> list() throws Exception {
        List<PlanListResDto> list = planService.AllList();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/list/follow")
    public ResponseEntity<List<PlanListResDto>> followList() throws Exception {
    	String userId = jwtService.getUserId();
        List<PlanListResDto> list = planService.followList(userId);
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/list/my")
    public ResponseEntity<List<PlanListResDto>> MyList() throws Exception {
    	String userId = jwtService.getUserId();
        List<PlanListResDto> list = planService.selectMyList(userId);
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/list/user/{userId}")
    public ResponseEntity<List<PlanListResDto>> UserList(@PathVariable("userId") String userId) throws Exception {
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
    public ResponseEntity<PlanResDto> view(@PathVariable("planId") int planId) throws Exception {
        PlanResDto PlanResDto = planService.selectPlan(planId);
        return ResponseEntity.ok(PlanResDto);
    }

    @GetMapping("/overlay")
    public ResponseEntity<List<PlanResDto>> getOverlay(@RequestParam("sel") List<Integer> selectedAttrs) throws Exception {
        String userId = jwtService.getUserId();
        List<PlanResDto> plans = planService.getOverlayList(selectedAttrs, userId);

        return ResponseEntity.ok(plans);
    }
}
