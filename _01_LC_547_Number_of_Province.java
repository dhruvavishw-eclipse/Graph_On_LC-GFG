import java.util.*;
public class _01_LC_547_Number_of_Province {


    public static void main(String[] args) {
        // Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(findCircleNum(isConnected)); // Output: 2
    }

     public static int findCircleNum(int[][] isConnected) {
          
          int n=isConnected.length;
         int count=0;
           boolean[] isVisited=new boolean[n];

           for(int i=0;i<n;i++){
            if(!isVisited[i]){
              bfs(i,isVisited,isConnected);
              count++;
            }
           }
           return count;

        }

        static void bfs(int i, boolean[] isVisited, int[][] isConnected) {
            int n=isConnected.length;
           Queue<Integer> q=new LinkedList<>();
           q.add(i);
           isVisited[i]=true;

           while(q.size()>0){
            int front=q.remove();
               for(int j=0;j<n;j++){
                   if(isConnected[front][j]==1 && isVisited[j]==false){
                    q.add(j);
                    isVisited[j]=true;
                   }
               }
           }
    }

}
