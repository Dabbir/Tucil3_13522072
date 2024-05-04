import java.util.Scanner;

public class Main {
  // ANSI escape codes for colors
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_BOLD = "\u001B[1m";
  
  public static void main(String[] args) {
    System.out.println(ANSI_BOLD + ANSI_BLUE + "  _____           _     _       " + ANSI_RESET);
    System.out.println(ANSI_BOLD + ANSI_BLUE + " |  __ \\         | |   | |      " + ANSI_RESET);
    System.out.println(ANSI_BOLD + ANSI_BLUE + " | |__) | __ ___ | |__ | |_   _ " + ANSI_RESET);
    System.out.println(ANSI_BOLD + ANSI_BLUE + " |  ___/ '__/ _ \\| '_ \\| | | | |" + ANSI_RESET);
    System.out.println(ANSI_BOLD + ANSI_BLUE + " | |   | | | (_) | |_) | | |_| |" + ANSI_RESET);
    System.out.println(ANSI_BOLD + ANSI_BLUE + " |_|   |_|  \\___/|_.__/|_|\\__, |" + ANSI_RESET);
    System.out.println(ANSI_BOLD + ANSI_BLUE + "                           __/ |" + ANSI_RESET);
    System.out.println(ANSI_BOLD + ANSI_BLUE + "                          |___/ " + ANSI_RESET);
    System.out.println(ANSI_GREEN + "Welcome to Word Ladder Solver!" + ANSI_RESET);

    Scanner scanner = new Scanner(System.in);
    // System.out.println("Please select directory path for dictionary file");
    // System.out.print("Directory path: ");
    // String dictionary = scanner.nextLine();
    String dictionary = "dictionary2.txt";
    
    // Read input from user
    System.out.print(ANSI_BOLD + ANSI_YELLOW + "Please enter the start word: " + ANSI_RESET);
    String start = scanner.nextLine();
    System.out.print(ANSI_BOLD + ANSI_YELLOW + "Please enter the end word: " + ANSI_RESET);
    String target = scanner.nextLine();

    while(start.length() != target.length()) {
      System.out.println(ANSI_BOLD + ANSI_RED + "Start and target words must be of the same length" + ANSI_RESET);
      System.out.print(ANSI_BOLD + ANSI_YELLOW + "Please enter the start word: " + ANSI_RESET);
      start = scanner.nextLine();
      System.out.print(ANSI_BOLD + ANSI_YELLOW + "Please enter the end word: " + ANSI_RESET);
      target = scanner.nextLine();
    }

    System.out.println("Pilih algoritma:");
    System.out.println("1. UCS");
    System.out.println("2. Greedy Best First Search");
    System.out.println("3. A*");
    
    // Perform word ladder solving here
    System.out.print("Pilihan: ");
    int choice = scanner.nextInt();

    switch(choice) {
      case 1:
        Driver driver = new Driver();
        driver.DriverUCS(start.toUpperCase(), target.toUpperCase(), dictionary);
        break;
      case 2:
        Driver driver2 = new Driver();
        driver2.DriverGreedyBFS(start.toUpperCase(), target.toUpperCase(), dictionary);
        break;
      case 3:
        Driver driver3 = new Driver();
        driver3.DriverAStar(start.toUpperCase(), target.toUpperCase(), dictionary);
        break;
      default:
        System.out.println("Pilihan tidak valid");
    }

  }
}
