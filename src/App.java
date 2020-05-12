//Linh Nguyen, Sylvia Le, Sophie Le
//File: App.java
//COM212-Prof.Tarimo
//Due date: 5/13/20

import java.util.Scanner;

/**
 * Class: App
 * Where everything happens
 * Main file of the project, which creates a console-based social networking platform focusing on a single user
 */
public class App 
{
    //only use one scanner for the entire class to avoid NoSuchElementException
    static final Scanner scan = new Scanner(System.in);

    /**
     * Functions after a new account has been created or existing account has been loaded
     * @param p profile of current user from MySocialProfile class
     */
    public static void homeScreen(MySocialProfile p) throws InterruptedException {
   
        boolean logout = false;         // flag check for log out
        
        while (!logout)
        {    // run until user chooses 5
            System.out.println("\n[HOME SCREEN]");

            // display next event scheduled to take place
            if (!p.userEvents.isEmpty()) p.userEvents.getLatestEvent();
            else System.out.println("Upcoming event: ");
           
            // display three recent posts
            System.out.print("Recent posts: ");
            p.posts.display();
            // display list of upcoming events
            System.out.print("Other events: ");
            System.out.print(p.userEvents.display());
            System.out.println("\n\n(1) Post to timeline\n(2) Add an event\n(3) View list of friends");
            System.out.println("(4) Add/remove a friend\n(5) Log out\nEnter a number to proceed:");
            
            char choice = scan.next().charAt(0);
            switch (choice){
                case '1':     
                    p.post(); //call input
                    break;
                case '2':     // add event
                    p.addEvent();
                    break;
                case '3':     // view friend list
                    p.listFriend();
                    java.lang.Thread.sleep(2000);
                    break;
                case '4':     // add/remove friend              
                    p.manageFriend();  //call input
                    break;
                case '5':     // log out
                    System.out.println("You have logged out");
                    logout = true;
                    java.lang.Thread.sleep(2000);
                    break;
                default:
                    System.out.println("Please try again");
                    java.lang.Thread.sleep(2000);
            }
            
        }
        
    }

    /**
     * Greeting. The first screen that the user see
     */
    public static void main(String[] args) throws InterruptedException {

        MySocialProfile currentUser = new MySocialProfile();
        boolean exit = false;       // flag check for exit

        System.out.println("\n*-*-*- Welcome to MySocialProfile! -*-*-*");
        while (!exit){      // run until user chooses e
            System.out.println("\n[MAIN MENU]\n(1) Create a new profile\n(2) Load an existing profile");
            System.out.println("(3) Exit program\nEnter a number to proceed:");

            char choice = scan.next().charAt(0);
            switch (choice){
                case '1':       // create a new profile
                    System.out.println("---You chose to create a new profile---");
                    java.lang.Thread.sleep(2000);
                    currentUser.createNewAcc();
                    java.lang.Thread.sleep(2000);
                    homeScreen(currentUser);
                    break;
                case '2':       // load an existing profile
                    System.out.println("---You chose to load an existing profile---");
                    java.lang.Thread.sleep(2000);
                    currentUser.loadprofile();
                    java.lang.Thread.sleep(2000);
                    homeScreen(currentUser);
                    break;
                case '3':       // exit program
                    System.out.println("---Have a good day [¬°-°]¬ ---");
                    exit = true;
                    break;
                default:
                    System.out.println("---Please try again---");
                    java.lang.Thread.sleep(2000);
            }
        }
    }
}
