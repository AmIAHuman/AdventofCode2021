import java.util.Scanner;
import java.io.File;
import java.math.BigInteger;

public class Day6 {
  public static void main(String[] args) {
    System.out.println("Part 1 answer: " + Part1());
    System.out.println("Part 2 answer: " + Part2());
  }
  public static BigInteger Part1() {
    BigInteger[] lanternFishes = new BigInteger[9];
    BigInteger counter = new BigInteger("0");
    for (int i = 0; i < lanternFishes.length; i++) {
      lanternFishes[i] = new BigInteger("0");
    }
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      String[] initialStates = scanner.nextLine().split(",");
      for (String state : initialStates) {
        lanternFishes[Integer.parseInt(state)] = lanternFishes[Integer.parseInt(state)].add(new BigInteger("1"));
      }
    } catch(Exception e){}
    for (int i = 0; i < 80; i++) {
      BigInteger zeroToSix = lanternFishes[0];
      for (int j = 1; j < lanternFishes.length; j++) {
        lanternFishes[j - 1] = lanternFishes[j];
      }
      lanternFishes[6] = lanternFishes[6].add(zeroToSix);
      lanternFishes[8] = zeroToSix;
    }
    for (int i = 0; i < lanternFishes.length; i++) {
      counter = counter.add(lanternFishes[i]);
    }
    return counter;
  }
  public static BigInteger Part2() {
    BigInteger[] lanternFishes = new BigInteger[9];
    BigInteger counter = new BigInteger("0");
    for (int i = 0; i < lanternFishes.length; i++) {
      lanternFishes[i] = new BigInteger("0");
    }
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      String[] initialStates = scanner.nextLine().split(",");
      for (String state : initialStates) {
        lanternFishes[Integer.parseInt(state)] = lanternFishes[Integer.parseInt(state)].add(new BigInteger("1"));
      }
    } catch(Exception e){}
    for (int i = 0; i < 256; i++) {
      BigInteger zeroToSix = lanternFishes[0];
      for (int j = 1; j < lanternFishes.length; j++) {
        lanternFishes[j - 1] = lanternFishes[j];
      }
      lanternFishes[6] = lanternFishes[6].add(zeroToSix);
      lanternFishes[8] = zeroToSix;
    }
    for (int i = 0; i < lanternFishes.length; i++) {
      counter = counter.add(lanternFishes[i]);
    }
    return counter;
  }
}
