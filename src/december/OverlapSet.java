package december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class OverlapSet
{

	public static void main(String[] args)
	{
		int a = 100, b = 9;
		int olda = 0, oldb = 0;
		while (a > 0)
		{
			olda = a;
			a = a / 10;
		}
		while (b > 0)
		{
			oldb = b;
			b = b / 10;
		}
		System.out.println(olda + " " + oldb);
		/*
		 * Set s1 = new Set(-10, -4); Set s2 = new Set(-3, -1); Set s3 = new
		 * Set(0, 2); Set s4 = new Set(3, 10); Set[] setArr = new Set[4];
		 * setArr[0] = s1; setArr[2] = s2; setArr[1] = s3; setArr[3] = s4; Set n
		 * = new Set(-5, 1);
		 */

		Set s1 = new Set(-10, -1);
		Set s2 = new Set(7, 10);
		Set s3 = new Set(0, 2);
		Set[] setArr = new Set[3];
		setArr[0] = s1;
		setArr[2] = s2;
		setArr[1] = s3;
		Set n = new Set(3, 6);

		Arrays.sort(setArr, new Comparator<Set>()
		{
			@Override
			public int compare(Set arg0, Set arg1)
			{
				return (arg0.x < arg1.x ? -1 : (arg0.x == arg1.x ? 0 : 1));
			}
		});
		ArrayList<Set> out = insert(setArr, n);

		Iterator<Set> it = out.iterator();
		while (it.hasNext())
		{
			Set s = it.next();
			System.out.println(s.x + " " + s.y);
		}
	}

	public static ArrayList<Set> insert(Set[] arr, Set newEle)
	{
		ArrayList<Set> outSet = new ArrayList<Set>();
		boolean merged = false;
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i].x > newEle.x)
			{
				outSet.add(arr[i]);
				continue;
			} else
			{
				int j = i, x, y;
				j++;
				while (j < arr.length && newEle.x < arr[j].y && arr[j].x < newEle.y)
				{
					j++;
				}
				if (--j > i && j < arr.length - 1)
				{
					x = arr[i].x;
					i = j;
					merged = true;
					if (newEle.y > arr[i].y)
					{
						outSet.add(new Set(x, newEle.y));
					} else
					{
						outSet.add(new Set(x, arr[i].y));
					}

				} else
				{
					outSet.add(new Set(arr[i].x, arr[i].y));
				}

			}
		}
		if (!merged)
		{
			outSet.add(new Set(newEle.x, newEle.y));
		}
		return outSet;
	}

}
