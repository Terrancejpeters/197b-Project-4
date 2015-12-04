import java.util.Random;

public class Grid{

	private int rows;
	private int cols;
	/* The percentage of cells that are in a cluster.
     0<= percentage<=100 */
	private int percentage;
	private Cell[][]grid;
	private Random rand;
	private long seed;

	public Grid(int r, int c, int p){
		rows = r;
		cols = c;
		percentage = p;
		//rand = new Random(); 
		rand = new Random(seed);// for debug
		initGrid();
	}

	private void initGrid(){
		grid = new Cell[rows][cols];
		int randInt;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				randInt = rand.nextInt(100);
				if (randInt < percentage){
					grid[i][j] = new Cell(true);
				}
				else{
					grid[i][j] = new Cell(false);
				}
			}
		}
	}

	/* Returns the number of clusters in the grid.
     It explores the grid for cells in a cluster that are also
     unvisited. When it finds one, it increments the cluster count
     and then uses markCluster to explore the extent of that cluster.  */
	public int getNumClusters() {
		int clustCt = 0;
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				if (grid[i][j].visited == false && grid[i][j].isInCluster == true){
					markCluster(i,j);
					clustCt++;
				}
			}
		}
		return clustCt;
	}

	/* This method explores the area around a cluster cell recursively.
     It first marks the grid position [row][col] as visited, then checks 
     the surrounding positions: right, left, up, down. If a surrounding 
     position is in a cluster and has not been visited, call markCluster
     on that cell.  */
	private void markCluster(int row, int col){
		grid[row][col].setVisited();
		//make sure there is a cell to right
		//check right cell
		if (row + 1 < rows){
			if(grid[row + 1][col].isInCluster() == true && grid[row + 1][col].isVisited() == false){
				markCluster((row +1),col);
			}
		}
		//make sure there is a cell to left
		//check left cell
		if (row - 1 >= 0){
			if(grid[row - 1][col].isInCluster() == true && grid[row - 1][col].isVisited() == false){
				markCluster((row - 1),col);
			}
		}
		//make sure there is a cell above
		//check up cell
		if (col + 1 < cols){
			if(grid[row][col + 1].isInCluster() == true && grid[row][col + 1].isVisited() == false){
				markCluster(row,(col + 1));
			}
		}
		//make sure there is a cell below
		//check down cell
		if (col - 1 >= 0){
			if(grid[row][col - 1].isInCluster() == true && grid[row][col - 1].isVisited() == false){
				markCluster(row,(col - 1));
			}
		}
	}

	/* Cells in the grid in a cluster are printed as a " O ", 
     otherwise printed as a " - ".  */  
	public void printGrid(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(grid[i][j].isInCluster){
					System.out.print(" O ");
				}
				else{
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}
}