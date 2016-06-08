package tree;

class node{
	node left;
	node right;
	Object data;
	
	node(Object value){
		left=null;
		right=null;
		data=value;
	}
	
	node getLeft(){
		return left;
	}
	
	void setLeft(node value){
		left=value;
	}

	node getRight(){
		return right;
	}
	
	void setRight(node value){
		right=value;
	}
	
	Object getData(){
		return data;
	}
	
	void setData(Object value){
		data=value;
	}
	
}

class BinaryTreeDS{
	node root;
	Object data;
	
	void add(Object data){
		node temp=root;
		node curr=new node(data);
		node prev=temp;
		//System.out.println("Root="+root);
		if ( root == null ){
			root=curr;
		}
		else{
		while(temp!=null){
			prev=temp;
			if ((int)temp.getData() > (int)data){
				temp=temp.getLeft();
			}
			else{
				
				temp=temp.getRight();
			}
		}
		if ((int)prev.getData() > (int)data)
			prev.setLeft(curr);
		else
			prev.setRight(curr);
		}
	}
	
	void inorder(){
		r_inorder(root);
	}
	
	void r_inorder(node p){
		if (p== null)
			return;
		else{
			r_inorder(p.getLeft());
			System.out.println(p.getData());
			r_inorder(p.getRight());
		}
			
	}
	
	void preorder(){
		r_preorder(root);
	}
	
	void r_preorder(node p){
		if (p== null)
			return;
		else{
			System.out.println(p.getData());
			r_preorder(p.getLeft());
			r_preorder(p.getRight());
		}
			
	}

	void postorder(){
		r_postorder(root);
	}
	 
	void r_postorder(node p){
		if (p==null){
			return;
		}
		else{
			r_postorder(p.getLeft());
			r_postorder(p.getRight());
			System.out.println(p.getData());
		}
	}
	
	Object getMax(){
		node temp=root;
		while(temp.getRight()!=null){
			temp=temp.getRight();
		}
		return temp.getData();
	}
	
	Object getMin(){
		node temp=root;
		while(temp.getLeft()!=null){
			temp=temp.getLeft();
		}
		return temp.getData();
	}
	
	int getHeight(){
		return r_getHeight(root);
	}
	
	int r_getHeight(node p){
		if (p==null){
			return 0;
		}
		else{
			int x = r_getHeight(p.getLeft());
			int y = r_getHeight(p.getRight());
			
			if (x>y)
				return x+1;
			else
				return y+1;
		}
	}
	
	int countElements(){
		return r_countElements(root);
	}
	
	int r_countElements(node p){
		
		if (p==null){
			return 0;
		}
		else{
			int x=r_countElements(p.getLeft());
			int y=r_countElements(p.getRight());
			return 1+x+y;
		}
	}
	
	boolean search(Object value){
		
		node temp=root;
		while(temp!=null){
			if ((int)temp.getData()==(int) value)
				return true;
			else if ((int)temp.getData()<(int)value)
				temp=temp.getRight();
			else
				temp=temp.getLeft();
		}
		
		return false;
	}
	
}

public class BinaryTree {
	public static void main (String args[]){
		BinaryTreeDS bt=new BinaryTreeDS();
		bt.add(50);
		bt.add(75);
		bt.add(25);
		bt.add(60);
		bt.add(90);
		bt.add(80);
		System.out.println("Inorder Traversal:");
		bt.inorder();
		System.out.println("Preorder Traversal:");
		bt.preorder();
		System.out.println("Postorder Traversal:");
		bt.postorder();
		System.out.println("Max element is "+bt.getMax());
		System.out.println("Min element is "+bt.getMin());
		System.out.println("Height of B tree is "+bt.getHeight());
		System.out.println("Total Elements in the tree is "+bt.countElements());
		System.out.println(bt.search(80));
		System.out.println(bt.search(51));
	}
	
}
