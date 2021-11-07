package by.itacademy.mikhalevich.icourse.generator;

import by.itacademy.mikhalevich.icourse.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestDataGenerator {

    public static void main(String[] args) {

        clearDataBase();

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Role admin = new Role().withId(1).withName("Admin");
        Role manager = new Role().withId(2).withName("Manager");
        Role user = new Role().withId(3).withName("User");

        Trainer trainer1 = new Trainer()
                .withName("Сафонова Габи Авксентьевна")
                .withLogin("Noahchie@mail.ru")
                .withPassword("Asphodel")
                .withRole(admin);

        Trainer trainer2 = new Trainer()
                .withName("Красильникова Любава Аристарховна")
                .withLogin("Ethande@google.com")
                .withPassword("Asp")
                .withRole(admin);

        Trainer trainer3 = new Trainer()
                .withName("Сафонова Габи Авксентьевна")
                .withLogin("Noahchie@mail.ru")
                .withPassword("Asphodel")
                .withRole(admin);

        Trainer trainer4 = new Trainer()
                .withName("Иванов Иван Иванович")
                .withLogin("Ivanox@ivan.iva")
                .withPassword("IVNV")
                .withRole(manager);

        Student student0 = new Student()
                .withName("Student Stufent Student")
                .withLogin("Student@stu.stu")
                .withPassword("STDNT")
                .withRole(user);

        Student student1 = new Student()
                .withName("Denisov Denis Denisovich")
                .withLogin("Denis@den.den")
                .withPassword("DNS")
                .withRole(user);

        Student student2 = new Student()
                .withName("Anutina Ania Annovna")
                .withLogin("Ania@ann.an")
                .withPassword("NN")
                .withRole(user);

        Mark mark0 = new Mark()
                .withMark(100)
                .withDate(Timestamp.valueOf(LocalDateTime.now()));

        Mark mark1 = new Mark()
                .withMark(10)
                .withDate(Timestamp.valueOf(LocalDateTime.now()));

        Mark mark2 = new Mark()
                .withMark(65)
                .withDate(Timestamp.valueOf(LocalDateTime.now()));

        Mark mark3 = new Mark()
                .withMark(70)
                .withDate(Timestamp.valueOf(LocalDateTime.now()));

        Set<Mark> marks = new HashSet<>();
        marks.add(mark0);
        marks.add(mark1);
        marks.add(mark2);
        marks.add(mark3);

        Student student3 = new Student()
                .withName("Shishkin Maksim")
                .withLogin("maks@maks.mk")
                .withPassword("Maks")
                .withRole(user);

        student3.setMarks(marks);
        student2.setMarks(marks);

        Set<Student> students = new HashSet<>();
        students.add(student0);
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Theme theme0 = new Theme();
        theme0.setTitle("Theme3");
        Theme theme1 = new Theme();
        theme0.setTitle("Theme2");
        Theme theme2 = new Theme();
        theme0.setTitle("Theme1");

        Set<Theme> themes = new HashSet<>();
        themes.add(theme0);
        themes.add(theme1);
        themes.add(theme2);

        Group group0 = new Group();
        group0.setTitle("A1");
        group0.setTrainer(trainer2);
        group0.setStudents(students);
        group0.setThemes(themes);

        Group group1 = new Group();
        group1.setTitle("Group1");
        group1.setTrainer(trainer3);
        group1.setStudents(students);
        group1.setThemes(themes);

        Group group2 = new Group()
                .withId(3)
                .withTitle("C3")
                .withTeacher(trainer2);

        em.persist(group0);
        em.persist(group1);
//        em.persist(group2);
//        em.persist(trainer2);
//        em.persist(trainer4);
//        em.persist(student0);
//        em.persist(student1);
//        em.persist(student2);

//        TypedQuery<Trainer> oneTrainerQuery = em.createQuery("from Trainer where name = 'Svetlana Borisovna Ivanova'", Trainer.class);
//        Trainer trainer = oneTrainerQuery.getSingleResult();
//
//
//        System.out.println(trainer);
        //System.out.println(role);

        tx.commit();
        em.close();

    }

    private static void clearDataBase() {

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query q0 = em.createQuery("DELETE FROM Group ");
            Query q1 = em.createQuery("DELETE FROM Student");
            Query q2 = em.createQuery("DELETE FROM Trainer ");
            Query q3 = em.createQuery("DELETE FROM Role");
            Query q4 = em.createQuery("DELETE FROM Theme");
            Query q5 = em.createQuery("DELETE FROM Mark ");
//            Query q4 = em.createQuery("DELETE FROM BomItem");

            q0.executeUpdate();
            q1.executeUpdate();
            q2.executeUpdate();
            q3.executeUpdate();
            q4.executeUpdate();
            q5.executeUpdate();

        } catch (SecurityException | IllegalStateException | RollbackException e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            em.close();
        }

    }
}
