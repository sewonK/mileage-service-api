package triple.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "photo")
public class Photo {
    @Id
    private UUID photoId;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;
}
