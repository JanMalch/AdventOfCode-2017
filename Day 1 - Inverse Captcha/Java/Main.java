import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String input = "...";

        ArrayList<Integer> digitsToSum = new ArrayList<>();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            // int cmp = i + 1; // Part 1
            int cmp = i + chars.length / 2;  // Part 2

            if (cmp >= chars.length) {
                cmp -= chars.length;
            }

            if (chars[i] == chars[cmp]) {
                digitsToSum.add(chars[i] - '0');
            }

        }

        int sum = 0;

        for (int i : digitsToSum) {
            sum += i;
        }

        System.out.println(sum);
    }
}
