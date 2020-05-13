//Linh Nguyen, Sylvia Le, Sophie Le
//File: dependencies.DateComparator.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

package dependencies;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Calendar;

/**
 * Class: dependencies.DateComparator
 * Implement Comparator Interface, used to compare dates according to their order in time
 */
public class DateComparator implements Comparator<ArrayList<Integer>>
{
    /**
    * Compares two dates according to time order.
    * 
    * @param dateKeyA
    * @param dateKeyB
    * @return -1 if dateA precedes dateB; 0 if the two date equals; 1 if dateB precedes dateA
    */
   @Override
    public int compare(ArrayList<Integer> dateKeyA, ArrayList<Integer> dateKeyB)
    {
        //get the date info from the arraylist and create an instance of Calendar class for it
        Calendar dateA = Calendar.getInstance();
        int yearA = (Integer) dateKeyA.get(2);
        int monthA = (Integer) dateKeyA.get(0);
        int dayA = (Integer) dateKeyA.get(1);
        int hourA = (Integer) dateKeyA.get(3);
        int minA = (Integer) dateKeyA.get(4);
        dateA.set(yearA, monthA, dayA, hourA, minA);

        Calendar dateB = Calendar.getInstance();
        int yearB = (Integer) dateKeyB.get(2);
        int monthB = (Integer) dateKeyB.get(0);
        int dayB = (Integer) dateKeyB.get(1);
        int hourB = (Integer) dateKeyB.get(3);
        int minB = (Integer) dateKeyB.get(4);
        dateB.set(yearB, monthB, dayB, hourB, minB);

        //create instance of Calendar class for the current time
        Calendar now = Calendar.getInstance();

        // //use compare() to compare the date
        // //Take the current time as a mark. dateA precedes dateB if the time from now to dateA is shorter than the time from now to dateB
        // //int i = Long.compare((dateA.getTimeInMillis() - now.getTimeInMillis()), (dateB.getTimeInMillis() - now.getTimeInMillis()));
        return dateA.compareTo(dateB);
    }
}
