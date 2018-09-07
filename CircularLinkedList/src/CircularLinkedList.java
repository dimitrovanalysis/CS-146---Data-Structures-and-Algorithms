
// circular linked list that implements connecting the head to the tail
//all methods standard linked list methods

public class CircularLinkedList {
	private Node start;
	private int count;

	public void add(int x) {
		count++;

		Node temp = new Node(x);

		if (start == null) {
			start = temp;
		}

		else {

			Node tp = start;

			while (tp.link != start) 
			{
				tp = tp.link;
			}
			tp.link = temp;
		}
		
		temp.link = start;
	}


	public void addStart(int x) {
		count++;

		Node temp = new Node(x);

		if (start == null) 
			temp.link = temp;

		else {
			Node tp = start;
			
			while (tp.link != start) {
				tp = tp.link;
			}
			
			tp.link = temp;
			temp.link = start;
		}

		start = temp;
	}

	public void addAt(int pos, int x) {

		Node temp, tp;
		temp = new Node(x);
		tp = start;

		for (int i = 0; i < pos; i++) {
			if (tp.link == start)
				break;
			tp = tp.link;
		}

		temp.link = tp.link;
		tp.link = temp;
		count++;

	}

	
// displaying list of prisoners w/ brackets 
	public String displayList() {

		StringBuilder sb = new StringBuilder();

		if (!isEmpty()) {

			Node temp = start;
			sb.append("[");
			sb.append(temp.data).append(", ");

			while (temp.link != start) {
				temp = temp.link;
				sb.append(temp.data).append(", ");
			}
			sb.append("]");
		}
		return sb.toString();

	}

//deletes at a certain position, then appends
	public Integer deleteAt(int position) {

		Node current = start;
		Node previous = start;
		Integer data = null;

		for (int i = 0; i < position; i++) {
			if (current.link == start)
				break;

			previous = current;
			current = current.link;
		}

		data = current.data;
		
		if (position == 0) 
			deleteFirst();
		

		else {
			previous.link = current.link;
		}

		count--;

		return data;

	}

//special case of deleting the first node
	public Integer deleteFirst() {

		Node temp = start;
		Integer data = temp.data;
		
		while (temp.link != start) {
			temp = temp.link;
		}

		temp.link = start.link;
		start = start.link;
		count--;

		return data;

	}

//helpers
	public int getCount() {
		return count;
	}

	public boolean isEmpty() {
		return start == null;
	}

	private static class Node {
		int data;
		Node link;

		public Node(int data) {
			this.data = data;
		}



	}

}