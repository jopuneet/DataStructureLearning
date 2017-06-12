// A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., 
// maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. 
// A rat starts from source and has to reach destination. The rat can move only in two directions: forward and down.
// In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path from source to destination. 
// Note that this is a simple version of the typical Maze problem. 
// For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with
// limited number of moves.


public class RatInMaze {

	private static int R = 0;
	private static int C = 0;
	
	public static boolean ratInMaze(int mat[][],int m,int n,boolean sol[][]){
		
		if(m == 0 && n ==0 )
			return sol[m][n] = true;
		
		if(isSafe(m,n,mat)){
			sol[m][n] = true;
			if(ratInMaze(mat, m-1, n, sol))
				return true;
			if(ratInMaze(mat, m, n-1, sol))
				return true;
			sol[m][n] = false;
			return false;
		}
		return false;
	}
	
	public static boolean isSafe(int i,int j,int mat[][]){
		if(i < 0 || i >= R || j < 0 || j >= C || mat[i][j] == 0)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		int maze[][]  =  { {1, 0, 0, 0},
		        {1, 1, 0, 1},
		        {0, 1, 0, 0},
		        {1, 1, 1, 1}
		    };
		
		R = maze.length;
		C = maze[0].length;
		
		boolean sol[][] = new boolean[R][C];
		
		if(ratInMaze(maze, R-1, C-1, sol)){
			
			for(int i = 0;i < R;++i){
				for(int j = 0;j < C;++j){
					if(sol[i][j])
						System.out.print(1+" ");
					else
						System.out.print(0+" ");
				}
				System.out.println();
			}
		}
		else
			System.out.println("cant reach");
	}

}
