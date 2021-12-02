import java.util.Scanner;
import java.io.File;

public class Part1 {
  public static void main(String[] args) {
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
    System.out.println(hor);
    System.out.println(depth);
    System.out.println(hor * depth);
  }
}
