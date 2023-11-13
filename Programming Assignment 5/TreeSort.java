/**
   Assignment: Devise an algorithm that uses a binary search tree to sort (for simplicity don't allow duplicate data) 
   an array of objects (could be Integers). Such a sort is called tree sort. Implement and test your algorithm.
   @author: Kerra McLeod
   @version: 1.0
*/
import java.util.*;
public class TreeSort
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      TreeSort tree = new TreeSort();
      boolean verification = true;
      int numberOfEntries = 0;
      do
      {
         System.out.println("How many integers would you like to add to the array?");
         while(!in.hasNextInt())
         {
            String input = in.next();
            System.out.println("Error: Please enter how many integers you want to add to the array.");
            verification = false;
         }
         if(in.nextInt() <= 0)
         {
            System.out.println("Please enter a positive integer.");
            verification = false;
         }
         numberOfEntries = in.nextInt();
         
      }
      while(verification = false);
      
      int array[] = new int[numberOfEntries];
      
      boolean numberVerification = true;
      for (int i = 0; i < numberOfEntries; i++)
      {
         do
         {
            System.out.println("Please enter an integer to add to the array. You have " + (numberOfEntries - i) + " spaces left.");
            while(!in.hasNextInt())
            {
               String input = in.next();
               System.out.println("Error: Please enter an integer you want to add to the array. You have " + (numberOfEntries - i) + " spaces left.");
               numberVerification = false;
            }
            array[i] = in.nextInt();
         }
         while(numberVerification = false);
      }
      System.out.println("Array before sorting: " + Arrays.toString(array));
      tree.insertToTree(array);
      System.out.print("Array after sorting: ");
      tree.putInOrder(tree.root);
   }  
   
   /** 
      Class containing left and right child 
      of current node and key value
   */ 
   class Node
   {
      int key;
      Node left, right;
   
      public Node(int item)
      {
         key = item;
         left = right = null;
      }
   }

   // Root of BST
   Node root;

   // Constructor
   TreeSort()
   {
      root = null;
   }

   /** 
      This method mainly calls insertNewKey()
      @param int key
   */ 
   public void insert(int key)
   {
      root = insertNewKey(root, key);
   }
    
   /** 
      A recursive function to insert a new key in BST 
      @param Node root, int key
      @return Node
   */
   public Node insertNewKey(Node root, int key)
   {
      /* If the tree is empty,
      return a new node */
      if (root == null)
      {
         root = new Node(key);
         return root;
      }
   
      /* Otherwise, recur
      down the tree */
      if (key < root.key)
         root.left = insertNewKey(root.left, key);
      else if (key > root.key)
         root.right = insertNewKey(root.right, key);
   
      /* return the root */
      return root;
   }
    
   /** 
      A function to do inorder traversal of BST
      @param Node root
   */ 
   public void putInOrder(Node root)
   {
      if (root != null)
      {
         putInOrder(root.left);
         System.out.print(root.key + " ");
         putInOrder(root.right);
      }
   }
   /**
      Inserts array into tree
      @param int array[]
   */
   public void insertToTree(int array[])
   {
      for(int i = 0; i < array.length; i++)
      {
         insert(array[i]);
      } 
   }
}
/**
  ----jGRASP exec: java --module-path C:\Program Files (x86)\Java\javafx-sdk-11.0.2\lib --add-modules=javafx.controls TreeSort
 How many integers would you like to add to the array?
 array
 Error: Please enter how many integers you want to add to the array.
 -5
 Please enter a positive integer.
 5
 Please enter an integer to add to the array. You have 5 spaces left.
 number
 Error: Please enter an integer you want to add to the array. You have 5 spaces left.
 100
 Please enter an integer to add to the array. You have 4 spaces left.
 54
 Please enter an integer to add to the array. You have 3 spaces left.
 25
 Please enter an integer to add to the array. You have 2 spaces left.
 100
 Please enter an integer to add to the array. You have 1 spaces left.
 1
 Array before sorting: [100, 54, 25, 100, 1]
 Array after sorting: 1 25 54 100 
  ----jGRASP: operation complete.
*/
