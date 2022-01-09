package study.racingcar_v1.utils;

public class ValidateUtils {

    private static final int THE_MIN_NUM_OF_CAR_NAMES = 2;

    private ValidateUtils() {}

    public static void validateNumOfCarNames(String[] carNames) {
        if(carNames.length < THE_MIN_NUM_OF_CAR_NAMES) {
            throw new RuntimeException("자동차 이름은 2개 이상이어야 합니다.");
        }
    }

    public static int validateRacingRound(String round) {
        int roundNum = validateInteger(round);
        validateNegative(roundNum);
        return roundNum;
    }

    private static int validateInteger(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new RuntimeException("시도횟수는 숫자여야 됩니다.");
        }
    }

    private static void validateNegative(int round) {
        if(round < 1) {
            throw new RuntimeException("시도횟수는 1이상이어야 합니다.");
        }
    }

}
