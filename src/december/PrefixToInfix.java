package december;

import java.util.Stack;

public class PrefixToInfix
{
	public static void main(String[] args)
	{
		String exp = "/-ab/*cde";// "ABC*+D-";
		Stack<String> values = new Stack<String>();
		char[] expArr = exp.toCharArray();

		for (int i = exp.length() - 1; i >= 0; i--)
		{
			if (expArr[i] == ' ')
			{
				continue;
			} else if (expArr[i] == '+' || expArr[i] == '-' || expArr[i] == '/' || expArr[i] == '*')
			{
				StringBuffer buf = new StringBuffer("");
				String a = values.pop(), b = values.pop();
				buf.append("(" + a + expArr[i] + b + ")");
				values.push(buf.toString());
			}

			else
			{
				values.push(String.valueOf(expArr[i]));
			}

		}
		System.out.println(values.pop());
		System.out.println(calculate("*-567"));

	}

	public static int calculate(String inFix)
	{
		Stack<Integer> stck = new Stack<Integer>();
		for (int i = inFix.length() - 1; i >= 0; i--)
		{
			if (inFix.charAt(i) == '+' || inFix.charAt(i) == '-' || inFix.charAt(i) == '/' || inFix.charAt(i) == '*')
			{
				int a = Integer.parseInt(String.valueOf(stck.pop()));
				int b = Integer.parseInt(String.valueOf(stck.pop()));
				int ans = 0;
				switch (inFix.charAt(i))
				{
					case '+':
						ans = a + b;
						break;
					case '-':
						ans = a - b;
						break;
					case '*':
						ans = a * b;
						break;
					case '/':
						ans = a / b;
						break;
				}
				stck.push(ans);
			} else
			{
				stck.push(Integer.parseInt(String.valueOf(inFix.charAt(i))));
			}
		}
		if (stck.size() == 1)
		{
			return stck.pop();
		} else
		{
			return -1;
		}
	}
}
