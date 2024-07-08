import java.util.LinkedList;

public class CustomLinkedList {
	
	int length = 0;
	Node head;
	Node next;
	Node tail;
	//LinkedList<Object> linkedList = new LinkedList<>();
	
	public CustomLinkedList(int value) {
		this.next = null;
		this.tail= this.head;
		this.length = 0;
	}
	
	class Node {
		int value;
		Node next;
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public void append(int value) {
		Node newNode = new Node(value);
		if ( this.length == 0 ) {
			this.head = newNode;
			this.tail = this.head;
		}
		this.tail.next = newNode;
		//this.head.tail = newNode;
		this.tail = newNode;
		this.length++;
	}
	
	public void prepend(int value) {
		Node newNode = new Node(value);
		Node currHead = this.head;
		this.head = newNode;
		this.head.next = currHead;
		System.out.println("Curr next: " + this.next);
		System.out.println("Curr head next: " + this.head.next);
		this.length++;
	}
	
	@Override
	public String toString() {
		StringBuilder strBldr = new StringBuilder();
		Node curr = this.head;
		while ( curr != null ) {
			strBldr.append("Head: { value: ");
			strBldr.append(curr.value);
			strBldr.append(", Next: { value: ");
			strBldr.append(curr.next == null ? null : curr.next.value);
			strBldr.append("} ");
			strBldr.append(", Tail: { value: ");
			strBldr.append(this.tail == null ? null : this.tail.value);
			strBldr.append("} ");
			strBldr.append("}\n");
			curr = curr.next;
		}
		return strBldr.toString();
	}
	
	public void insert(int index, int value) {
		
	}
	
	public int getLength() {
		return this.length;
	}
	
	public static void main(String[] args) {
		CustomLinkedList customLinkedList = new CustomLinkedList(10);
		customLinkedList.append(20);
		customLinkedList.append(30);
		customLinkedList.prepend(0);
		System.out.println(customLinkedList);
		System.out.println("Length: " + customLinkedList.getLength());
	}
}
