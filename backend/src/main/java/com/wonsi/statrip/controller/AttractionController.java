package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.plan.AttractionDto;
import com.wonsi.statrip.model.dto.plan.GugunDto;
import com.wonsi.statrip.model.dto.plan.SidoDto;
import com.wonsi.statrip.model.service.plan.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attraction")
public class AttractionController {

    @Autowired
    AttractionService attractionService;

    @GetMapping("/{id}")
    public AttractionDto one(@PathVariable("id") int contentId) throws Exception {
        return attractionService.selectOne(contentId);
    }

    @GetMapping("/list")
    public List<AttractionDto> list(int sido, int gugun, @RequestParam("types") int[] types) throws Exception {
    	System.out.println("list - Controller");
        return attractionService.selectList(sido, gugun, types);
    }

    @GetMapping("/idlist")
    public List<AttractionDto> idlist(@RequestParam("types") int[] ids) throws Exception {
        System.out.println("idlist: " + attractionService.selectIdList(ids));
        return attractionService.selectIdList(ids);
    }

    @GetMapping("/sido")
    public List<SidoDto> sido() throws Exception {
    	System.out.println("sido - Controller");
        return attractionService.selectSidoList();
    }

    @GetMapping("/gugun/{sidoCode}")
    public List<GugunDto> gugun(@PathVariable("sidoCode") int sidoCode) throws Exception {
    	System.out.println("gugun - Controller");
    	return attractionService.selectGugunList(sidoCode);
    }
}
