package domain;

public class RoundResult {
    private final Integer MOVING_CONDITION = 4;

    public boolean isGo(Integer randomNumber) {
        return randomNumber >= MOVING_CONDITION;
    }
}
