package nodes;

import java.util.ArrayList;
import java.util.List;

public class Nodes {
  private Node root;

  public Nodes(String word) {
    this.root = new Node(word, 0);
  }

  public Node getRoot() {
    return root;
  }

  public static class Node {
    private String word;
    private int cost;
    private Node parent;
    private List<Node> children;

    public Node(String word, int cost) {
      this.word = word;
      this.cost = cost;
      this.children = new ArrayList<>();
    }

    public String getWord() {
      return word;
    }

    public int getCost() {
      return cost;
    }

    public Node getParent() {
      return parent;
    }

    public void setParent(Node parent) {
      this.parent = parent;
    }

    public List<Node> getChildren() {
      return children;
    }

    public void addChild(Node child) {
      children.add(child);
    }
    
    public void printTree(Node root, String prefix, boolean isTail) {
      System.out.println(prefix + (isTail ? "└── " : "├── ") + root.getWord() + " (" + root.getCost() + ")");
      List<Node> children = root.getChildren();
      for (int i = 0; i < children.size() - 1; i++) {
        printTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
      }
      if (children.size() > 0) {
        printTree(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
      }
    }
  }
}
