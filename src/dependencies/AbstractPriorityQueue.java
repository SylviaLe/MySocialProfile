//Linh Nguyen, Sylvia Le, Sophie Le
//File: dependencies.AbstractPriorityQueue.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

package dependencies;
import java.util.Comparator;

/**
 * @param <K>
 * @param <V>
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

   private Comparator<K> comparator;

   protected AbstractPriorityQueue(Comparator<K> c) {
      this.comparator = c;
   }

   protected AbstractPriorityQueue() {
      this(new DefaultComparator<K>());
   }

   /**
    * Method for comparing two entries according to key
    *
    * @param a
    * @param b
    * @return
    */
   protected int compare(Entry<K, V> a, Entry<K, V> b) {
      return comparator.compare(a.getKey(), b.getKey());
   }

   /**
    * Determines whether a key is valid.
    *
    * @param key
    * @return
    * @throws IllegalArgumentException
    */
   protected boolean checkKey(K key) throws IllegalArgumentException {
      try {
         return comparator.compare(key, key) == 0;    // see if key can be compared to itself
      } catch (ClassCastException e) {
         throw new IllegalArgumentException("Incompatible key");
      }
   }

   @Override
   public boolean isEmpty() {
      return size() == 0;
   }

   //---------------- nested PQEntry class ---------------
   protected static class PQEntry<K, V> implements Entry<K, V> {

      private K key;
      private V value;

      public PQEntry(K key, V value) {
         this.key = key;
         this.value = value;
      }

      @Override
      public K getKey() {
         return this.key;
      }

      @Override
      public V getValue() {
         return this.value;
      }

      // utilities not exposed as part of the Entry interface
      protected void setKey(K key) {
         this.key = key;
      }

      protected void setValue(V value) {
         this.value = value;
      }
   }
   //------------ end of nested PQEntry class ------------
}
