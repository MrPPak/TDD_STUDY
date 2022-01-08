package study.step03_mvc.view;

import study.step03_mvc.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String RACING_GAME_WINNERS_MESSAGE = "가 최종우승했습니다.";
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,))를 기준으로 구분";
    public static final String INPUT_NUM_OF_ROUND_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static final String RACING_RESULT_MESSAGE = "실행결과";
    public static final String GO_FORWARD_MARK = "-";

    private OutputView() {}

    public static void printRaceResultMessage() {
        System.out.println();
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public static void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputNumOfRoundMessage() {
        System.out.println(INPUT_NUM_OF_ROUND_MESSAGE);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    // 매개변수를 Cars 클래스로 바꿔보는것은 어떨까
    public static void printCarStatus(List<Car> cars) {
        cars.forEach(car ->
            System.out.println(car.getCarName().getValue() + " : " + renderingCurrentCarPosition(car))
        );
        System.out.println();
    }

    private static String renderingCurrentCarPosition(Car car) {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < car.getPosition().getValue(); i++) {
            currentPosition.append(GO_FORWARD_MARK);
        }
        return currentPosition.toString();
    }

    public static void printWinner(List<Car> winners) {
        String winnersName = winners.stream()
                .map(car -> car.getCarName().getValue())
                .collect(Collectors.joining(","));
        System.out.println(winnersName + RACING_GAME_WINNERS_MESSAGE);
    }

}
