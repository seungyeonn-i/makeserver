//package com.ssumc.crud.repository;
//
//import com.ssumc.crud.user.User;
//import org.springframework.context.annotation.Primary;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//
//@Primary
//public class JpaUserRepository implements UserRepository {
//
//    private final EntityManager em;
//
//    public JpaUserRepository(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public User save(User user) {
//        em.persist(user);
//        return user;
//    }
//
//    @Override
//    public Optional<User> findById(int userId) {
//        User user = em.find(User.class, userId);
//        return Optional.ofNullable(user);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return em.createQuery("select m from User m", User.class).getResultList();
//    }
//}
