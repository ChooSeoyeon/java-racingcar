# java-racingcar

자동차 경주 미션 저장소



## 내가 해석한 요구사항

### 자동차
- [x] 자동차는 이름을 가지고 있다.
- [x] 이름은 5자 이하만 가능하다.
- [x] 자동차는 움직일 수 있다.
  - 자동차를 움직이는 조건은 파워다.
  - 파워가 4 이상일 경우 움직인다.
  - 파워가 4 보다 작을 경우 움직이지 않는다.


### 자동차 경주 / 자동차 게임
- 자동차는 움직일 수 있다.
  - 파워는 랜덤으로 생성된다.
- 자동차 경주 게임에 참여하는 자동차들의 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- n대의 자동차는 전진 또는 멈출 수 있다.

### 사용자 입출력
- 사용자는 몇 번의 [자동차] 이동을 할 것인지를 입력할 수 있어야 한다
- 전진하는 자동차를 출력할 때 자동차의 이름을 같이 출력한다



## 강의 내용
- 요구사항 분석 -> 같은 컨텍스트끼리 모음
- 파워라는 단어 정의함으로써 페어와의 커뮤니케이션 용이해짐 (개발자 스러운 용어 말고 일반적인 용어 사용함)
- 잘 동작한다고 나는 생각해도 근거가 없어 설득력이 없음
  - 둘다 잘 합의가 됐다면 일단 넘어가도 됨. 넘어간 다음에 살다보면 언젠가 문제 겪는 시점이 옴
  - 그때, 이거 했어야 되는데 하는 시점이 올 텐데 그때 해도 됨
  - 우리는 일단 단위테스트 작성해보자
- 자동차의 역할은 특정 파워를 넘기면 움직인다임. 기준이 4라는 거에 매몰되면 안됨
  - 구현은 구현일 뿐, 설계 했던 핵심에 접근하는 게 좋음
  - 동작으로만 생각하면, 테스트할 수 있다 없다 기준으로 해결하면 코드를 위한 코드가 생성되서 좋지 않음
  - 구현 형태나 코드 레벨로 접근하기보단, 설계를 제대로 했나, 역할 갖고 있나를 보자
- 우선순위 높은 거 중간중간에 판단해서 구현목록에서 위로 올릴까?
  - 우선순위 고민할 시간 없고, 일단 구현부터 하자
- 

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
