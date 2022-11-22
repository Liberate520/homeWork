
import java.util.*;

public class LinkedListTest2 {
	public static void main(String[] args)
	{
	
		LinkedList<Integer> linkedli = new LinkedList<Integer>();

		linkedli.add(new Integer(17));
		linkedli.add(new Integer(21));
		linkedli.add(new Integer(9));
		linkedli.add(new Integer(54));
		linkedli.add(new Integer(5));
		System.out.print("Elements before reversing: " + linkedli);

		linkedli = reverseLinkedList(linkedli);
		System.out.print("\nElements after reversing: " + linkedli);
	}


	public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> llist)
	{
		for (int i = 0; i < llist.size() / 2; i++) {
			Integer temp = llist.get(i);
			llist.set(i, llist.get(llist.size() - i - 1));
			llist.set(llist.size() - i - 1, temp);
		}
        
		return llist;
	}
}
