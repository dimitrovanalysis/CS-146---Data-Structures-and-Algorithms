import static org.junit.Assert.*;

import org.junit.Test;


public class RBTTester {

	@Test
	//Test the Red Black Tree
	public void test() {
					RBtree rbt = new RBtree();
        rbt.insertInRBTree("D");
        rbt.insertInRBTree("B");
        rbt.insertInRBTree("A");
        rbt.insertInRBTree("C");
        rbt.insertInRBTree("F");
        rbt.insertInRBTree("E");
        rbt.insertInRBTree("H");
        rbt.insertInRBTree("G");
        rbt.insertInRBTree("I");
        rbt.insertInRBTree("J");
        assertEquals("DBACFEHGIJ", makeString(rbt));
        String str=     
"Color: 1, Key:D Parent: \n" +
"Color: 1, Key:B Parent: D\n"+
"Color: 1, Key:A Parent: B\n"+
"Color: 1, Key:C Parent: B\n"+
"Color: 1, Key:F Parent: D\n"+
"Color: 1, Key:E Parent: F\n"+
"Color: 0, Key:H Parent: F\n"+
"Color: 1, Key:G Parent: H\n"+
"Color: 1, Key:I Parent: H\n"+
"Color: 0, Key:J Parent: I\n";
		assertEquals(str, makeStringDetails(rbt));
            
    }
	
	//add tester for spell checker
	//testing family functionality 
	@Test
	public void TestGPAuntSiblinglookup() {
		RBtree rbt = new RBtree();
        rbt.insertInRBTree("D");
        rbt.insertInRBTree("B");
        rbt.insertInRBTree("A");
        rbt.insertInRBTree("C");
        rbt.insertInRBTree("F");
        rbt.insertInRBTree("E");
        rbt.insertInRBTree("H");
        rbt.insertInRBTree("G");
        rbt.insertInRBTree("I");
        rbt.insertInRBTree("J");
        
        //find aunt test
	    String exampleString = "B";
	    assertEquals(exampleString, rbt.findAuntie("H").key);
	    
		//find grandparent test
		exampleString = "D";
		assertEquals(exampleString, rbt.findGrandparent("H").key);
		
		//find sibling test
		exampleString = "E";
		assertEquals(exampleString, rbt.findSibling("H").key);
		
	    //lookup function test
	    exampleString = "H";
		assertEquals(exampleString, rbt.lookUp("H").key);
		
    }
	

    
    public static String makeString(RBtree t)
    {
       class MyVisitor implements RBtree.Visitor {
          String result = "";
          public void visit(RBtree.RBNode n)
          {
             result = result + n.key; 
          }
       };
       MyVisitor v = new MyVisitor();
       t.preOrderVisit(v);
       return v.result;
    }

    public static String makeStringDetails(RBtree t) {
    	{
    	       class MyVisitor implements RBtree.Visitor {
    	          String result = "";
    	          public void visit(RBtree.RBNode n)
    	          {
    	        	  if(!(n.key).equals(""))
    	        		  result = result +"Color: "+n.color+", Key:"+n.key+" Parent: "+n.parent.key+"\n";
    	          }
    	       };
    	       MyVisitor v = new MyVisitor();
    	       t.preOrderVisit(v);
    	       return v.result;
    	 }
    }
  
    //added listed items to class from template!
    //(visitor interface with both preorder visit overloaded functions)
    
    
    
 }