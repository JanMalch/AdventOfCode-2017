import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main();
    }

    private String[] lines;

    Main() throws IOException {
        readInput();
        find();
    }

    void readInput() throws IOException {
        this.lines = Files.lines(Paths.get("input.txt")).toArray(String[]::new);
    }

    void find() {

        HashMap<String, Element> map = new HashMap<>(lines.length);

        for(String line : lines) {
            String name = line.substring(0, line.indexOf(" "));

            int weight = Integer.parseInt(
                    line.substring(line.indexOf(" (")+2, line.indexOf(")")));

            String[] children = !line.contains("->") ? null :
                    line.substring(line.indexOf("->") + 3, line.length())
                            .split(", ");

            Element element = new Element(weight, children);

            map.put(name, element);
        }


        for(Map.Entry<String, Element> entry : map.entrySet()) {
            String[] children = entry.getValue().children;


            if(children != null) {
                for(String child : children) {
                    if(map.containsKey(child)) {
                        map.get(child).parent = entry.getKey();
                    }
                }
            }

        }

        for(Map.Entry<String, Element> entry : map.entrySet()) {
            if(entry.getValue().parent == null) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }

    public static class Element {
        int weight;
        String parent = null;
        String[] children = null;

        Element(int weight, String[] children) {
            this.weight = weight;
            this.children = children;
        }
    }
}
