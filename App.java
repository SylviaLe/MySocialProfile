//Linh Nguyen, Sophie Le, Sylvia Le
//File: DateComparator.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

import java.util.Scanner;

/**
 * Class: App
 * Where everything happen
 */
public class App 
{
    static final Scanner scan = new Scanner(System.in);  //only use one scanner for the entire class to avoid NoSuchElementException

    /**
     * Functions after a new account has been created or existing account has been loaded
     * @param p
     */
    public static void homeScreen(MySocialProfile p)
    {
   
        boolean logout = false;         // flag check for log out
        
        while (!logout)
        {    // run until user chooses 5
            System.out.println("|HOME SCREEN|\n(1) Post to timeline\n(2) Add an event\n(3) View list of friends");
            System.out.println("(4) Add/remove a friend\n(5) Log out\nEnter a number to proceed:");
            
            char choice = scan.next().charAt(0);
            switch (choice){
                case '1':     
                    p.post(); //call input
                    break;
                case '2':     // add event
                    break;
                case '3':     // view friend list
                    p.listFriend();
                    break;
                case '4':     // add/remove friend              
                    p.manageFriend();  //call input
                    break;
                case '5':     // log out
                    System.out.println("You have logged out");
                    logout = true;
                    break;
                default:
                    System.out.println("Please try again");
            }
            
        }
        
    }

    /**
     * Greeting. The first screen that the user see
     */
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

}
