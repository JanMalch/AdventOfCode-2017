import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

    public static void main(String[] args) throws IOException  {
        new Part1();
    }

    String[] input;

    Part1() throws IOException {
        readInput();
        doYourThang();
    }

    void readInput() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        input = in.readLine().split(",");
        in.close();
    }


    void doYourThang() {

        int x = 0, y = 0, z = 0, max = 0;

        for(String hr : input) {
            switch(hr) {
                case "nw": x--; y++; break;
                case "n": y++; z--; break;
                case "ne": x++; z--;break;
                case "sw": x--; z++; break;
                case "s": y--; z++; break;
                case "se": x++; y--; break;
            }

            int temp = (Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2; // Part 2
            if ( temp > max) { max = temp; }
        }

        int steps = (Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2;
        System.out.println("steps: " + steps + ", max: " + max);
    }


}
