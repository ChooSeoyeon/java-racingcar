import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<Car> cars;

    RacingGame(final List<Car> cars) {
        this.cars = cars;
    }

    // 랜덤해서 테스트할 수 없다?
    // car 테스트에서 테스트 했다
    // 그럼 이거로 구현하면 되는 거 아닌가?
    // 방법은 있다. RacingGame.move()를 테스트하는 방법은 있다.
    // 그 에너지가 그만큼 보람있나?
    public void move() {
        for (int i = 0; i < cars.size(); i++) { // 반복문이 잘 도는가?
            final int power = new Random().nextInt(10);
            // 호출 여부를 위해 테스트 <- 이 사실을 알기 위해 소모되는 에너지가 그만큼 의미가 있는가
            // F <- E <- D <- B <- A <- Input
            // 어느 범위에서 테스트를 끊을 것인가?
            // 실수할 여지가 없고 간단한 코드인데, 실수했을 떄 해결하기 어렵다. <- 구조를 변경한다.
            cars.get(i).move(power);// 쉽다. 실수할 여지 없다. 만약 실수해도 해결하기 쉽다.
            // 그러면 일단 이대로 간다.
        }
    }

    // 우승자 구하기
    // 우승자는 누구인가? -> 가장 많이 간 사람 -> position이 가장 높은 자동차들
    // position들을 구해야 한다 -> 가장 높은 positon을 구해야 한다.
    // 가장 높은 position과 일치하는 자동차들이 우승 자동차들이다.
    // TODO: 메서드 이름 적절한 거로 변경하기
    public List<Car> winners() {
        int maxPosition = getMaxPosition();
        return getCars(maxPosition);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (final Car car : cars) {
            // TODO: indent 1로 줄이기
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<Car> getCars(final int maxPosition) {
         return cars.stream()
                .filter(it -> maxPosition == it.getPosition())
                .toList();
//        final List<Car> winners = new ArrayList<>();
//        for (final Car car : cars) { // TODO: final 붙이는 이유 알기
//            // TODO: stream 학습해서 indent 1로 줄이기
//            if (maxPosition == car.getPosition()) {
//                winners.add(car);
//            }
//        }
//
//        return winners;
    }
}
