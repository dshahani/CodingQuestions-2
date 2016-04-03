package december;

public class KMPStringMatch
{
	public static void main(String[] arg)
	{
		String smlTxt = "abcaby";// "abcdabca";
		int[] pre = preparePre(smlTxt.toCharArray());

		String longStr = "abxabcabcabyss";

		int j = 0;
		for (int i = 0; i < longStr.length(); i++)
		{
			if (j >= smlTxt.length())
			{
				break;
			}
			if (longStr.charAt(i) == smlTxt.charAt(j))
			{
				j++;
			} else
			{
				if (j - 1 >= 0)
				{
					j = pre[j - 1];
					i--;
				} else
				{
					j = 0;
				}
			}
		}

		if (j == smlTxt.length())
		{
			System.out.println("Match");
		}
	}

	public static int[] preparePre(char[] inArr)
	{
		int[] pre = new int[inArr.length];
		int j = 0;
		pre[0] = 0;
		for (int i = 1; i < inArr.length; i++)
		{
			if (inArr[j] == inArr[i])
			{
				j++;
				pre[i] = j;
			} else
			{
				while (j > 0 && inArr[j] != inArr[i])
				{
					j--;
					j = pre[j];
				}
				if (inArr[j] == inArr[i])
				{
					pre[i] = j + 1;
				}
			}
		}
		return pre;
	}
}
