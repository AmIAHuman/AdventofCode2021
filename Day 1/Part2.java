import java.util.Scanner;
import java.io.File;

public class Part2 {
  public static void main(String[] args) {
    int index = 0;
    int num1 = -1;
    int num2 = -1;
    int num3 = -1;
    int sum1 = -1;
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
          } catch(Exception e){System.out.println(e);}
          index++;
          sum1 = num1 + num2 + num3;
        }
        else {
          num1 = num2;
          num2 = num3;
          num3 = Integer.parseInt(line);
          int sum2 = num1 + num2 + num3;
          if (sum1 < sum2){
            System.out.println("inc " + sum1 + " " + sum2);
          }
          sum1 = sum2;
        }
      }
    } catch(Exception e){}
  }
}
