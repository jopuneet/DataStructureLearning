// Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices 
// of the graph are colored with same color. Here coloring of a graph means assignment of colors to all vertices.

// Input:
// 1) A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation of the graph. 
// 	A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.
// 2) An integer m which is maximum number of colors that can be used.

// Output:
// An array color[V] that should have numbers from 1 to m. color[i] should represent the color assigned to the ith vertex. 
// The code should also return false if the graph cannot be colored with m colors.


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
