import java.util.Arrays;

public class Part2 {

    public static void main(String[] args) {
        int input = 369;
        int position = 0;
        int numberAfterZero = -1;

        for (int i = 1; i < 50_000_001; i++) {
            position = (position + input) % i + 1;
            if(position == 1) {
             numberAfterZero = i;
            }
        }

        System.out.println(numberAfterZero);
    }

}