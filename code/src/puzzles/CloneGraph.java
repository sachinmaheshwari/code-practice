package puzzles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {

  public static class Node {
    private final String label;
    private final List<Node> neighbours;

    public Node(String label, List<Node> neighbours) {
      this.label = label;
      this.neighbours = neighbours;
    }

    public String getLabel() {
      return label;
    }

    public List<Node> getNeighbours() {
      return neighbours;
    }
  }

  public static void main(String[] args) {
    LinkedList<Node> neighbours = new LinkedList<>();
    neighbours.add(new Node("B", new ArrayList<>()));
    neighbours.add(new Node("C", new ArrayList<>()));
    neighbours.add(new Node("D", new ArrayList<>()));
    Node root = new Node("A", neighbours);
  }

  public static void printGraph(Node node) {
    System.out.println(node.getLabel());
    for(Node neighbour: node.getNeighbours()){
      System.out.println("->");
      printGraph(neighbour);
    }
  }


}
