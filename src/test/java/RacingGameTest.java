import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    // 테스트를 하기 위한 코드가 만들어졌다
    // 오해할 수 있는 코드다. 다른 개발자가 테스트를 위한 코드인지 모른다
    // 성능 or 유지보수성
    // 테스트하기힘들다
    @Test
    void move() {
        // 테스트하기 좋고 테스트만을 위해 존재해서 실수가 발생하는 것을 막는 코드를 작성하자.
        var neo1 = new Car("Neo1");
        var neo2 = new Car("Neo2");
        final List<Car> cars = List.of(
                neo1,
                neo2
        );
        final RacingGame racingGame = new RacingGame(cars);

        // 이거 좋은 거야 <- 왜? 난 다르게 생각해. 난 동의하지 않아.
        // 이건 안좋은거야. 랜덤은 있으면 안되는 거야 <- 피하기
        for (int i = 0; i < 1000; i++) {
            racingGame.move();
        }

        assertThat(neo1.getPosition()).isNotEqualTo(0);
    }

    @DisplayName("우승 자동차를 구한다.")
    @Test
    void winners() {
        // 테스트를 위한 코드다
        // 실수가 발생할 수 있다
        // 가능성은 존재한다. 그 가능성을 낮출 수 있는 방법은 무엇일까?
        var neo1 = new Car("Neo1", 0);
        var neo2 = new Car("Neo2", 1);
        final List<Car> cars = List.of(neo1, neo2);
        final RacingGame racingGame = new RacingGame(cars);

        racingGame.move();

        final List<Car> winners = racingGame.winners();

        assertThat(winners).containsExactly(neo2);
    }
}
