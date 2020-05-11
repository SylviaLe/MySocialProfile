//Linh Nguyen, Sylvia Le, Sophie Le
//File: dependencies.DateComparator.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

package dependencies;
import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {

   @Override
   public int compare(E a, E b) throws ClassCastException {
      return ((Comparable<E>) a).compareTo(b);
   }
}
