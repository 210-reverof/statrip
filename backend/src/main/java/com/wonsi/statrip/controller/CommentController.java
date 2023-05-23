package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.CommentDto;
import com.wonsi.statrip.model.service.CommentService;
import com.wonsi.statrip.model.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    JwtService jwtService;

    @GetMapping("/{shareId}")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable("shareId") int shareId) throws Exception {
        return ResponseEntity.ok(commentService.commentByShareId(shareId));
    }

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody CommentDto commentDto) throws Exception {
        String userId = jwtService.getUserId();
        commentDto.setUserId(userId);
        commentService.addComment(commentDto);
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteCommentById(@PathVariable("commentId") int commentId) throws Exception {
        System.out.println("delete=====" + commentId);
        commentService.deleteCommentById(commentId);
        return ResponseEntity.ok("success");
    }

//    @DeleteMapping("/share/{shareId}")
//    public ResponseEntity<String> deleteCommentByShare(@PathVariable("shareId") int shareId) throws Exception {
//        commentService.deleteCommentByShareId(shareId);
//        return ResponseEntity.ok("success");
//    }
//
//    @DeleteMapping("/user/{userId}")
//    public ResponseEntity<String> deleteCommentByUserId(@PathVariable("userId") String userId) throws Exception {
//        commentService.deleteCommentByUserId(userId);
//        return ResponseEntity.ok("success");
//    }
}
