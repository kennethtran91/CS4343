//Kenneth Tran
//CS4343
//Program1 - CirQueue

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AQueue {

    public static void main (String args[]) throws IOException {

    Scanner sc = new Scanner(System.in);
    System.out.print("\nenter your input file name (e.g input.txt): ");

    String fname = sc.next();
    FileReader fr = new FileReader(fname);
    BufferedReader br = new BufferedReader(fr);
    String line = null;
    int qsize =0 ; 

    while((line = br.readLine())!= null){

        String str[] = line.split(" ");


        System.out.println("\nDisplay the input: \n" + line + "\n");

        int inputqsize = Integer.parseInt(str[0]);
        qsize = inputqsize; 
        Queue queue = new Queue(qsize);
        System.out.println("Queue length: " + qsize);

        for(int i=0;i<str.length;i++){

            if(str[i].contains(".") || str[i].contains(" "))
            {

                String operation[] = str[i].split("\\.");

                if(operation[1].equals("in")){
                        int tmp = new Integer(operation[0]);
                        qsize++;
                        queue.enqueue(tmp);  
                }
        }
        if(line.contains("del")){ queue.dequeue();} 
    }
        queue.print();

    } 
}
  
  static class Queue {
    int front, rear, size;
    int [] Q;
    
    public Queue(int size) {

      Q = new int[size+1];
      front = 0;
      rear = 0;
    }
    


    public void enqueue(int val) {
      rear = (rear + 1) % Q.length;

      if (rear == front) { //if full
        System.out.println("Queue is full."); 
        if (rear == 0) rear = Q.length - 1; else rear = rear - 1; 
        return; 
      }
      Q[rear] = val;
    }


    public int dequeue() {
      if (front==-1) {//if empty
        System.out.println("Queue is empty.");
        return -1;
      }
      int temp = Q[front];
      front = (front+1) % Q.length;
      return temp;
    }



    public void print() {
      int curr = front;
      System.out.print("Queue state: ");
      if (curr == rear) { System.out.print("[empty]"); }
      else while (curr != rear) {
        curr = (curr + 1) % Q.length;
        System.out.print(Q[curr] + " ");
      }
      System.out.println();
    }
  }
}
