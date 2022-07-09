package triple.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import triple.backend.entity.Photo;

import java.util.UUID;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, UUID> {
}
