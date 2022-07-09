package triple.backend.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import triple.backend.enums.PointDetails;
import triple.backend.enums.PointType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="point_history")
@Table(indexes = {
        @Index(name="idx_review", columnList = "review_id, point_details"),
        @Index(name="idx_user", columnList = "user_id"),})
@EntityListeners(AuditingEntityListener.class)
public class PointHistory {
    @Id
    @Column(name = "history_id", length=36)
    @Type(type = "uuid-char")
    private UUID historyId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "point_type")
    private PointType pointType;

    @Enumerated(EnumType.STRING)
    @Column(name = "point_details")
    private PointDetails pointDetails;

    private int point;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
