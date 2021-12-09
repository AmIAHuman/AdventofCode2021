import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;

public class Day8 {
  public static String[] possibleMappings, actualMappings;
  public static void main(String[] args) {
    //System.out.println("Part 1 answer: " + Part1());
    System.out.println("Part 2 answer: " + Part2());
  }
  public static int Part1() {
    int counter = 0;
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().split(" \\| ")[1];
        String[] afterPipe = line.split(" ");
        for (String possibleDigit : afterPipe) {
          counter += (identifyDigit(possibleDigit) != -1) ? 1 : 0;
        }
      }
    } catch(Exception e){}
    return counter;
  }
  // public static int identifyDigit(String possibleDigit) {
  //   char[] possibleDigitCharArr = possibleDigit.toCharArray();
  //   Arrays.sort(possibleDigitCharArr);
  //   switch((new String(possibleDigitCharArr))) {
  //     case "abcefg":
  //       return 0;
  //     case "cf":
  //       return 1;
  //     case "acdeg":
  //       return 2;
  //     case "acdfg":
  //       return 3;
  //     case "bcdf":
  //       return 4;
  //     case "avdfg":
  //       return 5;
  //     case "abdefg":
  //       return 6;
  //     case "acf":
  //       return 7;
  //     case "abcdefg":
  //       return 8;
  //     case "abcdfg":
  //       return 9;
  //     default:
  //       return -1;
  //   }
  // }
  public static int identifyDigit(String possibleDigit) {
    switch(possibleDigit.length()) {
      case 2:
        return 1;
      case 3:
        return 7;
      case 4:
        return 4;
      case 7:
        return 8;
      default:
        return -1;
    }
  }
  public static int Part2() {
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      while (scanner.hasNextLine()) {
        possibleMappings = new String[9];
        actualMappings = new String[9];
        String line = scanner.nextLine().split(" \\| ")[0];
        String[] order = line.split(" ");
        Arrays.sort(order, Comparator.comparingInt(String::length));
        for (String a : order) {
          System.out.println(a);
        }
      }
    } catch(Exception e){}
    return 0;
  }
  /*

  Mapping array
   0000
  1    2
  1    2
   3333
  4    5
  4    5
   6666

  */
  public static int mapDigit(String possibleDigit) {
    char[] possibleDigitCharArr = possibleDigit.toCharArray();
    Arrays.sort(possibleDigitCharArr);
    String sortedPossibleDigit = new String(possibleDigitCharArr);
    switch(possibleDigit.length()) {
      case 2:
        possibleMappings[2] = sortedPossibleDigit;
        possibleMappings[5] = sortedPossibleDigit;
        return 1;
      case 3:
        String zero = "";
        for (String possibleZero : sortedPossibleDigit.split("")) {
          if(!possibleMappings[2].contains(possibleZero) && !possibleMappings[5].contains(possibleZero)) {
            possibleMappings[0] = possibleZero;
            actualMappings[0] = possibleZero;
          }
        }
        return 7;
      case 4:
        return 4;
      case 7:
        return 8;
      default:
        return -1;
    }
  }
}
