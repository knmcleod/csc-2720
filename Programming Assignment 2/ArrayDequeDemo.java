/**
* This program will implement a deque by
* using an array to contain its entries.
*
* @author  Kerra McLeod
* @version 1.0
*/
import java.util.*; 
public class ArrayDequeDemo
{ 
   public static void main(String[] args) 
   { 
      System.out.println("This program will implement a deque by using an array to contain its entries.");
      System.out.println("Select Following Options by Entering the Corresponding Numbers Given:");
      Deque<Object> deque = new ArrayDeque<Object>();
      Scanner in = new Scanner(System.in); 
      Object input;
      int menu;
      int value;
      do
      {  
         System.out.println("---------------------");        
         System.out.println("1: Front Functions.");
         System.out.println("2: Back Functions.");
         System.out.println("3: Check if Empty.");
         System.out.println("4: Clear Array.");
         System.out.println("5: End.");
         menu = in.nextInt();
         if(menu > 5 || menu < 1)
         {
            System.out.println("Number Input Error: Please Enter a Number Corresponding to an Action.");
         } 
         switch (menu)
         {
            case 1: // Front functions
               System.out.println("1: Add to Front. \n2: Remove from Front. \n3: Get Front. \n4: Go back to main options.");
               value = in.nextInt();
               if(value > 4 || value < 1)
               {
                  System.out.println("Number Input Error: Please Enter a Number Corresponding to an Action.");
               } 
               in.nextLine();
               switch(value)
               {
                  case 1: //adding to the front
                     System.out.println("What would you like to add to the front?");
                     input = in.nextLine();
                     deque.addFirst(input);
                     System.out.println("The front is now " + deque.getFirst() + ".");
                     break;
                  
                  case 2: //removing from the front
                     System.out.println("Removing Front.");
                     deque.removeFirst();
                     if(deque.peekFirst() == null)
                     {
                        System.out.println("The array is now empty.");
                     }
                     else
                     {  
                        System.out.println("The front is now " + deque.getFirst() + ".");
                     }
                     break;
                   
                  case 3: //getting front
                     System.out.println("Getting front.");
                     if(deque.peekFirst() == null)
                     {
                        System.out.println("The array is empty.");
                     }
                     else
                     {  
                        System.out.println("The front is " + deque.getFirst() + ".");
                     }
                     break;
                     
                  case 4: //Go back
                     System.out.println("Going back to main options.");
                     break;
               }  
               break;
               
            case 2: // Back functions
               System.out.println("1: Add to Back. \n2: Remove Back. \n3: Get Back. \n4: Go back to main options.");
               value = in.nextInt();
               if(value > 4 || value < 1)
               {
                  System.out.println("Number Input Error: Please Enter a Number Corresponding to an Action.");
               } 
               in.nextLine();
               switch(value)
               {
                  case 1: //adding to back
                     System.out.println("What would you like to add to the back?");
                     input = in.nextLine();
                     deque.addLast(input);
                     System.out.println("The back is now " + deque.getLast() + "."); 
                     break;
                  
                  case 2: //removing from back
                     System.out.println("Removing back.");
                     deque.removeLast(); 
                     if(deque.peekFirst() == null)
                     {
                        System.out.println("The array is now empty.");
                     }
                     else
                     {  
                        System.out.println("The back is now " + deque.getLast() + ".");
                     }
                     break; 
               
                  case 3: //getting back
                     System.out.println("Getting back.");
                     if(deque.peekFirst() == null)
                     {
                        System.out.println("The array is empty.");
                     }
                     else
                     {  
                        System.out.println("The back is " + deque.getLast() + ".");
                     } 
                     break;
                     
                  case 4: //Go back
                     System.out.println("Going back to main options.");
                     break;
               }
               break;
                               
            case 3: //checks if empty
               System.out.println("Checking if empty.");
               if(deque.isEmpty())
               {
                  System.out.println("Array is empty.");
               }
               else
               {
                  System.out.println("Array is not empty. Printing the array from first to last: " + deque);
               }
               break;
                
            case 4: // clears
               System.out.println("Clearing array");
               deque.clear();
               if(deque.isEmpty())
               {
                  System.out.println("Clearing was successful.");
               }
               else
               {
                  System.out.println("Clearing was unsuccessful.");
               }
               break;   
         
            case 5: //ends
               System.out.println("Goodbye!");
               break;   
         }     
      }
      while(menu != 5);              
   }
}
/** testing 
  ----jGRASP exec: java --module-path C:\Program Files (x86)\Java\javafx-sdk-11.0.2\lib --add-modules=javafx.controls ArrayDequeDemo
 This program will implement a deque by using an array to contain its entries.
 Select Following Options by Entering the Corresponding Numbers Given:
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 1
 1: Add to Front. 
 2: Remove from Front. 
 3: Get Front. 
 4: Go back to main options.
 1
 What would you like to add to the front?
 10
 The front is now 10.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 1
 1: Add to Front. 
 2: Remove from Front. 
 3: Get Front. 
 4: Go back to main options.
 1
 What would you like to add to the front?
 test
 The front is now test.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 2
 1: Add to Back. 
 2: Remove Back. 
 3: Get Back. 
 4: Go back to main options.
 1
 What would you like to add to the back?
 20
 The back is now 20.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 2
 1: Add to Back. 
 2: Remove Back. 
 3: Get Back. 
 4: Go back to main options.
 1
 What would you like to add to the back?
 test #2
 The back is now test #2.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 3
 Checking if empty.
 Array is not empty. Printing the array from first to last: [test, 10, 20, test #2]
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 1
 1: Add to Front. 
 2: Remove from Front. 
 3: Get Front. 
 4: Go back to main options.
 2
 Removing Front.
 The front is now 10.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 1
 1: Add to Front. 
 2: Remove from Front. 
 3: Get Front. 
 4: Go back to main options.
 3
 Getting front.
 The front is 10.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 2
 1: Add to Back. 
 2: Remove Back. 
 3: Get Back. 
 4: Go back to main options.
 2
 Removing back.
 The back is now 20.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 2
 1: Add to Back. 
 2: Remove Back. 
 3: Get Back. 
 4: Go back to main options.
 3
 Getting back.
 The back is 20.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 3
 Checking if empty.
 Array is not empty. Printing the array from first to last: [10, 20]
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 4
 Clearing array
 Clearing was successful.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 3
 Checking if empty.
 Array is empty.
 ---------------------
 1: Front Functions.
 2: Back Functions.
 3: Check if Empty.
 4: Clear Array.
 5: End.
 5
 Goodbye!
 
  ----jGRASP: operation complete.
*/