//Linh Nguyen, Sophie Le, Sylvia Le
//File: DateComparator.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;
import MySocialProfile.dependencies.*;

/**
 * Class: Event
 * Manage user's events
 */
public class Event 
{
    /**
     * A heap-based priority queue to hold the event
     * Use DateComparator class' instance as the key comparator
     */
    public HeapPriorityQueue<ArrayList<Integer>, String> events = new HeapPriorityQueue<>(new DateComparator()); 
    
    
    /**
     * Prompt user for info, check and add the event
     */
    public void addEvent()
    {
        //Two arraylist, one to hold the date (to add into the queue), the other to check the date
        ArrayList<Integer> eventDate = new ArrayList<>(); 
        ArrayList<Integer> temp = new ArrayList<>();
        int month, day, year, hour, min;
        String desc;
        
        Scanner scan = new Scanner(System.in);

        //ask user for info of the events
		System.out.print("Please enter a month MM: ");
		month = scan.nextInt();
		System.out.print("Please enter a day DD: ");
		day = scan.nextInt();
		System.out.print("Please enter a year YYYY: ");
		year = scan.nextInt();
		System.out.print("Please enter an hour of the day (0-23): ");
		hour = scan.nextInt();
		System.out.print("Please enter the minute of the hour (00-59): ");
        min = scan.nextInt();
        System.out.print("Please enter a description for the event: ");
        desc = scan.next();
        desc += scan.nextLine(); //catch carriage

        //check the date before adding the event

        temp.add(month);
        temp.add(day);
        temp.add(year);
        temp.add(hour);
        temp.add(min);

        if (passEvent(temp))
        {
            temp.clear(); //clear the temp to check again later
            System.out.println("The date you entered has passed, please enter again");
            addEvent(); //prompt user to enter event again
        }
        else
        {
            //add info to the list that keep the date info
            eventDate.add(month);
            eventDate.add(day);
            eventDate.add(year);
            eventDate.add(hour);
            eventDate.add(min);

            addEvent(eventDate, desc); //add the other same name mthod
        }

    }

    /**
     * Check if the event has passed
     * @return true if the event has passed; false if hasn't
     */
    public  boolean passEvent(ArrayList<Integer> dates)  //return true if event has passed
    {
        //create a calendar instance to keep the dat
        Calendar date = Calendar.getInstance();
        date.set(dates.get(2), dates.get(0), dates.get(1), dates.get(3), dates.get(4));

        Calendar now = Calendar.getInstance();                   
        if ((now.getTimeInMillis() - date.getTimeInMillis()) > 0)
			return true;   //events passed
		else
            return false;
    }

    /**
     * Add event to the queue. Used when load profile from file, and as a helper method for the other with the same name.
     * @param date 
     * @param desc
     */
    public void addEvent(ArrayList<Integer> date, String desc)
    {
        events.insert(date, desc);
    }
    
    /**
     * Generate a string represents the list of event
     * @return a string generate the list of events
     */
    public String toString()
    {
        String writeS = "";
        for (int i = 0; i < events.size(); i++)
        {
            ArrayList<Integer> date = events.heap.get(i).getKey();  //get the date (which function as a key)
            String desc = events.heap.get(i).getValue();  //get the description

            //generate a string for the event
            String chunk1 = "\"" + date.get(0) + " " + date.get(1) + " " + date.get(2) + " ";
            String chunk2 = date.get(3) + " " + date.get(4) + " " + desc + '"' + ",";
            String oneEvent = chunk1 + chunk2;

            //concatenate to the previous
            writeS = writeS + oneEvent;
        }
        return writeS;
    }

    /**
     * Test the class
     */
    public static void main(String[] args)
    {
        Event myPlan = new Event();
        myPlan.addEvent();
        ArrayList<Integer> dateKey = new ArrayList<>();
        dateKey.add(11);
        dateKey.add(19);
        dateKey.add(2001);
        dateKey.add(21);
        dateKey.add(55);
        myPlan.addEvent(dateKey, "My Birthday!");

        System.out.print(myPlan.toString());
    }
    
}
