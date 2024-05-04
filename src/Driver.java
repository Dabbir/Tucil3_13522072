import java.util.List;

import algorithms.*;
import nodes.Nodes;
import nodes.Nodes.Node;
import dictionary.Dictionary;

public class Driver {
  public void DriverUCS(String start, String target, String directoryPath) {
    UCS ucs = new UCS("src/dictionary/" + directoryPath);
    Nodes nodes = new Nodes(start);
    Node startWord = nodes.getRoot();
    Dictionary dictionary = new Dictionary("src/dictionary/" + directoryPath, start);
    nodes = new Nodes(target);
    Node targetWord = nodes.getRoot();
    System.out.println("\u001B[31m====================================================\u001B[0m");
    System.out.println("Start word: " + startWord.getWord());
    System.out.println("Target word: " + targetWord.getWord());

    if (!dictionary.isContains(startWord.getWord()) || !dictionary.isContains(targetWord.getWord())) {
      System.out.println("Start word or target word not in dictionary");
      return;
    }
    long startTime = System.currentTimeMillis();
    List<String> ladder = ucs.findPath(startWord, targetWord, dictionary);
    long endTime = System.currentTimeMillis();
    if (ladder != null) {
      System.out.println("Path found: " + (ladder.size() - 1) + " steps\u001B[1m\u001B[31m");
      for (int i = 0; i < ladder.size(); i++) {
        System.out.print(ladder.get(i));
        if (i < ladder.size() - 1) {
          System.out.print(" - ");
        }
      }
      System.out.println();
    } else {
      System.out.println("Path not found");
    }
    System.out.println("\u001B[33mTime taken: " + (endTime - startTime) + "ms\u001B[0m");
  }

  public void DriverGreedyBFS(String start, String target, String directoryPath) {
    GreedyBFS greedyBFS = new GreedyBFS("src/dictionary/" + directoryPath);
    Nodes nodes = new Nodes(start);
    Node startWord = nodes.getRoot();
    Dictionary dictionary = new Dictionary("src/dictionary/" + directoryPath, start);
    nodes = new Nodes(target);
    Node targetWord = nodes.getRoot();
    System.out.println("\u001B[31m====================================================\u001B[0m");
    System.out.println("Start word: " + startWord.getWord());
    System.out.println("Target word: " + targetWord.getWord());

    if (!dictionary.isContains(startWord.getWord()) || !dictionary.isContains(targetWord.getWord())) {
      System.out.println("Start word or target word not in dictionary");
      return;
    }
    long startTime = System.currentTimeMillis();
    List<String> ladder = greedyBFS.findPath(startWord, targetWord, dictionary);
    long endTime = System.currentTimeMillis();
    if (ladder != null) {
      System.out.println("Path found: " + (ladder.size() - 1) + " steps\u001B[1m\u001B[31m");
      for (int i = 0; i < ladder.size(); i++) {
        System.out.print(ladder.get(i));
        if (i < ladder.size() - 1) {
          System.out.print(" - ");
        }
      }
      System.out.println();
    } else {
      System.out.println("Path not found");
    }
    System.out.println("\u001B[33mTime taken: " + (endTime - startTime) + "ms\u001B[0m");
  }

  public void DriverAStar(String start, String target, String directoryPath) {
    AStar aStar = new AStar("src/dictionary/" + directoryPath);
    Nodes nodes = new Nodes(start);
    Node startWord = nodes.getRoot();
    Dictionary dictionary = new Dictionary("src/dictionary/" + directoryPath, start);
    nodes = new Nodes(target);
    Node targetWord = nodes.getRoot();
    System.out.println("\u001B[31m====================================================\u001B[0m");
    System.out.println("Start word: " + startWord.getWord());
    System.out.println("Target word: " + targetWord.getWord());

    if (!dictionary.isContains(startWord.getWord()) || !dictionary.isContains(targetWord.getWord())) {
      System.out.println("Start word or target word not in dictionary");
      return;
    }
    long startTime = System.currentTimeMillis();
    List<String> ladder = aStar.findPath(startWord, targetWord, dictionary);
    long endTime = System.currentTimeMillis();
    if (ladder != null) {
      System.out.println("Path found: " + (ladder.size() - 1) + " steps\u001B[1m\u001B[31m");
      for (int i = 0; i < ladder.size(); i++) {
        System.out.print(ladder.get(i));
        if (i < ladder.size() - 1) {
          System.out.print(" - ");
        }
      }
      System.out.println("\u001B[0m");
    } else {
      System.out.println("Path not found");
    }
    System.out.println("\u001B[33mTime taken: " + (endTime - startTime) + "ms\u001B[0m");
  }
}
