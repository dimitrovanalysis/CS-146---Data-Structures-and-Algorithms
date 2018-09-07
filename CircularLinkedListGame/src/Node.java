

public class Node {
		public int data;
		public Node link;

		//constructor
		public Node()
		{
			link = null;
			data = 0;
		}
		
		//overloaded constructor
		public Node(int d, Node n) {
			data = d;
			link = n;
		}
		
		//linking function - set link to next node
		public void setLink(Node n) {
			link = n;
		}
		
		//linking function - set data to next node
		public void setData(int d) {
			data = d;
		}
		
		//return function to get link to next node
		public Node getLink() {
			return link;	
		}
		//return function to get dataa from current node
		public int getData() {
			return data;
		}
		
	}