public class GridApp {

  public static void  main(String[] args){
    int numRows = 10;
    int numCols = 10;
    int percent = 30;
    Grid bg = new Grid(numRows, numCols, percent);
    bg.printGrid();
    int numClusters = bg.getNumClusters();
    System.out.println("number of clusters: "+numClusters);
   }
}