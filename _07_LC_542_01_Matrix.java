import java.util.*;
public class _07_LC_542_01_Matrix {
    
      public static class Pair{
        int row;
        int col;
        
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
      }

    public static void main(String RCB []){
    //  Input: mat = [[0,0,0],[0,1,0],[1,1,1]]  This one for LC
    // int grid [] [] = {{0,0,0},{0,1,0},{1,1,1}};
    // System.out.println(updateMatrix(grid));  // Output: [[0,0,0],[0,1,0],[1,2,1]]

    // Input: grid[][] = [[0, 1, 1, 0], [1, 1, 0, 0], [0, 0, 1, 1]] This one for GFG
    int grid[][] = {{0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}};
    System.out.println(nearest(grid));  // Output = [[1, 0, 0, 1], [0, 0, 1, 1], [1, 1, 0, 0]]

    }

    public static int[][] updateMatrix(int[][] grid) {
        // THis one is on LC and its return type is a 2D Array
        // THis problem has little bit of diff. , This is asking for nearest 0 from 0 
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int ans [] []=new int [m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.add(new Pair(i,j));
                }
            }
        }
                
        while(q.size()>0){        
          Pair front=q.remove();
           int row=front.row, col=front.col;
        
           if(col -1 >=0 && grid[row][col -1] ==1 && ans[row][col -1] ==0){
               ans[row] [col -1] = ans[row] [col] +1;
               q.add(new Pair(row, col-1));
           } 
           
           if(col +1 <n && grid[row][col +1] ==1 && ans[row][col +1] ==0){
               ans[row] [col +1] = ans[row] [col] +1;
               q.add(new Pair(row, col+1));
           } 
               
           if(row -1 >=0 && grid[row -1][col] ==1 && ans[row -1][col] ==0){
               ans[row -1] [col] = ans[row] [col] +1;
               q.add(new Pair(row -1, col));
           } 
           
           if(row +1 <m && grid[row +1][col] ==1 && ans[row +1][col] ==0){
            ans[row +1] [col] = ans[row] [col] +1;
                q.add(new Pair(row +1, col));
           }        
        }
               
        return ans; 

    }



       public static ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // This one for GFG and this has a seperate method because of it's return type that is 2D ArrayList;
        // And also GFG question is asking dist from nearest 1 while LC just reverse of this
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int ans [] []=new int [m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                }
            }
        }
             
        while(q.size()>0){
            
          Pair front=q.remove();
           int row=front.row, col=front.col;
        
           if(col -1 >=0 && grid[row][col -1] ==0 && ans[row][col -1] ==0){
               ans[row] [col -1] = ans[row] [col] +1;
               q.add(new Pair(row, col-1));
           } 
           
           if(col +1 <n && grid[row][col +1] ==0 && ans[row][col +1] ==0){
               ans[row] [col +1] = ans[row] [col] +1;
               q.add(new Pair(row, col+1));
           } 
                  
           if(row -1 >=0 && grid[row -1][col] ==0 && ans[row -1][col] ==0){
               ans[row -1] [col] = ans[row] [col] +1;
               q.add(new Pair(row -1, col));
           } 
           
           if(row +1 <m && grid[row +1][col] ==0 && ans[row +1][col] ==0){
            ans[row +1] [col] = ans[row] [col] +1;
                q.add(new Pair(row +1, col));
           }        
        }
        
        ArrayList<ArrayList<Integer>> ans2=new ArrayList<>();     
        for(int i=0;i<m;i++){
            ArrayList<Integer> a=new ArrayList<>();
             for(int j=0;j<n;j++){
                 a.add(ans[i][j]);
             }
            ans2.add(a);
        }      
        return ans2;
    }

}
