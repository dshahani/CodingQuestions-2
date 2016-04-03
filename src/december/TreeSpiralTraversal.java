package december;

import tree.Node;

public class TreeSpiralTraversal
{
	public static void printLevel(Node root, int level, boolean ltr)
	{

		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.value + " ");

		else if (ltr == true)
		{

			printLevel(root.left, level - 1, ltr);
			printLevel(root.right, level - 1, ltr);
		} else
		{
			printLevel(root.right, level - 1, ltr);
			printLevel(root.left, level - 1, ltr);

		}

	}

	public static void inwardSpiral(Node root)
	{

		int h = height(root);

		int firstLevel = 1;
		int lastLevel = h;

		while (firstLevel < lastLevel)
		{

			printLevel(root, firstLevel, true);
			printLevel(root, lastLevel, false);
			firstLevel++;
			lastLevel--;
		}
	}

	public static int height(Node root)
	{
		if (root == null)
		{
			return 0;
		}

		return 1 + Math.max(height(root.left), height(root.right));
	}

}
