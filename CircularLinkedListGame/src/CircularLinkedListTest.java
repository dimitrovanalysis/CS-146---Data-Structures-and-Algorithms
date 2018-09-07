import static org.junit.Assert.*;

import org.junit.Test;

public class CircularLinkedListTest extends CircularLinkedList{

	
	CircularLinkedList prisoners;
	
	public CircularLinkedListTest() {
		prisoners = new CircularLinkedList();
	}
	

	
	
	public void loadPrisoners(int numPrisoners) {
		boolean firstTime = true, secondTime = true;
		
		for(int i = -1; i<= numPrisoners-1; i++)
		{
			if (firstTime) {
				prisoners.insertAtStart(1);
				firstTime=false;
			
			}
			
			else if(secondTime) {
				prisoners.insertAtEnd(numPrisoners);
				secondTime = false;
			}
			else {
				prisoners.insertHere(i, i);
				
			}
		}
		
		
	}
	
	@Test
	public void loadPrisonersTest() {
		assertTrue(isEmpty());
		assertEquals(prisoners.size, 0);
		loadPrisoners(10);
		assertEquals(prisoners.size, 11);
		System.out.print("loadPrisonersTest: ");
		prisoners.display();
		assertFalse(prisoners.isEmpty());

	}
	
	public void playKingsGame(int size, int step){
		int origSize = size;
		loadPrisoners(size);
		int k = step;
		
		while(origSize>0)
		{
			
			if (k > size) {
			k = k % size;
			prisoners.deleteHere(k+1);
			}
			else {
				prisoners.deleteHere(k+1);
			}
			
			k = step + k;
			origSize--;
			size--;
		}
		
	}
	
	@Test
	public void playKingsGameTest1() {
		assertTrue(isEmpty());
		playKingsGame(6,2);
		prisoners.display();
		
	}
	
	@Test
	public void playKingsGameTest2() {
		assertTrue(isEmpty());
		playKingsGame(1,9);
		prisoners.display();
		
	}
	
	@Test
	public void playKingsGameTest3() {
		assertTrue(isEmpty());
		playKingsGame(7,7);
		prisoners.display();
		
	}
	
	@Test
	public void playKingsGameTest4() {
		assertTrue(isEmpty());
		playKingsGame(2,8);
		prisoners.display();
		
	}

	
	@Test
	public void playKingsGameTest5() {
		assertTrue(isEmpty());
		playKingsGame(5,1);
		prisoners.display();
		
	}
}
