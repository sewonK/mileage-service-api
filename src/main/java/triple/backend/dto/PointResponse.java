package triple.backend.dto;

import lombok.Getter;
import triple.backend.entity.User;

@Getter
public class PointResponse {
    private final String userId;
    private final int point;

    public PointResponse(String userId, int point) {
        this.userId = userId;
        this.point = point;
    }
}
