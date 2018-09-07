import static org.junit.Assert.*;

import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.Test;

public class LinkedListGameTest{
	
	
	LinkedList<Integer> linkedList;
	
	public LinkedListGameTest()
	{
		linkedList = new LinkedList<Integer>();
		
	}
	
@Test
public void KingsGame() {
	
	//size = 6 = list is from 1-6
	int size = 6;
	int step = 2;
	int initializeNum = 1;
	int next;
	int k = step;
	int iterate = 0;
	
	assertTrue(linkedList.isEmpty());
	assertTrue(size>0); //size is the length
	
	//create linked list and insert 1-size for every node
	for ( int i = 0; i<= size-1; ++i)
	{
		linkedList.add(initializeNum);
		initializeNum++;
	}

	
	assertFalse(linkedList.isEmpty());

	//figure out which node to pick in order to be the winner
	while(linkedList.size()>1) //makes sure we exit before we delete the last node
	{
		for (int i = 0; i<=linkedList.size()-1; i++) {
		System.out.print(linkedList.get(i));}
		
		next = step % size + 1; 
		linkedList.remove(next);
		step = step +  k + 1;
		size --;

	}

	assertFalse(linkedList.isEmpty());
	assertEquals(1, linkedList.size()); // checks if only 

	System.out.println(linkedList.get(0));
}
	
	
	
}
