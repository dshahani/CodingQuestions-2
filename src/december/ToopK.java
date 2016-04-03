package december;

import java.util.HashMap;
import java.util.Map;

public class ToopK
{

	static int kthlargest(Element arr[], int l, int r, int k)
	{
		if (l >= r)
		{
			return arr[l].value;
		}
		int pos = partition(arr, l, r);
		if (k - 1 == pos)
		{
			return arr[pos].value;
		} else if (k - 1 < pos)
		{
			return kthlargest(arr, l, pos - 1, k);
		} else
		{
			return kthlargest(arr, pos + 1, r, k);
		}
	}

	static int partition(Element arr[], int l, int r)
	{
		Element obj = arr[r], temp;
		int i = l - 1;
		for (int j = l; j < r; j++)
		{
			if (arr[j].freq > obj.freq)
			{
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		temp = arr[r];
		arr[r] = arr[i + 1];
		arr[i + 1] = temp;
		return i + 1;
	}

	public static void main(String[] args)
	{
		// List<Element> mylist=new ArrayList<Element>();
		int item_counter = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int arr[] = { 1, 2, 3, 4, 4, 5, 6, 6, 6, 1, 1, 1 };
		for (int i = 0; i < arr.length; i++)
		{
			if (map.containsKey(arr[i]))
			{
				map.put(arr[i], map.get(arr[i]) + 1);
			} else
			{
				item_counter++;
				map.put(arr[i], 1);
			}
		}
		Element obj[] = new Element[item_counter];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			System.out.println(entry.getKey() + "  " + entry.getValue());
			obj[i] = new Element(entry.getKey(), entry.getValue());
			i++;
		}

		int frequent = kthlargest(obj, 0, item_counter - 1, 1);
		System.out.println(frequent);
	}

}

class Element
{
	int value;
	int freq;

	Element(int k, int v)
	{
		this.value = k;
		this.freq = v;
	}
}
