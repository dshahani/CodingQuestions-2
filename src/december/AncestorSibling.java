package december;

import tree.Node;

public class AncestorSibling
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public static Node getSibling(Node node)
	{
		if (node == null)
		{
			return null;
		}

		Node parent = node.parent;

		if (parent == null)
		{
			return null;
		}

		return (parent.left == node ? parent.right : parent.left);
	}

	public static boolean covers(Node p, Node q)
	{
		if (p == null || q == null)
		{
			return false;
		}

		if (p == q)
		{
			return true;
		}

		return covers(p.left, q) || covers(p.right, q);
	}

	public static Node getAncestor(Node root, Node p, Node q)
	{
		if (!covers(root, p) || !covers(root, q))
		{
			return null;
		} else if (covers(p, q))
		{
			return p;
		} else if (covers(q, p))
		{
			return q;
		}

		Node sibling = getSibling(p);
		Node parent = p.parent;

		while (parent != null)
		{
			if (covers(sibling, q))
			{
				return parent;
			}
			sibling = getSibling(parent);
			parent = parent.parent;
		}

		return parent;
	}

}
