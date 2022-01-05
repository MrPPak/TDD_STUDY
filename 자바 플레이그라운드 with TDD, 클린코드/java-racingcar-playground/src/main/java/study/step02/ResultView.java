package study.step02;

import java.util.Scanner;

public class ResultView {

    public static String COUNT_MSG = "시도할 횟수는 몇회인가요?";

    private Scanner scanner;
    private InputCars cars;

    public ResultView(Scanner scanner, InputCars cars) {
        this.scanner = scanner;
        this.cars = cars;
    }


}
