import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;

public class Day5 {
  public static int[][] vents = new int[1000][1000];
  public static void main(String[] args) {
    for (int[] row : vents) {
      for (int col : row) {
        col = 0;
      }
    }
    System.out.println("Part 1 answer: " + Part1());
    vents = new int[1000][1000];
    System.out.println("Part 2 answer: " + Part2());
  }
  public static int Part1() {
    int counter = 0;
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] instructions = line.split(" -> ");
        String[] firstCoords = instructions[0].split(",");
        String[] secondCoords = instructions[1].split(",");
        cover(firstCoords, secondCoords, false);
      }
    } catch(Exception e){}
    for (int[] row : vents) {
      for (int col : row) {
        if(col > 1) {
          counter++;
        }
      }
    }
    return counter;
  }
  public static void cover(String[] firstCoords, String[] secondCoords, Boolean diagonal) {
    int[] first = Stream.of(firstCoords).mapToInt(Integer::parseInt).toArray();
    int[] second = Stream.of(secondCoords).mapToInt(Integer::parseInt).toArray();
    if(first[0] == second[0]) {
      for(int i = Math.min(first[1], second[1]); i <= Math.max(first[1], second[1]); i++) {
        vents[i][first[0]]++;
      }
    }
    else if(first[1] == second[1]) {
      for(int i = Math.min(first[0], second[0]); i <= Math.max(first[0], second[0]); i++) {
        vents[first[1]][i]++;
      }
    }
    else if(diagonal) {
      // right - high, low -> low, high
      // left  - high, high -> low, low
      if((first[0] > second[0] && first[1] < second[1]) || (first[0] < second[0] && first[1] > second[1])) {
        for(int i = 0; i <= Math.max(first[0], second[0]) - Math.min(first[0], second[0]); i++) {
          vents[Math.max(first[1], second[1]) - i][Math.min(first[0], second[0]) + i]++;
        }
      }
      else if((first[0] > second[0] && first[1] > second[1]) || (first[0] < second[0] && first[1] < second[1])) {
        for(int i = 0; i <= Math.max(first[0], second[0]) - Math.min(first[0], second[0]); i++) {
          vents[Math.min(first[1], second[1]) + i][Math.min(first[0], second[0]) + i]++;
        }
      }
    }
  }
  public static int Part2() {
    int counter = 0;
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] instructions = line.split(" -> ");
        String[] firstCoords = instructions[0].split(",");
        String[] secondCoords = instructions[1].split(",");
        cover(firstCoords, secondCoords, true);
      }
    } catch(Exception e){}
    for (int[] row : vents) {
      for (int col : row) {
        if(col > 1) {
          counter++;
        }
      }
    }
    return counter;
  }
  public static void printVents() {
    for (int[] row : vents) {
      for (int col : row) {
        if(col == 0) {
          System.out.print(".");
        }
        else {
          System.out.print(col);
        }
      }
      System.out.println();
    }
  }
}
