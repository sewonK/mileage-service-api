package triple.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PointDetails {
    TEXT("내용 점수"),
    PHOTO("사진 점수"),
    BONUS("보너스 점수");

    private final String title;
}
