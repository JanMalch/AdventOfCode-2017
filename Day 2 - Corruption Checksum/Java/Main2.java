import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        String input = "...";


        String[] rows = input.split("\n");

        ArrayList<Integer> sumHelper = new ArrayList<>();

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

            if (digitA > digitB) {
                sumHelper.add(digitA / digitB);
            } else {
                sumHelper.add(digitB / digitA);
            }

        }

        int sum = 0;

        for (int i : sumHelper) {
            sum += i;
        }

        System.out.println(sum);

    }

}
