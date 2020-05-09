# MySocialProfile notes
- Files that you need to care about:
  + MySocialProfile.java
  + Event.java and DateComparator.java
  + App.java
  
- Data structure used:
  + Name, email, password: String (email and password set the access modifier to private)
  + Class year: integer
  + Posts: Singly Linked Stack
  + Friend list: Array List
  + Event: heap-based priority queue
  
- Implementing the Event:
  + Use the HeapPriorityQueue provided by the textbook. Consider each event is an Entry with the date as the key and the description as 
  the value
  + Create a class name DateComparator.java implementing the built-in Comparator interface. Provide a method compare() to override the one 
  in the interface
  + The logic of compare(): for each date 'e', calculate the difference of e.getTimeInMillis() - now.getTimeInMillis(). Compare this 
  difference between dates, the smaller the difference the more imminence (the date that going to happen next)
  + In the Event.java class, create an instance of the HeapPriorityQueue to store the list of events. Pass an instance of the DateComparator
  as a parameter to the constructor
  + Reason for having a passEvent() instead of removePassEvent():
     > When ask the user for info of the new event, can check before adding to the queue if the date of the event has passed or not
     > When read the list of events from file, check before adding to the working heap. Later when save to record, save only what is in the
     working heap
     > Therefore, there is no need for an remove() method

- Current bugs and potential fix
  + Quite confusing post display (don't know which is the oldest and newest, so the display and save can be quite messy)
  
- Notes
User's posts: When displayed on console, user's posts are listed in an order such that the most recent post is on the left (sometimes it's quite messed up but that's the idea). Whereas, when they are written to mysocialprofile.txt file, the most recent post is on the right.

  
