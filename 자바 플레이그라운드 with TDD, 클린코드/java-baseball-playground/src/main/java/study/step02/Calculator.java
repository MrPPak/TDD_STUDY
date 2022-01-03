package study.step02;

public class Calculator {

    private int calculateNum;
    private String operator;

    private int sum(int first, int second) {
        return first + second;
    }

    private int subtract(int first, int second) {
        return first - second;
    }

    private int multiply(int first, int second) {
        return first * second;
    }

    private int divide(int first, int end) {
        if(end == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return first / end;
    }

    private int calculate(int first, int end) {
        if(operator.equals("+")) return sum(first, end);
        if(operator.equals("-")) return subtract(first, end);
        if(operator.equals("*")) return multiply(first, end);
        if(operator.equals("/")) return divide(first, end);
        throw new ArithmeticException("연산자를 잘못입력하셨습니다.");
    }

    public int calculateTheInput(String input) {

        String[] values = input.split(" ");
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i++) {
            if(i % 2 == 1) {
                operator = values[i];
            }else {
                calculateNum = Integer.parseInt(values[i]);
                result = calculate(result, calculateNum);
            }
        }

        return result;
    }
}
