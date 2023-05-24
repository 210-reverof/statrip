package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.ShareArticleDto;
import com.wonsi.statrip.model.service.JwtService;
import com.wonsi.statrip.model.service.ShareArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareArticleController {

    @Autowired
    private ShareArticleService shareArticleService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    private ResponseEntity<String> getArticle(@RequestBody ShareArticleDto shareArticleDto) throws Exception {
        String userId = jwtService.getUserId();
        shareArticleDto.setUserId(userId);
        shareArticleService.writeArticle(shareArticleDto);

        return ResponseEntity.ok("success");
    }

    @GetMapping
    private ResponseEntity<List<ShareArticleDto>> getList() throws Exception {
        List<ShareArticleDto> articles = shareArticleService.listArticle();

        return ResponseEntity.ok(articles);
    }

    @GetMapping("/list/user/{user}")
    private ResponseEntity<List<ShareArticleDto>> getUserList() throws Exception {
        List<ShareArticleDto> articles = shareArticleService.listArticle();

        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{no}")
    private ResponseEntity<ShareArticleDto> getArticle(@PathVariable("no") int no) throws Exception {
        ShareArticleDto article = shareArticleService.getArticle(no);

        return ResponseEntity.ok(article);
    }
    
    @DeleteMapping("/{no}")
    private ResponseEntity<String> deleteArticle(@PathVariable("no") int no) throws Exception {
    	shareArticleService.deleteArticle(no);

        return ResponseEntity.ok("success");
    }

    @PostMapping("/like/{articleNo}")
    private ResponseEntity<String> likeArticle(@PathVariable("articleNo") int articleNo) throws Exception {
    	String userId = jwtService.getUserId();
        shareArticleService.likeArticle(userId, articleNo);

        return ResponseEntity.ok("success");
    }
    
    @GetMapping("/mylike/{articleNo}")
    private ResponseEntity<Boolean> doILike(@PathVariable("articleNo") int articleNo) throws Exception {
    	String userId = jwtService.getUserId();

        return ResponseEntity.ok(shareArticleService.doILike(userId, articleNo));
    }
}
