/**
* This program will test LList
* 
* @author  Kerra McLeod
* @version 1.0
*/
public class LListTest<T> extends LList<T>
{ 
 
   public static void main(String[] args)
   {    
      System.out.println("Create an empty list.");
      ListInterface<String> myList = new LList<String>();
      System.out.println("\nTesting dummy:");
      displayList(myList);
      System.out.println("List should be empty; isEmpty returns " + myList.isEmpty() + ".");
      System.out.println("\nTesting adding features.");
      myList.add("15");
      myList.add("25");
      myList.add("5");
      myList.add(1, "50");
      System.out.println("List shouldn't be empty; isEmpty returns " + myList.isEmpty() + ".");
      displayList(myList);
      System.out.println("List should contain 50, 15, 25, 5 ");
      System.out.println("\nTesting clear():");
      myList.clear();
      System.out.println("List should be empty; isEmpty returns " + myList.isEmpty() + ".");
   
   } // end main
   
   public static void displayList(ListInterface<String> list)
   {
      int numberOfEntries = list.getLength();
      System.out.println("The list contains " + numberOfEntries + " entries, as follows: ");
      for(int position = 1; position <= numberOfEntries; position++)
      {
         System.out.println(list.getEntry(position) + " is entry " + position);
      }
   } //end displayList
}
/**
  ----jGRASP exec: java --module-path C:\Program Files (x86)\Java\javafx-sdk-11.0.2\lib --add-modules=javafx.controls LListTest
 Create an empty list.
 
 Testing dummy:
 The list contains 0 entries, as follows: 
 List should be empty; isEmpty returns true.
 
 Testing adding features.
 List shouldn't be empty; isEmpty returns false.
 The list contains 4 entries, as follows: 
 50 is entry 1
 15 is entry 2
 25 is entry 3
 5 is entry 4
 List should contain 50, 15, 25, 5 
 
 Testing clear():
 List should be empty; isEmpty returns true.
 
  ----jGRASP: operation complete.
 
*/