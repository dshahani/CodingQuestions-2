package december;

import java.util.LinkedList;
import java.util.Queue;

import tree.Node;

public class BfsTraversal
{

	public static void main(String[] args)
	{
		Node root = new Node(5);
		Node left = new Node(7);
		Node right = new Node(2);
		root.left = left;
		root.right = right;
		Node l1 = new Node(9);
		Node r1 = new Node(1);
		left.left = l1;
		right.right = r1;

		Queue<Node> qu = new LinkedList<Node>();
		qu.add(root);

		while (!qu.isEmpty())
		{
			Node node = qu.poll();
			System.out.println(node.value);
			if (node.left != null)
			{
				System.out.print(node.left.value + "\t");
				qu.add(node.left);
			} else
			{
				System.out.print("no value" + "\t");
			}

			if (node.right != null)
			{
				System.out.println(node.right.value);
				qu.add(node.right);
			} else
			{
				System.out.println("no value");
			}
		}
	}

}
