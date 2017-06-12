public class MColorProblem {

	private static int V = 0;
	
	public static boolean isSafe(int graph[][],int v,int c,int color[]){
		
		for(int i = 0;i < V;++i){
			if(graph[v][i] == 1 && color[i] == c)
				return false;
		}
		return true;
	}
	
	public static boolean mColoring(int graph[][],int v,int color[],int m){
		
		if(v == V)
			return true;
		
		for(int i = 1;i <= m;++i){
			if(isSafe(graph,v,i,color)){
				color[v] = i;
				if(mColoring(graph,v+1,color,m))
					return true;
				color[v] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		V = 4;
		 int graph[][] = {{0, 1, 1, 1},
			        {1, 0, 1, 0},
			        {1, 1, 0, 1},
			        {1, 0, 1, 0},
			    };

		 int color[] = new int[V];
		 int m = 3;
		 if(mColoring(graph, 0, color, m))
			 System.out.println("YES");
		 else
			 System.out.println("NO");
		 
	}

}
