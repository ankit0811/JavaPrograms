class Node {
	Node next;
	Object data;
	
	Node(Object dataValue){
		next=null;
		data=dataValue;
	}
	
	Node(Object dataValue,Node nextValue){
		next=nextValue;
		data=dataValue;
	}
	
	Object getData(){
		return data;
	}
	
	void setData(Object dataValue){
		data=dataValue;
	}
	
	Node getNext(){
		return next;
	}
	
	public void setNext(Node nextValue){
		next=nextValue;
	}
	
	
}


class LinkedListDS{
	int counter=0;
	Node head;
	
	LinkedListDS(){
		head=new Node(null);
		
	}
	
	void add(Object data){
		 Node temp = new Node(data);
		 Node current = head;
		 
		 while(current.getNext() != null){
			 current = current.getNext();
		 }
		 
		 current.setNext(temp);
		 counter++;
		 
	}
	
	void add(Object data, int index){
		Node temp=new Node(data);
		Node current = head;
		if (index > counter+1){
			System.out.println("Index cannot be greater than length");
		}
		else{
			int tempCount=0;
			while (tempCount != index && tempCount<=counter){
				current=current.getNext();
				tempCount++;
				
			}
			
			temp.setNext(current.getNext());
			current.setNext(temp);
			counter++;
		}
		
	}
	
	boolean deleteElement(Object data){
		Node current = head;
		Node prev = head;
		while( current.getNext() != null ){
			if (current.getData() == data){
				prev.setNext(current.getNext());
				counter--;
				return true;
			}
			else{
				prev=current;
				current=current.getNext();
			}
			
		}
		
		return false;
	}
	
	Object getValue(int index){
		int tempCount=0;
		Node current = head;
		while(tempCount<=counter && current.getNext() != null){
			if (tempCount==index){
				return current.getNext().getData();
			}
			else{
				current=current.getNext();
				tempCount++;
			}
		
		}
		return null;
	}
	
	void display(){
		Node current = head.getNext();
		while(current != null){
			System.out.println( "Current Addr=" + current + " " +
								"Next Addr=" + current.getNext() + " " + 
								current.getData());
			current=current.getNext();
			
		}
			
	}
	
	int getSize(){
		return counter;
	}
	
}

public class LinkedList {
	public static void main(String args[]){
		LinkedListDS ll=new LinkedListDS();
		ll.add(5);
		ll.add(10);
		ll.add(15);
		ll.add(1,0);
		ll.add(2,10);
		ll.display();
		System.out.println("LinkedList Size="+ll.getSize());
		System.out.println(ll.deleteElement(5));
		System.out.println(ll.deleteElement(5));
		ll.display();
		System.out.println("LinkedList Size="+ll.getSize()+" " +ll.head.getNext());
		
		System.out.println(ll.getValue(0));
	}
}
