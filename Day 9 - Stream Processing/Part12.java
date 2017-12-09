import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part12 {

    public static void main(String[] args) throws IOException {
        new Part12();
    }

    ArrayList<Character> input;

    Part12() throws IOException {
        input = new ArrayList<>();
        readInput();
        analyse();
    }

    void readInput() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        int character;

        while((character = in.read()) != -1) {
            input.add((char) character);
        }
    }

    void analyse() {
        boolean inGarbage = false;
        int score = 0;
        int level = 0;
        int garbageCount = 0;
        char currentChar;

        for(int i = 0; i < input.size(); i++) {
            currentChar = input.get(i);

            if(currentChar == '!') {
                i++;
            } else if (inGarbage && currentChar != '>') {
                garbageCount++; // Part 2
            } else if (currentChar == '<') {
                inGarbage = true;
            } else if (currentChar == '>') {
                inGarbage = false;
            } else if (currentChar == '{') {
                score += ++level;
            } else if (currentChar == '}') {
                level--;
            }

        }

        System.out.println("Score: " + score + ", Garbage: " + garbageCount);

    }

}
