package december;

public class ReplaceChar
{

	public static void main(String[] args)
	{
		String str = "hello how are you ";
		char[] arr = ReplaceFun(str.toCharArray(), str.length());

		for (char c : arr)
		{
			System.out.print(c);
		}

	}

	public static char[] ReplaceFun(char[] str, int length)
	{
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++)
		{
			if (str[i] == ' ')
			{
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char[] mArr = new char[newLength];
		for (i = length - 1; i >= 0; i--)
		{
			if (str[i] == ' ')
			{
				mArr[newLength - 1] = '0';
				mArr[newLength - 2] = '2';
				mArr[newLength - 3] = '%';
				newLength = newLength - 3;
			} else
			{
				mArr[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return mArr;
	}
}
