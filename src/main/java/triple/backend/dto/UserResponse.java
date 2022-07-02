package triple.backend.dto;

import lombok.Getter;

@Getter
public class UserResponse {
    private final String userId;
    private final int point;

    public UserResponse(String userId, int point) {
        this.userId = userId;
        this.point = point;
    }
}
