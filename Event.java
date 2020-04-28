
public abstract class Event 
{
    /*
    priority queue: save calendar obj, compare date, then add to queue
    dateCompare()  //may need to be in another class to implement the compare() method as an obj of the Comparator interface. See page 365 line 28-29
    //have an instance of Comparable basically compare the date base on the result of currentTime - evntTime, no abs
    addEvent()  //ask the date, ask the name, create a calendar obj then add to queue
    cpassEvent() //check if the event has passes, if yes then do not add. 
    toString()  //use to write into the file, in mm dd yy hh mm format
    addEvent(date[], description) //use when load from file, can call out from addEvent too

    public HeapPriorityQueue<ArrayList, String> events = new HeapPriorityQueue<>();

    public int compare(Entry<> a, Entry<> b)
    {
        ArrayList dateKeyA = a.getKey();
        ArrayList dateKeyB = b.getKey();

        Calendar dateA = Calendar.getInstance();
        dateA.set(dateKeyA.get(2), dateKeyA.get(0), dateKeyA.get(1), dateKeyA.get(3), dateKeyA.get(4));

        Calendar dateB = Calendar.getInstance();
        dateA.set(dateKeyB.get(2), dateKeyB.get(0), dateKeyB.get(1), dateKeyB.get(3), dateKeyB.get(4));

        return comp.compare((now.getTimeInMillis() - dateA.getTimeInMillis()), (now.getTimeInMillis() - dateB.getTimeInMillis()));
    }

    public void addEvent()
    {
        int month, day, year, hour, min;
        String desc;
        ArrayList<Integer> eventDate;
        ArrayList<Integer> temp;

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
        System.out.print("Please enter a month MM: ");
        desc = scan.next();
        scan.nextLine();  //catch carriage

        //code to check before adding

        temp.add(month);
        temp.add(day);
        temp.add(year);
        temp.add(hour);
        temp.add(min);

        if (events.passEvent(temp))
        {
            temp.clear();
            System.out.println("The date you entered has passed, please enter again")
            addEvent();
        }
        else
        {
            eventDate.add(month);
            eventDate.add(day);
            eventDate.add(year);
            eventDate.add(hour);
            eventDate.add(min);

            events.addEvent(eventDate, desc)
        }

    }

    public  boolean passEvent(ArrayList<Integer> dates)  //return true if event has passed
    {
        Calendar date = Calendar.getInstance();
        date.set(dates.get(2), dates.get(0), dates.get(1), dates.get(3), dates.get(4));
                           
        if ((now.getTimeInMillis() - date.getTimeInMillis()) < 0)
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
    
    public toString()
    {
        String writeS;
        for (int i = 0, i < events.size(), i++)
        {
            ArrayList<Integer> date = events.get(i).getKey()
            String desc = events.get(i).getValue();

            String temp = '"' + date.get(0) + " " + date.get(1) + " " + date.get(2) + " " + date.get(3) + " " + date.get(4) + " " + desc + '"';
            writeS = writeS + temp;
        }

        return writeS;
    }
     */
}
