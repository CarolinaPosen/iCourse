package by.itacademy.mikhalevich.icourse.generator;

import by.itacademy.mikhalevich.icourse.jdbc.EntityManagerHelper;
import by.itacademy.mikhalevich.icourse.model.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
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
        trainer1.setSalaries(getSalaries());

        Trainer trainer2 = new Trainer()
                .withName("Красильникова Любава Аристарховна")
                .withLogin("Ethande@google.com")
                .withPassword("Asp")
                .withRole(manager);
        trainer2.setSalaries(getSalaries());

        Trainer trainer3 = new Trainer()
                .withName("Волков Евгений Мэлорович")
                .withLogin("Mica@yandex.ru")
                .withPassword("Odel")
                .withRole(manager);
        trainer3.setSalaries(getSalaries());

        Set<Theme> themes0 = new HashSet<>();
        Theme theme0 = new Theme();
        theme0.setTitle("ПРОЕКТИРОВАНИЕ 3-Х УРОВНЕВОЙ АРХИТЕКТУРЫ");
        Theme theme1 = new Theme();
        theme1.setTitle("ОСНОВЫ APACHE MAVEN");
        Theme theme2 = new Theme();
        theme2.setTitle("APACHE TOMCAT СЕРВЕР");

        Set<Theme> themes1 = new HashSet<>();
        Theme theme3 = new Theme();
        theme3.setTitle("ОСНОВЫ GIT");
        Theme theme4 = new Theme();
        theme4.setTitle("Работа с базами данных");
        Theme theme5 = new Theme();
        theme5.setTitle("Сервлеты");

        Set<Theme> themes2 = new HashSet<>();
        Theme theme6 = new Theme();
        theme6.setTitle("Обмен информацией. Cookie и сессии");
        Theme theme7 = new Theme();
        theme7.setTitle("Обработка данных сервлетами");
        Theme theme8 = new Theme();
        theme8.setTitle("Java Server Pages");

        themes0.add(theme0);
        themes0.add(theme1);
        themes0.add(theme2);

        themes1.add(theme3);
        themes1.add(theme4);
        themes1.add(theme5);

        themes2.add(theme6);
        themes2.add(theme7);
        themes2.add(theme8);


        Student student0 = new Student()
                .withName("Осипов Вилен")
                .withLogin("Asp@google.com")
                .withPassword("Asp")
                .withRole(user);

        student0.setMarks(getMarks(themes0));

        Student student1 = new Student()
                .withName("Рыбаков Тимофей")
                .withLogin("Odel@yandex.ru")
                .withPassword("Odel")
                .withRole(user);

        student1.setMarks(getMarks(themes0));

        Student student2 = new Student()
                .withName("Исаков Савелий")
                .withLogin("Ania@ann.an")
                .withPassword("NN")
                .withRole(user);

        student2.setMarks(getMarks(themes0));

        Set<Student> students0 = new HashSet<>();
        students0.add(student0);
        students0.add(student1);
        students0.add(student2);


        Student student3 = new Student()
                .withName("Исаков Савелий")
                .withLogin("Camellia@tut.by")
                .withPassword("Camellia")
                .withRole(user);

        student3.setMarks(getMarks(themes1));

        Student student4 = new Student()
                .withName("Вишняков Евгений")
                .withLogin("Halcyo@tut.by")
                .withPassword("Halcyo")
                .withRole(user);

        student4.setMarks(getMarks(themes1));

        Student student5 = new Student()
                .withName("Нестерова Жюли")
                .withLogin("Anem@google.com")
                .withPassword("Anem")
                .withRole(user);

        student5.setMarks(getMarks(themes1));

        Set<Student> students1 = new HashSet<>();
        students1.add(student3);
        students1.add(student4);
        students1.add(student5);

        Student student6 = new Student()
                .withName("Фомичёва Зинаида")
                .withLogin("Chalice@yandex.ru")
                .withPassword("Chalice")
                .withRole(user);
        student6.setMarks(getMarks(themes2));

        Student student7 = new Student()
                .withName("Родионова Милена")
                .withLogin("Fawn@mail.ru")
                .withPassword("Fawn")
                .withRole(user);

        student7.setMarks(getMarks(themes2));

        Student student8 = new Student()
                .withName("Нестерова Жюли")
                .withLogin("Anem@google.com")
                .withPassword("Anem")
                .withRole(user);

        student8.setMarks(getMarks(themes2));

        Student student9 = new Student()
                .withName("Самойлова Жаклин")
                .withLogin("Tranquil@mail.ru")
                .withPassword("Tranquil")
                .withRole(user);

        student9.setMarks(getMarks(themes2));

        Student student10 = new Student()
                .withName("Родионова Милена")
                .withLogin("Fawn@mail.ru")
                .withPassword("Fawn")
                .withRole(user);

        student10.setMarks(getMarks(themes2));

        Set<Student> students2 = new HashSet<>();
        students2.add(student6);
        students2.add(student7);
        students2.add(student8);
        students2.add(student9);
        students2.add(student10);

        Group group0 = new Group();
        group0.setTitle("A1");
        group0.setTrainer(trainer1);
        group0.setStudents(students0);
        group0.setThemes(themes0);

        Group group1 = new Group();
        group1.setTitle("B2");
        group1.setTrainer(trainer2);
        group1.setStudents(students1);
        group1.setThemes(themes1);

        Group group2 = new Group();
        group2.setTitle("C3");
        group2.setTrainer(trainer3);
        group2.setStudents(students2);
        group2.setThemes(themes2);

        em.persist(group0);
        em.persist(group1);
        em.persist(group2);
        tx.commit();
        em.close();

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
            Query q5 = em.createQuery("DELETE FROM Role");
            Query q6 = em.createQuery("DELETE FROM Theme");

            q0.executeUpdate();
            q1.executeUpdate();
            q2.executeUpdate();
            q3.executeUpdate();
            q4.executeUpdate();
            q5.executeUpdate();
            q6.executeUpdate();

        } catch (SecurityException | IllegalStateException | RollbackException e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            em.close();
        }

    }

    private static Set<Mark> getMarks(Set<Theme> themes) {
        Set<Mark> marks = new HashSet<>();

        long offset = Timestamp.valueOf("2020-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long diff = end - offset + 1;

        Iterator<Theme> i = themes.iterator();
        while (i.hasNext()) {
            marks.add(new Mark()
                    .withMark((int) (Math.random() * 100))
                    .withDate(new Timestamp(offset + (long) (Math.random() * diff)))
                    .withTheme(i.next()));
        }

        return marks;
    }

    private static Set<Salary> getSalaries() {
        Set<Salary> salaries = new HashSet<>();

        long offset = Timestamp.valueOf("2020-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long diff = end - offset + 1;

        for (int i = 0; i < 12; i++) {
            salaries.add(new Salary()
                    .withSalary(new BigDecimal (Math.random() * 1000))
                    .withDate(new Timestamp(offset + (long) (Math.random() * diff))));
        }
        return salaries;
    }

}