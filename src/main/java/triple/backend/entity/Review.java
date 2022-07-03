package triple.backend.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "review")
@Table(indexes = {
        @Index(name="placeIndex", columnList = "placeId, createdDate")
})
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @Column(length=36)
    @Type(type = "uuid-char")
    private UUID reviewId;

    private String content;

    @OneToMany(
            mappedBy = "review",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<Photo> attachedPhotoIds = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(length=36)
    @Type(type = "uuid-char")
    private UUID placeId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
