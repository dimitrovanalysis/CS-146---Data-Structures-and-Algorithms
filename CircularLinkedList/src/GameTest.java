import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest{
	
	//check if linked list is empty using assertTrue
	@Test
	public void loadPrisonerTest1() {

	Game prisoners = new Game();
	
	
	String actualResult = prisoners.loadPrisoners(0);
	//didnt use asserttrue as it wouldnt work for prisoners
	//assert equals performs same function
	
	assertEquals("", actualResult); //empty string checks out with 0 prisoners

	}
// loads 10 prisoners and checks to see if they actually appear
		@Test
		public void loadPrisonerTest2() {

		Game prisoners = new Game();

		String actualResult = prisoners.loadPrisoners(10);

		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ]", actualResult);

		
		}



		@Test
		public void freePrisonerTest1() {
		Game prisoners = new Game();
		
		int size = 6; //define size here
		
		prisoners.loadPrisoners(size);
		String actualResult = prisoners.showPrisoners();
		System.out.println(actualResult);
		
		int step = 2; //define step here
		 
		System.out.print("First Test:");
		while(prisoners.showPrisoners() != "" && size >= 1)
		{
			prisoners.freePrisoners(step);
			System.out.print(prisoners.showPrisoners());
			
			size--;
		}
		
		
		
	}
		
		
		@Test
		public void freePrisonerTest2() {
		Game prisoners = new Game();
		
		int size = 1; //define size here
		
		prisoners.loadPrisoners(size);
		String actualResult = prisoners.showPrisoners();
		System.out.println(actualResult);
		
		int step = 9; //define step here
		 
		System.out.print("Second Test:");
		while(prisoners.showPrisoners() != "" && size > 0)
		{
			prisoners.freePrisoners(step);
			System.out.print(prisoners.showPrisoners());
			
			size--;
		}
		
		
		
		}
		
		
		@Test
		public void freePrisonerTest3() {
		Game prisoners = new Game();
		
		int size = 7; //define size here
		
		prisoners.loadPrisoners(size);
		String actualResult = prisoners.showPrisoners();
		System.out.println(actualResult);
		
		int step = 7; //define step here
		 
		System.out.print("Third Test:");
		while(prisoners.showPrisoners() != "" && size >= 1)
		{
			prisoners.freePrisoners(step);
			
			System.out.print(prisoners.showPrisoners());
			
			size--;
		}
		
		
		
		}
		
		@Test
		public void freePrisonerTest4() {
		Game prisoners = new Game();
		
		int size = 2; //define size here
		
		prisoners.loadPrisoners(size);
		String actualResult = prisoners.showPrisoners();
		System.out.println(actualResult);
		
		int step = 8; //define step here
		 
		System.out.print("Fourth Test:");
		while(prisoners.showPrisoners() != "" && size >= 1)
		{
			prisoners.freePrisoners(step);
			
			System.out.print(prisoners.showPrisoners());
			
			size--;
		}
		
		
		
		}
		
		@Test
		public void freePrisonerTest5() {
		Game prisoners = new Game();
		
		int size = 5; //define size here
		
		prisoners.loadPrisoners(size);
		String actualResult = prisoners.showPrisoners();
		System.out.println(actualResult);
		
		int step = 1; //define step here
		 
		System.out.print("Fifth Test:");
		while(prisoners.showPrisoners() != "" && size >= 1)
		{
			prisoners.freePrisoners(step);
			
			System.out.print(prisoners.showPrisoners());
			
			size--;
		}
		
		
		
		}
		
}