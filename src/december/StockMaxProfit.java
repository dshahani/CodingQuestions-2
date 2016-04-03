package december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockMaxProfit
{

	public static void main(String[] args)
	{
		Integer[] in = { 100, 180, 260, 40, 4000000, 535, 695, 1000, 100 };
		List<Integer> inLst = Arrays.asList(in);
		List<Integer> res = maxProfit(inLst);
		System.out.println(res.get(0));
		System.out.println(res.get(1));

		System.out.println(maxProfitF1(inLst));

		int[] opt = new int[in.length];
		opt[in.length - 1] = 0;
		int maxPrice = in[in.length - 1];
		for (int i = in.length - 2; i >= 0; i--)
		{
			if (maxPrice < in[i])
			{
				maxPrice = in[i];
			}
			if (maxPrice - in[i] > opt[i + 1])
			{
				opt[i] = maxPrice - in[i];
			} else
			{
				opt[i] = opt[i + 1];
			}

		}

		for (int i = 0; i < opt.length; i++)
		{
			System.out.print(opt[i] + "\t");
		}
		System.out.println("");
		System.out.println(opt[0]);

	}

	// Follow up:
	// Buy Sell(multiple) but buy one sell one, no holding more than one

	static int maxProfitF1(List<Integer> prices)
	{

		int n = prices.size();
		int buyId;
		int sellId;
		if (n < 2)
			return 0;

		int min = prices.get(0);
		int max_profit = 0;
		buyId = 0;
		for (int i = 1; i < n; i++)
		{
			if (prices.get(i) - prices.get(i - 1) < 0)
			{
				max_profit += prices.get(i - 1) - min;
				sellId = i - 1;
				System.out.println("Buy: " + buyId);
				System.out.println("Sell: " + sellId);
				min = prices.get(i);
				buyId = i;
			}
		}

		if (buyId < n - 1)
		{
			max_profit += (prices.get(n - 1) - prices.get(buyId));
			System.out.println("Buy: " + buyId);
			sellId = n - 1;
			System.out.println("Sell: " + sellId);
		}

		return max_profit;

	}

	static List<Integer> maxProfit(List<Integer> prices)
	{

		int n = prices.size();
		List<Integer> result = new ArrayList<Integer>();
		if (n < 2)
		{
			return result;
		}

		int buyId = 0;
		int sellId = 1;
		int prevId = 0;
		int min = prices.get(0);
		int maxDiff = prices.get(1) - prices.get(0);

		for (int i = 1; i < n; i++)
		{
			if (maxDiff < prices.get(i) - min)
			{
				maxDiff = prices.get(i) - min;
				sellId = i;
				buyId = prevId;
			}

			if (min > prices.get(i))
			{
				min = prices.get(i);
				prevId = i;

			}
		}
		result.add(buyId);
		result.add(sellId);
		return result;

	}

}
