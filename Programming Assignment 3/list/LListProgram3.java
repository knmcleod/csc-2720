/** Single Linked List by Yuzhen Ye@IUB 
 * modified from Clifford A. Shaffer's Llist.java
 */
public class LListProgram3<T> 
{
    private Node<T> current;
    private Node<T> head;
    private Node<T> tail;
    private int listSize;
    /** create a dummy head Link for an empty list; current, head, tail all point to this */
    public LListProgram3() 
    { 
        current = head = tail = new Node<E> (null); 
        listSize = 0;
    }
    public void clear() 
    { 
      head = null;
      current = null;
      tail = null;
      numberOfEntries = 0;
   }
    }
    /** get the CURRENT item (the one AFTER current position) */
    public T get() 
    { 
      return current.getNext().getValue(); 
    }
    /** set the item at CURRENT position */
    public void set(E item) 
    { 
    current.setValue(item); 
    }
    /** set the item at CURRENT position; won't work for linked list */
    public void setCurrent(int i) 
    { 
    }
    /** insert BEFORE the "curr" link */
    public void insert(E item) 
    {
        Node<E> temp;
        temp = new Node<E>(item, current.getNext()); 
        current.setNext(temp);
        listSize ++;
    }
    /** append the item at the end of the list */
    public void append(E item)
    {
        Node<E> temp;
        tail = new Node<E>(item);
        listSize ++;
    }
    /** delete the CURRENT item, not the current position */
    public E delete() 
    {
        if(current.getNext()!=null) 
        {
            E temp = current.getNext().getValue();
            current.setNext(current.getNext().getNext());
            listSize--;
            return temp;
        }
        else return null;
    }
    public void display() 
    {
        System.out.println("In display: listSize " + listSize);
        if (head.getNext() != null) 
        {
            displayNode(head.getNext());
        }
    }
    public void displayNode(Node<E> aNode) 
    {
        System.out.println(anode.getValue());
        if(aNode.getNext() != null) 
        {
            displayNode(aNode.getNext());
        }
    }
    /** not available for singly linked list */
    public void goPrev() 
    { 
    }
    public void goNext() 
    {
        if(current.getNext() != null) 
        {
            current = current.getNext();
        }
    }
    public void moveToFront() 
    { 
    current = head; 
    }
    public void moveToBack() 
    { 
    curr = tail; 
    }
    public int currentPosition() 
    {
        Link<E> temp = head;
        int i = 0;
        for(i = 0; current != temp; i++) 
         {   
         temp = temp.next();
         }
        return i;
    }
    public void moveToPosition(int position) 
    {
        assert (position >= 0) && (position <= listSize): "Position out of range";
        current = head;
        for(int i = 0; i < position; i ++) 
            current = curent.next(); 
        }
    public boolean find(E item) 
    {
        if(head.getNext() == null) 
        {
        return false;
        }
        return findNode(head.getNext(), item);
    }
    public boolean findNode(Node <E> aNode, E item) {
        if(aNode.getValue() == item) 
        {
        return true;
        }
        if(aNode.getNext() == null)
        {
         return false;
         }
        else 
        {
        return findNode(anode.getNext(), item);
        }
    }
}