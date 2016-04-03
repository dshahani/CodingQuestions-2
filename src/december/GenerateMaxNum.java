package december;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GenerateMaxNum
{

	public static void main(String[] args)
	{
		int[] input = { 11, 10, 990, 870, 32, 94, 210 };
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < input.length; i++)
		{
			int temp = input[i];
			int pre = 0;
			while (temp > 0)
			{
				pre = temp;
				temp = temp / 10;
			}
			if (map.containsKey(pre))
			{
				map.get(pre).add(input[i]);
			} else
			{
				ArrayList<Integer> lst = new ArrayList<Integer>();
				lst.add(input[i]);
				map.put(pre, lst);
			}
		}

		ArrayList<Integer> lstSrt = null;
		for (int j = 9; j >= 0; j--)
		{
			if (map.containsKey(j))
			{
				lstSrt = map.get(j);
				Collections.sort(lstSrt, Collections.reverseOrder());
				Iterator<Integer> it = lstSrt.iterator();
				while (it.hasNext())
				{
					System.out.print(it.next() + "\t");
				}
			}
		}
	}

}
