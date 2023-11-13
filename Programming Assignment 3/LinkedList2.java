public class LinkedList2<T>
{
   public static void main(String[] args) 
   {
      LinkedList myList = new LinkedList();
      myList.add(0, 2);
      myList.add(0, 1);
      System.out.println(myList.getEntry(1));
   	
      myList.add(0, 0);
      System.out.println(myList);
   	
      myList.add(1, 5);
      System.out.println(myList);
   	
      myList.remove(2);
      System.out.println(myList);
   }
	
   private Node<T> head;
   private Node<T> tail;
   private int numberOfEntries;
   public LinkedList2() 
   {
      head = null;
   }
   
   public void clear()
   {
      head = null;
      tail = null;
      numberOfEntries = 0;
   }
	
   public T getEntry(int index) 
   {
      Node<T> current = head;
      int count = 0;
      while (count < index) {
         current = current.getNext();
         if (current == null) 
         {
            throw new IndexOutOfBoundsException("Cannot find item at position " + index);
         }
         count++;
      }
      return current.getData();
   }

   public void add(int newPosition, T newEntry) 
   {
      Node<T> newNode = new Node<T>(newEntry, null);
   	
      if (newPosition == 0) {
         newNode.setNext(head);
         head = newNode;
         return;
      }
   	
      Node current = head;
      int count = 0;
      while (count < newPosition - 1) 
      {
         current = current.getNext();
         if (current == null) 
         {
            throw new IndexOutOfBoundsException("Cannot find item at position " + (newPosition-1));
         }
         count++;
      }
   	
      newNode.setNext(current.getNext());
      current.setNext(newNode);
   }
	
   public void remove(int givenPosition) 
   {
      if (givenPosition == 0) 
      {
         head = head.getNext();
         return;
      }
   	
      Node<T> current = head;
      int count = 0;
      while (count < givenPosition - 1) 
      {
         current = current.getNext();
         if (current == null) 
         {
            throw new IndexOutOfBoundsException("Cannot find item at position " + (givenPosition - 1));
         }
         count++;
      }
   	
      if (current.getNext() == null) 
      {
         throw new IndexOutOfBoundsException("Cannot find item at position " + givenPosition);
      }
   	
      current.setNext(current.getNext().getNext());
   }
   
   public int getLength() 
   { 
      return numberOfEntries; 
   } // end getLength

   
   public boolean isEmpty()
   {
      boolean result;
      if(numberOfEntries == 0)
      {
         assert head == null : "numberOfEntries is 0 but head is not null";
         result = true;
      }
      else
      {
         assert head != null : "numberOfEntries is not 0 but head is null";
         result = false;
      }
      return result;
   }//end isEmpty

   
   public boolean contains(T anEntry)
   {
      boolean found = false;
      Node<T> currentNode = head;
      while(!found && (currentNode != null))
      {
         if(anEntry.equals(currentNode.getData()))
         {
            found = true;
         }
         else
         {
            currentNode = currentNode.getNext();
         }
      }
      return found;
   }//end contains

   
   public boolean replace(int givenPosition, T newEntry)
   {
      boolean isSuccessful = true;
      if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         Node<T> desiredNode = getNodeAt(givenPosition);
         desiredNode.setData(newEntry);
      }
      else
      {
         isSuccessful = false;
      }
      return isSuccessful;
   }//end replace

   public String toString() 
   {
      String output = "";
      Node current = head;
      while (current != null) {
         output += current.getData() + ", ";
         current = current.getNext();
      }
   	
      return output;
   }
   
   public T[] toArray()
   {
      // The cast is safe because the new array contains null entries 
      @SuppressWarnings("unchecked") 
         T[] result = (T[])new Object[numberOfEntries];
      int index = 0;
      Node<T> currentNode = head;
      while((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.getData();
         currentNode = currentNode.getNext();
         index++;
      }
      return result;
   } //end toArray

   private Node<T> getNodeAt(int givenPosition)
   {
      Node<T> currentNode = head;
      for(int counter = 1; counter < givenPosition; counter++)
      {
         currentNode = currentNode.getNext();
      }
      return currentNode;
   } //end getNodeAt
}