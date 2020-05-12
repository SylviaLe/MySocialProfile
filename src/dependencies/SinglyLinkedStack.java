//Linh Nguyen, Sylvia Le, Sophie Le
//File: dependencies.SinglyLinkedStack.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

package dependencies;

 /**
  * Implementation of a generic stack ADT using a SinglyLinkedList.
  * Stack: a collection of objects that are inserted
  * and removed according to the last-in first-out principle.
  */

public class SinglyLinkedStack<E> {
  private SinglyLinkedList<E> list;   //The SinglyLinkedList object

  //Constructor method
  public SinglyLinkedStack() {
    list = new SinglyLinkedList<>();  //new stack starts with an empty list
  }

  

  /**
  * Return the number of elements in the stack.
  * @return number of elements in the stack. 
  */
  public int size() { 
    return list.size();
  }

  /** 
  * Return whether the stack is empty.
  * @return true if the stack is empty, false otherwise. 
  */
  public boolean isEmpty() {
    return list.isEmpty();
  }

  /**
  * Insert an element at the top of the stack.
  * @param element to be inserted.
  */
  public void push(E element) {
    list.addFirst(element);
  }

  /** 
  * Inspect the element at the top of the stack.
  * @return top element in the stack, null if empty.  
  */
  public E top() {
    return list.first();
  }

  /** 
  * Remove the top element from the stack.
  * @return element removed, null if empty.
  */
  public E pop() {
    return list.removeFirst();
  }
  
  /**
   * Displays the stack contents
   */
  public void display() {
    list.display();    //Use the display method of the SinglyLinkedList
  }

  public String toString()
  {
    return list.toString();
  }


 /**
  * Test the class by performing a series of operations
  */
  public static void main(String[] args) {
    SinglyLinkedStack<Integer> A = new SinglyLinkedStack<>();  //A stack of integers
    A.push(7);
    A.push(6);
    //i = A.pop();
    A.push(9);
    A.push(10);
    A.push(15);
    A.push(18);
    A.push(20);
    //i = A.pop();
    System.out.print(A.toString());
    //A.display();

    SinglyLinkedStack<Character> B = new SinglyLinkedStack<>();    //A stack of characters
    B.push('B');
    B.push('>');
    B.push('5');
    //B.display();
  }
}
