import java.util.Scanner;
import java.io.File;

public class Part1 {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
      }
    } catch(Exception e){}
  }
}
