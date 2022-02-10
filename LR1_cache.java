/*  
*  Following is a cache map that will store a key -> value points
*  To a cell or node that will be in the actual memory.
*  
*/
class DoublyLinkedList<T>{

	private Node<T> sentinel;
	private Node<T> current;

	private class Node<T>{
		private T data;
		private Node next;
		private Node prev;

		public Node(final T data){
			this.data = data;
			this.next = prev = null;
		}
	}

	public DoublyLinkedList(){
		this.sentinel = new Node(null);
		this.sentinel.next = sentinel.prev;
		this.current = sentinel;
	}

	public void add(final T data){
		Node<T> newNode = new Node<T>(data);
		newNode.next = current.next;
		newNode.prev = current;
		current.next.prev = newNode;
		current.next = newNode;
		current = newNode;
	}	

	private boolean hasCurrent(){
		return this.sentinel != this.current;
	}
	
	public Node evict(){
		if(hasCurrent()){
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}else{
			System.out.println("Cache is empty load more items");
		}

		return current;
	}
 
	/*
	* This is a temporary debugger for the doubly linked list.
	*/
	public void printAll(){
		Node temp = current;
		while(temp!=sentinel){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}

	public static void main(String[] args){
		DoublyLinkedList temp = new DoublyLinkedList();
		temp.add(1);
		temp.add(2);
		temp.add(3);
		temp.add(4);
		temp.printAll();
	} 

}


class HashMap<K,V>{
	
	private class Entry<K,V>{
		//when we hash our key will will to set the value that it points to 
		//to the value at the other end.....
	}

}

public class LR1_cache{
	public static void main(String[] args){
		System.out.println("run this following cache");
	}
} 