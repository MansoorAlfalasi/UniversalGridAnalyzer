import java.util.Scanner;
public class GridAnalyzer {
 public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int[][] grid = {
        {0,1,2,3,4,5,6},{0,1,2,3,4,5,6},
        {0,1,2,3,4,5,6},{0,1,2,3,4,5,6},
        {0,1,2,3,4,5,6},{0,1,2,3,4,5,6}};

    int choice = -1;

    while (choice != 0) {

        System.out.println("1.Display  2.Sums  3.Max/Min  4.Freq  5.Pattern  6.Subgrid  7.Boundary  8.Check  0.Exit");
        choice = input.nextInt();

        if (choice == 1) {
            displayGrid(grid);
        }

        else if (choice == 2) {
            int[] r = rowSum(grid);
            int[] c = colSum(grid);

            System.out.println("Row sums: ");

            for (int x : r) 
            {
                System.out.print(x + " ");
            }
            System.out.println();
            
            System.out.println("Column sums: ");

            for (int x : c) System.out.print(x + " ");
        }

        else if (choice == 3) {
            int[] a = max(grid);
            int[] b = min(grid);

            System.out.println("Max: " + a[0]);
            System.out.println("Min: " + b[0]);
        }

        else if (choice == 4) {
            System.out.println("Enter a number: ");
            int num = input.nextInt();
            int[] res = sameGreaterThan(grid, num);

            System.out.println("This is the frequency of " + num + ": " + res[0] + ", and the number of numbers greather than" + num + ": " + res[1]);
        }

        else if (choice == 5) {
            System.out.println(increaseRow(grid));
        }

        else if (choice == 6) {
            System.out.println("write the starting row, starting column, ending row, and ending column: ");
            int rS = input.nextInt();
            int cS = input.nextInt();
            int rE = input.nextInt();
            int cE = input.nextInt();
        
            System.out.println("Sum of subgrid: " + sumOfSubgrid(grid, rS, cS, rE, cE));
            System.out.println("Max of subgrid: " + maxOfSubgrid(grid, rS, cS, rE, cE));
        }

        else if (choice == 7) {
            System.out.println("Boundary: ");
            Boundary(grid);
        }

        else if (choice == 8) {
            System.out.println(rowHasDups(grid));
        }
    }

    input.close();
 }

 public static void displayGrid(int[][] grid){
    for (int row = 0; row < grid.length; row++){
        for (int col = 0; col < grid[0].length; col++){

            System.out.print(grid[row][col] + " ");
        }
        System.out.println();
    }
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
    for(int row = 0; row<grid.length; row++){
        rowSum[col] += grid[row][col];
        }
    }
    return rowSum;
 }


 public static int[] max(int[][] grid){
    int max=grid[0][0];
    int r=0;
    int c=0;

    for (int row = 0; row < grid.length; row++){
        for (int col = 0; col < grid[0].length; col++)
            if (grid[row][col] > max){
                max = grid[row][col];
                r=row;
                c=col;
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

public static int sumOfSubgrid(int[][] grid, int rS, int cS, int rE, int cE){
    int sum = 0;

    for (int row = rS; row <= rE; row++){
        for (int col = cS; col <= cE; col++){
            sum += grid[row][col];
        }
    }
    return sum;

}
public static int maxOfSubgrid(int[][] grid, int rS, int cS, int rE, int cE){
    int max = grid[rS][cS];

    for (int row = rS; row <= rE; row++){
        for (int col = cS; col <= cE; col++){
            if (grid[row][col] > max){
                max = grid[row][col];
            }
        }
    }
    return max;
}

public static void Boundary(int[][] grid) {
    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[0].length; col++) {

            if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
                System.out.print(grid[row][col] + " ");
            }
        }
    }
}
public static boolean rowHasDups(int[][] grid){
    for (int row = 0; row < grid.length; row++){
        for (int col = 0; col < grid[0].length; col++){

            for (int c = col + 1; c < grid[0].length; c++){
                if (grid[row][col] == grid[row][c]){
                    return true;
                }
            }
        }
    }
    return false;

}
}
