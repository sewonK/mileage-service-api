package triple.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "photo")
public class Photo {
    @Id
    @Column(name = "photo_id", length=36)
    @Type(type = "uuid-char")
    private UUID photoId;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
}
