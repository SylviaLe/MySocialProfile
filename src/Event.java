//Linh Nguyen, Sylvia Le, Sophie Le
//File: Event.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import dependencies.*;


/**
 * Class: Event
 * Manage user's events
 */
public class Event 
{
    /**
     * A heap-based priority queue to hold the event
     * Use dependencies.DateComparator class' instance as the key comparator
     */
    public HeapPriorityQueue<ArrayList<Integer>, String> events = new HeapPriorityQueue<>(new DateComparator()); 
    
    
    public ArrayList<Integer> scanDate()
    {
        ArrayList<Integer> temp = new ArrayList<>();
        int month, day, year, hour, min;
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

        temp.add(month);
        temp.add(day);
        temp.add(year);
        temp.add(hour);
        temp.add(min);

        return temp;
    }


    /**
     * Prompt user for info, check and add the event
     */
    public void addEvent()
    {
        //Two arraylist, one to hold the date (to add into the queue), the other to check the date
        ArrayList<Integer> eventDate = new ArrayList<>();
        ArrayList<Integer> tempDate;
        String desc;
        
        //check the date before adding the event

        tempDate = scanDate();
        while (passEvent(tempDate))
        {
            System.out.println("The date you entered has passed, please enter again");
            tempDate = scanDate();
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a description for the event: ");
        desc = scan.next();
        desc += scan.nextLine(); //catch carriage

        //add info to the list that keep the date info
        eventDate.add(tempDate.get(0));
        eventDate.add(tempDate.get(1));
        eventDate.add(tempDate.get(2));
        eventDate.add(tempDate.get(3));
        eventDate.add(tempDate.get(4));

        addEvent(eventDate, desc); //add the other same name mthod

    }

    /**
     * Check if the event has passed
     * @return true if the event has passed; false if hasn't
     */
    public static boolean passEvent(ArrayList<Integer> dates)  //return true if event has passed
    {
        LocalDateTime currentDateTime = LocalDateTime.now(); // get the current date and time in local time zone
        LocalDateTime thisDateTime = LocalDateTime.of(dates.get(2), dates.get(0), dates.get(1), dates.get(3), dates.get(4));

        if(currentDateTime.isAfter(thisDateTime)) return true; //this event passed
        else return false;
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
     * Check if queue is empty
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty(){
    	return events.size() == 0;
    }

    
    /**
    * Print out one upcoming event. The most imminent
    */
    public void getLatestEvent()
    { 
        ArrayList<Integer> date = events.min().getKey();
        String desc = events.min().getValue();
        String dateString = Integer.toString(date.get(0)) + '/' + Integer.toString(date.get(1)) +'/' + Integer.toString(date.get(2)) + ' ' + Integer.toString(date.get(3)) + ':'  + Integer.toString(date.get(4));
        System.out.println("Upcoming event: " + dateString + " > " + desc);
    }
    
    /**
     * Print out all events in a user-friendly format, different than one in toString method
     * @return a String object of all events
     */
    public String display()
    {
    	String writeS = "";
        for (int i = 0; i < events.size(); i++)
        {
            ArrayList<Integer> date = events.heap.get(i).getKey();  //get the date (which function as a key)
            String desc = events.heap.get(i).getValue();  //get the description

            //generate a string for the event
            String chunk1 = date.get(0) + "/" + date.get(1) + "/" + date.get(2) + " ";
            String chunk2 = date.get(3) + ":" + date.get(4) + " > " + desc + ",";
            String oneEvent = chunk1 + chunk2;

            //concatenate to the previous
            writeS = writeS + oneEvent;
        }
        return writeS;
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

    // Testing methods
    public static void main(String[] args)
    {
        //Event myEvent = new Event();
        //myEvent.addEvent();
        //ArrayList<Integer> dateKey = new ArrayList<>();

        //System.out.print(myEvent.toString());
        
    }
    
}
