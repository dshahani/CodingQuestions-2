package december;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountTriangle
{

	public static void main(String[] args)
	{
		Integer[] in = { 10, 5, 3, 7, 4, 1 };
		Arrays.sort(in);

		for (int i = 0; i <= in.length - 3; i++)
		{
			if (in[i] + in[i + 1] > in[i + 2])
			{
				System.out.println("{" + in[i] + "," + in[i + 1] + "," + in[i + 2] + "}");
			}
		}

		System.out.println("-----------------------------------");

		for (int i = 0; i < in.length - 2; i++)
		{

			for (int j = i + 1; j < in.length - 1; j++)
			{

				for (int k = j + 1; k < in.length; k++)
				{

					int a = in[i], b = in[j], c = in[k];

					if (a + b > c && b + c > a && c + a > b)
					{
						System.out.println("{" + a + "," + b + "," + c + "}");
					}
				}
			}
		}

		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < in.length; i++)
		{
			for (int j = i + 1; j < in.length; j++)
			{
				map.put(i + j, i + "," + j);
			}
		}

		for (int i = 0; i < in.length; i++)
		{

		}

	}
}
