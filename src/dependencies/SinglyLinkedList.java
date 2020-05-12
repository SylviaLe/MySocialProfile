//Linh Nguyen, Sylvia Le, Sophie Le
//File: dependencies.SinglyLinkedList.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

package dependencies;
/**
* A generic SinglyLinkedList class, holding a list of generic SNodes
* An SNode stores an arbitrary element E
*/

public class SinglyLinkedList<E> {
	//Instance Variables
	private SNode<E> head;		//Reference to the head node of the list
	private SNode<E> tail;		//Reference to the tail node of the list
	private int size;		//The number of nodes in the list

	//Constructs an initially empty list
	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	//ACCESS METHODS

	//Returns the size, number of nodes in the list
	public int size() {
		return size;
	}

	//Returns true if the list is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}

	//Returns (but doesn't remove) the first element
	//That's the element stored at the head node
	public E first() {
		if (isEmpty()) {
			return null;	//If the list is empty
		}
		return head.getElement();
	}

	//Returns (but doesn't remove) the last element
	//That's the element stored at the tail node
	public E last() {
		if (isEmpty())
			return null;	//If the list is empty
		return tail.getElement();
	}

	//UPDATE METHODS

	//Add element e to the front of the list
	public void addFirst(E e) {
		//Starts by creating and linking a new node to current head node
		SNode<E> newNode = new SNode<>(e,head);
		if (isEmpty()) {
			tail = newNode;		//Special case, new node becomes the tail also
		}
		head = newNode;			//New node becomes the head of the list
		size++;
	}

	//Adds the newScore element to the end of the list
	public void addLast(E e) {
		//Starts by creating a new node, its successor will be null
		SNode<E> newNode = new SNode<>(e, null);
		if (isEmpty()) {
			head = newNode;		//Special case, new node becomes the head also
		}
		else {
			tail.setNext(newNode);	//Link new node after the current tail node
		}
		tail = newNode;			//New node becomes the tail of the list
		size++;
	}

	//Removes and returns the first element of the list
	public E removeFirst() {
		if (isEmpty())
			return null;				//Nothing to remove or return
		else {
			E answer = head.getElement(); //We will return this in the end
			head = head.getNext();		//Will become null if list HAD only one node
			size--;
			if (size == 0)
				tail = null;			//Special case, as list is now empty
			return answer;				//As expected
		}
	}

	/**
	 * Displays the list contents
	 */
	public void display() {
		SNode<E> current = head;
		int i = 0;
		while (current != null && i < 3) {      			// for each node,
			System.out.print(current + ", ");  	// display it using the SNode.toString() method
			current = current.getNext();		//Fetch the next node in the list
			i++;
		}
		System.out.println("");
	}

	/**
	 * Generate a string representation of the linked list
	 * Will be used in the stack
	 */
	public String toString()
	{
		String stack = "";
		SNode<E> current = head;
		//int i = 0;
		{
			while (current != null) 
			{   // for each node,
				stack = "\"" + current.getElement() + "\"" + ',' + stack;  	// display it using the SNode.toString() method				
				current = current.getNext();		//Fetch the next node in the list
			}
		}
		return stack;
	}

	//Testing the class using the main method
	public static void main(String[] args) {
		//Your test code goes here
	}



}
