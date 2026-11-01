import java.util.*;
public class _05_LC_994_Rotting_Oranges {

    
      public static class Triplet {
        int row;
        int col;
        int time;
        
        Triplet(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }

    public static void main(String RCB []){
        // Input: mat = [[2,1,1],[1,1,0],[0,1,1]]
        int [] [] mat = {{2,1,1},{1,1,0},{0,1,1}};

       System.out.println(orangesRotting(mat));  // Output: 4
    }

    public static int orangesRotting(int[][] mat) {
        if(mat == null ||  mat.length ==0  ||  mat[0].length ==0) return -1;
       
        Queue<Triplet> q= new LinkedList<>();
     int m=mat.length, n=mat[0].length;
     for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
             if(mat[i][j]==2){
                 q.add( new Triplet(i, j, 0));
             }
            
         }
     }

    
     
     int maxTime=0;
     
     while(q.size()>0){
         Triplet front=q.remove();
         int row=front.row, col=front.col,  time=front.time;
          
         
         
         maxTime=Math.max(time,maxTime);
         
         if(col-1 >= 0 && mat[row][col-1] ==1){ // Checking Left
             mat[row][col -1]=2;
             q.add(new Triplet(row, col-1, time +1));
         }
         
         if(col+1 <n && mat[row][col+1] ==1){
             mat[row][col +1]=2;
             q.add(new Triplet(row, col+1, time +1));  // Checking Right
         }
         
         
         if(row -1 >= 0 && mat[row-1][col] ==1){ // Checking Up
             mat[row -1][col]=2;
             q.add(new Triplet(row -1, col, time +1));
         }
         
         if(row +1 <m && mat[row+1][col] ==1){ // Checking Down
             mat[row +1][col]=2;
             q.add(new Triplet(row +1, col, time +1));
         }
         
     }
     
     for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
             if(mat[i][j]==1){
                return -1;
             }
         }
     }
     
     return maxTime;

    }
   
}
