package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.HotspotArticleDto;
import com.wonsi.statrip.model.service.HotspotArticleService;
import com.wonsi.statrip.model.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hotspot")
public class HotspotArticleController {
	
    @Autowired
    private HotspotArticleService hotspotArticleService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    private ResponseEntity<String> writeArticle(@RequestParam int planId, @RequestParam int attractionId, @RequestParam("file") MultipartFile file ) throws Exception {
    	System.out.println("hot - writeArticle start");
        String userId = jwtService.getUserId();
        HotspotArticleDto hotspotArticleDto = new HotspotArticleDto();
        hotspotArticleDto.setUserId(userId);
        hotspotArticleDto.setPlanId(planId);
        hotspotArticleDto.setAttractionId(attractionId);
        
        try {
            String uploadDir = "c:/tmp/img/";
            String fileName = file.getOriginalFilename();
            String filePath = uploadDir + fileName;
            
            // 파일 저장
            File dest = new File(filePath);
            file.transferTo(dest);

            hotspotArticleDto.setUploadDir(uploadDir);
            hotspotArticleDto.setImgName(fileName);
            hotspotArticleDto.setImgPath(filePath);

            System.out.println("hot - writeArticle upload : " + hotspotArticleDto.toString());
            hotspotArticleService.writeArticle(hotspotArticleDto);
            
            return ResponseEntity.ok("success");
        	
        }catch (IOException e) {
            e.printStackTrace();

            return ResponseEntity.ok("fail");
        }

    }

    @GetMapping
    private ResponseEntity<List<HotspotArticleDto>> getList() throws Exception {
        List<HotspotArticleDto> articles = hotspotArticleService.listArticle();

        return ResponseEntity.ok(articles);
    }

    @GetMapping("/list/user/{user}")
    private ResponseEntity<List<HotspotArticleDto>> getUserList() throws Exception {
        List<HotspotArticleDto> articles = hotspotArticleService.listArticle();

        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{no}")
    private ResponseEntity<HotspotArticleDto> getArticle(@PathVariable("no") int no) throws Exception {
    	HotspotArticleDto article = hotspotArticleService.getArticle(no);

        return ResponseEntity.ok(article);
    }
    
    @DeleteMapping("/{no}")
    private ResponseEntity<String> deleteArticle(@PathVariable("no") int no) throws Exception {
    	hotspotArticleService.deleteArticle(no);

        return ResponseEntity.ok("success");
    }

}
