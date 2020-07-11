package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (!checkLength(name)) {
            throw new IllegalArgumentException("이름은 5자 이내로 설정해주세요.");
        }
        this.name = name;
    }

    // TODO: 2020/06/28 추가기능 구현

    public int play() {
        if (moveOrStop()) {
            position++;
        }
        return position;
    }

    private Boolean moveOrStop() {
        int random = (int) (Math.random() * 10);
        if (random <= 3) {
            return false;
        }
        return true;
    }

    private Boolean checkLength(String name) {
        if (name.length() > 5) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
