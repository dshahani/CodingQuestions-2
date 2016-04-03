package december;

import java.util.HashMap;
import java.util.Map;

public class mobileKeyToString
{

	public static void main(String[] args)
	{

		Map<Character, String> map = new HashMap<Character, String>();
		map.put('2', "a,b,c");
		map.put('3', "d,e,f");
		map.put('4', "g,h,i");
		map.put('5', "j,k,l");
		map.put('6', "m,n,o");
		map.put('7', "p,q,r,s");
		map.put('8', "t,u,v");
		map.put('9', "w,x,y,z");
		System.out.println(getStringFrmNumKey(map, "7267232"));

	}

	private static String getStringFrmNumKey(Map<Character, String> map, String numKey)
	{

		String str = calcCart(map.get(numKey.charAt(0)), map.get(numKey.charAt(1)));

		for (int i = 2; i < numKey.length(); i++)
		{
			str = calcCart(str, map.get(numKey.charAt(i)));
		}
		return str;
	}

	private static String calcCart(String str1, String str2)
	{
		StringBuffer outBuf = new StringBuffer("");
		if (str1 == null || str2 == null)
		{
			return (str1 != null ? str1 : str2);
		}
		int a = str1.length(), b = str2.length();
		String[] p1 = str1.split(",");
		String[] p2 = str2.split(",");
		for (String s1 : p1)
		{
			for (String s2 : p2)
			{
				outBuf.append(s1 + s2 + ",");
				if ((s1 + s2).equalsIgnoreCase("sampada"))
				{
					System.out.println(s1 + s2);
				}
			}
		}

		return outBuf.deleteCharAt(outBuf.length() - 1).toString();
	}

}
