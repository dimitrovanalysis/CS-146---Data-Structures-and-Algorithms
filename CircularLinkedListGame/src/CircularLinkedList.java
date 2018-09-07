
public class CircularLinkedList extends Node
{
	
	public Node start;
	public int size;
	public Node end ;
	

	public CircularLinkedList() {
			start = null;
			size = 0;
			end = null;
	}
	
	public int getCount() {
		return size; //count of nodes
	}

	public boolean isEmpty() {
		return (start == null);
	}
	
	public void insertAtStart(int prisonerNum)
	{
		Node nodePointer = new Node(prisonerNum, null);
		nodePointer.setLink(start);

		start = nodePointer;
		nodePointer.setLink(start);
		end = start;
		
		size++;
		
	}
	
    public void insertAtEnd(int val)
    {
        Node nodePointer = new Node(val,null);  
        
        nodePointer.setLink(start);
        
        if(start == null)
        {            
        
        	
        	start = nodePointer;
            nodePointer.setLink(start);
            end = start;
            
        }
        
        else
        {
        	
            end.setLink(nodePointer);
            end = nodePointer;            
        }
        
        
        size++;
    }

	public void insertHere(int prisonerNum, int prisonerPos)
	{
		Node nodePointer = new Node(prisonerNum, null);
		Node startPointer = start;

		prisonerPos = prisonerPos - 1;
		for(int i = 1; i < size -1; i++)
		{

			if (i == prisonerPos)
			{

				Node temp = startPointer.getLink();
				startPointer.setLink(nodePointer);
				nodePointer.setLink(temp);
				break;
			}
			
			startPointer = startPointer.getLink();

		}

		size++;
		
	}
	
	public void deleteHere(int prisonerPos)
	{
		if (size == 1 && prisonerPos == 1)
		{
			start = null;
			end = null;
			size = 0;
			return;
			
		}
		
		if(prisonerPos == 1)
		{
			start = start.getLink();
			end.setLink(start);
			size--;
			return;
			
		}
		
		if (prisonerPos == size)
		{
			Node tempStart1 = start;
			Node tempStart2 = start;
			
			while (tempStart1!=end)
			{
				tempStart2 = tempStart1;
				tempStart1 = tempStart2.getLink();
			}
			
			end = tempStart2;
			end.setLink(start);
			size--;
			return;
		}
		
		Node nodePointer = start;
		prisonerPos = prisonerPos -1;
		
		for(int i = 1; i < size-1; i++)
		{
			if (i == prisonerPos)
			{
				Node tempNode = nodePointer.getLink(); 
				tempNode = tempNode.getLink();
				nodePointer.setLink(tempNode);
				break;	
			}
			nodePointer = nodePointer.getLink();
		}
		
		size--;
	}
	
	public void display() {
		System.out.print("Line of prisoners: ");
		Node nodePointer = start;
		
		if(start.getLink() == start)
		{
			System.out.print(start.getData() + "-->" + nodePointer.getData() + "\n");
			return;
		}

		System.out.print(start.getData() + "-->");
		nodePointer = start.getLink();
		
		while(nodePointer.getLink() != start)
		{
			System.out.print(nodePointer.getData() + "-->");
			nodePointer = nodePointer.getLink();
		}
		System.out.print(nodePointer.getData() + "-->");
		nodePointer = nodePointer.getLink();
		System.out.print(nodePointer.getData() + "\n");
	}
}