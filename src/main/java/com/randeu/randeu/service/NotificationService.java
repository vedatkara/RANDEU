package com.randeu.randeu.service;

import com.randeu.randeu.dao.NotificationRepository;
import com.randeu.randeu.model.Notification;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public List<Notification> getNotificationsByPid(Integer id){
        return notificationRepository.findNotifications(id);
    }

    @Transactional
    public void saveNotification(Notification notification) {
        try {
            notificationRepository.save(notification);
        }catch (Exception e) {
            logger.error("An error occur while saving notification", e);
        }
    }

    public void update(Integer nid){
        notificationRepository.readNotification(nid);
    }
}
