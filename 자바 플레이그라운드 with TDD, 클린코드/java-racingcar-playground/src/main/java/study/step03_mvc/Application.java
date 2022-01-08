package study.step03_mvc;

import study.step03_mvc.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new GameController(scanner).play();
    }
}
