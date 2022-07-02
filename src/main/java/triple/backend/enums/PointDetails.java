package triple.backend.enums;

public enum PointDetails {
    TEXT("내용 점수"),
    PHOTO("사진 점수"),
    BONUS("보너스 점수");

    private final String title;

    PointDetails(String title) { this.title = title; }

    public String getTitle() { return title; }
}
