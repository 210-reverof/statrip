package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.StatDto;
import com.wonsi.statrip.model.dto.response.CloudDto;
import com.wonsi.statrip.model.dto.response.CountDto;
import com.wonsi.statrip.model.dto.response.FollowCntDto;
import com.wonsi.statrip.model.dto.response.GraphDto;
import com.wonsi.statrip.model.service.JwtService;
import com.wonsi.statrip.model.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/stat")
public class StateController {

    @Autowired
    private StatService statService;
    @Autowired
    private JwtService jwtService;

    @GetMapping("/my")
    public ResponseEntity<StatDto> getMyStat() throws Exception {
    	System.out.println("my");
        String userId = jwtService.getUserId();
        StatDto dto = statService.getStat(userId);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<StatDto> getStat(@PathVariable("userId") String userId) throws Exception {
        StatDto dto = statService.getStat(userId);
        
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/exp")
    public ResponseEntity<StatDto> getExpStat() throws Exception {
    	String userId = jwtService.getUserId();
    	StatDto dto = statService.getExpStat(userId);
    	
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/mycount")
    public ResponseEntity<CountDto> getMyCount() throws Exception {
    	String userId = jwtService.getUserId();
    	CountDto dto = statService.getCount(userId);
    	
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/count/{userId}")
    public ResponseEntity<CountDto> getCount(@PathVariable("userId") String userId) throws Exception {
    	CountDto dto = statService.getCount(userId);
    	
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/recommend")
    public ResponseEntity<List<StatDto>> getMyRecommend() throws Exception {
        String userId = jwtService.getUserId();
        List<StatDto> recommends = statService.getRecommend(userId);

        return ResponseEntity.ok(recommends);
    }
    
    @GetMapping("/graph")
    public ResponseEntity<GraphDto> getGraph() throws Exception {

    	 return ResponseEntity.ok(statService.getGraph());
    }
    
    @GetMapping("/cloud")
    public ResponseEntity<List<CloudDto>> getCloud() throws Exception {

    	 return ResponseEntity.ok(statService.getCloud());
    }
}
