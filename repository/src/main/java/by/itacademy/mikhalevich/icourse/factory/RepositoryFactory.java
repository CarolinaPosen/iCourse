package by.itacademy.mikhalevich.icourse.factory;
import by.itacademy.mikhalevich.icourse.*;
import by.itacademy.mikhalevich.icourse.jdbc.*;
import by.itacademy.mikhalevich.icourse.jpa.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class RepositoryFactory {
    private static final RepositoryTypes TYPE;
    private static RepositoryDatasource datasource;

    static {
        Properties appProperties = new Properties();
        try {
            appProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        TYPE = RepositoryTypes.getTypeByStr(appProperties.getProperty("repository.type"));
        if (TYPE == RepositoryTypes.JDBC) {
            datasource = RepositoryDatasource.getInstance(
                    appProperties.getProperty("postgres.driver"),
                    appProperties.getProperty("postgres.uri"),
                    appProperties.getProperty("postgres.user"),
                    appProperties.getProperty("postgres.password"));
        }
    }

    private RepositoryFactory() {
        //factory empty private
    }

    public static TrainerRepository getTrainerRepository() {
        switch (TYPE) {
            case JDBC:
                return TeacherRepositoryPostgres.getInstance(datasource);
            case JPA:
                return TrainerRepositoryJpaImpl.getInstance();
            default:
                return TrainerRepositoryJpaImpl.getInstance();
        }
    }

    public static StudentRepository getStudentRepository() {
        switch (TYPE) {
            case JDBC:
                return StudentRepositoryPostgres.getInstance(datasource);
            case JPA:
                return StudentRepositoryJpaImpl.getInstance();
            default:
                return StudentRepositoryJpaImpl.getInstance();
        }
    }

    public static GroupRepository getGroupRepository() {
        switch (TYPE) {
            case JDBC:
                return GroupRepositoryPostgres.getInstance(datasource);
            case JPA:
                return GroupRepositoryJpaImpl.getInstance();
            default:
                return GroupRepositoryJpaImpl.getInstance();
        }
    }

    public static SalaryRepository getSalaryRepository() {
        switch (TYPE) {
            case JDBC:
                return SalaryRepositoryPostgres.getInstance(datasource);
            case JPA:
                return SalaryRepositoryJpaImpl.getInstance();
            default:
                return SalaryRepositoryJpaImpl.getInstance();
        }
    }

    public static MarkRepository getMarkRepository() {
        switch (TYPE) {
            case JDBC:
                return MarkRepositoryPostgres.getInstance(datasource);
            case JPA:
                return MarkRepositoryJpaImpl.getInstance();
            default:
                return MarkRepositoryJpaImpl.getInstance();
        }
    }

    public static RoleRepository getRoleRepository() {
        switch (TYPE) {
            case JDBC:
                return RoleRepositoryPostgres.getInstance(datasource);
            case JPA:
                return RoleRepositoryJpaImpl.getInstance();
            default:
                return RoleRepositoryJpaImpl.getInstance();
        }
    }

}