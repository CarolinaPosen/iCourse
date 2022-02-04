package by.itacademy.mikhalevich.icourse.auth;

import by.itacademy.mikhalevich.icourse.model.auth.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Credential, Integer> {
    Optional<Credential> findByUsername(String username);
}
