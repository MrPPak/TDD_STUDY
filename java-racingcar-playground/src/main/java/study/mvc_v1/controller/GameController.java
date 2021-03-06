package study.mvc_v1.controller;

import study.mvc_v1.domain.RacingGame;
import study.mvc_v1.utils.ValidateUtils;
import study.mvc_v1.view.InputView;
import study.mvc_v1.view.OutputView;

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
