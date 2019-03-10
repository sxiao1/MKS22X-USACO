import java.io.*;
import java.util.*;
public class USACO{
  public static int[][] pasture;

  public static int bronze(String filename){
    int instructions[] = new int[4]; //4 values inputted
    ArrayList<Integer> nums = new ArrayList<Integer>();
    try{
      File text = new File(filename);
      Scanner in = new Scanner(text);
      while(in.hasNextInt()){
        nums.add(in.nextInt()); //adding all the values into an arraylist
      }
    }
    catch(FileNotFoundException e){}
    for(int i = 0; i < 4; i++){
      instructions[i] = nums.get(0); //adding values to the array
      nums.remove(0); //removing the first value to not mess up the index
    }
    int row = instructions[0];
    int col = instructions[1];
    /*System.out.println(row);
    System.out.println(col); making sure the right numbers get added to array */
    pasture = new int[row][col];
    for(int r = 0; r < row; r ++){
      for(int c = 0; c < col; c++){
        pasture[r][c] = nums.get(0); //copying over the numbers in the pasture
        nums.remove(0);
      }
    }
    int[][] moves = new int[instructions[3]][3]; //array of all the moves
    for(int r = 0; r < moves.length; r++){
      for(int c = 0; c < moves[0].length; c++){
        moves[r][c] = nums.get(0); //adding the values into the array
        nums.remove(0);
      }
    }
    for(int i = 0; i < moves.length; i++){
      stomping(moves[i][0],moves[i][1],moves[i][2]);
    }
    int finald = instructions[2];
    for(int r = 0; r < pasture.length; r++){
      for(int c = 0; c < pasture[0].length; c++){
        if(pasture[r][c] > finald){ //if greater than the final then it will be 0
          pasture[r][c] = 0;
        }
        else{
          pasture[r][c] = finald - pasture[r][c]; //if not replace value with difference
        }
      }
    }
    int total = 0;
    for(int r = 0; r < pasture.length; r++){
      for(int c = 0; c < pasture[0].length; c++){
        total += pasture[r][c];
      }
    }
    return 72 * 72 * total;
  }
  public static void stomping(int row, int col, int depth){
    int max = 0;
    int newRow = row -1; //starts with row 1 and col 1 instead of 0
    int newCol = col -1;
    for(int r = 0; r < 3; r++){
      for(int c = 0; c < 3; c++){
        if(pasture[newRow + r][newCol + c] > max){ //finding the largest value in a 3 x 3 square
          max = pasture[newRow + r][newCol + c];
        }
      }
    }
    int newd = max - depth;
    for(int r = 0; r < 3; r++){
      for(int c = 0; c < 3; c++){
        if(pasture[newRow + r][newCol + c] > newd){ //if larger than the depth, then its new value is the depth
          pasture[newRow + r][newCol + c] = newd;
        }
      }
    }
  }
  public static String returnString(){
    String newstr = "";
    for(int r = 0; r < pasture.length; r++){
      for(int c = 0; c < pasture[0].length; c++){
        newstr += "" + pasture[r][c];
      }
      newstr += "\n";
    }
    return newstr;
  }
  public static char[][] board;
  public static int silver(String filename){
    String together = "";
    int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    try{
      File text = new File(filename);
      Scanner in = new Scanner(text);
      int rows = in.nextInt();
      int cols = in.nextInt();
      int time = in.nextInt();
      in.nextLine();
      String path = "";
      while(in.hasNextLine()){
        path = in.nextLine();
        together += path;
      }
      int index = 0;
      board = new char[rows][cols];
      for(int r = 0; r < rows; r++){
        for(int c = 0; c < cols; c++){
          board[r][c] = together.charAt(index);
          index++;
        }
      }
      String[] nums = path.split(" ");
    }
    catch(FileNotFoundException e){}
    return 1;
  }
}
