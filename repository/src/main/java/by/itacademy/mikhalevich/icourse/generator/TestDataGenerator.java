package by.itacademy.mikhalevich.icourse.generator;

import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TestDataGenerator {

    public static void main(String[] args) {

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Role role = em.find(Role.class, 1);
        Role admin = new Role()
                .withId(1)
                .withName("Administrator");

        Trainer trainer = new Trainer()
                .withName("Ivan Ivanovich Ivanov")
                .withLogin("ivan@ivan.ivan")
                .withPassword("Ivan");

        trainer.withRole(admin);

        em.persist(admin);
        em.persist(trainer);

        //System.out.println(trainer);
        //System.out.println(role);

        tx.commit();
        em.close();
    }

}
