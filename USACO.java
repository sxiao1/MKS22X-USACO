import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{
  private int col;
  private int row;
  private int[][] pasture;
  private int finallvl;
  private int[][] instruct;
  public USACO (String filename)throws FileNotFoundException{
    try{
      File text = new File("makelake.1.in");
      Scanner in = new Scanner(text);
      String line = in.nextLine();
      for(int i = 0; i < line.length(); i++){
      }
      }
      catch(NumberFormatException e){}
    //pasture;
    //finallvl = 0;
    //instruct = 0;
    for(int r = 0; r < pasture.length; r ++){
      for(int c = 0; c < pasture.length; c ++){
        //pasure[r][c] = ary[r][c];
      }
    }

  }

  public void cowStomp(int r, int c, int num){
    pasture[r - 1][c - 1] = pasture[r - 1][c - 1] - num;
  }
}
