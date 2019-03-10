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
    return 1;
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
