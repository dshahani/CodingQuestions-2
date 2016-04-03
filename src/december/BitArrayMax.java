package december;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BitArrayMax
{

	public static void main(String[] args)
	{
		int[][] arr = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 }, { 0, 1, 1 } };
		HashSet<Integer> ignoreSet = new HashSet<Integer>();
		for (int j = 0; j < arr[0].length; j++)
		{
			HashSet<Integer> temp = new HashSet<Integer>();
			boolean ignore = false;
			for (int i = 0; i < arr.length; i++)
			{
				if (ignoreSet.contains(ignoreSet))
				{
					continue;
				}
				if (arr[i][j] == 1)
				{
					ignore = true;
				} else
				{
					temp.add(i);
				}
			}
			if (ignore)
			{
				ignoreSet.addAll(temp);
			}
		}
		List<Integer> sortedList = new ArrayList<Integer>(ignoreSet);
		Collections.sort(sortedList);
		int index = missingIndex(sortedList, 0, sortedList.size());
		for (int i = 0; i < arr[0].length; i++)
		{
			System.out.print(arr[index][i] + " ");
		}
	}

	public static int missingIndex(List<Integer> lst, int start, int end)
	{
		if (end - start == 1)
		{
			return start + 1;
		}
		int mid = (start + end) / 2;

		if (lst.get(mid) > mid)
		{
			return missingIndex(lst, 0, mid);
		} else
		{
			return missingIndex(lst, mid, end);
		}
	}

}
