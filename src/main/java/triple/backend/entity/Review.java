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
        @Index(name="idx_place", columnList = "place_id, created_date")
})
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @Column(name = "review_id", length=36)
    @Type(type = "uuid-char")
    @JoinColumn(name = "review_id")
    private UUID reviewId;

    private String content;

    @OneToMany(
            mappedBy = "review",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<Photo> attachedPhotoIds = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "place_id", length=36)
    @Type(type = "uuid-char")
    private UUID placeId;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updated_date;
}
