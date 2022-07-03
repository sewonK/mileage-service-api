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
    @Column(length=36)
    @Type(type = "uuid-char")
    private UUID photoId;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;
}
