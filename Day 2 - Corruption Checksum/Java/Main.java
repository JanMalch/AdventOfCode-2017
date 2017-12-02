
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        String input = "...";


        String[] rows = input.split("\n");

        ArrayList<Integer> differences = new ArrayList<>();

        for(String row : rows) {

            String[] digits = row.split("\t");

            int maximum = Integer.MIN_VALUE;
            int minimum = Integer.MAX_VALUE;

            for(String strDigit : digits) {
                int digit = Integer.parseInt(strDigit);

                if (digit > maximum) {
                    maximum = digit;
                }
                if (digit < minimum) {
                    minimum = digit;
                }
            }

			differences.add(maximum - minimum);

        }

        int sum = 0;

        for(int i : differences) {
            sum += i;
        }

        System.out.println(sum);

    }

}
