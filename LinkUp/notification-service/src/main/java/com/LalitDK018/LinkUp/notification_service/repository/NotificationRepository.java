package com.LalitDK018.LinkUp.notification_service.repository;

import com.LalitDK018.LinkUp.notification_service.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
