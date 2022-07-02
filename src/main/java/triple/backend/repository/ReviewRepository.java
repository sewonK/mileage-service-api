package triple.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import triple.backend.entity.Review;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {

}
