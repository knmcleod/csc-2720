public class LinkedList
{
	public static void main(String[] args) {
		LinkedList 11 = new LinkedList();
		11.insert(0, 2);
		ll.insert(0, 1);
		System.out.println(ll.find(1));
		
		ll.insert(0, 0);
		System.out.println(ll);
		
		ll.insert(1, 5);
		System.out.println(ll);
		
		ll.delete(2);
		System.out.println(ll);
	}
	
	private Node head;
	public LinkedList() {
		head = null;
	}
	
	public int find(int n) {
		Node current = head;
		int count = 0;
		while (count < n) {
			current = current.getNext();
			if (current == null) {
				throw new IndexOutOfBoundsException("Cannot find item at position " + n);
			}
			count++;
		}
		return current.getData();
	}
	
	public void insert(int pos, int val) {
		Node newNode = new Node(val, null);
		
		if (pos == 0) {
			newNode.setNext( head );
			head = newNode;
			return;
		}
		
		Node current = head;
		int count = 0;
		while (count < pos-1) {
			current = current.getNext();
			if (current == null) {
				throw new IndexOutOfBoundsException("Cannot find item at position " + (pos-1));
			}
			count++;
		}
		
		newNode.setNext( current.getNext() );
		current.setNext( newNode );
	}
	
	public void delete(int pos) {
		if (pos == 0) {
			head = head.getNext();
			return;
		}
		
		Node current = head;
		int count = 0;
		while (count < pos-1) {
			current = current.getNext();
			if (current == null) {
				throw new IndexOutOfBoundsException("Cannot find item at position " + (pos-1));
			}
			count++;
		}
		
		if (current.getNext() == null) {
			throw new IndexOutOfBoundsException("Cannot find item at position " + pos);
		}
		
		current.setNext( current.getNext().getNext() );
	}

	public String toString() {
		String output = "";
		Node current = head;
		while (current != null) {
			output += current.getData() + ", ";
			current = current.getNext();
		}
		
		return output;
	}
}