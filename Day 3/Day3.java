import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;

public class Day3 {
  public static int bitLength = -1;
  public static String oxyGenBits = "";
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      bitLength = scanner.nextLine().length();
    } catch(Exception e){}

    System.out.println("Part 1 answer: " + Part1());
    System.out.println("Part 2 answer: " + Part2());
  }
  public static int Part1() {
    String commonBits = "";
    int gamma = -1, epsilon = -1;
    ArrayList<ArrayList<Integer>> bitsArraylist = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < bitLength; i++) {
      bitsArraylist.add(new ArrayList<Integer>());
    }
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      while(scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] lineArr = line.split("");
        for(int i = 0; i < bitLength; i++) {
          bitsArraylist.get(i).add(Integer.parseInt(lineArr[i]));
        }
      }
    } catch(Exception e){}
    for(int i = 0; i < bitLength; i++) {
      commonBits += ((Collections.frequency(bitsArraylist.get(i), 0) > bitsArraylist.get(i).size() / 2) ? "0" : "1");
    }
    gamma = Integer.parseInt(commonBits, 2);
    epsilon = Integer.parseInt(invert(commonBits), 2);
    return gamma * epsilon;
  }
  public static int Part2() {
    ArrayList<String> bitsAL = new ArrayList<String>();
    ArrayList<String> bits2AL = new ArrayList<String>();
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      while(scanner.hasNextLine()) {
        String line = scanner.nextLine();
        bitsAL.add(line);
        bits2AL.add(line);
      }
    } catch(Exception e){}
    for(int i = 0; i < bitLength; i++) {
      bitsAL = getRemainingALCB(i, bitsAL);
      if(bits2AL.size() != 1){
        bits2AL = getRemainingALLCB(i, bits2AL);
      }
    }
    return Integer.parseInt(oxyGenBits, 2) * Integer.parseInt(bits2AL.get(0), 2);
  }
  public static String invert(String bits) {
    String[] originalArr = bits.split("");
    String newBits = "";
    for(String bit : originalArr) {
      newBits += ((bit.equals("0")) ? "1" : "0");
    }
    return newBits;
  }
  public static String print2DArrayList(ArrayList<ArrayList<Integer>> twoDAL) {
    String result = "";
    for(int i = 0; i < twoDAL.size(); i++) {
      for(int j = 0; j < twoDAL.get(i).size(); j++) {
        result += twoDAL.get(i).get(j);
      }
      result += "\n";
    }
    return result;
  }
  public static ArrayList<String> getRemainingALCB(int index, ArrayList<String> bitsAL) {
    ArrayList<String> bitAL = new ArrayList<String>();
    ArrayList<String> newBitsAL = new ArrayList<String>();
    for(String bits : bitsAL) {
      String[] bitsStrArr = bits.split("");
      bitAL.add(bitsStrArr[index]);
    }
    String commonBit = ((Collections.frequency(bitAL, "0") > bitAL.size() / 2) ? "0" : "1");
    oxyGenBits += commonBit;
    for(int i = 0; i < bitAL.size(); i++) {
      if(commonBit.equals(bitAL.get(i))) {
        newBitsAL.add(bitsAL.get(i));
      }
    }
    return newBitsAL;
  }
  public static ArrayList<String> getRemainingALLCB(int index, ArrayList<String> bitsAL) {
    ArrayList<String> bitAL = new ArrayList<String>();
    ArrayList<String> newBitsAL = new ArrayList<String>();
    for(String bits : bitsAL) {
      String[] bitsStrArr = bits.split("");
      bitAL.add(bitsStrArr[index]);
    }
    String leastCommonBit = ((Collections.frequency(bitAL, "0") <= bitAL.size() / 2) ? "0" : "1");
    for(int i = 0; i < bitAL.size(); i++) {
      if(leastCommonBit.equals(bitAL.get(i))) {
        newBitsAL.add(bitsAL.get(i));
      }
    }
    return newBitsAL;
  }
}
