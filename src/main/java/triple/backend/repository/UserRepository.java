package triple.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import triple.backend.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
