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

public class GreedyBFS extends Algorithm {
  public GreedyBFS(String filename) {
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
      List<String> neighbors = generateNeighbors(currentNode, dictionary);
      for (String neighborWord : neighbors) {
        if (!explored.contains(neighborWord)) {
          Node neighborNode = new Node(neighborWord, h(neighborWord, target.getWord()));
          neighborNode.setParent(currentNode);
          frontier.add(neighborNode);
          explored.add(neighborWord);
        }
      }
      Node nextNode = frontier.poll();
      if (nextNode != null) {
        frontier.clear();
        frontier.add(nextNode);
      }
    }

    return null;
  }

}