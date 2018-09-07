import java.util.LinkedList;

public class LinkedListGame{
	
	LinkedList<Integer> linkedList;
	
	public LinkedListGame()
	{
		linkedList = new LinkedList<Integer>();
		
	}
	
	
	
	public void KingsGame(){
		int size = 6;
		int step = 2 ;
		int initializeNum = 1;
		int next;
		int k = step;
		//create linked list and insert 1-size for every node
		for ( int i = 0; i<= size; ++i)
		{
			linkedList.add(initializeNum);
			initializeNum++;
		}
		
		//figure out which node to pick in order to be the winner
		
		while(linkedList.size()!=0 && size>0) //makes sure we exit before we delete the last node
		{
			next = step % size + 1; 
			linkedList.remove(next);
			step = step +  k + 1;
			size --;
		}
	
		System.out.println(linkedList.get(0));
	}
	
	
}