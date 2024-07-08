
public class CustomStack {
	
	int length = 0;
	protected Node head;
	protected Node top;
	protected Node bottom;
	
	public CustomStack() {
		
	}
	
	class Node {
		int value;
		Node next;
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("{ Node: ");
			builder.append("{ Value: ");
			builder.append(value);
			builder.append(" }, ");
			builder.append(" Next: ");
			builder.append("{ Value: ");
			builder.append((this.next != null) ? next.value : null);
			builder.append(" } }");
			return builder.toString();
		}
	}
	
	public Node peek() {
		return this.top;
	}
	
	public Node pop() {
		if ( this.length <= 0 ) {
			return null;
		}
		this.length--;
		Node placeHolder = this.top;
		this.top = this.top.next;
		if ( this.length == 1 ) {
			this.bottom = null;
			this.bottom = null;
		}
		return placeHolder;
	}
	
	public Node push(int value) {
		Node newNode = new Node(value);
		if ( this.length == 0 ) {
			this.top = newNode;
			this.bottom = newNode;
		} else {
			newNode.next = this.top;
			this.top = newNode;
		}
		this.length++;
		return newNode;
	}
	
	public static void main(String[] args) {
		CustomStack stack = new CustomStack();
		System.out.println("Push: " + stack.push(10));
		System.out.println("Push: " + stack.push(100));
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Peek: " + stack.peek());
	}
}