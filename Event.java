import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;

public class Event 
{
    /*
    priority queue: save calendar obj, compare date, then add to queue
    dateCompare()  //may need to be in another class to implement the compare() method as an obj of the Comparator interface. See page 365 line 28-29
    //have an instance of Comparable basically compare the date base on the result of currentTime - evntTime, no abs
    addEvent()  //ask the date, ask the name, create a calendar obj then add to queue
    cpassEvent() //check if the event has passes, if yes then do not add. 
    toString()  //use to write into the file, in mm dd yy hh mm format
    addEvent(date[], description) //use when load from file, can call out from addEvent too

    */

    /*
    public int compare(ArrayList dateKeyA, ArrayList dateKeyB)
    {
        Calendar dateA = Calendar.getInstance();
        dateA.set(dateKeyA.get(2), dateKeyA.get(0), dateKeyA.get(1), dateKeyA.get(3), dateKeyA.get(4));

        Calendar dateB = Calendar.getInstance();
        dateA.set(dateKeyB.get(2), dateKeyB.get(0), dateKeyB.get(1), dateKeyB.get(3), dateKeyB.get(4));

        //revise the thing down here
        return ((now.getTimeInMillis() - dateA.getTimeInMillis()).compareTo((now.getTimeInMillis() - dateB.getTimeInMillis())));
    }
    */
    public HeapPriorityQueue<ArrayList<Integer>, String> events = new HeapPriorityQueue<>(new DateComparator());
    ArrayList<Integer> eventDate; 
    ArrayList<Integer> temp;

    public Event()
    {
        eventDate = new ArrayList<>();
        temp = new ArrayList<>();
    }
    public void addEvent()
    {
        int month, day, year, hour, min;
        String desc;
        

        Scanner scan = new Scanner(System.in);

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

        //code to check before adding

        temp.add(month);
        temp.add(day);
        temp.add(year);
        temp.add(hour);
        temp.add(min);

        while (passEvent(temp))
        {
            temp.clear();
            System.out.println("The date you entered has passed, please enter again");
            addEvent();
        }
        eventDate.add(month);
        eventDate.add(day);
        eventDate.add(year);
        eventDate.add(hour);
        eventDate.add(min);

        addEvent(eventDate, desc);

    }

    public  boolean passEvent(ArrayList<Integer> dates)  //return true if event has passed
    {
        Calendar date = Calendar.getInstance();
        date.set(dates.get(2), dates.get(0), dates.get(1), dates.get(3), dates.get(4));

        Calendar now = Calendar.getInstance();                   
        if ((now.getTimeInMillis() - date.getTimeInMillis()) > 0)
			return true;   //events passed
		else
            return false;
            
        //explain: sẽ không có remove nữa mà chỉ có cái check pass này thôi, vì lúc chạy mà load event vào ó thì 
        //có check trc xem là nó có pass hay chưa r, nếu chưa thì mới add vào cái working queue. 
        //lúc logout thì sẽ lấy dữ liệu từ cái working queue đó overwrite cái file kia, nên cũng coi là remove rồi
    }

    public void addEvent(ArrayList<Integer> date, String desc)
    {
        events.insert(date, desc);
    }
    
    public String toString()
    {
        String writeS = "";
        for (int i = 0; i < events.size(); i++)
        {
            ArrayList<Integer> date = events.heap.get(i).getKey();
            String desc = events.heap.get(i).getValue();

            String chunk1 = "\"" + date.get(0) + " " + date.get(1) + " " + date.get(2) + " ";
            String chunk2 = date.get(3) + " " + date.get(4) + " " + desc + '"' + ",";
            String oneEvent = chunk1 + chunk2;
            writeS = writeS + oneEvent;
        }
        return writeS;
    }

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
