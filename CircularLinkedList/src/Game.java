//game class that uses the circularLinkedList 

public class Game {

	private CircularLinkedList prisoners = new CircularLinkedList();

	
	//loads the prisoners into the array. returns the displayed array
	public String loadPrisoners(int numberOfPrisoners) {
		int count = 1;

		while (count <= numberOfPrisoners) {
			if (prisoners.isEmpty()) {
				prisoners.addStart(count++);
			}

			else {
				prisoners.add(count++);
			}

		}
		return prisoners.displayList();
	}


	public Integer freePrisoners(int freePosition) {

			//deletes at the modulo of the given amount to help with circularness
		return prisoners.deleteAt(freePosition%prisoners.getCount()+1);
		
	}



	public String showPrisoners() {

		return prisoners.displayList();

	}

}