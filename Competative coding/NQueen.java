public class NQueen {

	private static int N = 0;
	
	public static boolean isSafe(int row,int col,int mat[][]){
		
		for(int i = 0;i < col;++i){
			if(mat[row][i] == 1)
				return false;
		}
		
		for(int i = row,j = col;i >= 0&& j >= 0;--i,--j){
			if(mat[i][j] == 1)
				return false;
		}
		
		for(int i = row,j = col;i < N && j >= 0;++i,--j){
			if(mat[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	public static boolean NQueenSolver(int col,int mat[][]){
		
		if(col >= N){
			print(mat);
			return false;
		}
		
		for(int i = 0;i < N;++i){
			if(isSafe(i,col,mat)){
				mat[i][col] = 1;
				NQueenSolver(col+1,mat);
				mat[i][col] = 0;
			}
		}
		return false;
	}
	
	public static void print(int mat[][]){
		
		for(int i = 0; i < N;++i){
			for(int j = 0;j < N;++j){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
			
		}
		System.out.println();
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = 4;
		int mat[][] = new int[N][N];
		NQueenSolver(0, mat);
	} 

}
