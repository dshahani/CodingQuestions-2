package december;

import linkedlist.Link;

public class ReverseKNodes
{

	public static void main(String[] args)
	{
		Link head = new Link(5);
		Link node = new Link(4);
		head.nextLink = node;
		Link node1 = new Link(3);
		node.nextLink = node1;
		Link node2 = new Link(2);
		node1.nextLink = node2;
		Link node3 = new Link(1);
		node2.nextLink = node3;
		// node3.nextLink = null;

		Link node4 = new Link(6);
		node3.nextLink = node4;
		Link node5 = new Link(8);
		node4.nextLink = node5;
		Link node6 = new Link(2);
		node5.nextLink = node6;
		Link node7 = new Link(10);
		node6.nextLink = node7;
		Link node8 = new Link(21);
		node7.nextLink = node8;
		Link node9 = new Link(31);
		node8.nextLink = node9;
		node9.nextLink = null;

		printList(head);
		System.out.println("");
		printList(reverseKRec(head, 2, true));
		/*
		 * System.out.println(""); printList(reverseKNode(head, 2));
		 * System.out.println(""); printList(reverseKRec(head, 2, true));
		 */

	}

	public static Link reverseKNode(Link head, int k)
	{
		Link pre, current, next;
		int i = 1;

		current = head;
		pre = null;
		boolean forward = true, first = true;
		Link dummyHead = null;
		while (current != null)
		{
			if (dummyHead == null)
			{
				dummyHead = head;
			}
			next = current.nextLink;
			if (forward)
			{
				current.nextLink = pre;
				pre = current;
			}
			if (i == k)
			{

				if (first)
				{
					dummyHead.nextLink = next;
					head = pre;
					first = false;
				} else
				{
					dummyHead.nextLink = current;
					while (dummyHead.nextLink != null)
					{
						dummyHead = dummyHead.nextLink;

					}
					dummyHead.nextLink = next;
				}
				pre = null;
				forward = false;
			} else if (i == 0)
			{
				dummyHead = current;
				forward = true;
			}
			current = next;
			if (forward)
			{
				i++;
			} else
			{
				i--;
			}

		}

		return head;

	}

	public static Link reverseList(Link head)
	{

		Link pre, current, next;

		current = head;
		pre = null;

		while (current != null)
		{
			next = current.nextLink;
			current.nextLink = pre;
			pre = current;
			current = next;
		}
		return pre;

	}

	public static void printList(Link head)
	{
		while (head != null)
		{
			System.out.print(head.data1 + " -> ");
			head = head.nextLink;
		}
	}

	public static Link reverseKRec(Link node, int k, boolean forward)
	{
		if (node == null)
			return null;

		int count = 1;
		Link prev = null;
		Link current = node;
		Link next;

		/*
		 * The loop serves two purposes 1) If b is true, then it reverses the k
		 * nodes 2) If b is false, then it moves the current pointer
		 */
		while (current != null && count <= k)
		{
			next = current.nextLink;

			/* Reverse the nodes only if b is true */
			if (forward)
				current.nextLink = prev;

			prev = current;
			current = next;
			count++;
		}

		/*
		 * 3) If b is true, then node is the kth node. So attach rest of the
		 * list after node. 4) After attaching, return the new head
		 */
		if (forward)
		{
			node.nextLink = reverseKRec(current, k, !forward);
			return prev;
		}

		/*
		 * If b is not true, then attach rest of the list after prev. So attach
		 * rest of the list after prev
		 */
		else
		{
			prev.nextLink = reverseKRec(current, k, !forward);
			return node;
		}
	}

}
