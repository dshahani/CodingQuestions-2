package december;

public class WordMatrix
{
	public static void main(String[] args)
	{
		char[][] matrix = { { 'a', 'b', 'c', 'd' }, { 'l', 'm', 'n', 'e' }, { 'k', 'p', 'o', 'f' },
				{ 'j', 'i', 'h', 'g' } };

		int[][] val = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < val.length; i++)
		{
			for (int j = 0; j < val[0].length; j++)
			{
				val[i][j] = 1;
			}
		}

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				updateMatrix(matrix, val, i, j);
			}
		}

		for (int i = 0; i < val.length; i++)
		{
			for (int j = 0; j < val[0].length; j++)
			{
				System.out.print(val[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	public static void updateMatrix(char[][] alpha, int[][] val, int i, int j)
	{
		int[] row = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] col = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int k = 0; k < 8; k++)
		{
			if (i + row[k] >= 0 && i + row[k] < alpha.length && j + col[k] >= 0 && j + col[k] < alpha[0].length)
			{
				if ((alpha[i + row[k]][j + col[k]] - alpha[i][j]) == 1)
				{
					if (val[i + row[k]][j + col[k]] < val[i][j] + 1)
					{
						val[i + row[k]][j + col[k]] = val[i][j] + 1;
						updateMatrix(alpha, val, i + row[k], j + col[k]);
					}
				}
			}

		}
	}
}
