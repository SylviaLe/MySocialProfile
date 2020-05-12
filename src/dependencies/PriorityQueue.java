//Linh Nguyen, Sylvia Le, Sophie Le
//File: dependencies.PriorityQueue.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

package dependencies;
/**
 * Interface for the priority queue ADT.
 * @param <K>
 * @param <V>
 */
public interface PriorityQueue<K, V> {

   int size();

   boolean isEmpty();

   Entry<K, V> insert(K key, V value) throws IllegalArgumentException;

   Entry<K, V> min();

   Entry<K, V> removeMin();
}
