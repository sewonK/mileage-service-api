package triple.backend.enums;

public enum Action {
    ADD("리뷰 작성"),
    MOD("리뷰 수정"),
    DELETE("리뷰 삭제");

    private final String title;

    Action(String title) { this.title = title; }

    public String getTitle() { return title; }
}
