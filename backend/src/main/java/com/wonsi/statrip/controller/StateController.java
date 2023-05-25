package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.StatDto;
import com.wonsi.statrip.model.service.JwtService;
import com.wonsi.statrip.model.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/{userId}")
    public ResponseEntity<StatDto> getStat(@PathVariable("userId") String userId) throws Exception {
        StatDto dto = statService.getStat(userId);
        
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/exp/{userId}")
    public ResponseEntity<StatDto> getExpStat(@PathVariable("userId") String userId) throws Exception {
        StatDto dto = statService.getExpStat(userId);
        
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/recommend")
    public ResponseEntity<List<StatDto>> getMyRecommend() throws Exception {
        String userId = jwtService.getUserId();
        List<StatDto> recommends = statService.getRecommend(userId);

        return ResponseEntity.ok(recommends);
    }
}
