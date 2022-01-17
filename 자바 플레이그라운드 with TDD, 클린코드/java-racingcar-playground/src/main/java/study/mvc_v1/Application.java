package study.mvc_v1;

import study.mvc_v1.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new GameController(scanner).play();
    }
}
