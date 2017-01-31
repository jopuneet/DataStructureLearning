//Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix (mat[][]) the task to print a solution of the Sudoku. 
//For simplicity you may assume that there will be only one unique solution.
//Example
//For the above configuration the solution is
//3 1 6 5 7 8 4 9 2
//5 2 9 1 3 4 7 6 8
//4 8 7 6 2 9 5 3 1
//2 6 3 4 1 5 9 8 7
//9 7 4 8 6 3 1 2 5
//8 5 1 7 9 2 6 4 3
//1 3 8 9 4 7 2 5 6
//6 9 2 3 5 1 8 7 4
//7 4 5 2 8 6 3 1 9
//
//Input:
//The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.
//
//Output:
//For each test case in a new line print the space separated values of the solution of the the sudoku.
//
//Constraints:
//1<=T<=10
//0<=mat[]<=9
//
//Example:
//Input:
//1
//3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 1 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0
//
//Output:
//3 1 6 5 7 8 4 9 2 5 2 9 1 3 4 7 6 8 4 8 7 6 2 9 5 3 1 2 6 3 4 1 5 9 8 7 9 7 4 8 6 3 1 2 5 8 5 1 7 9 2 6 4 3 1 3 8 9 4 7 2 5 6 6 9 2 3 5 1 8 7 4 7 4 5 2 8 6 3 1 9 

import java.util.*;

class Sudoku {

	static int N = 9;
	static int grid[][] = new int[9][9];

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					grid[j][j2] = scanner.nextInt();
				}
			}
			boolean solved = solve(new Cell(0, 0));
			if (!solved) {
				System.out.println("SUDOKU cannot be solved.");
				return;
			}
			printGrid(grid);
			System.out.println();
		}
	}
	
	 static void printGrid(int grid[][]) {
		  for (int row = 0; row < N; row++) {
		   for (int col = 0; col < N; col++)
		    System.out.print(grid[row][col] + " ");
		  }
		 }

static class Cell {

	int row, col;

	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "Cell [row=" + row + ", col=" + col + "]";
	}

	};

	static boolean isValid(Cell cell, int value) {

		if (grid[cell.row][cell.col] != 0) {
			throw new RuntimeException("Cannot call for cell which already has a value");
		}

		for (int c = 0; c < 9; c++) {
			if (grid[cell.row][c] == value)
				return false;
		}

		for (int r = 0; r < 9; r++) {
			if (grid[r][cell.col] == value)
				return false;
		}

		int x1 = 3 * (cell.row / 3);
		int y1 = 3 * (cell.col / 3);
		int x2 = x1 + 2;
		int y2 = y1 + 2;

		for (int x = x1; x <= x2; x++)
			for (int y = y1; y <= y2; y++)
				if (grid[x][y] == value)
					return false;

		return true;
	}

	static Cell getNextCell(Cell cur) {

		int row = cur.row;
		int col = cur.col;

		col++;

		if (col > 8) {

			col = 0;
			row++;
		}

		if (row > 8)
			return null;

		Cell next = new Cell(row, col);
		return next;
	}

	static boolean solve(Cell cur) {

		if (cur == null)
			return true;

		if (grid[cur.row][cur.col] != 0) {
			return solve(getNextCell(cur));
		}

		for (int i = 1; i <= 9; i++) {

			boolean valid = isValid(cur, i);

			if (!valid)
				continue;

			grid[cur.row][cur.col] = i;

			boolean solved = solve(getNextCell(cur));

			if (solved)
				return true;
			else
				grid[cur.row][cur.col] = 0;
		}

		return false;
	}
}
