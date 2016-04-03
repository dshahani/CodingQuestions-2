package december;

import java.util.ArrayList;

import linkedlist.Link;

public class LinkListSeq
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
		Link node4 = new Link(6);
		node3.nextLink = node4;
		Link node5 = new Link(8);
		node4.nextLink = node5;
		Link node6 = new Link(2);
		node5.nextLink = node6;
		Link node7 = new Link(5);
		node6.nextLink = node7;
		Link node8 = new Link(21);
		node7.nextLink = node8;
		Link node9 = new Link(31);
		node8.nextLink = node9;
		node9.nextLink = head;

		Link r = head;
		do
		{
			System.out.print(r.data1 + "\t");
			r = r.nextLink;
		} while (r != head);

		ArrayList<Link> res = largestSeqLst(head, 4);

		Link start = res.get(0), end = res.get(1);
		System.out.println("\n------- result -------");
		if (start != null && end != null)
		{
			while (start != end)
			{
				System.out.print(start.data1 + "\t");
				start = start.nextLink;
			}
			System.out.print(end.data1 + "\t");
		}
	}

	public static ArrayList<Link> largestSeqLst(Link head, int target)
	{
		if (head == null)
		{
			return null;
		}

		ArrayList<Link> result = new ArrayList<Link>();
		Link start = null, end = null;
		Link curr = head;
		do
		{
			if (curr.data1 == target && start == null)
			{
				start = curr;
			} else if (curr.data1 == target)
			{
				end = curr;
			}

			curr = curr.nextLink;
		} while (curr != head);

		result.add(start);
		result.add(end);

		return result;

	}

}
