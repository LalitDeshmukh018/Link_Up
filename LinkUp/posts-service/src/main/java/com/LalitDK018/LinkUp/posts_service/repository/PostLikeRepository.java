package com.LalitDK018.LinkUp.posts_service.repository;

import com.LalitDK018.LinkUp.posts_service.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    boolean existsByUserIdAndPostId(Long userId, Long postId);

    @Transactional
    void deleteByUserIdAndPostId(Long userId, Long postId);
}
