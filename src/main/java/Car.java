public class Car {
    private final String name;
    private int position;

    Car(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능하다");
        }
        this.name = name;
        this.position = 0; // 명시 -> 하면 좋은 것이기에 우선순위 낮음
    }

    // 동일한 패키지에서 접근한다 <- 외부에서 접근하지 못한다
    // 접근제어자를 통해서 의도 전달 가능
    // 내 코드를 누군가 사용할 떄 실수할 가능성 줄이기
    // 생성자 vs 리플릭션
    // 테스트를 어떻게 바라볼 것인가?에 대한 기준이 됨 <- 테스트 하기 위해 프로덕션 레벨을 어느정도까지 건드릴 수 있냐
    // 랜덤을 분리한다 <- 테스트를 위해 구조 변경
    // 결국은 좋은 소프트웨어를 만들기 위함. 빠른 회복 탄력성 가지게 만들기
    // 실수 방지하는 코드 만드는 거임
    // 테스트코드를 위한 프로덕션 코드 변경되면 안된다고 딱 자르기보다 어디까지 허용할지를 정하기
    // 자신만의 기준 찾으면 됨
    Car(final String name, final int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능하다");
        }
        this.name = name;
        this.position = position; // 명시 -> 하면 좋은 것이기에 우선순위 낮음
    }

    // 해야 하는 것이기에 우선순위 높음
    public void move(int power) {
        if (power >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
