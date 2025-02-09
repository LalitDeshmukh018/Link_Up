package com.Lalitdk.LinkUp.post_service.service;

import com.Lalitdk.LinkUp.post_service.Exception.ResourceNotFoundException;
import com.Lalitdk.LinkUp.post_service.dto.PostCreateRequestDto;
import com.Lalitdk.LinkUp.post_service.dto.PostDto;
import com.Lalitdk.LinkUp.post_service.entity.Post;
import com.Lalitdk.LinkUp.post_service.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostDto createPost(PostCreateRequestDto postCreateRequestDto, Long userId) {

    Post post = modelMapper.map(postCreateRequestDto, Post.class);
    post.setUserid(userId);

    Post savedPost = postRepository.save(post);
    return modelMapper.map(savedPost, PostDto.class );

    }

    public PostDto getPostById(Long postId) {
      log.debug("Retrieving the post with id {}", postId);
      Post post = postRepository.findById(postId)
          .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
      return modelMapper.map(post, PostDto.class);
  }

    public List<PostDto> getAllPostOfUser(Long userId) {
      List<Post> posts = postRepository.findAllByUserid(userId);
     return posts 
            .stream()
            .map((element) -> modelMapper.map(element, PostDto.class))
            .collect(Collectors.toList());
    }
  





    }

