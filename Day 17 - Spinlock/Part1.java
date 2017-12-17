public class Part1 {

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(0);

        int input = 369;
        int position = 0;

        for (int i = 1; i < 2018; i++) {
            position = (position + input) % values.size() + 1;
            values.add(position, i);
        }

        System.out.print(values.get(position) + " -> ");
        System.out.println(values.get(position + 1));
    }

}
