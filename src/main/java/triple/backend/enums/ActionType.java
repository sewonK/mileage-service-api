package triple.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionType {
    ADD("리뷰 작성"),
    MOD("리뷰 수정"),
    DELETE("리뷰 삭제");

    private final String title;
}
