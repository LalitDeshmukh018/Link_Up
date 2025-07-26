package com.LalitDK018.LinkUp.posts_service.repository;

import com.LalitDK018.LinkUp.posts_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
