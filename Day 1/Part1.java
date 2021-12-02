import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

 public static void main(String[] args) {
  BufferedReader objReader = null;
  int index = 0;
  int num1 = -1;
  int num2 = -1;
  try {
   String strCurrentLine;
   objReader = new BufferedReader(new FileReader("day1.in.txt"));
   while ((strCurrentLine = objReader.readLine()) != null) {
     if(index == 0) {
       System.out.println("n/a");
       index++;
       num1 = Integer.parseInt(strCurrentLine);
     }
     else {
       num2 = Integer.parseInt(strCurrentLine);
       if(num1 < num2){
         System.out.println("inc " + num1 + " to " + num2);
       }
       num1 = num2;
     }
   }
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   try {
    if (objReader != null)
     objReader.close();
   } catch (IOException ex) {
    ex.printStackTrace();
   }
  }
 }
}
