public class Cell {

   boolean isInCluster;
   boolean visited;
   
   public Cell(boolean clust){
      isInCluster = clust;
      visited = false;
   }
   
   public boolean isInCluster(){
     return isInCluster;
   }
   
   public void setVisited(){
      visited = true;
   }
   
   public boolean isVisited(){
      return visited;
   }
}