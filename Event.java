
public abstract class Event 
{
    /*
    priority queue: save calendar obj, compare date, then add to queue
    dateCompare()  //may need to be in another class to implement the compare() method as an obj of the Comparator interface. See page 365 line 28-29
    //have an instance of Comparable basically compare the date base on the result of currentTime - evntTime, no abs
    newEvent()  //ask the date, ask the name, create a calendar obj then add to queue
    checkEvent() //check if the event has passes, if yes then do not add
    toString()  //use to write into the file
    putEvent(date[], description) //use when load from file, can call out from addEvent too

    public HeapPriorityQueue<ArrayList, String> = new HeapPriorityQueue<>();

    public int compare(Entry<> a, Entry<> b)
    {
        ArrayList dateKeyA = a.getKey();
        ArrayList dateKeyB = b.getKey();

        Calendar dateA = Calendar.getInstance();
        dateA.set(dateKeyA.get(2), dateKeyA.get(0), dateKeyA.get(1), dateKeyA.get(3), dateKeyA.get(4));

        Calendar dateB = Calendar.getInstance();
        dateA.set(dateKeyB.get(2), dateKeyB.get(0), dateKeyB.get(1), dateKeyB.get(3), dateKeyB.get(4));

        return comp.compare(dateA.getTimeInMillis(), dateB.getTimeInMillis());
    }

    public void 
     */
}
