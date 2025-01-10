package app.dao;

import org.springframework.stereotype.Repository;
import app.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class DaoUserImpl implements DaoUser{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(int id) {

        User user = entityManager.find(User.class,id);
        return user;
    }

    @Override
    public List<User> getUsers() {

        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }}

