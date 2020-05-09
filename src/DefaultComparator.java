//Linh Nguyen, Sylvia Le, Sophie Le
//File: DateComparator.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {

   @Override
   public int compare(E a, E b) throws ClassCastException {
      return ((Comparable<E>) a).compareTo(b);
   }
}
