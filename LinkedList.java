//Kenneth Tran
//CS4343
//Program1 - DoublyLinkedList
//Implement insertion, deletion and search for a doubly-linked list as defined in class.
//Input:
// -list of pairs of an integer and an operation, e.g., 1.in 3.in 5.in 3.del 2.in 1.sch ….. (insertions are to be taken place at the head unless otherwise specified)

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class LinkedList {

	static Node head = null;

	class Node {

		int data;
		Node next, prev;

		Node(int d) {
			data = d;
			next = prev = null;
		}
	}

	//Function to search a node
	void searchNode(int key){
		// Store head node
		Node temp = head, prev = null;

		// Search for the key
		while (temp != null && temp.data == key)
		{
			prev = temp;
			temp = temp.next;
			System.out.println("found ");
		} 
	}


	//Function to delete a node in a Doubly Linked List.

	void deleteNode(int key)
	{
		// Store head node
		Node temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.data == key)
		{
			head = temp.next; // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of the
		// previous node as we need to change temp.next
		while (temp != null && temp.data != key)
		{
			prev = temp;
			temp = temp.next;
		} 

		// If key was not present in linked list
		if (temp == null) return;

		// Unlink the node from linked list
		prev.next = temp.next;
	}

	/* Function to insert a node at the beginning of the Doubly Linked List */
	void push(Node head_ref, int new_data) {

		/* allocate node */
		Node new_node = new Node(new_data);

		/* since we are adding at the begining,
		prev is always NULL */
		new_node.prev = null;

		/* link the old list off the new node */
		new_node.next = (head);

		/* change prev of head node to new node */
		if ((head) != null) {
			(head).prev = new_node;
		}

		/* move the head to point to the new node */
		(head) = new_node;
	}

	//Remove duplicate insert
	void removeDuplicates()
    {
        /*Another reference to head*/
        Node temp = head;
 
        /* Pointer to store the next pointer of a node to be deleted*/
        Node next_next;
 
        /* do nothing if the list is empty */
        if (head == null)    
            return;
 		
        /* loop thr list till the last node */
        while (temp.next != null) {
 
            /*Compare temp  node with the next node */
            if (temp.data == temp.next.data) {
                next_next = temp.next.next;
                temp.next = null;
                temp.next = next_next;
                System.out.println("duplicate key " + temp.data + "\n");
            }
            else // advance if no deletion
               temp  = temp.next;
        }
    }


	//Function to print nodes in a given doubly linked list
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        System.out.print("enter your input file name (e.g input.txt): ");
        String fname = sc.next();
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
		LinkedList list = new LinkedList();

        while((line = br.readLine())!= null){

            String str[] = line.split(" ");
            System.out.println("\nDisplay the input: \n" + line + "\n");

            for(int i=0;i<str.length;i++){

                String operation[] = str[i].split("\\.");

                if(operation[1].equals("in")){
                	int tmp = new Integer(operation[0]);
                	list.push(head, tmp);
                }

                else if(operation[1].equals("del")){
                	int tmp = new Integer(operation[0]);                	
                	list.deleteNode(tmp);                	
                }
                else if(operation[1].equals("sch")){
					int tmp = new Integer(operation[0]);
					list.searchNode(tmp);
                
                }
                
            }
        }
		list.removeDuplicates();
		System.out.println("Display the output after operation:");
		list.printList();
	}
}
