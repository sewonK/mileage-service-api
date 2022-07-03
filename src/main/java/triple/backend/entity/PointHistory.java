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
        @Index(name="reviewMultiIndex", columnList = "reviewId, pointDetails"),
        @Index(name="userIndex", columnList = "userId"),})
@EntityListeners(AuditingEntityListener.class)
public class PointHistory {
    @Id
    @Column(length=36)
    @Type(type = "uuid-char")
    private UUID historyId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Enumerated(EnumType.STRING)
    private PointType pointType;

    @Enumerated(EnumType.STRING)
    private PointDetails pointDetails;

    private int point;

    @CreatedDate
    private LocalDateTime createdDate;
}
