/**
 * 
 */

/**
 * @author jack
 *
 */
public class BinaryTree {

	/**
	 * @param args
	 */
	
	private TreeNode root;
	
	
	public BinaryTree()
	{
		root=null;
	}
	
	//get num nodes
	public int countNodes()
	{
		return recCountNodes(root);
	}
	
	//recursive helper counter method
	private int recCountNodes(TreeNode r)
	{
		if(r==null)
			return 0;
		
		return recCountNodes(r.getLeft())+recCountNodes(r.getRight())+1;
	}
	
	//Traversals=prefix-node,left,right postfix-left,right,node infix-right,left,node
	
	//prints out node, then left, then right
	public void prefix()
	{
		recPrefix(root);
	}
	
	private void recPrefix(TreeNode r)
	{
		if(r==null)
			return;
		
		System.out.println(r.getValue());
		recPrefix(r.getLeft());
		recPrefix(r.getRight());
	}
	
	public void infix()
	{
		recInfix(root);
	}
	
	private void recInfix(TreeNode r)
	{
		if(r==null)
			return;
		
		recPrefix(r.getRight());
		recPrefix(r.getLeft());
		System.out.println(r.getValue());
	}
	
	public void postfix()
	{
		recPostfix(root);
	}
	
	private void recPostfix(TreeNode r)
	{
		if(r==null)
			return;
		
		recPrefix(r.getLeft());
		recPrefix(r.getRight());
		System.out.println(r.getValue());
	}
	
	//count number of leaves in Tree
	public int numLeaves()
	{
		return numLeaves(root);
	}
	
	private int numLeaves(TreeNode r)
	{
		if(r==null)
			return 0;
		
		if(r.getLeft()==null&&r.getRight()==null)	//leaf
			return 1;
		
		return numLeaves(r.getLeft())+numLeaves(r.getRight());
	}
	
	public boolean add(Object value)
	{
		add(root,value);
		return true;
	}
	
	private TreeNode add(TreeNode node,Object value)
	{
		if(root==null)
		{
			node=new TreeNode(value);
			root=node;
		}
		
		if (node==null)
		      node=new TreeNode(value);
		
		else
		{
		   int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
		   if (diff < 0)
		     node.setLeft(add(node.getLeft(), value));
		   else // if (diff > 0)
		     node.setRight(add(node.getRight(), value));
		}
		
		return node;
	}
	
	public String toString()
	{
		String str=toString(root);
		if(str.startsWith(" ,"));
		str=str.substring(2);
		str="["+str+"]";
		return str;
	}
	
	public String toString(TreeNode node)
	{
		if(node==null)
			return"";
		else
			return toString(node.getLeft())+", "+node.getValue().toString()+toString(node.getRight());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt=new BinaryTree();
		bt.add("cool");
		bt.add("beans");
		bt.add("thanks");
		bt.add("man");
		System.out.println(bt);	//should be [beans, cool, man, thanks]
		
		
		
		
	}
}