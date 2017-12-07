import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        new Main2();
    }

    String[] input;
    ArrayList<Node<Element>> nodes;
    Node<Element> root = null;

    Main2() throws IOException {
        readInput();
        this.nodes = new ArrayList<>(input.length);
        find();
    }

    void readInput() throws IOException {
        this.input = Files.lines(Paths.get("input.txt")).toArray(String[]::new);
    }

    private static Element createElement(String line) {
        String name = line.substring(0, line.indexOf(" "));

        int weight = Integer.parseInt(
                line.substring(line.indexOf(" (") + 2, line.indexOf(")")));

        String[] children = !line.contains("->") ? null :
                line.substring(line.indexOf("->") + 3, line.length())
                        .split(", ");

        return new Element(weight, name, children);
    }



    void find() {
        for (String line : input) {
            nodes.add(new Node<>(createElement(line)));
        }

        for (Node<Element> node : nodes) {
            node.addChildren(getChildrenNodes(node.getData().name));
        }


        for (Node<Element> node : nodes) {
            if (node.isRoot()) {
                root = node;
                break;
            }
        }

        for(Node<Element> node : root.children) {
            downTheRabbitHole(node);
        }
    }

    int downTheRabbitHole(Node<Element> node) {

        int[] childrenWeights = new int[node.children.size()];
        int childrenWeightsSum = 0;

        if(!node.isLeaf()) {
            int i = 0;
            for(Node<Element> child : node.getChildren()) {
                childrenWeights[i++] = downTheRabbitHole(child);
            }

            for(int j = 1; j < childrenWeights.length; j++) {
                if(childrenWeights[j] != childrenWeights[j-1]) {

                    int diff = childrenWeights[j] - childrenWeights[j-1];

                    System.out.println(Arrays.toString(childrenWeights) + " @ " + node.getData().name);
                    System.out.println("The problem's name: " + node.getChildren().get(j).getData().name);
                    System.out.println("Its' weight: " + node.getChildren().get(j).getData().weight);
                    System.out.println("It would better me: " + (node.getChildren().get(j).getData().weight - diff));
                    System.exit(0);
                }
            }

            for(int cW : childrenWeights) {
                childrenWeightsSum += cW;
            }
        }


        return node.getData().weight + childrenWeightsSum;
    }


    List<Node<Element>> getChildrenNodes(String searchName) {
        List<Node<Element>> children = new ArrayList<>();
        List<String> childrenNames = new ArrayList<>();

        for (Node<Element> node : nodes) {
            if (node.getData().name.equals(searchName)) {
                childrenNames = node.getData().children != null ?
                        Arrays.asList(node.getData().children)
                        : new ArrayList<>();
                break;
            }
        }

        for (Node<Element> node : nodes) {
            if (childrenNames.contains(node.getData().name)) {
                children.add(node);
            }
        }

        return children;
    }


    public static class Element {
        int weight;
        String name;
        String[] children;

        Element(int weight, String name, String[] children) {
            this.weight = weight;
            this.name = name;
            this.children = children;
        }

        public String toString() {
            return "Element ( " + name + ", " + weight + " )";
        }

    }

    public static class Node<T> {

        private List<Node<T>> children = new ArrayList<>();
        private Node<T> parent = null;
        private T data = null;

        public Node(T data) {
            this.data = data;
        }

        public void addChild(T data) {
            Node<T> child = new Node<>(data);
            child.setParent(this);
            this.children.add(child);
        }

        public void addChild(Node<T> child) {
            child.setParent(this);
            this.children.add(child);
        }

        public void addChildren(List<Node<T>> children) {
            for (Node<T> node : children) {
                node.setParent(this);
            }

            this.children.addAll(children);
        }


        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public boolean isRoot() {
            return this.parent == null;
        }

        public boolean isLeaf() {
            return this.children.size() == 0;
        }

        public void removeParent() {
            this.parent = null;
        }
    }

}
