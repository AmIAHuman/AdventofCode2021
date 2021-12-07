import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;

public class Day7 {
  public static void main(String[] args) {
    System.out.println("Part 1 answer: " + Part1());
    System.out.println("Part 2 answer: " + Part2());
  }
  public static int Part1() {
    ArrayList<Integer> fuels = new ArrayList<Integer>();
    int[] crabs = new int[0];
    int max;
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      crabs = Stream.of(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
    } catch(Exception e){}
    max = Arrays.stream(crabs).max().getAsInt();
    for (int fuel = 0; fuel <= crabs.length; fuel++) {
      fuels.add(alignSum(crabs, fuel));
    }
    return Collections.min(fuels);
  }
  public static int alignSum(int[] crabs, int fuel) {
    int sum = 0;
    for (int crab : crabs) {
      sum += Math.abs(crab - fuel);
    }
    return sum;
  }
  public static int Part2() {
    ArrayList<Integer> fuels = new ArrayList<Integer>();
    int[] crabs = new int[0];
    int max;
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      crabs = Stream.of(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
    } catch(Exception e){}
    max = Arrays.stream(crabs).max().getAsInt();
    for (int fuel = 0; fuel <= crabs.length; fuel++) {
      fuels.add(alignIncreasingSum(crabs, fuel));
    }
    return Collections.min(fuels);
  }
  public static int alignIncreasingSum(int[] crabs, int fuel) {
    int sum = 0;
    for (int crab : crabs) {
      sum += getIncreasingSum(Math.abs(crab - fuel));
    }
    return sum;
  }
  public static int getIncreasingSum(int num) {
    int sum = 0;
    for (int i = 0; i <= num; i++) {
      sum += i;
    }
    return sum;
  }
}
