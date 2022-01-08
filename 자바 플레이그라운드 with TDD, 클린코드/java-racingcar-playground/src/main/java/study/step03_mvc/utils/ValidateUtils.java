package study.step03_mvc.utils;

import study.step03_mvc.exception.InvalidCarNameException;
import study.step03_mvc.exception.InvalidPositionException;

public class ValidateUtils {

    private static final int CAR_NAME_START_LENGTH = 1;
    private static final int CAR_NAME_END_LENGTH = 5;
    private static final int THE_MINIMUM_NUM_OF_CAR_NAMES = 2;

    private ValidateUtils() {}

    public static void validateNumOfCarNames(String[] carNames) {
        if(carNames.length < THE_MINIMUM_NUM_OF_CAR_NAMES) {
            throw new InvalidCarNameException("자동차 이름은 1개 이상이어야 합니다.");
        }
    }

    public static int validateRacingRound(String input) {
        int round = validateInteger(input);
        validateNotNegative(round);
        return round;
    }

    private static void validateNotNegative(int count) {
        if(count < 1) {
            throw new RuntimeException("시도횟수는 1이상이어야 합니다.");
        }
    }

    private static int validateInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new RuntimeException("시도횟수는 숫자이어야 합니다.");
        }
    }


}
