package by.itacademy.mikhalevich.icourse.generator;

import by.itacademy.mikhalevich.icourse.jdbc.EntityManagerHelper;
import by.itacademy.mikhalevich.icourse.model.*;
import by.itacademy.mikhalevich.icourse.model.auth.Authority;
import by.itacademy.mikhalevich.icourse.model.auth.Credential;
import by.itacademy.mikhalevich.icourse.model.auth.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

public class TestDataGenerator {

    public static void main(String[] args) {

        clearDataBase();
        fillDb();

    }

    private static void fillDb() {

        addRoleToDb();

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Role roleAdmin = new Role().withName("ADMIN");
        Role roleUser = new Role().withName("USER");
        em.persist(roleAdmin);
        em.persist(roleUser);

        Authority authorityRead = new Authority().withName("READ_INFO");
        Authority authorityWrite = new Authority().withName("WRITE_INFO");
        em.persist(authorityRead);
        em.persist(authorityWrite);

        List<Role> trainerRoleAdmin = Arrays.asList(roleAdmin);
        List<Role> trainerRoleUser = Arrays.asList(roleUser);

        List<Authority> trainerAuthorityRead = Arrays.asList(authorityRead);
        List<Authority> trainerAuthorityWrite = Arrays.asList(authorityWrite);

        Trainer trainer1 = new Trainer()
                .withName("Сафонова Габи Авксентьевна")
                .withCredential(new Credential("S", "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02", true, trainerRoleAdmin, trainerAuthorityWrite));
        addSalaries(trainer1);

        Trainer trainer2 = new Trainer()
                .withName("Красильникова Любава Аристарховна")
                .withCredential(new Credential("K", "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02", true, trainerRoleUser, trainerAuthorityRead));
        addSalaries(trainer2);

        Trainer trainer3 = new Trainer()
                .withName("Волков Евгений Мэлорович")
                .withCredential(new Credential("V", "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02", true, trainerRoleUser, trainerAuthorityRead));
        addSalaries(trainer3);

        Theme theme0 = new Theme();
        theme0.setTitle("ПРОЕКТИРОВАНИЕ 3-Х УРОВНЕВОЙ АРХИТЕКТУРЫ");
        Theme theme1 = new Theme();
        theme1.setTitle("ОСНОВЫ APACHE MAVEN");
        Theme theme2 = new Theme();
        theme2.setTitle("APACHE TOMCAT СЕРВЕР");

        Theme theme3 = new Theme();
        theme3.setTitle("ОСНОВЫ GIT");
        Theme theme4 = new Theme();
        theme4.setTitle("Работа с базами данных");
        Theme theme5 = new Theme();
        theme5.setTitle("Сервлеты");

        Theme theme6 = new Theme();
        theme6.setTitle("Обмен информацией. Cookie и сессии");
        Theme theme7 = new Theme();
        theme7.setTitle("Обработка данных сервлетами");
        Theme theme8 = new Theme();
        theme8.setTitle("Java Server Pages");

        Set<Theme> themes0 = new HashSet<>();
        themes0.add(theme0);
        themes0.add(theme1);
        themes0.add(theme2);

        Set<Theme> themes1 = new HashSet<>();
        themes1.add(theme3);
        themes1.add(theme4);
        themes1.add(theme5);

        Set<Theme> themes2 = new HashSet<>();
        themes2.add(theme6);
        themes2.add(theme7);
        themes2.add(theme8);


        Student student0 = new Student()
                .withName("Осипов Вилен")
                .withCredential(
                        new Credential(
                                "Asp@google.com",
                                "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                                true,
                                trainerRoleAdmin,
                                trainerAuthorityRead));

        student0.addMark(getMark(theme0));
        student0.addMark(getMark(theme1));
        student0.addMark(getMark(theme2));

        Student student1 = new Student()
                .withName("Рыбаков Тимофей")
                .withCredential(
                        new Credential("Odel@yandex.ru",
                        "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                        true,
                        trainerRoleAdmin,
                        trainerAuthorityRead));

        student1.addMark(getMark(theme0));
        student1.addMark(getMark(theme1));
        student1.addMark(getMark(theme2));

        Student student2 = new Student()
                .withName("Исаков Савелий")
                .withCredential(
                        new Credential("Ania@ann.an",
                        "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                                true,
                                trainerRoleAdmin,
                                trainerAuthorityRead));

        student2.addMark(getMark(theme3));
        student2.addMark(getMark(theme4));
        student2.addMark(getMark(theme5));

        Set<Student> students0 = new HashSet<>();
        students0.add(student0);
        students0.add(student1);
        students0.add(student2);


        Student student3 = new Student()
                .withName("Прокопенко Виталий")
                .withCredential(new Credential("Procop@tut.by",
                        "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                        true,
                        trainerRoleAdmin,
                        trainerAuthorityRead));

        student3.addMark(getMark(theme3));
        student3.addMark(getMark(theme4));
        student3.addMark(getMark(theme5));

        Student student4 = new Student()
                .withName("Вишняков Евгений")
                .withCredential(new Credential("Halcyo@tut.by",
                        "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                        true,
                        trainerRoleAdmin,
                        trainerAuthorityRead));

        student4.addMark(getMark(theme6));
        student4.addMark(getMark(theme7));
        student4.addMark(getMark(theme8));

        Student student5 = new Student()
                .withName("Плитнткова Экли")
                .withCredential(
                        new Credential("Ecli@google.com",
                        "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                                true,
                                trainerRoleAdmin,
                                trainerAuthorityRead));

        student5.addMark(getMark(theme6));
        student5.addMark(getMark(theme7));
        student5.addMark(getMark(theme8));

        Set<Student> students1 = new HashSet<>();
        students1.add(student3);
        students1.add(student4);
        students1.add(student5);

        Student student6 = new Student()
                .withName("Фомичёва Зинаида")
                .withCredential(new Credential("Chalice@yandex.ru",
                        "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                        true,
                        trainerRoleAdmin,
                        trainerAuthorityRead));

        student6.addMark(getMark(theme0));
        student6.addMark(getMark(theme1));
        student6.addMark(getMark(theme2));

        Student student7 = new Student()
                .withName("Радиона Силена")
                .withCredential(
                        new Credential("SILENA@mail.ru",
                                "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                                true,
                                trainerRoleAdmin,
                                trainerAuthorityRead));

        student7.addMark(getMark(theme3));
        student7.addMark(getMark(theme4));
        student7.addMark(getMark(theme5));

        Student student8 = new Student()
                .withName("Нестерова Жюли")
                .withCredential(new Credential("Anem@google.com",
                        "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                        true,
                        trainerRoleAdmin,
                        trainerAuthorityRead));

        student8.addMark(getMark(theme6));
        student8.addMark(getMark(theme7));
        student8.addMark(getMark(theme8));

        Student student9 = new Student()
                .withName("Самойлова Жаклин")
                .withCredential(new Credential("Tranquil@mail.ru",
                        "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                        true,
                        trainerRoleAdmin,
                        trainerAuthorityRead));

        student9.addMark(getMark(theme0));
        student9.addMark(getMark(theme1));
        student9.addMark(getMark(theme2));

        Student student10 = new Student()
                .withName("Родионова Милена")
                .withCredential(new Credential("Fawn@mail.ru",
                        "$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02",
                        true,
                        trainerRoleAdmin,
                        trainerAuthorityRead));

        student10.addMark(getMark(theme3));
        student10.addMark(getMark(theme4));
        student10.addMark(getMark(theme5));

        Set<Student> students2 = new HashSet<>();
        students2.add(student6);
        students2.add(student7);
        students2.add(student8);
        students2.add(student9);
        students2.add(student10);

        Group group0 = new Group();
        group0.setTitle("A1");
        group0.addTrainer(trainer1);
        group0.setStudents(students0);
        group0.setThemes(themes0);

        Group group1 = new Group();
        group1.setTitle("B2");
        group1.addTrainer(trainer2);
        group1.setStudents(students1);
        group1.setThemes(themes1);

        Group group2 = new Group();
        group2.setTitle("C3");
        group2.addTrainer(trainer3);
        group2.setStudents(students2);
        group2.setThemes(themes2);

        em.persist(group0);
        em.persist(group1);
        em.persist(group2);
        tx.commit();
        em.close();
    }

    private static void addRoleToDb(){

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        Role admin = new Role().withName("USER");
//        Role manager = new Role().withName("ADMIN");
//        Role user = new Role().withName("MANAGER");

//        em.persist(admin);
//        em.persist(manager);
//        em.persist(user);

        tx.commit();
        em.close();

    }

    private static Credential getCredential(EntityManager em, String username) {
        TypedQuery<Credential> serviceQuery = em.createQuery("from Credential c where c.username = :username", Credential.class);
        serviceQuery.setParameter("username", username);
        Credential credential = serviceQuery.getSingleResult();
        return credential;
    }

    private static void clearDataBase() {

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query q0 = em.createQuery("DELETE FROM Salary ");
            Query q1 = em.createQuery("DELETE FROM Mark ");
            Query q2 = em.createQuery("DELETE FROM Group ");
            Query q3 = em.createQuery("DELETE FROM Student");
            Query q4 = em.createQuery("DELETE FROM Trainer ");
            Query q5 = em.createQuery("DELETE FROM Credential ");
            Query q6 = em.createQuery("DELETE FROM Theme");
            Query q7 = em.createQuery("DELETE FROM Role");
            Query q8 = em.createQuery("DELETE FROM Authority ");

            q0.executeUpdate();
            q1.executeUpdate();
            q2.executeUpdate();
            q3.executeUpdate();
            q4.executeUpdate();
            q5.executeUpdate();
            q6.executeUpdate();
            q7.executeUpdate();
            q8.executeUpdate();

        } catch (SecurityException | IllegalStateException | RollbackException e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            em.close();
        }

    }

    private static Mark getMark(Theme theme) {
        long offset = Timestamp.valueOf("2020-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long diff = end - offset + 1;

        return new Mark()
                    .withMark((int) (Math.random() * 100))
                    .withDate(new Timestamp(offset + (long) (Math.random() * diff)))
                    .withTheme(theme);
    }

    private static void addSalaries(Trainer trainer) {
        Set<Salary> salaries = new HashSet<>();

        long offset = Timestamp.valueOf("2020-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long diff = end - offset + 1;

        for (int i = 0; i < 12; i++) {
            trainer.addSalary(new Salary()
                    .withSalary(new BigDecimal (Math.random() * 1000))
                    .withDate(new Timestamp(offset + (long) (Math.random() * diff))));
        }
//        return salaries;
    }

}