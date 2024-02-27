import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @DisplayName("이름은 5자가 넘지 않을 경우 잘 생성된다.")
    @Test
    void validName() {
        // org.assertj.core.api.Assertions.assertThatThrownBy()
        final Car neoCar = new Car("neo12");
    }

    @DisplayName("이름은 5자 이하일 경우 예외가 발생한다.")
    @Test
    void invalidName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final Car neoCar = new Car("neo123");
        });
    }

    @DisplayName("자동차의 최초 위치는 0이다.")
    @Test
    void defaultPosition() {
        final Car neoCar = new Car("neo12");

        assertThat(neoCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차는 움직인다.")
    @Test
    void move() {
        final Car neoCar = new Car("neo12");

        // 실패 가능 -> 움직임의 역할을 자동차가 가지고 있다.
        final int power = 5;
        neoCar.move(power);

        // 실패 못함 -> 움직임의 역할을 외부에 가지고 있다.
        // neoCar.move();

        assertThat(neoCar.getPosition()).isEqualTo(1);
    }
}
