package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/10/17.
 */
public class RemoveOddElements {

        public static void main(String[] args) {

            LinkedList list1 = new LinkedList();
            LinkedList list2 = new LinkedList();

            list1.add(6);


            Node l1 = list1.getHeadPointer();

            Node l3 = removeOddElements(l1);

            display(l3);


        }

    private static Node removeOddElements(Node l1) {

        Node head = null;
        Node prev = null;
        Node next =null;
        head =l1;

        while( head!=null && head.getData()%2!=0){
            head =head.getNext();
        }

        if(head==null){
            return null;
        }
        else{
            if(head.getNext()==null){
                return head;
            }
            else{
                prev =head;
                next = head.getNext();

                while(next.getNext()!=null){
                    if(next.getData()%2==0){
                        prev.setNext(next);
                        prev=prev.getNext();
                    }
                    next=next.getNext();

                }
                if(next.getData()%2==0){
                    prev.setNext(next);
                }
                else{
                    prev.setNext(null);
                }
                return head;
            }
        }
    }

    private static void display(Node l3) {

            while(l3!=null){
                System.out.print(" "+l3.getData());
                l3= l3.getNext();
            }
        }
}
