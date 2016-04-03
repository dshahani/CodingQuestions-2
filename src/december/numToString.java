package december;

import java.util.HashMap;
import java.util.Scanner;

public class numToString
{
	static HashMap h1 = new HashMap();
	static HashMap h2 = new HashMap();

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number ");
		int n = s.nextInt();
		h1.put(1, "One");
		h1.put(2, "Two");
		h1.put(3, "Three");
		h1.put(4, "Four");
		h1.put(5, "Five");
		h1.put(6, "Six");
		h1.put(7, "Seven");
		h1.put(8, "Eight");
		h1.put(9, "Nine");
		h1.put(10, "Ten");
		h1.put(11, "Eleven");
		h1.put(12, "Twelve");
		h1.put(13, "Thirteen");
		h1.put(14, "Fourteen");
		h1.put(15, "Fifteen");
		h1.put(16, "Sixteen");
		h1.put(17, "Seventeen");
		h1.put(18, "Eighteen");
		h1.put(19, "Nineteen");
		h2.put(2, "Twenty");
		h2.put(3, "Thirty");
		h2.put(4, "Fourty");
		h2.put(5, "Fifty");
		h2.put(6, "Sixty");
		h2.put(7, "Seventy");
		h2.put(8, "Eighty");
		h2.put(9, "Ninety");
		String output = getStringRepresentation(n);
		System.out.println("Output: " + output);
	}

	public static String getStringRepresentation(int n)
	{
		StringBuilder sb = new StringBuilder();
		String temp;
		int x = n / 1000000;
		if (x > 0)
		{
			temp = getStringFor3Digits(x);
			sb.append(temp).append(" Million");
		}
		n = n % 1000000;
		x = n / 1000;
		if (x > 0)
		{
			System.out.println("For thousand x = " + x);
			temp = getStringFor3Digits(x);
			sb.append(" ").append(temp).append(" Thousand");
		}
		n = n % 1000;
		if (n > 0)
		{
			temp = getStringFor3Digits(n);
			sb.append(" ").append(temp);
		}
		return sb.toString();
	}

	public static String getStringFor3Digits(int n)
	{
		StringBuilder sb = new StringBuilder();
		int x = n / 100;
		if (x > 0)
		{
			System.out.println("In hundred x = " + x + " " + h1.get(x));
			sb.append(h1.get(x)).append(" Hundred");
		}
		n = n % 100;
		if (n < 20)
		{
			System.out.println("n = " + n + " " + h1.get(n));
			sb.append(" ").append(h1.get(n));
		} else
		{
			x = n / 10;
			if (x > 0)
			{
				sb.append(" ").append(h2.get(x));
			}
			n = n % 10;
			if (n > 0)
				sb.append(" ").append(h1.get(n));
		}
		return sb.toString();
	}
}