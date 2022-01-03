package study.step01;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static final String BASIC_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public int splitAndSum(String input) {
        if(isEmpty(input)) return 0;

        List<String> tokens = tokenizer(input);
        return sum(toInt(tokens));
    }

    private boolean isEmpty(String input) {
        return input == null || input == "";
    }

    private List<String> tokenizer(String input) {
        String delimiter = getDelimiter(input);
        return Arrays.asList(input.replace("//" + delimiter + "\n","").split(delimiter));
    }

    private String getDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);

        if(matcher.find()) {
            return matcher.group(1);
        }

        return BASIC_DELIMITER;
    }

    private List<Integer> toInt(List<String> tokens) {
        return tokens.stream().map(str -> {
            valid(str);
            return Integer.parseInt(str);
        }).collect(Collectors.toList());
    }

    private void valid(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 문자는 입력할 수 없습니다.");
        }

        if(Integer.parseInt(str) < 0) {
            throw new RuntimeException("0 이상의 숫자만 입력하세요.");
        }
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(number -> number).sum();
    }
}
