import java.io.File;
import java.util.Scanner;

public class Day2 {
  public static void main(String[] args) {
    System.out.println("Part 1 answer: " + Part1());
    System.out.println("Part 2 answer: " + Part2());
  }
  public static int Part1(){
    int hor = 0;
    int depth = 0;
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
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
  public static int Part2(){
    int hor = 0;
    int depth = 0;
    int aim = 0;
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
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