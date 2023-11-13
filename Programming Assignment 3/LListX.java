/** 
A linked implementation of the ADT list. 
*/ 
public class LListX<Object> implements ListInterfaceX<Object>
{ 
   private Node<Object> dummy;
   private Node firstNode;
   private Node lastNode;
   private Node nodeBefore;
   private Node nodeAfter;
   private int numberOfEntries; 
 
   public LListX() 
   { 
      dummy = new Node(null, null);
      initializeDataFields(); 
   } // end default constructor 
 
   public void clear() 
   { 
      initializeDataFields(); 
   } // end clear 
   
   // Locates a given entry within this bag. 
   // Returns a reference to the node containing the entry, if located, 
   // or null otherwise. 
   private Node getReferenceTo(Object anEntry) 
   { 
      boolean found = false; 
      Node currentNode = firstNode; 
      while (!found && (currentNode != null)) 
      { 
         if (anEntry.equals(currentNode.data)) 
         {
            found = true; 
         }
         else 
         {
            currentNode = currentNode.next; 
         }
      } // end while 
      return currentNode; 
   } // end getReferenceTo
   
 /** Adds a new entry to this bag. 
 @param newEntry The object to be added as a new entry. 
 */ 
   public void add(Object newEntry)
   {
      Node newNode = new Node(newEntry);
      if (isEmpty())
      {
         firstNode = newNode;
      }
      else
      {
         lastNode.setNextNode(newNode);
      }
      lastNode = newNode;
      numberOfEntries++;
   }
   
   public void add(int givenPosition, Object newEntry)
   {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
      {
         Node newNode = new Node(newEntry);
         if (givenPosition == 1) // Case 1
         {
            newNode.setNextNode(firstNode);
            firstNode = newNode;
         }
         else // Case 2: list is not empty and givenPosition > 1Node
         {                                      
            nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
         } // end if
         numberOfEntries++;
      }
      else
      {
         throw new IndexOutOfBoundsException("Illegal position given to add operation.");
      }
   }
   
   public boolean remove(Object anEntry) 
   { 
      boolean result = false; 
      Node nodeN = getReferenceTo(anEntry); 
      if (nodeN != null) 
      { nodeN.data = firstNode.data; 
      // Replace located entry with entry 
      // in first node 
         firstNode = firstNode.next; 
      // Remove first node 
         numberOfEntries--; 
         result = true; 
      } // end if 
      return result; 
   } // end remove
   
   public Object remove(int givenPosition)
   {
      Object result = null;                           // Return value
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
      // Assertion: !isEmpty()
         if (givenPosition == 1)                 // Case 1: Remove first entry
         {
            result = firstNode.getData();        // Save entry to be removed
            firstNode = firstNode.getNextNode(); // Remove entry
         }
         else// Case 2: Not first entry
         {Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeToRemove = nodeBefore.getNextNode();
            result = nodeToRemove.getData();    // Save entry to be removedNode 
            nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);  // Remove entry
         } // end if
         numberOfEntries--;                     // Update count
         return result;                         // Return removed entry
      }
      else
      {
         throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
      }
   }
   
   public boolean contains(Object anEntry) 
   { 
      boolean found = false; 
      Node currentNode = firstNode; 
      while (!found && (currentNode != null)) 
      { 
         if (anEntry.equals(currentNode.data)) 
         {
            found = true; 
         }
         else 
         {
            currentNode = currentNode.next;
         } 
      } // end while 
      return found; 
   } // end contains
   
   public boolean isEmpty()
   {
      boolean result;
      if(numberOfEntries == 0)
      {
         //Assertion: firstNode == null
         result = true;
      }
      else
      {
      //Assertion: firstNode != null
         result = false;
      }
      return result;
   }
   
   public Object replace(int givenPosition, Object newEntry)
   {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
      // Assertion: !isEmpty()
         Node desiredNode = getNodeAt(givenPosition);
         Object originalEntry = desiredNode.getData();
         desiredNode.setData(newEntry);
         return originalEntry;
      }
      else
      {
         throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
      }
   } // end replace
   
   public Object getEntry(int givenPosition)
   {
      if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         //Assertion: !isEmpty()
         return getNodeAt(givenPosition).getData();
      }
      else
      {
         throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
      }
   }
   
   /** Retrieves all entries that are in this bag. 
   @return A newly allocated array of all the entries in the bag. 
   */ 
   public Object[] toArray() 
   { 
   // The cast is safe because the new array contains null entries 
      @SuppressWarnings("unchecked") 
         Object[] result = (Object[])new Object[numberOfEntries]; 
   // Unchecked cast 
      int index = 0; 
      Node currentNode = firstNode; 
      while ((index < numberOfEntries) && (currentNode != null)) 
      { 
         result[index] = currentNode.data; 
         index++; 
         currentNode = currentNode.next; 
      } // end while 
      return result; 
   } // end toArray
   public int getLength() 
   { 
      return numberOfEntries; 
   } // end getLength
  
 
 // Initializes the class’s data fields to indicate an empty list. 
   private void initializeDataFields() 
   { 
      firstNode = null; 
      numberOfEntries = 0; 
   } // end initializeDataFields 
 
 // Returns a reference to the node at a given position. 
 // Precondition: The chain is not empty; 
 // 1 <= givenPosition <= numberOfEntries. 
   private Node getNodeAt(int givenPosition) 
   { 
   // Assertion: (firstNode != null) && 
   // (1 <= givenPosition) && (givenPosition <= numberOfNodes) 
      Node currentNode = firstNode; 
   // Traverse the chain to locate the desired node 
   // (skipped if givenPosition is 1) 
      for (int counter = 1; counter < givenPosition; counter++) 
      { 
         currentNode = currentNode.getNextNode(); 
      }
   // Assertion: currentNode != null 
      return currentNode;
   } // end getNodeAt

   private class Node<T>
   { 
      private T data; // Entry in bag 
      private Node next; // Link to next node
      private Node(T dataPortion) 
      { 
         this(dataPortion, null); 
      } // end constructor 
   
      private Node(T dataPortion, Node nextNode) 
      { 
         data = dataPortion; 
         next = nextNode; 
      } // end constructors 
   
      private Object getData() 
      { 
         return data; 
      } // end getData 
   
      private void setData(T newData) 
      { 
         data = newData; 
      } // end setData 
   
      private Node getNextNode() 
      { 
         return next; 
      } // end getNextNode 
   
      private void setNextNode(Node nextNode) 
      { 
         next = nextNode; 
      } // end setNextNode  
   } // end Node
} // end LList