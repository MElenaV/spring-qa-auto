package com.spring.qa.auto.lesson6.hibernate;

import java.util.List;

import com.spring.qa.auto.lesson4.entity.UserEntity;
import com.spring.qa.auto.lesson6.hibernate.session.HibernateSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Slf4j
public class HibernateExampleMain {

    public static void main(String[] args) {
        Transaction transaction = null;
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(25);
        userEntity.setFirstName("Alex");
        userEntity.setSecondName("Brown");
        try (Session session = HibernateSessionUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(userEntity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error("Failed insert: {}", e.getMessage());
        }

        //select user_entity
        try (Session session = HibernateSessionUtil.getSessionFactory().openSession()) {
            List<UserEntity> userEntityList = session.createQuery("from UserEntity",
                    UserEntity.class).list();
            userEntityList.forEach(u -> log.info("[Entity] id {}, name: {}, second name : {}, age: {}",
                    u.getId(), u.getFirstName(), u.getSecondName(), u.getAge()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error("Failed select: {}", e.getMessage());
        }
    }
}
