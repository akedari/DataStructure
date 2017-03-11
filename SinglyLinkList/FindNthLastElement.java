package linkedListOperations;

import static linkedListOperations.LinkedList.display;

/**
 * Created by abhijeetkedari on 3/10/17.
 */

//Implement an algorithm to  nd the nth to last element of a singly linked list.


public class FindNthLastElement {

    public static void main(String[] args){
        LinkedList list1 = new LinkedList();
        int n =1;

        list1.add(7);
        list1.add(3);
        list1.add(8);
        list1.add(3);
        list1.add(8);
        list1.add(8);
        list1.add(2);
        list1.add(1);
        list1.add(7);
        list1.add(7);
        list1.add(3);
        display(list1.getHeadPointer());
        System.out.println();

        Node res = findNthLastElement(list1.getHeadPointer(),n);
        if(res==null){
            System.out.print(n+ "th  Last element is out of range");
        }
        else {
            System.out.println(n+ "th  Last element "+res.getData());
        }
    }

    private static Node findNthLastElement(Node headPointer, int n) {
        Node head = headPointer;
        Node next =head;
        Node curr = head;

        for(int i=0;i<n-1;i++){
            if(next==null){
                return null;
            }
            next=next.getNext();
        }

        if(next==null){
            return curr;
        }

        while(next.getNext()!=null){
            next=next.getNext();
            curr=curr.getNext();
        }

        return curr;

    }
}
