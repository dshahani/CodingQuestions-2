package december;

import java.util.Stack;

public class IslandProblemStack
{
	static final int ROW = 5, COL = 5;

	public static boolean isSafe(int[][] movement, int row, int col, boolean[][] visited)
	{
		return ((row < ROW && row >= 0) && (col < COL && col >= 0) && (movement[row][col] == 1 && !visited[row][col]));
	}

	public static void DFS(int[][] M, boolean[][] visited, int row, int col)
	{
		int[] rowNmr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colNmr = { -1, 0, 1, -1, 1, -1, 0, 1 };
		Stack<Integer> dfsStack = new Stack<Integer>();
		dfsStack.push(row);
		dfsStack.push(col);

		while (!dfsStack.isEmpty())
		{
			col = dfsStack.pop();
			row = dfsStack.pop();
			visited[row][col] = true;
			for (int k = 0; k < 8; k++)
			{
				if (isSafe(M, row + rowNmr[k], col + colNmr[k], visited))
				{
					dfsStack.push(row + rowNmr[k]);
					dfsStack.push(col + colNmr[k]);
				}
			}
		}
	}

	public static int countIslands(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 0;
		boolean[][] bol = new boolean[rows][cols];
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (matrix[i][j] == 1 && !bol[i][j])
				{
					DFS(matrix, bol, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws java.lang.Exception
	{
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		System.out.println("Number of islands is: " + countIslands(M));
	}

}
