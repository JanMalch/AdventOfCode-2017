public class Main {

    public static void main(String[] args) {
        int input = 0; // your input

        int circle = 0;
        int circleWidth = 1;
        int bottomRight = 1;
        int startNumber = 1;

        while(true) {
            circle++;
            circleWidth += 2;
            startNumber = bottomRight + 1;
            bottomRight = circleWidth * circleWidth;

            if(bottomRight > input) {
                break;
            }
        }


        int center = (int) Math.ceil(circleWidth / 2);

        int bottomLeft = bottomRight - circleWidth + 1;
        int topLeft = bottomLeft - circleWidth + 1;
        int topRight = topLeft - circleWidth + 1;


        System.out.println(input + " is on ring #" + circle);

        System.out.println("Square size = " + circleWidth + " * " + circleWidth);
        System.out.println("Center = ( " + center + " | " + center + " )\n");


        System.out.println(topLeft + " - " + topRight);
        System.out.println("|             |");
        System.out.println("|        " + startNumber);
        System.out.println(bottomLeft + " - " + bottomRight + "\n");

        int coordX = circleWidth - 1;
        int coordY = circleWidth - 2;
        int searchPointer = startNumber;


        while (searchPointer != input) {
            if(searchPointer < topRight) {
                coordY--;
                searchPointer++;
            }
            if(searchPointer == topRight) {
                break;
            }
        }

        while (searchPointer != input) {
            if(searchPointer < topLeft) {
                coordX--;
                searchPointer++;
            }
            if(searchPointer == topLeft) {
                break;
            }
        }

        while (searchPointer != input) {
            if(searchPointer < bottomLeft) {
                coordY++;
                searchPointer++;
            }
            if(searchPointer == bottomLeft) {
                break;
            }
        }

        while (searchPointer != input) {
            if(searchPointer < bottomRight) {
                coordX++;
                searchPointer++;
            }
            if(searchPointer == bottomRight) {
                break;
            }
        }

        System.out.println(input + " is at ( " + coordX + " | " + coordY + " )");

        int xDiff = coordX - center;
        int yDiff = coordY - center;

        int steps = Math.abs(xDiff) + Math.abs(yDiff);
        System.out.println("Steps: " + steps);
    }

}
