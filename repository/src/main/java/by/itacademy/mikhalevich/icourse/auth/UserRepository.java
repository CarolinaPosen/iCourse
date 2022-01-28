package by.itacademy.mikhalevich.icourse.auth;

import by.itacademy.mikhalevich.icourse.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
