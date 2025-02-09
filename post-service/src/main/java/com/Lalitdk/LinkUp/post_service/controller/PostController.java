package com.Lalitdk.LinkUp.post_service.controller;

import com.Lalitdk.LinkUp.post_service.dto.PostCreateRequestDto;
import com.Lalitdk.LinkUp.post_service.dto.PostDto;
import com.Lalitdk.LinkUp.post_service.service.PostService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor

public class PostController {

   private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequestDto postCreateRequestDto ){
        PostDto createdPost = postService.createPost(postCreateRequestDto,1L);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId){
        PostDto postDto = postService.getPostById(postId);
        return ResponseEntity.ok(postDto);        
    }

    @GetMapping("/users/{userId}/allPost")
    public ResponseEntity<List<PostDto>> getAllPostOfUser(@PathVariable Long userId){
        List<PostDto> postDto = postService.getAllPostOfUser(userId);
        return ResponseEntity.ok(postDto);
    }
}
