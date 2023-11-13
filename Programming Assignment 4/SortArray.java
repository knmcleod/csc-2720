import java.util.Date;
import java.util.*;
/** 
 Class for sorting an array of Comparable objects from smallest to largest. 
*/ 
public class SortArray 
{ 
   public static void main(String[] args)
   {
      Random rd = new Random(); // creating Random object
      int[] arr = new int[50000];
      for (int i = 0; i < arr.length; i++) 
      {
         arr[i] = rd.nextInt(); // storing random integers in an array
      }
      Date current = new Date(); // Get current time 
      long startTime = current.getTime(); 
      quickSort(arr, 0, 49999); // Code to be timed 
      current = new Date(); // Get current time 
      long stopTime = current.getTime(); 
      long elapsedTime = stopTime - startTime; // Milliseconds
   }
 
 /** Sorts an array into ascending order. 
 Uses quick sort with median-of-three pivot selection for arrays of at least 
 MIN_SIZE entries, and uses insertion sort for smaller arrays. */ 
   public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) 
   { 
      if (last - first + 1 < MIN_SIZE) 
      { 
         insertionSort(a, first, last); 
      }
      else
      { 
      // Create the partition: Smaller | Pivot | Larger 
         int pivotIndex = partition(a, first, last); 
      // Sort subarrays Smaller and Larger 
         quickSort(a, first, pivotIndex - 1); 
         quickSort(a, pivotIndex + 1, last); 
      } // end if
   } // end quickSort
   
   /* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
   array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
   public int partition(int[] arr, int low, int high)
   {
     
    // pivot
      int pivot = arr[high];
     
    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
      int i = (low - 1);
   
      for(int j = low; j <= high - 1; j++)
      {
         
        // If current element is smaller
        // than the pivot
         if (arr[j] < pivot)
         {
             
            // Increment index of
            // smaller element
            i++;
            swap(arr, i, j);
         }
      }
      swap(arr, i + 1, high);
      return (i + 1);
   }
   /**
   Algorithm partition(a, first, last);
   // Partitions an array a[first..last] as part of quick sort into two subarrays named 
   // Smaller and Larger that are separated by a single entry—the pivot—named pivotValue. 
   // Entries in Smaller are <= pivotValue and appear before pivotValue in the array. 
   // Entries in Larger are >= pivotValue and appear after pivotValue in the array. 
   // Precondition: first >= 0; first < a.length; last – first >= 3; last < a.length. 
   // Returns the index of the pivot. 
   mid = index of the array’s middle entry;
   sortFirstMiddleLast(a, first, mid, last);
   // Assertion: a[mid] is the pivot, that is, pivotValue; 
   // a[first] <= pivotValue and a[last] >= pivotValue, so do not compare these two 
   // array entries with pivotValue. 
   // Move pivotValue to next-to-last position in array 
      Exchange a[mid] and a[last – 1];
      pivotIndex = last – 1;
      pivotValue = a[pivotIndex];
   // Determine two subarrays: 
   Smaller = a[first..endSmaller];
   Larger = a[endSmaller+1..last–1];
   // such that entries in Smaller are <= pivotValue and 
   // entries in Larger are >= pivotValue. 
   // Initially, these subarrays are empty. 
   indexFromLeft = first + 1;
   indexFromRight = last - 2;
   done = false;
   while (!done) 
   { 
   // Starting at indexFromLeft leave entries that are < pivotValue and 
   // locate the first entry that is >= pivotValue. You will find one, since the last 
   // entry is >= pivotValue. 
   while (a[indexFromLeft] < pivotValue)
   {
      indexFromLeft++;
   } 
   // Starting at indexFromRight leave entries that are > pivotValue and 
   // locate the first entry that is <= pivotValue. You will find one, since the first 
   // entry is <= pivotValue. 
   while (a[indexFromRight] > pivotValue)
   {
      indexFromRight--;
   } 
   // Assertion: a[indexFromLeft] >= pivotValue and 
   // a[indexFromRight] <= pivotValue 
   if (indexFromLeft < indexFromRight) 
   { 
      Exchange a[indexFromLeft] and 
      a[indexFromRight]
      indexFromLeft++;
      indexFromRight--;
   } 
   else 
      done = true 
   } // Place pivotValue between the subarrays Smaller and Larger 
   Exchange a[pivotIndex] and 
   a[indexFromLeft] 
   pivotIndex = indexFromLeft; 
   // Assertion: Smaller = a[first..pivotIndex–1] 
   //       pivotValue = a[pivotIndex] 
   //       Larger = a[pivotIndex+1..last] 
   return pivotIndex;
   */
   
 /** Sorts the first n objects in an array into ascending order. 
 @param a An array of Comparable objects. 
 @param n An integer > 0. */ 
   public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) 
   { 
      for (int index = 0; index < n-1; index++) 
      { 
         int indexOfNextSmallest = getIndexOfSmallest(a, index, n-1); 
         swap(a, index, indexOfNextSmallest); 
      // Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[i]. 
      } // end for 
   } // end selectionSort 
 
 // Finds the index of the smallest value in a portion of an array a. 
 // Precondition: a.length > last >= first >= 0. 
 // Returns the index of the smallest value among 
 // a[first], a[first + 1], . . . , a[last]. 
   private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) 
   { 
      T min = a[first]; 
      int indexOfMin = first; 
      for (int index = first + 1; index <= last; index++) 
      { 
         if (a[index].compareTo(min) < 0) 
         { 
            min = a[index]; 
            indexOfMin = index; 
         } // end if 
      // Assertion: min is the smallest of a[first] through a[index]. 
      } // end for 
   
      return indexOfMin; 
   } // end getIndexOfSmallest 
 
 // Swaps the array entries a[i] and a[j].
   private static void swap(Object[] a, int i, int j) 
   {
      Object temp = a[i]; 
      a[i] = a[j]; 
      a[j] = temp; 
   } // end swap 
} // end SortArray