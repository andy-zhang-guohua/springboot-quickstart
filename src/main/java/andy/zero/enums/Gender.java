package andy.zero.enums;

public enum Gender {
    MALE(1, "男"),
    FEMALE(2, "女");

    int value;
    String displayName;

    Gender(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }
}
