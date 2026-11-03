import java.util.*;
public class _09_LC_785_Bipartite_Graph {
    public static void main(String[] args) {
        // Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
        int [] [] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};

   System.out.println(isBipartite(graph));  //LC  False

//    System.out.println( isBipartiteGFG(graph)); // GFG False
    }


    public  static boolean isBipartite(int[][] graph) {
        int v=graph.length;
     
        int [] vis=new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                if(!bfs(i,vis,graph)) return false ;
            }
        }
        return true;
    }

     public static boolean bfs(int src, int[] vis, int[][] graph) {
         vis[src]=1;
       Queue<Integer> q=new LinkedList<>();

       q.add(src);
      while(q.size()>0){
         int vertex=q.remove();
         int color=vis[vertex];
          for(int ele: graph[vertex]){
            if(vis[ele]==0){
               q.add(ele);
               vis[ele]=3-color;  // For one color ==1, second ==2,3==(1+2) , Then 3-1 gives 2 and 3-2 gives 1 for other vertex
            }
            else if(vis[ele]==color) return false;
          }
      }
      return true;
     }


     public static boolean isBipartiteGFG(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int m=graph.length;
        int n=graph[0].length;
        int v=(m*n) ;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int x= graph[i][0];
            int y=graph[i][1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        int [] vis=new int[v];
        for(int i=0;i<m;i++){
            if(vis[i]==0){
                if(!bfsGFG(i,vis,adj)) return false ;
            }
        }
        return true;
    }

     public static boolean bfsGFG(int src, int[] vis, ArrayList<ArrayList<Integer>> adj) {
         vis[src]=1;
       Queue<Integer> q=new LinkedList<>();

       q.add(src);
      while(q.size()>0){
         int vertex=q.remove();
         int color=vis[vertex];
          for(int ele: adj.get(vertex)){
            if(vis[ele]==0){
               q.add(ele);
               vis[ele]=3-color;  // For one color ==1, second ==2,3==(1+2) , Then 3-1 gives 2 and 3-2 gives 1 for other vertex
            }
            else if(vis[ele]==color) return false;
          }
      }
      return true;
     }

}
