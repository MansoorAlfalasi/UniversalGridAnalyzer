public class GridAnalyzer{
 public static void main (String[] args){
    int[][] grid= new int[6][6]; 
System.out.println(sameGreaterThan(grid, 0));

 }

 // day 1 morning
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
    for(int row = 0; row<grid.length; row++){
        rowSum[col] += grid[row][col];
        }
    }
    return rowSum;
 }
 // day 2 night


 public static int[] max(int[][] grid){
    int max=grid[0][0];
    int r=0;
    int c=0;

    for (int row = 0; row < grid.length; row++){
        for (int col = 0; col < grid[0].length; col++){
            if (grid[row][col] > max){
                max = grid[row][col];
                r=row;
                c=col;
            }

        }
    }
    int[] MRC= {max, r, c};
    return MRC;
 }


     public static int[] min(int[][] grid) {
    int max=grid[0][0];
    int r=0;
    int c=0;


    for (int row = 0; row < grid.length; row++){
        for (int col = 0; col < grid[0].length; col++){
            if (grid[row][col] < max){
                max = grid[row][col];
                r=row;
                c=col;
            }
        }
     }
     int[] MRC= {max, r, c};
     return MRC;
    }
    
    public static int[] sameGreaterThan(int[][] grid, int num){
        int[] count = {0, 0};
        
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == num){
                    count[0] ++;
                }
                if(grid[row][col] > num){
                    count[1] ++;
                }
            }
        }
        return count;

    }
}
    public static int rowHigh(int[][] grid){
    int highest = 0;
    int num = 0;

    for (int row = 0; row < grid.length; row++){
        int sum = 0;
        for (int col = 0; col < grid[0].length; col++){
            sum += grid[row][col];
        }
        if (sum > highest){
            highest = sum;
            num = row;
        }
    }
    return num;
}
public static int colWithLowestSum(int[][] grid){
    int low = 0;
    int num = 0;

    for (int col = 0; col < grid[0].length; col++){
        int sum = 0;
        for (int row = 0; row < grid.length; row++){
            sum += grid[row][col];
        }
        if (sum < low){
            low = sum;
            num = col;
        }
    }
    return num;
}
public static int increaseRow(int[][] grid){
    for (int row = 0; row < grid.length; row++){
        boolean increasing = true;

        for (int c = 1; c < grid[0].length; c++){
            if (grid[row][c] <= grid[row][c - 1]){
                increasing = false;
                return -1;
            }
        }

        if (increasing) {
            return row;
        }
    }
    return -1;
}
