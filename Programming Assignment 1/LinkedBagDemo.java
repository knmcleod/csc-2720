import java.util.Scanner;
/** LinkedBagDemo.java
 * A demo for a class of bags whose entries are stored in a chain of linked nodes.
 * The bag is never full.
 * @author Kerra McLeod
 * @version 2.0.6
 */
public class LinkedBagDemo
{ 
   public static void main(String[] args) 
   { 
      Scanner input = new Scanner(System.in);
      BagInterface<String> aBag = new LinkedBag<>(); 
      System.out.println("How many names would you like to add?");
      if(input.hasNextInt())
      {
         int nameCount = input.nextInt();
         input.nextLine();
         for(int i = 0; i < nameCount; i++)
         { 
            System.out.println("What name would you like to add?");
            String name = input.nextLine();
            aBag.add(name); 
         } 
         System.out.println("What name would you like to remove?");
         String nameRemoved = input.nextLine();
         aBag.remove(nameRemoved);
         System.out.println("What name would you like to check for?");
         String nameChecked = input.nextLine();
         aBag.contains(nameChecked);
         aBag.toArray();
      
      }
      else
      {
         System.out.println("Error: Please enter an integer.");
      }
   } // end main 
}

/**
 ----jGRASP exec: java --module-path C:\Program Files (x86)\Java\javafx-sdk-11.0.2\lib --add-modules=javafx.controls LinkedBagDemo
 How many names would you like to add?
 3
 What name would you like to add?
 Kerra
 Kerra has been added.
 What name would you like to add?
 Erin
 Erin has been added.
 What name would you like to add?
 Daniel
 Daniel has been added.
 What name would you like to remove?
 Erin
 Erin has been removed.
 What name would you like to check for?
 Kerra
 Kerra is in the bag.
 Contents of Bag: [Daniel, Kerra]
 
  ----jGRASP: operation complete.
*/
