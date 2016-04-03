package december;

public class CountInversions
{
	public static void main(String[] args)
	{
		// int[] input = { 1, 20, 6, 4, 5 };// { 2, 4, 1, 3, 5 };
		int[] input = { 2, 5, 8, 9, 10, 15, 11 };
		System.out.println(divide(input, 0, input.length - 1));
		for (int i = 0; i < input.length; i++)
		{
			System.out.print(input[i] + "\t");
		}
	}

	public static int divide(int[] input, int low, int high)
	{
		int inversion = 0;
		if (low >= high)
		{
			return 0;
		}

		int mid = low + (high - low) / 2;
		inversion = divide(input, low, mid);
		inversion += divide(input, mid + 1, high);
		inversion += combine(input, low, mid + 1, high);
		return inversion;
	}

	public static int combine(int[] input, int low, int mid, int high)
	{
		int[] temp = new int[input.length];
		int k = low, i = low, j = mid;
		int inversion = 0;
		for (int l = low; l <= high; l++)
		{
			temp[l] = input[l];
		}

		while (i <= (mid - 1) && j <= high)
		{
			if (temp[i] <= temp[j])
			{
				input[k] = temp[i];
				i++;
			} else
			{
				input[k] = temp[j];
				inversion = inversion + (mid - i);
				j++;
			}
			k++;
		}

		while (i <= (mid - 1))
		{
			input[k] = temp[i];
			k++;
			i++;
		}

		while (j <= high)
		{
			input[k] = temp[j];
			k++;
			j++;
		}
		return inversion;
	}
}
