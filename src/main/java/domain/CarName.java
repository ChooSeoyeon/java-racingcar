package domain;

public class CarName {
    private String name;
    private final Integer CAR_NAME_MAX_LENGTH = 5;
    private final Integer CAR_NAME_MIN_LENGTH = 1;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (isLongerThanMaxLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
        }
        if (isShorterThanMinLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 한 글자 이상입니다.");
        }
    }

    public String getName() {
        return name;
    }

    private boolean isLongerThanMaxLength(String name) {
        return name.length() > CAR_NAME_MAX_LENGTH;
    }

    private boolean isShorterThanMinLength(String name) {
        return name.length() < CAR_NAME_MIN_LENGTH;
    }
}

