package triple.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PointType {
    PLUS("적립", 1),
    MINUS("소멸", -1);

    private final String title;
    private final int value;
}
