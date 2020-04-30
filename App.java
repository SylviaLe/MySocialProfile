import java.util.Scanner;

public class App 
{
    /*
    main()
    currentUser() //cuz the second case has more to do 
    exit()
     */
    // have all scanner use in one place for the class
    // only use close() when done with all scanner
    static final Scanner scan = new Scanner(System.in);

    public static void homeScreen(MySocialProfile p){
   
        boolean logout = false;         // flag check for log out
        
        while (!logout){    // run until user chooses 5
            System.out.println("\n\n(1) post to timeline\n(2) add an event\n(3) view list of friends");
            System.out.println("(4) add/remove a friend\n(5) log out\n\nEnter a number:");
            
            int choice = scan.nextInt();
            switch (choice){
                case 1:     // post to timeline
                    p.post();
                    break;
                case 2:     // add event
                    break;
                case 3:     // view friend list
                    break;
                case 4:     // add/remove friend
                    p.manageFriend();
                    break;
                case 5:     // log out
                    System.out.println("You have logged out");
                    logout = true;
                    break;
                default:
                    System.out.println("Please try again");
            }
            
        }
    }
    public static void main(String[] args) {

        MySocialProfile currentUser = new MySocialProfile();
        boolean exit = false;       // flag check for exit

        while (!exit){      // run until user chooses e
            System.out.println("\n\ncreate a new profile (c)\nload an existing profile (l)");
            System.out.println("exit program (e)\n\nEnter a letter to proceed:");

            char choice = scan.next().charAt(0);
            switch (choice){
                case 'c':       // create a new profile
                    System.out.println("you chose to create a new profile");
                    currentUser.createNewAcc();
                    homeScreen(currentUser);
                    break;
                case 'l':       // load an existing profile
                    System.out.println("you chose to load an existing profile");
                    currentUser.loadProfile();
                    homeScreen(currentUser);
                    break;
                case 'e':       // exit program
                    System.out.println("Have a good day :P");
                    exit = true;
                    break;
                default:
                    System.out.println("Please try again");
            }
        }

    }
    //some note on event loader:
    /* a = min();
    while (currentTime - min.getKey().getTime <= 0) {removeMin(), a = min()}*/


}
