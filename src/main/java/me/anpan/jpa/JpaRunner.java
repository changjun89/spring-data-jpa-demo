package me.anpan.jpa;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("lcj");
        account.setPassword("jpa");
        Session session = entityManager.unwrap(Session.class);

        entityManager.persist(account);
    }
}
