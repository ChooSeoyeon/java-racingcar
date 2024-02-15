# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

---
## 단어 정의
- 시도(try): 각 라운드를 의미한다. 매 라운드(시도)마다 자동차들은 전진하거나 멈춰있는다.
- 전진(forward): 실제로 차량이 앞으로 한칸 움직인다.

## 📄 기능 요구사항 정의

### 게임 시작
- [x] 자동차 이름을 입력받는다
  - [x] 자동차 이름은 쉼표로 구분해야 한다
  - [x] 자동차 이름은 공백 포함 5자 이하여야 한다
  - [x] 자동차 이름은 중복될 수 없다
  - [x] 자동차는 한 대 이상어야아 한다
- [x] 시도 횟수를 입력받는다
  - [x] 시도 횟수는 숫자여야 한다
  - [x] 시도 횟수는 1 이상이어야한다

### 게임 진행
- [x] 각 라운드마다 모든 자동차가 전진을 시도한다
  - [x] 0~9 사이의 랜덤값을 구해 4 이상인 경우 전진 가능하다고 판단한다
  - [x] 전진 가능 여부에 따라 전진한다
  - [x] 전진 결과를 출력한다

### 게임 종료
- [x] 우승자를 출력한다
  - [x] 우승자는 한 명 이상일 수 있다

---
## 부록
### 생각 로그
- 요구사항 정의 목표: 유저가 게임 동작 과정을 이해할 수 있게 작성한다.

### 고민한 포인트
- 의존성 갖는 관계에서 매개변수로 객체를 넘기는 것과, 필드로 객체를 갖는 것의 차이점
  1. 매개변수
    - 장점: 객체를 메시지처럼 주고받을 수 있음 (사용하는 측에서 단일 객체를 쓰던, 객체 리스트를 쓰던 상관 없이 사용 가능함)
      - 상관 없이 사용 가능하단 게 잘 안와닿긴 함 (ex. car를 사용하는 racing이 있다고 할 때)
        - racing이 car를 매개변수로 받을 땐 List<Car>를 가진 누군가가 racing을 사용할 때 racing 객체를 하나만 만들고, 함수를 여러 번 호출하면 됨
        - racing이 car를 필드로 받을 땐 List<Car>를 가진 누군가가 racing을 사용할 때 List<Racing> 처럼 객체를 여러 개 만들고, 각각의 함수를 한 번씩 호출하면 됨
    - 단점: 동일한 매개변수를 메서드마다 반복해서 넣어주는 일 생기기도 함 (매개변수가 많아짐)
  2. 필드
    - 장점: 모든 메서드가 사용하는 필드의 경우, 중복 코드 줄일 수 있음
    - 단점: 필드 형태가 고정되어 있어 유연하지 못함

- dto 재사용
  - 용도가 다르지만 전달할 데이터는 같은 경우, 동일한 dto를 재사용해도 되는가
    1. 재사용할 때 장점: 코드 중복 감소
    2. 재사용안하고 각각 만들어 사용할 때 장점: 두 기능의 스펙이 달라졌을 때 대응하기 용이함
  - 우리가 생각한 결론: 서비스 볼륨에 따라 다름

- dto 값을 활용하는 로직의 위치 (도메인과 dto 매핑하는 작업)
  1. 도메인에 넣을 때: dto의 필드가 변경되면 도메인의 코드가 바껴야 함(바람직 x)
    - dto의 필드를 도메인이 사용
  2. dto에 넣을 때: 도메인 필드가 변경되면 dto의 코드가 바껴야 함
    - 도메인의 필드를 dto가 사용
  - 우리가 생각한 결론: 두 번째 방식이 나음
    - 도메인보단 dto가 변경될 일이 더 많아서
    - dto가 많아지면 도메인이 dto를 사용하는 첫 번째 방식에선 도메인 로직이 매우 더러워져