import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ContactBook {

    //initialize linked list and scanner
    LinkedList<Contact> LL = new LinkedList<Contact>();
    static Scanner scanner = new Scanner(System.in);


    //add contact function
    public void addContact(){
        String name, phoneNumber, email;

        //input name
        System.out.print("Enter name: ");
        name = scanner.nextLine();

        //input phone number
        System.out.print("Enter phone number: ");
        phoneNumber = scanner.nextLine();

        //input email
        System.out.print("Enter email: ");
        email = scanner.nextLine();

        //make a contact from the input and add it to the linked list
        Contact con1 = new Contact(name, phoneNumber, email);
        LL.add(con1);
        System.out.println("Added successfully");
    }


    //delete contact function
    public void deleteContact(){
        //check if linked list is empty or not
        if(LL.isEmpty()){
            System.out.println("Your current contactbook is empty.");
        }
        else{
            //user input
            System.out.print("What name/phonenumber/email do you want to delete? ");
            String answer = scanner.nextLine();

            //initialize iterator
            Iterator<Contact> it = LL.iterator();
            Contact current = it.next();

            //check if the input exists or not
            while(!(current.getName().equals(answer)) && !(current.getEmail().equals(answer)) && !(current.getPhoneNumber().equals(answer))){
                //when the iterator already in the end of the list
                if(!(it.hasNext())){
                    System.out.println(answer + " cannot be found in the contactbook");
                    break;
                }
                current = it.next();
            }

            //remove contact based on the user input
            if(current.getName().equals(answer) || current.getPhoneNumber().equals(answer) || current.getEmail().equals(answer)){
                LL.remove(current);
                System.out.println("Deleted successfully.");
            }
        }
    }


    //print all the contacts
    public void printContact(){
        //check if the linked list is empty or not
        if(LL.isEmpty()){
            System.out.println("Your current contactbook is empty.");
        }
        else{
            //printing all the contacts
            System.out.println("\nYour current contactbook: ");
            for(Contact i:LL){
                System.out.println("Contact (" + (LL.indexOf(i)+1) + ")");
                System.out.println("Name: "+ i.getName());
                System.out.println("Phone number: "+ i.getPhoneNumber());
                System.out.println("Email: "+ i.getEmail());
                System.out.println();
            }
        }
    }


    //search based on email
    public void emailSearch(){
        //check if the linked list is empty or not
        if(LL.isEmpty()){
            System.out.println("Your current contactbook is empty.");
        }
        else{
            //user input
            System.out.print("Input email: ");
            String emailAnswer = scanner.nextLine();

            //initialize iterator
            Iterator<Contact> it = LL.iterator();
            Contact current = it.next();

            //check if the input exists or not
            while(!(current.getEmail().equals(emailAnswer))){
                if(!(it.hasNext())){
                    System.out.println(emailAnswer + " cannot be found in the contactbook");
                    break;
                }
                current = it.next();
            }

            //output if the input exists
            if(current.getEmail().equals(emailAnswer)){
                System.out.println("\nContact (" + (LL.indexOf(current)+1) + ")");
                System.out.println("Name: "+ current.getName());
                System.out.println("Phone number: "+ current.getPhoneNumber());
                System.out.println("Email: "+ current.getEmail());
            }  

        }
    }


    //search based on name or phone number
    public void contactSearch(){
        //check if the linked list is empty or not
        if(LL.isEmpty()){
            System.out.println("Your current contactbook is empty.");
        }
        else{
            //user input
            System.out.print("Search for name or phonenumber: ");
            String answer = scanner.nextLine();

            //initialize the iterator
            Iterator<Contact> it = LL.iterator();
            Contact current = it.next();

            //check if the input exists or not
            while(!(current.getPhoneNumber().equals(answer)) && !(current.getName().equals(answer))){
                if(!(it.hasNext())){
                    System.out.println(answer + " cannot be found in the contactbook");
                    break;
                }
                current = it.next();
            }

            //output if the user input exists
            if(current.getPhoneNumber().equals(answer) || current.getName().equals(answer)){
                System.out.println("\nContact (" + (LL.indexOf(current)+1) + ")");
                System.out.println("Name: "+ current.getName());
                System.out.println("Phone number: "+ current.getPhoneNumber());
                System.out.println("Email: "+ current.getEmail());
            }  

        }
    }


    //main function
    public static void main (String[] args) {
        ContactBook contactBook = new ContactBook();

        while(true){
            System.out.println("\n************************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("************************************");
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine();
            command = command.toUpperCase();

            switch (command) {
                case "A":
                    contactBook.addContact();
                    break;
                case "D":
                    contactBook.deleteContact();
                    break;
                case "E":
                    contactBook.emailSearch();
                    break;
                case "P":
                    contactBook.printContact();
                    break;
                case "S":
                    contactBook.contactSearch();
                    break;
                case "Q":
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }


    }
}