package triple.backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PointResponse {
    private final String userId;
    private final int point;

    public PointResponse(String userId, int point) {
        this.userId = userId;
        this.point = point;
    }
}
