package com.Lalitdk.LinkUp.post_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Lalitdk.LinkUp.post_service.entity.PostLike;

import jakarta.transaction.Transactional;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
        boolean existsByUserIdAndPostId(Long userId, Long postId);
        @Transactional
        void deleteByUserIdAndPostId(long userId, Long postId);
}