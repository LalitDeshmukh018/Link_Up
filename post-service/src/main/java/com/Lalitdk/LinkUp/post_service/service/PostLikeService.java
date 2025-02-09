package com.Lalitdk.LinkUp.post_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lalitdk.LinkUp.post_service.Exception.BadRequestException;
import com.Lalitdk.LinkUp.post_service.Exception.ResourceNotFoundException;
import com.Lalitdk.LinkUp.post_service.entity.PostLike;
import com.Lalitdk.LinkUp.post_service.repository.PostLikeRepository;
import com.Lalitdk.LinkUp.post_service.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeService {

    @Autowired
    PostLikeRepository postLikeRepository;
    @Autowired
    PostRepository postRepository;

    public void likePost(Long postId, Long userId) {
        log.info("Attempting to like the post with id :{}" + postId);
        boolean exists = postRepository.existsById(postId);
        if (!exists) {
            throw new ResourceNotFoundException("Post not found with id " + postId);
        }
        boolean alreadyLiked = postLikeRepository.existsByUserIdAndPostId(userId, postId);
        if (alreadyLiked)
            throw new BadRequestException("Cannot like the same post again " + postId);

        PostLike postLike = new PostLike();
        postLike.setPostId(postId);
        postLike.setUserId(userId);
        postLikeRepository.save(postLike);
    }

    public void unlikePost(Long postId, long userId) {
        log.info("Attempting to unlike the post with is {}" + postId);
        boolean exists = postRepository.existsById(postId);
        if (!exists)
            throw new ResourceNotFoundException("Post Not found with id" + postId);
        boolean alreadyLiked = postLikeRepository.existsByUserIdAndPostId(userId, postId);
        if (!alreadyLiked)
            throw new BadRequestException("Cannot unlike the post again " + postId);

        postLikeRepository.deleteByUserIdAndPostId(userId, postId);
        log.info("Post with id : {}  unliked successfully", postId);

    }

}
