package triple.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PointDetails {
    TEXT("리뷰 작성(텍스트)", 1),
    PHOTO("리뷰 작성(사진)", 1),
    BONUS("리뷰 작성(첫 리뷰)", 1),
    ;

    private final String title;
    private final int point;
}
