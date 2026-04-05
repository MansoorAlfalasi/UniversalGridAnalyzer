public class GridAnalyzer{
 public static void main (String[] args){
    int[][] grid= new int[6][6]; 

 }
 public static int[] rowSum(int[][] grid){
    int[] rowSum = new int[grid.length];

    for( int row = 0; row<grid.length; row++){
        for(int col = 0; col<grid[0].length; col++){
        rowSum[row] += grid[row][col];
        }


    }

    return rowSum;
 }
  public static int[] colSum(int[][] grid){
    int[] rowSum = new int[grid[0].length];
    for(int col = 0; col<grid[0].length; col++){
    for( int row = 0; row<grid.length; row++){
        rowSum[col] += grid[row][col];
        }
    }
    return rowSum;
 }






}
  
