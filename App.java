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
            System.out.println("|HOME SCREEN|\n(1) Post to timeline\n(2) Add an event\n(3) View list of friends");
            System.out.println("(4) Add/remove a friend\n(5) Log out\nEnter a number to proceed:");
            
            int choice = scan.nextInt();
            switch (choice){
                case 1:     // post to timeline
                    Scanner in = new Scanner(System.in);
                    System.out.print("What is on your mind: ");
                    String newPost = in.next();
                    in.nextLine();   //to catch carriage
                    
                    p.post(newPost); //call input
                    in.close();

                    break;
                case 2:     // add event
                    break;
                case 3:     // view friend list
                    break;
                case 4:     // add/remove friend
                    Scanner in2 = new Scanner(System.in);
                    System.out.print("Please enter your friend's email address: ");
                    String friend = in2.next();
                    in2.nextLine();    //to catch carriage
                
                    p.manageFriend(friend);  //call input
                    in2.close();
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
            System.out.println("|MAIN MENU|\n(1) Create a new profile\n(2) Load an existing profile");
            System.out.println("(3) Exit program\nEnter a number to proceed:");

            char choice = scan.next().charAt(0);
            switch (choice){
                case '1':       // create a new profile
                    System.out.println("---You chose to create a new profile---");
                    currentUser.createNewAcc();
                    homeScreen(currentUser);
                    break;
                case '2':       // load an existing profile
                    System.out.println("---You chose to load an existing profile---");
                    currentUser.loadprofile();
                    homeScreen(currentUser);
                    break;
                case '3':       // exit program
                    System.out.println("---Have a good day :P---");
                    exit = true;
                    break;
                default:
                    System.out.println("---Please try again---");
            }
        }

    }
    //some note on event loader:
    /* a = min();
    while (currentTime - min.getKey().getTime <= 0) {removeMin(), a = min()}*/


}
