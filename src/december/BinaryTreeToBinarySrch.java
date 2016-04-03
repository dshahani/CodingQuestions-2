package december;

import java.util.ArrayList;
import java.util.Collections;

import tree.Node;

public class BinaryTreeToBinarySrch
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

		System.out.println(root.left.value);
		ArrayList<Integer> order = new ArrayList<Integer>();
		inOrder(root, order);
		Collections.sort(order);
		Node newNode = creatBSrchTree(order, 0, order.size());
		System.out.println(newNode.left.value);
	}

	public static Node creatBSrchTree(ArrayList<Integer> order, int start, int end)
	{
		if (start >= end)
		{
			return null;
		}
		int mid = (start + end) / 2;
		Node node = new Node(order.get(mid));
		node.left = creatBSrchTree(order, start, mid - 1);
		node.right = creatBSrchTree(order, mid + 1, end);
		return node;
	}

	public static void inOrder(Node root, ArrayList<Integer> order)
	{
		if (root == null)
		{
			return;
		}

		inOrder(root.left, order);
		order.add(root.value);
		inOrder(root.right, order);
	}
}
