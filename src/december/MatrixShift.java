package december;

public class MatrixShift
{
	public static void main(String[] args)
	{
		int[][] matrix = new int[][] { new int[] { 1, 2, 3, 4, 5 }, new int[] { 6, 7, 8, 9, 10 },
				new int[] { 11, 12, 13, 14, 15 }, new int[] { 16, 17, 18, 19, 20 }, new int[] { 21, 22, 23, 24, 25 } };

		int curCol = matrix[0].length - 1;
		int curRow = 0;

		while (curRow != matrix.length)
		{
			while (curCol != 0)
			{
				int temp = matrix[curRow][curCol];
				matrix[curRow][curCol] = matrix[curRow][curCol - 1];
				matrix[curRow][curCol - 1] = temp;
				curCol--;
			}
			curCol = matrix[0].length - 1;
			curRow++;
		}

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
