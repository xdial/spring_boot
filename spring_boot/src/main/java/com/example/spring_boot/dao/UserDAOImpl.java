package com.example.spring_boot.dao;

import org.springframework.stereotype.Repository;
import com.example.spring_boot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();

    }

    @Override
    public void createUser(User user) {

        entityManager.persist(user);
    }

    @Override
    public User getUser(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public User updateUser(User user, Long id) {
        User userToBeUpdated = getUser(id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setPhoneNumber(user.getPhoneNumber());
        return entityManager.merge(userToBeUpdated);
    }

    @Override
    public void deleteUser(Long id) {

        entityManager.remove(getUser(id));
    }
}
