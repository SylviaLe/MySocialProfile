import java.util.ArrayList;
import java.util.Comparator;
import java.util.Calendar;


public class DateComparator implements Comparator<ArrayList<Integer>>
{
    public int compare(ArrayList<Integer> dateKeyA, ArrayList<Integer> dateKeyB)
    {
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
        dateA.set(yearB, monthB, dayB, hourB, minB);

        //revise the thing down here
        Calendar now = Calendar.getInstance();
        int i = Long.compare((now.getTimeInMillis() - dateA.getTimeInMillis()), (now.getTimeInMillis() - dateB.getTimeInMillis()));
        return i;
    }
}