package link_list_example;

import java.util.Scanner;

class Dcnode {
	int data;       // Stores the actual data
	Dcnode right,left;      // Stores the address/reference of the next node

	// Constructor to create a new node
	Dcnode(int data) {
	
	this.data = data;   // Store data in the node
	left= right = null;   // Initially, node does not point to another node
	}
}
public class Doubly_Circular {
	    Dcnode root,last;

	    void insert_left(int data)
	    {
	        Dcnode n= new Dcnode(data);//create a node

	        if(root==null)//only 1st time
	        {
	            root=last=n;
	            last.right=root; //next use for reference
	        }
	        else
	        {
	            n.right=root;//1
	            root.left=n;//2
	            root=n;
	            last.right=root;//3
	            root.left=last;
	        }

	    }

	    void insert_right(int data)
	    {
	        Dcnode n=new Dcnode(data);//create a node

	        if(root==null)//only 1st time
	        {
	        	root=last=n;
	            last.right=root;
	        }
	        else
	        {
	            last.right=n;//1
	            n.left=last;
	            last=n;//2
	            last.right=root;//3
	            root.left=last;
	        }
	    }

	    void delete_left()
	    {
	        if(root==null)
	            System.out.print("\nEmpty List");
	        else
	        {
	            Dcnode t=root;//1

	            if(root==last)//single node
	            {
	                root=last=null;
	            }
	            else
	            {
	                root= root.right;//2
	                last.right=root;//3
	            }
	            System.out.print("\n|"+t.data+"|-> deleted");
	        }
	    }

	    void delete_right()
	    {
	        if(root==null)
	            System.out.print("\nEmpty List");
	        else
	        {
	            Dcnode t,t2;

	            t=t2=root;//1

	            if(root==last)//single node
	            {
	                root=last=null;//manual deletion
	            }
	            else
	            {
	                while(t!=last)//2
	                {
	                    t2=t;
	                    t=t.right;
	                }

	                last=t2;//3
	                last.right=root;//4
	            }

	            System.out.print("\n<-|"+t.data+"|-> deleted");
	        }
	    }

	    void print_list()
	    {
	        if(root==null)
	            System.out.print("\nList Empty");
	        else
	        {
	            Dcnode t=root;

	            do
	            {
	                System.out.print("<-|"+t.data+"|->");
	                t=t.right;
	            }while(t!=root);
	        }
	    }
	    public static void main(String[] args) {

		     // Create Scanner object for user input
		     Scanner sc = new Scanner(System.in);

		     // Create Linked List object
		     Doubly_Circular obj = new Doubly_Circular();

		     int choice;
		     int data;
		     


		     // Repeat menu until user selects 0
		     do {

		         // Display menu
		         System.out.println("\n\n===== LINKED LIST MENU =====");
		         System.out.println("1. Insert Left");
		         System.out.println("2. Insert Right");
		         System.out.println("3. Delete Left");
		         System.out.println("4. Delete Right");
		         System.out.println("5. Print List");
		         System.out.println("0. Exit");

		         // Read user's choice
		         System.out.print("Enter choice: ");
		         choice = sc.nextInt();

		         // Execute operation according to choice
		         switch (choice) {

		             // ------------------------------------------------
		             // INSERT LEFT
		             // ------------------------------------------------
		             case 1:

		                 // Read data from user
		                 System.out.print("Enter data: ");
		                 data = sc.nextInt();

		                 // Call insert_left()
		                 obj.insert_left(data);

		                 break;
		             // ------------------------------------------------
		             // INSERT RIGHT
		             // ------------------------------------------------
		             case 2:

		                 // Read data from user
		                 System.out.print("Enter data: ");
		                 data = sc.nextInt();

		                 // Call insert_right()
		                 obj.insert_right(data);

		                 break;
		             // ------------------------------------------------
		             // DELETE LEFT
		             // ------------------------------------------------
		             case 3:

		                 // Delete first node
		                 obj.delete_left();

		                 break;
		             // ------------------------------------------------
		             // DELETE RIGHT
		             // ------------------------------------------------
		             case 4:

		                 // Delete last node
		                 obj.delete_right();

		                 break;
		             // ------------------------------------------------
		             // PRINT
		             // ------------------------------------------------
		             case 5:

		                 // Display complete Linked List
		                 obj.print_list();

		                 break;
		             
		             // ------------------------------------------------
		             // EXIT
		             // ------------------------------------------------
		             case 0:

		                 System.out.println("Exiting...");

		                 break;
		             // ------------------------------------------------
		             // INVALID CHOICE
		             // ------------------------------------------------
		             default:

		                 System.out.println("Invalid choice");
		         }

		     // Continue until user enters 0
		     } while (choice != 0);

		     // Close Scanner
		     sc.close();
		 }
}


