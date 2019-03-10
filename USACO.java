import java.io.*;
import java.util.*;
public class USACO{
  public static int[][] pasture;

  public static int bronze(String filename){
    int instructions[] = new int[4];
    ArrayList<Integer> nums = new ArrayList<Integer>();
    try{
      File text = new File(filename);
      Scanner in = new Scanner(text);
      while(in.hasNextInt()){
        nums.add(in.nextInt());
      }
    }
    catch(FileNotFoundException e){}
    for(int i = 0; i < 4; i++){
      instructions[i] = nums.get(0);
      nums.remove(0);
    }
    int row = instructions[0];
    int col = instructions[1];
    /*System.out.println(row);
    System.out.println(col); making sure the right numbers get added to array */
    pasture = new int[row][col];
    for(int r = 0; r < row; r ++){
      for(int c = 0; c < col; c++){
        pasture[r][c] = nums.get(0);
        nums.remove(0);
      }
    }
    int[][] moves = new int[instructions[3]][3];
    for(int r = 0; r < moves.length; r++){
      for(int c = 0; c < moves[0].length; c++){
        moves[r][c] = nums.get(0);
        nums.remove(0);
      }
    }
    for(int i = 0; i < moves.length; i++){
      stomping(moves[i][0],moves[i][1],moves[i][2]);
    }
    return 1;
  }
  public static void stomping(int row, int col, int depth){
    int max = 0;
    int newRow = row -1;
    int newCol = col -1;
    for(int r = 0; r < 3; r++){
      for(int c = 0; c < 3; c++){
        if(pasture[newRow + r][newCol + c] > max){
          max = pasture[newRow + r][newCol + c];
        }
      }
    }
    int newd = max - depth;
    for(int r = 0; r < 3; r++){
      for(int c = 0; c < 3; c++){
        if(pasture[newRow + r][newCol + c] > newd){
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
}
