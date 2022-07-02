package triple.backend.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@Entity(name = "photo")
public class Photo {
    @Id
    private UUID photoId;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;
}
