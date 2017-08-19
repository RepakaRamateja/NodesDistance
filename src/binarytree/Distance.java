/*
 * reference  http://algorithms.tutorialhorizon.com/find-the-distance-between-two-nodes-of-a-binary-tree/
 */

package binarytree;

/*  this program is to find the distance  between nodes in the binary tree
 * 
 * using the below formula to calculate the distance between two nodes X and y
 * 
 * Distance(X, Y) = Distance(root, X) +Distance(root, Y) — 2*(Distance(root to LCA(X,Y)
 * 
 *   LCA ----> LEAST COMMON ANCESTOR
 * 
 */


/*
 * Node class 
 */
class Node
{
	Node left;     //left child
	Node right;    //right child
	int data;      //value of the node
	
	/*constructor to initialize data
	 */
	Node(int idata)
	{
		data=idata;
		left=null;
		right=null;
	}		
}


public class Distance
{
	
	
	 // method to calculate the distance between two nodes values(value1,value2)
	
	public int finddistance(Node root,int value1,int value2)
	{
		
		int x = Pathlength(root, value1) - 1;
		
		int y= Pathlength(root, value2) - 1;
		
		Node lca=findLca(root, value1, value2);
		
		int val=lca.data;
		
		int lcadistance=Pathlength(root,val) - 1;
		
		int distance=0;
		
		distance= x + y - 2 * lcadistance; 

		return distance;
	}
	
	
	//function to find the length of the path from given element to root
	
	public int Pathlength(Node root, int n1)
	{
		
		if(root!=null)
		{
		    int x=0;
		    
		    if(root.data==n1 || (x = Pathlength(root.left,n1)) > 0 || (x=Pathlength(root.right,n1)) > 0)
		    {
		    	
		    	return x+1;
		    	
		    }
		    
		   return 0;
		}
		
		return 0;
		
	}
	
	//function to find the least common ancestor 
	
	public Node findLca(Node root,int val1,int val2)
	{
		
		if(root==null || root.data==val1 || root.data==val2)
		{
			return root;
		}
		
		Node left=findLca(root.left,val1,val2);
		
		Node right=findLca(root.right,val1,val2);
		
		if(left!=null && right!=null)
		{
			return root;
		}
		
	     return  left != null ? left :right;   
	}
	
	//driver code
	
	public static void main(String args[])
	{
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		
		Distance dis=new Distance();
		
		System.out.println("the distance between nodes is" + dis.finddistance(root,45,20));
				
		
	}
	

}
