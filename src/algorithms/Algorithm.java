package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import dictionary.*;
import nodes.Nodes.*;
import interfaces.*;

public abstract class Algorithm implements FunctionValue, GValue, HValue {
  private HashSet<String> dictionary;
  public static int nodesExplored = 0;

  public Algorithm(String filename) {
    dictionary = new Dictionary(filename).getDictionary();
  }

  public HashSet<String> getDictionary() {
    return dictionary;
  }

  protected List<String> generateNeighbors(Node node, Dictionary dictionary) {
    List<String> neighbors = new ArrayList<>();
    String word = node.getWord();
    char[] chars = word.toCharArray();
    for (int i = 0; i < word.length(); i++) {
      char originalChar = chars[i];
      for (char c = 'A'; c <= 'Z'; c++) {
        chars[i] = c;
        String neighborWord = new String(chars);
        if (!neighborWord.equals(word) && dictionary.isContains(neighborWord)) {
          neighbors.add(neighborWord);
        }
      }
      chars[i] = originalChar;
    }
    return neighbors;
  }

  public List<String> constructPath(Node node) {
    List<String> ladder = new ArrayList<>();
    while(node != null) {
      ladder.add(node.getWord());
      node = node.getParent();
    }
    Collections.reverse(ladder);
    return ladder;
  }

  public int g(Node node) {
    int gValue = 0;
    Node currentNode = node;
    while (currentNode != null) {
      gValue++;
      currentNode = currentNode.getParent();
    }
    return gValue;
  }

  public int h(String node, String targetWord) {
    int hValue = 0;
    for (int i = 0; i < node.length(); i++) {
      if (node.charAt(i) != targetWord.charAt(i)) {
        hValue++;
      }
    }
    return hValue;
  }

  public int f(Node node, String targetWord) {
    return g(node) + h(node.getWord(), targetWord);
  }

  public abstract List<String> findPath(Node startWord, Node targetWord, Dictionary dictionary);
}