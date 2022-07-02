package triple.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import triple.backend.entity.Photo;

import java.util.UUID;

public interface PhotoRepository extends JpaRepository<Photo, UUID> {
}
