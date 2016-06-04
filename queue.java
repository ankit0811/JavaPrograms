package queue;

class node{
	node next;
	Object data;
	
	node(Object value){
		next=null;
		data=value;
		
	}
	
	void setData(Object value){
		data=value;
	}
	
	Object getData(){
		return data;
	}
	
	void setNext(node value){
		next=value;
	}
	
	node getNext(){
		return next;
	}
	
}

class queueDS{
	node front,rear;
	int counter=0;
	
	queueDS(){
		front=new node(null);
		rear=new node(null);
		
	}
	
	void enqueue(Object value){
		node currNode=new node(value);
		if (front.getNext() == null){
			front.setNext(currNode);
			rear=front.getNext();
			counter++;
		}
		else{
			rear.setNext(currNode);
			rear=rear.getNext();
			counter++;
		}
		//System.out.println(front.getNext().getData());
			
		
	}
	
	Object dequeue(){
		
		if (front.getNext() != null){
			front=front.getNext();
			counter--;
			return front.getData();
			
		}
		
		return "The Queue is empty";
		
	}
	
	
	boolean delete(Object value){
		
		node temp=front;
		node prev;
		while(temp !=rear){
			prev=temp;
			temp=temp.getNext();
			if (temp.getData()==value){
				prev.setNext(temp.getNext());
				counter --;
				if (temp==rear){
					rear=prev;
				}
				return true;
			}
		}
		
		return false;
	}
	
	
	int queueSize(){
		return counter;
	}
	
	
	void display(){
		
		node temp=front;
		//System.out.println(front.getNext().getData());
		while(front !=rear){
			front=front.getNext();
			System.out.println(front.getData());
		}
		front=temp;
	}
}

public class queue {
	public static void main(String args[]){
		queueDS Q=new queueDS();
		Q.enqueue(10);
		Q.enqueue(20);
		Q.enqueue(30);
		Q.enqueue(40);
		System.out.println("Queue Size===>"+Q.queueSize());
		Q.display();
/*		for (int i=0;i<4;i++){
			System.out.println(Q.dequeue());
		}
		*/
		System.out.println(Q.delete(40));
		Q.display();
		System.out.println("Queue Size===>"+Q.queueSize());
	}
}
