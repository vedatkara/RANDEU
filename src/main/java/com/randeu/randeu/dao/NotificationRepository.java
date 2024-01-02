package com.randeu.randeu.dao;

import com.randeu.randeu.model.Notification;
import com.randeu.randeu.model.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query(value = "SELECT n.nid, message, created_at, is_read, pid FROM notification n WHERE n.pid=:pid", nativeQuery = true)
    List<Notification> findNotifications(Integer pid);

    @Modifying
    @Transactional
    @Query(value= "UPDATE notification n SET is_read=:1 WHERE n.nid =:id",nativeQuery = true)
    void readNotification(int id);



}
