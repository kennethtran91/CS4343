//Kenneth Tran
//CS4343
//Program1 - Stack

/* Implement insertion (or push) and deletion (or pop) for a stack and a circular queue with length of n keys as defined in class.

-Input: list of pairs of an integer and an operation, e.g.,

10 1.in 3.in 5.in del 2.in ….. for the queue

10 1.push 2.push 5.push pop 2.push ….. for the stack

-Output: the list before operation and the list after operation displayed on the screen standard outout (not into a file). */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class QStack
{
	public static void main (String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nenter your input file name (e.g input.txt): ");

        String fname = sc.next();
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        int qsize =0 ; 
        Stack<Integer> stack = new Stack<>();

        while((line = br.readLine())!= null){

            String str[] = line.split(" ");
            System.out.println("\nDisplay the input: \n" + line + "\n");

            int inputqsize = Integer.parseInt(str[0]);
            qsize = inputqsize; 


            System.out.println("Queue length: " + qsize);

            for(int i=0;i<str.length;i++){

                if(str[i].contains("."))
                {
                    String operation[] = str[i].split("\\.");

                    if(operation[1].equals("push")){
                        int tmp = new Integer(operation[0]);
                        stack.push(tmp);  
                    } 
                } else { 
                    if(str[i].equals("pop")){
                //System.out.println("pop ");
                        stack.pop();
                    }       
                }

            } 
            System.out.println("Queue state: " + stack.toString());

        }
    }


}