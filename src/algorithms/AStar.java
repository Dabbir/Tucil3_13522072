package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import dictionary.Dictionary;
import nodes.Nodes;
import nodes.Nodes.Node;

public class AStar extends Algorithm {
  public AStar(String filename) {
    super(filename);
  }

  @Override
  public List<String> findPath(Node start, Node target, Dictionary dictionary) {
    PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparing(Node::getCost));
    Set<String> explored = new HashSet<>(); 
    frontier.add(start);
    
    while (!frontier.isEmpty()) {
      Node currentNode = frontier.poll();
      if (currentNode.getWord().equals(target.getWord())) {
        System.out.println(explored.size() + " nodes explored");
        return constructPath(currentNode);
      }
      explored.add(currentNode.getWord()); 
      List<Node> neighborsNode = new ArrayList<>();
      List<String> neighbors = generateNeighbors(currentNode, dictionary);
      for (String neighborWord : neighbors) {
        Node neighborNode = new Node(neighborWord, g(currentNode) + h(neighborWord, target.getWord()));
        currentNode.addChild(neighborNode);
        neighborNode.setParent(currentNode);
        neighborsNode.add(neighborNode);
      }
      for (Node neighbor : neighborsNode) {
        if (!explored.contains(neighbor.getWord())) { 
          frontier.add(neighbor);
          explored.add(neighbor.getWord());
        } else if (frontier.contains(neighbor)) {
          for (Node node : frontier) {
            if (node.getWord().equals(neighbor.getWord()) && node.getCost() > neighbor.getCost()) {
              frontier.remove(node);
              frontier.add(neighbor);
            }
          }
        }
      }
    }

    return null;
  }
}