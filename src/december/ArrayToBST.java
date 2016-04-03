package december;

import tree.Node;

public class ArrayToBST
{

	public static void main(String[] args)
	{
		int[] in = { 45, 16, 22, 51, 18, 72, 33, 64, 40 };

		Node root;
		root = new Node(in[0]);
		for (int i = 0; i < in.length; i++)
		{
			createBst(in[i], root);
		}
		inorderTree(root);
	}

	public static void inorderTree(Node root)
	{
		if (root == null)
		{
			return;
		}
		inorderTree(root.left);
		System.out.print(root.value + "->");
		inorderTree(root.right);
	}

	public static Node createBst(int i, Node root)
	{
		if (root == null)
		{
			return (new Node(i));
		}

		if (root.value <= i)
		{
			root.right = createBst(i, root.right);
		} else
		{
			root.left = createBst(i, root.left);
		}
		return root;
	}
}
