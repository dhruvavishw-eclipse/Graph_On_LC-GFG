import java.util.*;
public class _08_GFG_Undirected_Graph_Cycle {


     public static class Pair{
        int vertex;
        int parent;
        
        Pair(int vertex, int parent){
            this.vertex=vertex;
            this.parent=parent;
        }
    }

    //  new ArrayList<>(Arrays.asList( new ArrayList<>(Arrays.asList(1,3)),
    //                                                                      new ArrayList<>(Arrays.asList(3,0,1)),    
    //                                                                      new ArrayList<>(Arrays.asList(2)),   
    //                                                                      new ArrayList<>(Arrays.asList(0)) ));

    public static void main(String[] args) {
        // Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
         ArrayList<ArrayList<Integer>> adj =  new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1,2)),
                                                                             new ArrayList<>(Arrays.asList(0,2)),
                                                                             new ArrayList<>(Arrays.asList(0,1,3)),
                                                                             new ArrayList<>(Arrays.asList(2))));
         
         
       System.out.println(isCycle(adj));             // True                           

    }

   public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
       int n=adj.size();
       boolean vis []=new boolean [n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(bfs(i,vis,adj)) return true;
            }
        }
        return false;
    }
    
    
    
    public static boolean bfs(int src, boolean vis [],ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        
        while(q.size()>0){
        Pair front =q.remove();
         int vertex=front.vertex;
         int parent=front.parent;
         
         for(int ele: adj.get(vertex)){
             if(!vis[ele]){
                 q.add(new Pair(ele,vertex));
                 vis[ele]=true;
             }
             else if(ele!= parent) return true;
         }
            
        }
        return false;
    }

}
