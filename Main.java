import java.util.Scanner;
import java.io.File;

public class Main {
  public static void main(String[] args) {
    Main runMain = new Main();
    // Day One
    Main.Day1 dayOne = runMain.new Day1();
    System.out.println("Day 1 - Part 1: " + dayOne.Part1());
    System.out.println("Day 1 - Part 2: " + dayOne.Part2());
    // Day Two
    Main.Day2 dayTwo = runMain.new Day2();
    System.out.println("Day 2 - Part 1: " + dayTwo.Part1());
    System.out.println("Day 2 - Part 2: " + dayTwo.Part2());
  }
  public class Day1 {
    public int Part1(){
      int index = 0 ,num1 = -1, num2 = -1, counter = 0;
      try {
        Scanner scanner = new Scanner(new File("day1.in.txt"));
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          if(index == 0) {
            index++;
            num1 = Integer.parseInt(line);
          }
          else {
            num2 = Integer.parseInt(line);
            if(num1 < num2){
              counter++;
            }
            num1 = num2;
          }
        }
      } catch(Exception e){}
      return counter;
    }
    public int Part2(){
      int index = 0, num1 = -1, num2 = -1, num3 = -1, sum1 = -1, counter = 0;
      try {
        Scanner scanner = new Scanner(new File("day1.in.txt"));
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          if(index == 0){
            num1 = Integer.parseInt(line);
            try {
              Scanner sc = new Scanner(new File("day1.in.txt"));
              sc.nextLine();
              num2 = Integer.parseInt(sc.nextLine());
              num3 = Integer.parseInt(sc.nextLine());
            } catch(Exception e){}
            index++;
            sum1 = num1 + num2 + num3;
          }
          else {
            num1 = num2;
            num2 = num3;
            num3 = Integer.parseInt(line);
            int sum2 = num1 + num2 + num3;
            if (sum1 < sum2){
              counter++;
            }
            sum1 = sum2;
          }
        }
      } catch(Exception e){}
      return counter;
    }
  }
  public class Day2 {
    public int Part1(){
      int hor = 0;
      int depth = 0;
      try {
        Scanner scanner = new Scanner(new File("day2.in.txt"));
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          String[] tmp = line.split(" ");
          switch(tmp[0]){
            case "forward":
              hor += Integer.parseInt(tmp[1]);
              break;
            case "up":
              depth -= Integer.parseInt(tmp[1]);
              break;
            case "down":
              depth += Integer.parseInt(tmp[1]);
              break;
            default:
              System.out.println("err");
              break;
          }
        }
      } catch(Exception e){}
      return hor * depth;
    }
    public int Part2(){
      int hor = 0;
      int depth = 0;
      int aim = 0;
      try {
        Scanner scanner = new Scanner(new File("day2.in.txt"));
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          String[] tmp = line.split(" ");
          switch(tmp[0]){
            case "forward":
              hor += Integer.parseInt(tmp[1]);
              depth += aim * Integer.parseInt(tmp[1]);
              break;
            case "up":
              aim -= Integer.parseInt(tmp[1]);
              break;
            case "down":
              aim += Integer.parseInt(tmp[1]);
              break;
            default:
              System.out.println("err");
              break;
          }
        }
      } catch(Exception e){}
      return hor * depth;
    }
  }
}

