package study.step03_mvc.controller;

import study.step03_mvc.domain.RacingGame;
import study.step03_mvc.utils.ValidateUtils;
import study.step03_mvc.view.InputView;
import study.step03_mvc.view.OutputView;

import java.util.Scanner;

public class GameController {

    private InputView inputView;

    public GameController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void play() {
        String[] cars = inputCarNames();
        int round = inputRacingRound();

        OutputView.printRaceResultMessage();
        RacingGame racingGame = new RacingGame(cars, round);
        while(racingGame.isContinue()) {
            racingGame.race();
            OutputView.printCarStatus(racingGame.getCars());
        }
        OutputView.printWinner(racingGame.findWinners());
    }

    private int inputRacingRound() {
        try {
            OutputView.printInputNumOfRoundMessage();
            return ValidateUtils.validateRacingRound(inputView.inputValue());
        } catch (RuntimeException e) {
            OutputView.printExceptionMessage(e);
            return inputRacingRound();
        }
    }

    private String[] inputCarNames() {
        try {
            OutputView.printInputCarNameMessage();
            String[] cars = inputView.inputCarNames();
            ValidateUtils.validateNumOfCarNames(cars);
            return cars;
        } catch (Exception e) {
            OutputView.printExceptionMessage(e);
            return inputCarNames();
        }
    }
}
