package study.racingcar_v1;

import study.racingcar_v1.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new GameController(new Scanner(System.in)).play();
    }
}
