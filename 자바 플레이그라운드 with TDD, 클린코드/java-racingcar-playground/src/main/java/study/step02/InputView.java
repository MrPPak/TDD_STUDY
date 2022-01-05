package study.step02;

import java.util.Scanner;

public class InputView {

    public static String INPUT_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private Scanner scanner;
    private InputCars cars;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void InputCarNames() {
        System.out.println(INPUT_CAR_NAME_MSG);
        cars = new InputCars(scanner.next());
    }

}
