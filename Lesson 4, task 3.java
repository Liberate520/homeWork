public class GFG
{	
static int sum=0;
	
static class Node
{
	int data;
	Node next;
}

static Node push( Node head_ref, int new_data)
{
	Node new_node = new Node();

	new_node.data = new_data;

	new_node.next = (head_ref);

	(head_ref) = new_node;
	return head_ref;
}

static void sumOfNodes( Node head)
{

	if (head == null)
		return;


	sumOfNodes(head.next);

	sum = sum + head.data;
}

static int sumOfNodesUtil( Node head)
{

	sum = 0;

	sumOfNodes(head);

	return sum;
}

public static void main(String args[])
{
	Node head = null;


	head = push(head, 33);
	head = push(head, 6);
	head = push(head, 9);
	head = push(head, 4);
	head = push(head, 27);

	System.out.println( "Sum of nodes = "
		+ sumOfNodesUtil(head));
}
}

