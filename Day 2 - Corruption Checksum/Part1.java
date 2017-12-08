public class Part1 {

    public static void main(String[] args) {
        String input = "...";

        String[] rows = input.split("\n");

        int sum = 0;

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

            sum += maximum - minimum;

        }
        
        System.out.println(sum);
    }

}
