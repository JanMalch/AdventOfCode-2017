public class Part2 {

    public static int x;
    public static int y;
    public static int[][] rows;
    public static int input;

    public static void main(String[] args) {

        input = 0; // your input

        int maxWidth = 11; // enough for my input number of about 360k

        rows = new int[maxWidth][maxWidth]; // outer index = x, inner index = y

        int center = (int) Math.ceil(maxWidth / 2);
        rows[center][center] = 1;

        x = center + 1;
        y = center;

        int minX = center - 1;
        int minY = center - 1;
        int maxX = center + 1;
        int maxY = center + 1;

        try {
            while (true) {
                minX--;
                minY--;
                maxX++;
                maxY++;

                for(; y > minY; y--) {
                    setValue();
                }
                y++;
                x--;

                for(; x > minX; x--) {
                    setValue();
                }
                x++;
                y++;

                for(; y < maxY; y++) {
                    setValue();
                }
                x++;
                y--;

                for(; x < maxX; x++) {
                    setValue();
                }
            }
        } catch(Exception e) {
            System.err.println("Choose larger maxWidth ...");
        }

    }

    public static void setValue() {
        int north = rows[x][y-1];
        int northEast = rows[x+1][y-1];
        int east = rows[x+1][y];
        int southEast = rows[x+1][y+1];
        int south = rows[x][y+1];
        int southWest = rows[x-1][y+1];
        int west = rows[x-1][y];
        int northWest = rows[x-1][y-1];

        rows[x][y] = north + northEast + east + southEast + south + southWest + west + northWest;

        if(rows[x][y] > input) {
            System.out.println("First value written bigger than my input: " + rows[x][y]);
            System.out.println("I'm outta here ...");
            System.exit(0);
        }

    }
}
