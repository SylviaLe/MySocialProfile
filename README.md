# MySocialProfile notes
- Files that you need to care about:
  + MySocialProfile.java: basic operation on a profile
  + Event.java (manage the events list) and dependencies.DateComparator.java (the comparator for the heap)
  + App.java: This is the user interface. Compile this and follow the instructions on the screen
  
- Data structure used:
  + Name, email, password: String (email and password set the access modifier to private)
  + Class year: integer
  + Posts: Singly Linked Stack
  + Friend list: Array List
  + Event: heap-based priority queue
  
- Implementing the Event:
  + Use the HeapPriorityQueue provided by the textbook. Consider each event is an Entry with the date as the key and the description as 
  the value
  + Create a class name dependencies.DateComparator.java implementing the built-in Comparator interface. Provide a method compare() to override the one 
  in the interface
  + The logic of compare(): for each date 'e', calculate the difference of e.getTimeInMillis() - now.getTimeInMillis(). Compare this 
  difference between dates, the smaller the difference the more imminence (the date that going to happen next)
  + In the Event.java class, create an instance of the HeapPriorityQueue to store the list of events. Pass an instance of the dependencies.DateComparator
  as a parameter to the constructor
  + Reason for having a passEvent() instead of removePassEvent():
     > When ask the user for info of the new event, can check before adding to the queue if the date of the event has passed or not
     > When read the list of events from file, check before adding to the working heap. Later when save to record, save only what is in the
     working heap
     > Therefore, there is no need for an remove() method

- Current bugs and potential fix
  + Sometimes the post is note display to the right order
    > Note: In the file, the latest post is on the rightmost; when display, the latest post must be display first
  + If the number of events is above 4 or 5, the listing order is no-longer correct. 
    > Since we used the textbook's implementation, we assumed that this implementation is closest to the java built-in priority queue. 
    > In which case, this is rather a 'feature' of the heap, not a bug.
    > According to this link https://stackoverflow.com/questions/36187631/java-priorityqueue-and-comparator-not-ordering-correctly 
    > (or this link https://stackoverflow.com/questions/50154361/comparator-not-working-correctly-for-priorityqueue-java) (and some other link when type 'java priority queue comparator not working properly' in the Google Search bar),
    > The heap only guarantee that the first item is the item with the minimum key (or maximum, in case of max heap). The rest of the heap might not be in perfect order.
  
