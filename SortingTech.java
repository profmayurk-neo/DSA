/*
Q.3. Write a menu-driven Java program to implement various sorting techniques using separate user-
defined functions. The program should accept n integer elements from the user, store them in an array,
and provide a menu to select and perform the required sorting technique.
The menu should include the following options:
1. Accept Array Elements: Accept n integer elements from the user and store them in an array.
2. Quick Sort: Implement a function to sort the elements in ascending order using the Quick
Sort algorithm.
3. Selection Sort: Implement a function to sort the elements in ascending order using the Selection
Sort algorithm.
4. Insertion Sort: Implement a function to sort the elements in ascending order using the Insertion
Sort algorithm.
5. Merge Sort: Implement a function to sort the elements in ascending order using the Merge
Sort algorithm.
6. Bubble Sort: Implement a function to sort the elements in ascending order using the Bubble
Sort algorithm.
7. Display Array: Display the elements of the array after sorting.
8. Exit: Terminate the program.
Objective: To implement a menu-driven Java program using user-defined functions for Quick Sort, Selection
Sort, Insertion Sort, Merge Sort, and Bubble Sort, and understand the working of different sorting
algorithms.
*/

import java.util.Arrays;
import java.util.Scanner;

public class SortingTech {

    private static Scanner scanner = new Scanner(System.in);
    private static int[] array = null;
    private static int size = 0;

    static void acceptArrayElements() {
    	if(array == null) {
            System.out.print("Enter the number of elements: ");
            size = scanner.nextInt();
            array = new int[size];
            System.out.println("Enter the elements:");
            for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        }
    }

        
    }
    static void displayArray() {
        if (array == null) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void merge_sort(int a[],int start,int end)
    {
    	
        if(start<end)
        {
            int mid=(start+end)/2;
            merge_sort(a,start,mid);
            merge_sort(a,mid+1,end);
            merger(a,start,mid,end);
        }
    }
    static void merger(int a[],int start,int mid,int end)
    {	
    	
        int i,j;
        int temp[]=new int[a.length];
        int t_index=start;
        //set
        i=start;
        j=mid+1;
        t_index=start;
        while(i<=mid && j<=end)
        {
            if(a[i]<a[j])
                temp[t_index++]=a[i++];
            else
                temp[t_index++]=a[j++];
        }
        while(i<=mid)
            temp[t_index++]=a[i++];
        while(j<=end)
            temp[t_index++]=a[j++];
        for(i=start;i<=end;i++)//copy back to a
            a[i]=temp[i];
    }
    static void selection_sort(int a[]) 
    { 
    	
        int i,j,min,position; 
        for(i=0;i<a.length-1;i++)
		{
			min=a[i];
			position=i;//reference
			for(j=i+1;j<a.length;j++)
				{
					if(a[j]<min)
					{
						min=a[j];
						position=j;											}
				}
			 a[position]=a[i];
			a[i]=min;
		}
	}

    static void quick_sort(int a[],int start,int end)
    {
    	
	    int i=start;
        int j=end;
	    int pivot=start;
	    while(i<j)
		    {
			while(a[ j ]>a[pivot])//should be 
				j--;
			if(i<j)//if not greater than swap
				{
					int temp=a[pivot];
					a[pivot]=a[j];
					a[j]=temp;
				}
		    }
	    if(i<end)//not till end then
		    quick_sort(a,i+1,end);
    }

    static void bubble_sort(int a[])
	{
		int i,j,temp;
		for(i=0;i<a.length-1;i++)//n-1:passes
			{
				for(j=0;j<a.length-1;j++)
				//j should stop at second last so j+1 can be last
					{
					  if(a[j]>a[j+1])
						{
							temp=a[j];a[j]=a[j+1];a[j+1]=temp;
						}
					}
			}
    }
    static  void insertion_sort(int a[])
    {
        int i,j,element;
        for(i=0;i<a.length-1;i++)
        {
            element=a[i+1];//new element
		    j=i+1;//from j to Zero
            while(j>0 && a[j-1]>element)
            {
            a[j]=a[j-1];//move back
		    j--;
            }
            a[j]=element;
        }
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Accept Array Elements");
            System.out.println("2. Quick Sort");
            System.out.println("3. Selection Sort");
            System.out.println("4. Insertion Sort");
            System.out.println("5. Merge Sort");
            System.out.println("6. Bubble Sort");
            System.out.println("7. Display Array");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

             switch (choice) {
                case 1:
                    acceptArrayElements();
                    break;
                case 2:
                	if (array == null) {
                        System.out.println("Array is empty.");
                        break;}
                	int start= array[0];
                	int end=array[size-1];
                	
                    quick_sort(array, start, end);
                    System.out.println("After Sort Arrayis:"+Arrays.toString(array));
                    break;
                case 3:
                	if (array == null) {
                        System.out.println("Array is empty.");
                        break;}
                        
                    selection_sort(array);
                    System.out.println("After Sort Arrayis:"+Arrays.toString(array));
                    break;
                case 4:
                	if (array == null) {
                        System.out.println("Array is empty.");
                        break;}
                        
                    insertion_sort(array);
                    System.out.println("After Sort Arrayis:"+Arrays.toString(array));
                    break;
                case 5:
                	if (array == null) {
                        System.out.println("Array is empty.");
                        break;}
                        
                	int start1= array[0];
                	int end1=array[size-1];
                    merge_sort(array, start1, end1);
                    System.out.println("After Sort Arrayis:"+Arrays.toString(array));
                    break;
                case 6:
                	if (array == null) {
                        System.out.println("Array is empty.");
                        break;}
                  
                    bubble_sort(array);
                    System.out.println("After Sort Arrayis:"+Arrays.toString(array));
                    break;
                case 7:
             
                    displayArray();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

