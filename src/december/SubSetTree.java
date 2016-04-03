package december;

import tree.Node;

public class SubSetTree
{

	public static void main(String[] args)
	{

	}

	public boolean checkSubTree(Node root1, Node root2)
	{
		if (root1 == null)
		{
			return false;
		} else if (root2 == null)
		{
			return true;
		} else if (root1.value == root2.value)
		{
			return checkTree(root1.left, root2.left) && checkTree(root1.right, root2.right);
		} else
		{
			return checkTree(root1.left, root2) || checkTree(root1.right, root2);
		}
	}

	public boolean checkTree(Node root1, Node root2)
	{
		if (root1 == null)
		{
			return false;
		} else if (root2 == null)
		{
			return true;
		} else if (root1.value == root2.value)
		{
			return checkTree(root1.left, root2.left) && checkTree(root1.right, root2.right);
		} else
			return false;
	}
}
