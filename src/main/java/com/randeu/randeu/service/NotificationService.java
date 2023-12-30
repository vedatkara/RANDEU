package com.randeu.randeu.service;

import com.randeu.randeu.dao.NotificationRepository;
import com.randeu.randeu.model.Notification;
import com.randeu.randeu.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public ResponseEntity<List<Notification>> getNotificationsByPid(int id){
        return new ResponseEntity<>(notificationRepository.findNotifications(id), HttpStatus.OK);
    }

    public Notification saveNotification(Notification notification) {
        try {
           return notificationRepository.save(notification);
        }catch (Exception e) {
            logger.error("An error occur while saving notification", e);
            return null;
        }
    }

    public void update(Notification notification){
        notificationRepository.readNotification(notification.getId());
    }
}
