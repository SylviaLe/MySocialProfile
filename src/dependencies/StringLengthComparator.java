//Linh Nguyen, Sylvia Le, Sophie Le
//File: dependencies.StringLengthComparator.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

package dependencies;
import java.util.Comparator;

/**
 *
 * @author Rogerio J. Gentil
 */
public class StringLengthComparator implements Comparator<String> {

   /**
    * Compares two strings according to their lengths.
    * 
    * @param s1
    * @param s2
    * @return 
    */
   @Override
   public int compare(String s1, String s2) {
      if (s1.length() < s2.length()) {
         return -1;
      } else if (s1.length() == s2.length()) {
         return 0;
      } else {
         return 1;
      }
   }

}
