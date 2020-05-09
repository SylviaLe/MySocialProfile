//Linh Nguyen, Sylvia Le, Sophie Le
//File: DateComparator.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

/**
 * Interface for a key-value pair
 *
 * @author Rogerio J. Gentil
 * @param <K> key
 * @param <V> value
 */
public interface Entry<K, V> {

   /**
    * Returns the key stored in this entry
    *
    * @return
    */
   K getKey();

   /**
    * Returns the value stored in this entry
    *
    * @return
    */
   V getValue();
}
