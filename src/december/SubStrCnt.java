package december;

import java.util.HashMap;
import java.util.Map;

public class SubStrCnt
{
	public static void main(String[] args)
	{
		String in = "ABCGRETCABCG", subStr;
		int lenOfSubStr = 3, freq = 0;
		Map<String, Integer> subMap = new HashMap<String, Integer>();
		for (int i = 0; i <= in.length() - lenOfSubStr; i++)
		{
			subStr = in.substring(i, i + lenOfSubStr);
			if (subMap.containsKey(subStr))
			{
				freq = subMap.get(subStr);
				subMap.put(subStr, ++freq);
			} else
			{
				subMap.put(subStr, 1);
			}
		}

		for (String key : subMap.keySet())
		{
			System.out.println(key + " : " + subMap.get(key));
		}
	}
}
