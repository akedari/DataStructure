package linkedListOperations;

import static linkedListOperations.LinkedList.display;

/**
 * Created by abhijeetkedari on 3/10/17.
 */
public class FindLoopStartingPoint {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        int n = 1;

        Node n11 = new Node(1);
        Node n22 = new Node(2);

        n11.setNext(n22);
        n22.setNext(n11);

        Node res = findLoopStartingPoint(n11);
        if(res==null){
            System.out.println("empty list");
        }
        else{
            System.out.println("Loop Starting point "+res.getData());
        }
    }

    private static Node findLoopStartingPoint(Node head) {

        Node p1 =head;
        Node p2 =head;

        if(head==null){
            return null;
        }

        if(head.getNext()==null || head.getNext()==head){
            return head;
        }

        p1 =p1.getNext();
        p2 = p2.getNext().getNext();
        while (!(p1.equals(p2))){
            p1=p1.getNext();
            p2=p2.getNext().getNext();
        }

        p2 = head;

        while(!(p1.equals(p2))){
            p1=p1.getNext();
            p2=p2.getNext();
        }

        return p1;




    }
}
