import java.io.File;
import java.util.Scanner;

public class Day1 {
  public static void main(String[] args) {
    System.out.println("Part 1 answer: " + Part1());
    System.out.println("Part 2 answer: " + Part2());
  }
  public static int Part1(){
    int index = 0, num1 = -1, num2 = -1, counter = 0;
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
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
  public static int Part2(){
    int index = 0, num1 = -1, num2 = -1, num3 = -1, sum1 = -1, counter = 0;
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if(index == 0){
          num1 = Integer.parseInt(line);
          try {
            num2 = Integer.parseInt(scanner.nextLine());
            num3 = Integer.parseInt(scanner.nextLine());
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
          index++;
        }
      }
    } catch(Exception e){}
    return counter;
  }
}
