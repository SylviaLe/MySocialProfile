import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MySocialProfile
{
    public String name;
    public String email;
    public String pass;
    public int classYear;
    //public Event events;
    public SinglyLinkedStack<String> posts = new SinglyLinkedStack<>();
    public ArrayList<String> friends = new ArrayList<>();
    
    public void createNewAcc()
    {
        Scanner user = new Scanner(System.in);

        System.out.print("Please enter your email address: ");
        this.email = user.next();

        System.out.print("Please enter a password for your account: ");
        this.pass = user.next();

        System.out.print("Please enter your name: ");
        this.name = user.next();

        System.out.print("Please enter your class year: ");
        this.classYear = user.nextInt();
        user.nextLine();  //catch the carriage. DO NOT REMOVE
       
        this.posts = new SinglyLinkedStack<>();
        this.friends = new ArrayList<>();
        //this.events = new Event();
        user.close();
    }

    public void loadprofile(){
	    FileIO.doStuff("userdata.txt");
    }

    public void post()
    {
    	Scanner in = new Scanner(System.in);
    	System.out.print("What is on your mind: ");
        String newPost = in.next();
        in.nextLine();   //to catch carriage
    	
        posts.push(newPost);
        in.close();
    }
    //addEvent()
    public void manageFriend()
    {
    	Scanner in = new Scanner(System.in);
    	System.out.print("Please enter your friend's email address: ");
        String friend = in.next();
        in.nextLine();    //to catch carriage
        
        if (friends.contains(friend))
            friends.remove(friend);
        else 
            friends.add(friend);
        
        in.close();
    }
    
    public void logout()   //when the user logout, write everything into the file
    {
        try 
        {
			FileWriter fileOut = new FileWriter("newFile.txt");
			BufferedWriter bufWriter = new BufferedWriter(fileOut);
			
			bufWriter.write(name + "\n" + email + "\n" + pass + "\n" + Integer.toString(classYear) + "\n" + posts.toString() + "\n" + friends.toString());
			//for the moment, havent write the event in yet
			bufWriter.close();
            fileOut.close();
        }
        catch (IOException e) 
        {
			e.printStackTrace();
		}
    }
    

    public static void main(String[] args)
    {
        MySocialProfile profile = new MySocialProfile();
        profile.createNewAcc();
        profile.loadprofile();
        profile.post();
        profile.manageFriend();
        profile.logout();
    }
}
