package triple.backend.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import triple.backend.enums.PointDetails;
import triple.backend.enums.PointType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="point_history")
public class PointHistory {
    @Id
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
