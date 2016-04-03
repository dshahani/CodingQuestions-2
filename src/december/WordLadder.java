package december;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder
{
	public static void main(String[] args)
	{
		String start = "cat", end = "bat";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");// dict.add("hot");
		dict.add("bat");// dict.add("dot");
		dict.add("bet");// dict.add("dog");
		dict.add("bot");// dict.add("lot");
		dict.add("bog");// dict.add("log");
		dict.add("dog");

		Map<String, Word> crossed = new HashMap<String, Word>();
		Map<String, Word> crossedB = new HashMap<String, Word>();

		Queue<Word> nq = new LinkedList<Word>();
		Queue<Word> rq = new LinkedList<Word>();

		nq.add(new Word(start, 1));
		rq.add(new Word(end, 1));

		Word top, bottom;
		boolean found = false;
		while (!nq.isEmpty() && !rq.isEmpty())
		{
			top = nq.remove();
			bottom = rq.remove();

			char[] wordArr = top.word.toCharArray();
			char temp;
			for (int i = 0; i < wordArr.length; i++)
			{
				temp = wordArr[i];
				for (char c = 'a'; c <= 'z'; c++)
				{
					if (temp != c)
					{
						wordArr[i] = c;
						if (dict.contains(String.valueOf(wordArr)))
						{
							if (String.valueOf(wordArr).equals(end))
							{
								System.out.println("total distance " + top.level);
								found = true;
								break;
							}
							if (crossedB.containsKey(String.valueOf(wordArr)))
							{
								int cost = crossedB.get(String.valueOf(wordArr)).level + top.level;
								System.out.println("total distance " + cost);
								found = true;
								break;
							} else
							{
								nq.add(new Word(String.valueOf(wordArr), top.level + 1));
								crossed.put(String.valueOf(wordArr), new Word(String.valueOf(wordArr), top.level + 1));
							}

						}
					}
				}
				wordArr[i] = temp;
				if (found)
				{
					break;
				}
			}

			if (found)
			{
				break;
			}

			wordArr = bottom.word.toCharArray();
			for (int i = 0; i < wordArr.length; i++)
			{
				temp = wordArr[i];
				for (char c = 'a'; c <= 'z'; c++)
				{
					if (temp != c)
					{
						wordArr[i] = c;
						if (dict.contains(String.valueOf(wordArr)))
						{
							if (crossed.containsKey(String.valueOf(wordArr)))
							{
								int cost = crossed.get(String.valueOf(wordArr)).level + bottom.level;
								System.out.println("total distance " + cost);
								found = true;
								break;
							} else
							{
								rq.add(new Word(String.valueOf(wordArr), bottom.level + 1));
								crossedB.put(String.valueOf(wordArr),
										new Word(String.valueOf(wordArr), bottom.level + 1));
							}
						}
					}
				}
				wordArr[i] = temp;
				if (found)
				{
					break;
				}
			}
			if (found)
			{
				break;
			}
		}
	}
}
