package bg.softuni.portfolio.repository;

import bg.softuni.portfolio.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String value);

    Optional<User> findByUsername(String username);
}