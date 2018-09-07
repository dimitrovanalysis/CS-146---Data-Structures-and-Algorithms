import static org.junit.Assert.*;

import org.junit.Test;

// tester class for our CircularLinkedList while implementing the kingsGame

public class CircularLinkedListTest extends CircularLinkedList{

// standard constructor/instance var	
	CircularLinkedList prisoners;
	
	public CircularLinkedListTest() {
		prisoners = new CircularLinkedList();
	}
	

	//loads first prisoner first, then last prisoner, then fills 
	//in the rest of the list with the missing prisoners
	
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
	//test function to check if array is 0 before any calls,
	// and !0 after prisonerLoad
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
	
	//kingsGame that uses a simple algorithm taking advantage
	//of the modulo function. This pairs well with the CircularlyLinkedList
	//have to add special case of when step == size (delete once more)
	public void playKingsGame(int size, int step){
		int origSize = size;
		int origStep = step;
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
	
	//First test, testing 6 prisoners with a step of 2
	@Test
	public void playKingsGameTest1() {
		assertTrue(isEmpty());
		playKingsGame(6,2);
		prisoners.display();
		System.out.println("Expected: 1-->1");
		
	}
	
	//second test, testing 1 prisoner with a step of 9
	@Test
	public void playKingsGameTest2() {
		assertTrue(isEmpty());
		playKingsGame(1,9);
		prisoners.display();
		System.out.println("Expected: 1-->1");
		
	}
	
	//special case of when step == size from the beginning
	//does not pass this test
	@Test
	public void playKingsGameTest3() {
		assertTrue(isEmpty());
		playKingsGame(7,7);
		prisoners.display();
		System.out.println("Expected: 4-->4");
	}
	
	//4th test, size = 2, step = 8;
	@Test
	public void playKingsGameTest4() {
		assertTrue(isEmpty());
		playKingsGame(2,8);
		prisoners.display();
		System.out.println("Expected: 2-->2");
	}

	//5th test, size = 5, step = 1
	@Test
	public void playKingsGameTest5() {
		assertTrue(isEmpty());
		playKingsGame(5,1);
		prisoners.display();
		System.out.println("Expected: 3-->3");
		
	}
}
