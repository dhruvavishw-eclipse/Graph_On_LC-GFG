import java.util.*;
public class _06_LC_1020_Number_of_Enclaves {

       static class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    public static void main(String RCB []){
    //    Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
    int [] [] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};

      System.out.println(numEnclaves(grid));  // Outpu =3;
    }

     public static int numEnclaves(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
     int m=grid.length;
     int n=grid[0].length;
     
     for(int j=0;j<n;j++){
         if(grid[0][j] ==1){
             grid[0][j] =-1;
             q.add(new Pair(0,j));
         }
         
         if(grid[m-1][j] ==1){
             grid[m-1][j] =-1;
             q.add(new Pair (m-1,j));
         }
      }
      
      
      for(int i=0;i<m;i++){
         if(grid[i][0] ==1){
            grid[i][0] =-1;
             q.add(new Pair (i,0));
         }
         
         if(grid[i][n-1] ==1){
             grid[i][n-1] =-1;
             q.add(new Pair (i,n-1));
         }
      }
      
      
      while(q.size()>0){
      Pair front=q.remove();
      int row=front.row, col= front.col;
      
      
       if( col-1 >=0 && grid[row][col -1] ==1){
             grid[row][col -1]=-1;
             q.add(new Pair(row,col-1));
         }
         
         if( col+1 < n && grid[row ][col +1] ==1){
            grid[row ][col +1]=-1;
            q.add(new Pair(row,col+1));
         }
      
      if( row-1 >=0 &&  grid[row -1][col] ==1){
            grid[row -1][col]=-1;
            q.add(new Pair(row-1,col));
            
         }
         
         if(row+1 < m && grid[row +1][col] ==1){
             grid[row +1][col] =-1;
             q.add(new Pair(row+1,col));
         }
    }
    
    int x=0;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                x++;
            }
        }
    }
    return x;
    }
}
