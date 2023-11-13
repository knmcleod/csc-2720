/**
* This program will implement ListInterface and a dummy node
* 
* @author  Kerra McLeod
* @version 1.0
*/
public class LList<T> implements ListInterface<T>
{   
   private Node<T> head;
   private Node<T> current;
   private Node<T> tail;
   private ListInterface<Node> myList;
   private int numberOfEntries;
   
   /**
      Constructs LList
   */
   public LList()
   {
      head = null; 
   }
   
   private class Node<T>
   { 
      private T data; // Entry in bag 
      private Node<T> next; // Link to next node
      private Node(T dataPortion) 
      { 
         this(dataPortion, null); 
      } // end constructor 
   
      private Node(T dataPortion, Node nextNode) 
      { 
         data = dataPortion; 
         next = nextNode; 
      } // end constructors 
      
      private T getData() 
      { 
         return data; 
      } // end getData 
   
      private void setData(T newData) 
      { 
         data = newData; 
      } // end setData 
   
      private Node<T> getNextNode() 
      { 
         return next; 
      } // end getNextNode 
   
      private void setNextNode(Node nextNode) 
      { 
         next = nextNode; 
      } // end setNextNode  
   } // end Node

   /** 
      Removes all entries from this list
   */
   public void clear()
   {
      head = null;
      tail = null;
      numberOfEntries = 0;
   }
   
   /** 
     Gets Front
     @return front
   */
   public T getFront() 
   {
      return head.getData();
   } // end getFront
   
   /** 
     Adds new entry to list by inserting it at given position 
     @param newPosition and newEntry
   */
   public void add(int newPosition, T newEntry)
   {
      boolean isSuccessful = true;
      if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
      {
         Node<T> newNode = new Node(newEntry);
         if(isEmpty())
         {
            head = newNode;
            tail = newNode;
         }
         else if (newPosition == 1)
         {
            newNode.setNextNode(head);
            head = newNode;
         }
         else if (newPosition == numberOfEntries + 1)
         {
            tail.setNextNode(newNode);
            tail = newNode;
         }
         else
         {
            Node<T> nodeBefore = getNodeAt(newPosition - 1);
            Node<T> nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
         }//end if
         numberOfEntries++;
      }
      else
      {
         throw new IndexOutOfBoundsException("Illegal position given to add operation.");
      }
   } //end add
   
   /** 
     Adds a new entry to the end of this list.
     @param newEntry
   */
   public void add(T newEntry)
   {
      Node<T> newNode = new Node(newEntry);
      if (isEmpty())
      {
         head = newNode;
         tail = newNode;
      }
      else
      {
         tail.setNextNode(newNode);
         tail = newNode;
      }
      numberOfEntries++;
   } //end add
   
   /** 
     Removes the entry at the given position in this list
     @param givenPosition
     @return result
   */
   public T remove(int givenPosition)
   {
      T result = null;
      if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         if (givenPosition == 1)
         {
            result = head.getData();
            head = head.getNextNode();
            if (numberOfEntries == 1)
            {
               tail = null;
            }
         }
         else
         {
            Node<T> nodeBefore = getNodeAt(givenPosition - 1);
            Node<T> nodeToRemove = nodeBefore.getNextNode();
            Node<T> nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);
            result = nodeToRemove.getData();
            if (givenPosition == numberOfEntries)
            {
               tail = nodeBefore;
            }
         }
         numberOfEntries--;
         return result;
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }//end if
   }// end remove
   
   /** 
     Gets the entry at the given position within this list
     @param index given by user
     @return entry
   */
   public T getEntry(int givenPosition)
   {
      T result = null;
      if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         return getNodeAt(givenPosition).getData();
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   } //end getEntry
   
   /** 
     Change the contents of an entry at a specific spot
     @param givenPosition and newEntry
     @return true or false
   */
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
   
   /** 
     Sees whether a given entry occurs in this list
     @param anEntry
     @return true or false
   */
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
            currentNode = currentNode.getNextNode();
         }
      }
      return found;
   }//end contains
   
   /**
      Checks if empty
      @return true or false
   */
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
   
   /** 
     Gets the size of this list
     @return length of list
   */
   public int getLength() 
   { 
      return numberOfEntries; 
   } // end getLength
   
   /**
      Gets node at position
      @param givenPosition
      @return Node
   */
   private Node<T> getNodeAt(int givenPosition)
   {
      Node<T> currentNode = head;
      for(int counter = 1; counter < givenPosition; counter++)
      {
         currentNode = currentNode.getNextNode();
      }
      return currentNode;
   } //end getNodeAt
   
   /** 
     Retreieves all entries in this list in order
     @return array
   */
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
         currentNode = currentNode.getNextNode();
         index++;
      }
      return result;
   } //end toArray
   
}