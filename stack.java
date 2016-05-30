class NewNode{
	Object data;
	NewNode next;
	NewNode(Object value){
		next=null;
		data=value;
	}
	
	
	void setData(Object value){
		data=value;
	}
	
	Object getData(){
		return data;
	}
	
	void setNext(NewNode nextValue){
		next=nextValue;
	}
	
	NewNode getNext(){
		return next;
	}
	
}

class StackDS{
	NewNode top;
	int counter;
	
	StackDS(){
		top=new NewNode(null);
		
	}
	
	void push(Object data){
		NewNode current=new NewNode(data);
		current.setNext(top.getNext());
		top.setNext(current);
		counter++;
		System.out.println(current+" "+
							data+" "+
							current.getNext()+" "+
							top.getNext()+" "+
							top);
	}
	
	
	Object pop(){
		NewNode temp=top;
		if (counter > 0 && temp.getNext() != null){
			top=top.getNext();
			counter--;
			return temp.getNext().getData();
		
		}
		return "No more data";	
	}
	
	Object peek(){
		
		if (counter > 0 && top.getNext() != null){
			return top.getNext().getData();
		
		}
		return "No more data";	
		
	}
	
}

public class stack {
	public static void main(String args[]){
		StackDS ss=new StackDS();
		ss.push(1);
		ss.push(2);
		ss.push(3);
		System.out.println(ss.peek());
		System.out.println(ss.pop());
		System.out.println(ss.peek());
		ss.push('A');
		System.out.println(ss.peek());
		
		
	}
}
