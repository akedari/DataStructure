package linkedListOperations;

import java.util.HashMap;

import static linkedListOperations.LinkedList.display;

/**
 * Created by abhijeetkedari on 3/10/17.
 */

// Write code to remove duplicates from an unsorted linked list. FOLLOW UP
// How would you solve this problem if a temporary bu er is not allowed?


public class RemoveDuplicateWithoutBuffer {

    public static void main(String[] args){
        LinkedList list1 = new LinkedList();

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

//        Node res = removeDuplicateWithOutBuffer(list1.getHeadPointer());
//        System.out.println(" \nAfter Removing Duplicate entries: ");
//        display(res);

        Node result = removeDuplicateWithBuffer(list1.getHeadPointer());
        System.out.println(" \nAfter Removing Duplicate entries: ");
        display(result);

    }

    private static Node removeDuplicateWithBuffer(Node headPointer) {
        Node head = headPointer;
        Node curr = head;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        if(curr==null){
            return null;
        }

        if(curr.getNext()==null){
            return curr;
        }

        map.put(curr.getData(),1);
        Node next =curr.getNext();

        while(next!=null){
            if(!(map.containsKey(next.getData()))){
                map.put(next.getData(),1);
                curr.setNext(next);
                curr=curr.getNext();
            }
            next=next.getNext();
        }
        curr.setNext(null);
        return head;

    }

    public static Node removeDuplicateWithOutBuffer(Node headPointer) {

        Node head = headPointer;
        Node runner = head;
        Node curr = head;

        if(head==null){
            return null;
        }

        if(head.getNext()==null){
            return head;
        }
        else{

            while (curr!=null){
                int data = curr.getData();
                runner = curr;
                while (runner.getNext()!=null){
                    if(data==runner.getNext().getData()){
                        runner.setNext(runner.getNext().getNext());
                    }
                    else{
                        runner=runner.getNext();
                    }
                }
                curr=curr.getNext();
            }
        }


        return head;
    }


}
