import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        String input = "...";


        String[] rows = input.split("\n");

        int sum = 0;

        for (String row : rows) {

            int[] digits = Arrays.stream(row.split("\t")).mapToInt(Integer::parseInt).toArray();

            int digitA = 0;
            int digitB = 0;

            outer:
            for (int digit : digits) {
                for (int cmpDigit : digits) {
                    if (digit != cmpDigit && digit % cmpDigit == 0) {
                        digitA = digit;
                        digitB = cmpDigit;
                        break outer;
                    }
                }
            }

            sum += digitA / digitB;
        }

        System.out.println(sum);
    }

}