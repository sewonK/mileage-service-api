package triple.backend.enums;

public enum PointDetails {
    TEXT("텍스트 리뷰 작성"),
    PHOTO("포토 리뷰 작성"),
    BONUS("특정 장소에 첫 리뷰 작성");

    private final String title;

    PointDetails(String title) { this.title = title; }

    public String getTitle() { return title; }
}
