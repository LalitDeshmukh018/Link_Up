package com.Lalitdk.LinkUp.post_service.repository;

import com.Lalitdk.LinkUp.post_service.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserid(Long userId);
}
