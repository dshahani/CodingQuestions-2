package december;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import tree.Node;

public class BSTSequence
{

	public static void main(String[] args)
	{
		Node root = new Node(2);
		Node a = new Node(1);
		Node b = new Node(3);
		Node c = new Node(4);
		Node d = new Node(5);
		Node e = new Node(6);
		root.left = a;
		root.right = b;
		// a.left = c;
		// a.right = d;
		// b.right = e;
		// b.left = d;

		ArrayList<LinkedList<Integer>> lst = getAllSequence(root);

		for (LinkedList<Integer> ls : lst)
		{
			Iterator<Integer> it = ls.iterator();
			while (it.hasNext())
			{
				System.out.print(it.next() + "->");
			}
			System.out.println("");
		}
	}

	public static ArrayList<LinkedList<Integer>> getAllSequence(Node root)
	{
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

		if (root == null)
		{
			result.add(new LinkedList<Integer>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(root.value);

		ArrayList<LinkedList<Integer>> leftSeq = getAllSequence(root.left);
		ArrayList<LinkedList<Integer>> rightSeq = getAllSequence(root.right);

		for (LinkedList<Integer> left : leftSeq)
		{
			for (LinkedList<Integer> right : rightSeq)
			{
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveAll(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}

		return result;
	}

	public static void weaveAll(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix)
	{
		if (first.isEmpty() || second.isEmpty())
		{
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveAll(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);

		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveAll(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);

	}

}
