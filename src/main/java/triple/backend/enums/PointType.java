package triple.backend.enums;

public enum PointType {
    PLUS("적립"),
    MINUS("소멸");

    private final String title;

    PointType(String title) { this.title = title; }

    public String getTitle() { return title; }
}
