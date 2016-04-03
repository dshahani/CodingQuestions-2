package december;

public class CheckIdenticalBST
{

	// next element smaller and greater than x should be same in both array
	public static void main(String[] args)
	{
		int a[] = { 8, 3, 6, 1, 4, 7, 10, 14, 13 };
		int b[] = { 8, 10, 14, 3, 6, 4, 1, 7, 13 };
		System.out.println(checkForBST(a, b, 0, 0, a.length, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public static boolean checkForBST(int[] a, int[] b, int i, int j, int n, int min, int max)
	{
		if (i == n && j == n)
		{
			return true;
		}

		int q, w;
		for (q = i; q < n; q++)
		{
			if (a[q] < max && a[q] > min)
			{
				break;
			}
		}

		for (w = j; w < n; w++)
		{
			if (b[w] < max && b[w] > min)
			{
				break;
			}
		}

		if (q == n && w == n)
		{
			return true;
		}

		if (q == n ^ w == n)
		{
			return false;
		}

		if (a[q] != b[w])
		{
			return false;
		}

		return (checkForBST(a, b, q + 1, w + 1, n, a[q], max) && checkForBST(a, b, q + 1, w + 1, n, min, a[q]));
	}

}
