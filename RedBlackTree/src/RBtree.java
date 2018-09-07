import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * RB tree class with local visitor and node classes
 * @author Konstantin
 *
 */
public class RBtree {
	
	//initializing the tree
	public RBNode initial = new RBNode("");
	public RBNode root = initial;
	
	//constructor setting everything to initial value
	public RBtree()
	{
		root.left = initial;
		root.right = initial;
        root.parent = initial;

	}
	

	
	//function used for tester 
	public RBNode findSibling(String currentString)
	{
		RBNode parent = lookUp(currentString).parent;
		if (parent!=null)
			{
				if(parent.key.compareTo(currentString)<0)
					return parent.left;
					else if(parent.key.compareTo(currentString)>0)
						return parent.right;
			}
		return null;
	}
	
	
	//transitions from tester to lookupNode function
	public RBNode lookUp(String string)
	{
		return lookUpNode(root,string);	
	}

	//actual look up function
	private RBNode lookUpNode(RBNode currentnode, String string) {

		if(currentnode== initial || string.compareTo(currentnode.key)== 0)
		{
			return currentnode;
		}

		else if(string.compareTo(currentnode.key)<0)
		{
			return lookUpNode(currentnode.left, string);
		}
		
		else if(string.compareTo(currentnode.key)>0)	
		{
			return lookUpNode(currentnode.right, string);
		}
		
		return null;
	}	
	
	
private void rotateLeft(RBNode currentNode)
{
	RBNode rightNode = currentNode.right;
	currentNode.right = rightNode.left;
	
	if(rightNode.left!=initial)
	{
		rightNode.left.parent=currentNode;
	}
	
	rightNode.parent = currentNode.parent;
	
	if(currentNode.parent==initial)
	{
		root = rightNode;
	}
	
	else if(currentNode.parent.left==currentNode)
	{
		currentNode.parent.left = rightNode;
	}
	
	else
		currentNode.parent.right = rightNode;
	rightNode.left = currentNode;
	currentNode.parent = rightNode;	
}


private void rotateRight(RBNode currentNode)
{
	RBNode leftNode = currentNode.left;
	currentNode.left = leftNode.right;
	
	if(leftNode.right!=initial)
	{
		leftNode.right.parent=currentNode;
	}
	
	leftNode.parent = currentNode.parent;
	
	if(currentNode.parent==initial)
	{
		root = leftNode;
	}
	
	else if(currentNode==currentNode.parent.right)
	{
		currentNode.parent.right = leftNode;
	}
	
	else
		currentNode.parent.left = leftNode;
	
	leftNode.right = currentNode;
	currentNode.parent = leftNode;
	
}

//fixtree function calling rotateleft/right function to fix
public void fixTree(RBNode currentNode)
{
	RBNode initialNode = initial;
	
	while (currentNode.parent.color == 0)
	{
		if (currentNode.parent == currentNode.parent.parent.left)
		{
			initialNode = currentNode.parent.parent.right;
			
			if (initialNode.color == 0)
			{
				currentNode.parent.color =1;
				initialNode.color = 1;
				currentNode.parent.parent.color =  0;
				currentNode = currentNode.parent.parent;
			}
			
			else if (currentNode == currentNode.parent.right)
			{
				currentNode = currentNode.parent;
				rotateLeft(currentNode);
			}
			
			else
			{
				currentNode.parent.color = 1;
				currentNode.parent.parent.color =0;
				rotateRight(currentNode.parent.parent);
			}
		}
		else
		{
			initialNode = currentNode.parent.parent.left;
			
			if (initialNode.color == 0){
				currentNode.parent.color = 1;
				initialNode.color = 1;
				currentNode.parent.parent.color = 0;
				currentNode = currentNode.parent.parent;
			}

			else if (currentNode == currentNode.parent.left){
				currentNode = currentNode.parent;
				rotateRight(currentNode);
			}
			
			else
			{
				currentNode.parent.color = 1;
				currentNode.parent.parent.color = 0;
				rotateLeft(currentNode.parent.parent);
			}
		}
	}

	root.color = 1;
}

//insert function that takes string and inserts into node
public void insertInRBTree(String word)
{ 
	RBNode stringNode =new RBNode(word);
	insertGivenNode(stringNode);
}

//insert function that takes node and inserts into tree
//recursive
public void insertGivenNode(RBNode currentNode)
{
	RBNode initialNode = initial;
	RBNode rootNode = root;
	
	while(rootNode!=initial)
	{
		initialNode=rootNode;
		
		if(currentNode.key.compareTo(rootNode.key) < 0)
		{
			rootNode=rootNode.left;
		}
		
		else rootNode=rootNode.right;
	}
	
	currentNode.parent = initialNode;
	
	if(initialNode==initial)
	{
		root = currentNode;
	}
	
	else if (currentNode.key.compareTo(initialNode.key) < 0)
	{
		initialNode.left=currentNode;
	}
	
	else initialNode.right = currentNode;
	
	currentNode.left = initial;
	currentNode.right = initial;
	currentNode.color = 0;
	fixTree(currentNode);
}


public RBNode findGrandparent(String currentString)
{
	RBNode parent = lookUp(currentString).parent;
	return parent.parent;
}

public RBNode findAuntie(String currentString)
{
	RBNode grandparent = findGrandparent(currentString);
	
	if (grandparent!=null)
	{
		if(grandparent.key.compareTo(currentString)<0)
			return grandparent.left;
		
		else if(grandparent.key.compareTo(currentString)>0)
			return grandparent.right;

	}

	return null;

}


//dictionary method
public static void main(String[] args) {
	try {
		
		File file1 = new File("Dictionary.txt");
		FileReader fileReader1 = new FileReader(file1);
		BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
		String newLine;
		RBtree redBlackTree = new RBtree();
		
		double start = System.currentTimeMillis();
		
		while ((newLine = bufferedReader1.readLine()) != null) {
			redBlackTree.insertInRBTree(newLine);
		}
		
		double end = System.currentTimeMillis();
	    System.out.println("\nRuntime for Insertion"+(end-start));   
		fileReader1.close();
		
		//dictionary has been inserted into a redblacktree
		//now for insertion of poem and comparison of poem to given dictionary
		
		File file2 = new File("poem.txt");
		FileReader fileReader2 = new FileReader(file2);
		BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
		
		start = System.currentTimeMillis();
		
		String word;
		while ((word = bufferedReader2.readLine()) != null) {
			
			RBtree.RBNode currentNode = redBlackTree.lookUp(word);
			
			if(currentNode==redBlackTree.initial)
			{
				System.out.println(word + " does not exist in given dictionary");
			}
			else
					System.out.println("found "+currentNode.key+ " with color "+currentNode.color+" with parent " +currentNode.parent.key);
		}
		
		end = System.currentTimeMillis();
	    System.out.println("\n Runtime for Lookup "+(end - start));   
	   
	    fileReader2.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

//VISITOR AND NODE DOWN HERE -------------------

public static interface Visitor
  {
  	/**
     This method is called at each node.
     @param n the visited node
  	 */
  	void visit(RBNode n);
  }


 public void preOrderVisit(Visitor v)
  {
  	preOrderVisit(root, v);
  }


 private void preOrderVisit(RBNode n, Visitor v)
  {
  	if (n == null)
  		{
  		return;
  		}
  	v.visit(n);
  	preOrderVisit(n.left, v);
  	preOrderVisit(n.right, v);
  }

	// need to include node class for function/tester to work---
	
	public class RBNode {

		public String key;
		RBNode left;
		RBNode right;
		RBNode parent;
		int color;
		
		public RBNode(String givenWord)
		{
			color = 1; //initial color for red/black tree node
			left = initial;
			right = initial;
			parent = initial;
			this.key=givenWord;
		}

	}
	//------------------end node class ------------------
	
}