package com.Lalitdk.LinkUp.post_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lalitdk.LinkUp.post_service.service.PostLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
 public class LikesController {

    @Autowired
    PostLikeService postLikeService;
    
    @PostMapping ("/{postId}")
    public ResponseEntity<Void> likePost(@PathVariable Long postId){
        postLikeService.likePost(postId,1L);
        return ResponseEntity.noContent().build();

}

    @DeleteMapping ("/{postId}")
    public ResponseEntity<Void> unlikePost(@PathVariable Long postId){
        postLikeService.unlikePost(postId,1L);
        return ResponseEntity.noContent().build();

}

}

