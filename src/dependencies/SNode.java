//Linh Nguyen, Sylvia Le, Sophie Le
//File: dependencies.SNode.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

package dependencies;

/**
* A generic node class for a SinglyLinkedList class
* This stores an arbitrary element object type
*/

public class SNode<E> {
	private E element;				//Reference to the element stored at this node
	private SNode<E> next;				//Reference to the successor node in the list

	//The Constructor method
	public SNode(E e, SNode<E> n) {
		element = e;
		next = n;
	}

	//ACCESS METHODS

	//Returns the GameScore element stored at the node
	public E getElement() {
		return element;
	}

	//Returns the next node
	public SNode<E> getNext() {
		return next;
	}

	//UPDATE METHODS

	//Updates/sets the element field
	public void setElement(E e) {
		element = e;
	}

	//Sets the next node field
	public void setNext(SNode<E> n) {
		next = n;
	}

	//Returns a string representation of the node
	public String toString() {
		return element.toString();		//Using the toString() method of the E class
	}

	//Testing the class in the main method
	public static void main(String[] args) {
	
	}

}

