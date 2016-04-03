package december;

import tree.Node;

public class LargestPathLeaf
{
	public static void main(String[] arg)
	{

		Node root = new Node(10);
		Node a = new Node(8);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(5);
		Node e = new Node(2);
		// TreeNode f = new TreeNode(3);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		// b.right = f;
		System.out.println(getDiameter(root));

	}

	public static int getDiameter(Node root)
	{
		if (root == null)
		{
			return 0;
		}

		int lheight = getHeight(root.left);
		int rheight = getHeight(root.right);

		int ldiameter = getDiameter(root.left);
		int rdiameter = getDiameter(root.right);

		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}

	public static int getHeight(Node root)
	{
		if (root == null)
		{
			return 0;
		}

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

}
