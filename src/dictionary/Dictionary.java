package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Dictionary {
  private static HashSet<String> dictionary;

  public Dictionary(String filename) {
    dictionary = new HashSet<>();
    loadDictionary(filename);
  }

  public Dictionary(String filename, String Word) {
    dictionary = new HashSet<>();
    loadWordDictionary(filename, Word);
  }

  private void loadDictionary(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String word;
      while ((word = br.readLine()) != null) {
        dictionary.add(word.toUpperCase());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void loadWordDictionary(String filename, String Word) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String word;
      while ((word = br.readLine()) != null){
        if (word.length() == Word.length()) {
          dictionary.add(word.toUpperCase());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean isContains(String word) {
    return dictionary.contains(word.toUpperCase());
  }

  public HashSet<String> getDictionary() {
    return dictionary;
  }
}
