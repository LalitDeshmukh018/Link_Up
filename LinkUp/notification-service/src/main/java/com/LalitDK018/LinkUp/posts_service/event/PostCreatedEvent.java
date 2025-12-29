package com.LalitDK018.LinkUp.posts_service.event;

import lombok.Builder;
import lombok.Data;

@Data
public class PostCreatedEvent {
    Long creatorId;
    String content;
    Long postId;
}
