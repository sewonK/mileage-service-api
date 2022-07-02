package triple.backend.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name = "users")
public class User {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    @Type(type = "uuid-char")
    private UUID userId;

    @ColumnDefault("0")
    private Integer point;
}
