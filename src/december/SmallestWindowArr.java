package december;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowArr
{
	public static void main(String[] args)
	{
		System.out.println(minWindow("671324523125", "251"));
	}

	public static String minWindow(String s, String t)
	{
		if (s.length() == 0 || t.length() == 0)
			return "";
		Map<Character, Integer> remaining = new HashMap<Character, Integer>();
		int required = t.length();
		for (int i = 0; i < required; i++)
		{
			if (remaining.get(t.charAt(i)) != null)
			{
				int val = remaining.get(t.charAt(i));
				remaining.put(t.charAt(i), val + 1);
			} else
			{
				remaining.put(t.charAt(i), 1);
			}
		}

		int min = Integer.MAX_VALUE, start = 0, left = 0, i = 0;
		while (i < s.length() && start < s.length())
		{
			if (required > 0)
			{
				if (i == s.length())
					break;

				if (remaining.get(s.charAt(i)) != null)
				{
					int val = remaining.get(s.charAt(i));
					remaining.put(s.charAt(i), val - 1);
					if (remaining.get(s.charAt(i)) >= 0)
						required--;
				}

				i++;
			} else
			{
				if (i - start < min)
				{
					min = i - start;
					left = start;
				}

				int val = remaining.get(s.charAt(start));
				remaining.put(s.charAt(start), val + 1);
				if (remaining.get(s.charAt(start)) > 0)
					required++;
				start++;
			}
		}
		return (min == Integer.MAX_VALUE ? "" : s.substring(left, min));
	}
}
