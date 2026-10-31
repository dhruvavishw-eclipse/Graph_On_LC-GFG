import java.util.*;
public class _03_LC_841_Keys_and_Rooms {

    public static void main(String[] args) {
    //    Input: rooms = [[1,3],[3,0,1],[2],[0]]
     ArrayList<ArrayList<Integer>> rooms = new ArrayList<>(Arrays.asList( new ArrayList<>(Arrays.asList(1,3)),
                                                                         new ArrayList<>(Arrays.asList(3,0,1)),    
                                                                         new ArrayList<>(Arrays.asList(2)),   
                                                                         new ArrayList<>(Arrays.asList(0)) )); // THis is list of list  ArrayList<ArrayList<Integer>> 
  
           System.out.println(canVisitAllRooms(rooms));                                                              
    }

                                                  


    public static boolean canVisitAllRooms(ArrayList<ArrayList<Integer>> rooms) {
        int n=rooms.size();
        boolean visited []=new boolean[n];
         visited[0]=true;
         Queue<Integer> q= new LinkedList<>();
         q.add(0);
        
         while(q.size()>0){
            int front=q.remove();
            for(int ele:rooms.get(front)){
                if(!visited[ele]){
                    q.add(ele);
                    visited[ele]=true;
                }
            }
         }
         for(boolean flag:visited){
            if(!flag) return false;
         }
         return true;
    }
}
