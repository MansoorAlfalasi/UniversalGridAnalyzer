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
  // day 2 night


 public int[] max(int[][] grid){
    int max=grid[0][0];
    int r=0;
    int c=0;
    int[] MRC= {max, r, c};

    for (int row = 0; row < grid.length; row++){
        for (int col = 0; col < grid[0].length; col++){
            if (grid[row][col] > max){
                max = grid[row][col];
                r=row;
                c=col;
            }

        }
    }

    return MRC;
 }


     public int[] min(int[][] grid) {
    int max=grid[0][0];
    int r=0;
    int c=0;
    int[] MRC= {max, r, c};

    for (int row = 0; row < grid.length; row++){
        for (int col = 0; col < grid[0].length; col++){
            if (grid[row][col] < max){
                max = grid[row][col];
                r=row;
                c=col;
            }
        }
     }
     return MRC;
    }







}
  
