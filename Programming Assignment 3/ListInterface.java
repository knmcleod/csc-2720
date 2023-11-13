/**
* ListInterface
* 
* @author  Kerra McLeod
* @version 1.0
*/
public interface ListInterface<T>
{
   /** 
      Gets Front
      @return front
   */
   public T getFront();
   
   /**
      Checks if empty
      @return true or false
   */
   public boolean isEmpty();
   
   /** 
      Adds a new entry to the end of this list.
      @param newEntry
   */
   public void add(T newEntry);
   
   /** 
      Adds new entry to list by inserting it at given position 
      @param newPosition and newEntry
   */
   public void add(int newPosition, T newEntry);
   
   /** 
      Removes the entry at the given position in this list
      @param givenPosition
      @return result
   */
   public T remove(int givenPosition);
   
   /** 
      Removes all entries from this list
   */
   public void clear();
   
   /** 
      Change the contents of an entry at a specific spot
      @param givenPosition and newEntry
      @return true or false
   */
   public boolean replace(int givenPosition, T newEntry);
   
   /** 
      Gets the entry at the given position within this list
      @param index given by user
      @return entry
   */
   public T getEntry(int index);
   
   /** 
      Sees whether a given entry occurs in this list
      @param anEntry
      @return true or false
   */
   public boolean contains(T anEntry);
   
   /** 
      Gets the size of this list
      @return length of list
   */
   public int getLength();
   
   /** 
      Retreieves all entries in this list in order
      @return array
   */
   public T[] toArray();
}