package triple.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PointType {
    PLUS("적립"),
    MINUS("소멸");

    private final String title;
}
