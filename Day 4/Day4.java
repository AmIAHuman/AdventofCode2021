import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.File;

public class Day4 {
  public static int lastMove = -1;
  public static ArrayList<Integer> moves = new ArrayList<Integer>();
  public static ArrayList<ArrayList<Integer>> winBoard = new ArrayList<ArrayList<Integer>>();
  public static ArrayList<ArrayList<ArrayList<Integer>>> allBoards = new ArrayList<ArrayList<ArrayList<Integer>>>();
  public static void main(String[] args) {
    getMoves();
    processBoard();
    System.out.println("Part 1 answer: " + Part1());
    System.out.println("Part 2 answer: " + Part2());
  }
  public static int Part1() {
    Boolean won = false;
    for (int move : moves) {
      if(won) break;
      allBoards = useMove(move, allBoards);
      won = checkWinOfAllBoards(allBoards);
    }
    return countUnmarked(winBoard) * lastMove;
  }
  public static int Part2() {
    int moveIndex = 0;
    for (int move : moves) {
      allBoards = useMove(move, allBoards);
      moveIndex++;
      if(allBoards.size() == 1) break;
      allBoards = removeWinBoards(allBoards);
    }
    allBoards = useMove(moves.get(moveIndex), allBoards);
    return countUnmarked(allBoards.get(0)) * lastMove;
  }
  public static void getMoves() {
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      String line = scanner.nextLine();
      String[] movesArr = line.split(",");
      for(String move : movesArr) {
        moves.add(Integer.parseInt(move));
      }
    } catch(Exception e){}
  }
  public static void processBoard() {
    try {
      Scanner scanner = new Scanner(new File("input.txt"));
      scanner.nextLine();
      scanner.nextLine();
      while (scanner.hasNextLine()) {
        ArrayList<ArrayList<Integer>> tmpBoard = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 5; i++) {
          ArrayList<Integer> tmpBoardLine = new ArrayList<Integer>();
          String line = scanner.nextLine();
          String[] nums = line.split(" ");
          for(String num : nums) {
            if(!num.equals("")) tmpBoardLine.add(Integer.parseInt(num));
          }
          tmpBoard.add(tmpBoardLine);
        }
        allBoards.add(tmpBoard);
        scanner.nextLine();
      }
    } catch(Exception e){}
  }
  public static ArrayList<ArrayList<ArrayList<Integer>>> useMove(int move, ArrayList<ArrayList<ArrayList<Integer>>> boards) {
    lastMove = move;
    for (int i = 0; i < boards.size(); i++) {
      for (int j = 0; j < boards.get(i).size(); j++) {
        for (int j2 = 0; j2 < boards.get(i).get(j).size(); j2++) {
          if(boards.get(i).get(j).get(j2) == move) {
            boards.get(i).get(j).set(j2, -1);
          }
        }
      }
    }
    return boards;
  }
  public static int countUnmarked(ArrayList<ArrayList<Integer>> board) {
    int sum = 0;
    for(int i = 0; i < board.size(); i++) {
      for(int j = 0; j < board.get(i).size(); j++) {
        if(board.get(i).get(j) != -1) sum += board.get(i).get(j);
      }
    }
    return sum;
  }
  public static ArrayList<ArrayList<ArrayList<Integer>>> removeWinBoards(ArrayList<ArrayList<ArrayList<Integer>>> boards) {
    for(int i = boards.size() - 1; i >= 0; i--) {
      if(checkWin(boards.get(i))) {
        winBoard = boards.get(i);
        boards.remove(i);
      }
    }
    return boards;
  }
  public static Boolean checkWinOfAllBoards(ArrayList<ArrayList<ArrayList<Integer>>> boards) {
    for(ArrayList<ArrayList<Integer>> board : boards) {
      if(checkWin(board)) {
        winBoard = board;
        return true;
      }
    }
    return false;
  }
  public static Boolean checkWin(ArrayList<ArrayList<Integer>> board) {
    ArrayList<Integer> winRow = new ArrayList<Integer>();
    for(int i = 0; i < 5; i++) {
      winRow.add(-1);
    }
    for(int i = 0; i < board.size(); i++) {
      if(board.get(i).equals(winRow)) return true;
      Boolean winCol = true;
      for(int j = 0; j < 5; j++) {
        winCol = winCol && board.get(j).get(i) == -1;
      }
      if(winCol) return true;
    }
    return false;
  }
  public static String print3DArrayList(ArrayList<ArrayList<ArrayList<Integer>>> threeDAL) {
    String result = "";
    for(int i = 0; i < threeDAL.size(); i++) {
      for(int j = 0; j < threeDAL.get(i).size(); j++) {
        for(int k = 0; k < threeDAL.get(i).get(j).size(); k++) {
          result += threeDAL.get(i).get(j).get(k) + " ";
        }
        result += "\n";
      }
      result += "\n";
    }
    return result;
  }
  public static String print2DArrayList(ArrayList<ArrayList<Integer>> twoDAL) {
    String result = "";
    for(int i = 0; i < twoDAL.size(); i++) {
      for(int j = 0; j < twoDAL.get(i).size(); j++) {
        result += twoDAL.get(i).get(j) + " ";
      }
      result += "\n";
    }
    return result;
  }
}
