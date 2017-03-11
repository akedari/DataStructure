package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/10/17.
 */
public class AddingTwoLinkedList {

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.add(6);
        list1.add(5);
        list1.add(4);

        list2.add(6);
        list2.add(5);
        list2.add(5);


        Node l1 = list1.getHeadPointer();
        Node l2 = list2.getHeadPointer();

        Node l3 = additionOfList(l1, l2);

        display(l3);
    }

    private static void display(Node l3) {

        while(l3!=null){
            System.out.print(" "+l3.getData());
            l3= l3.getNext();
        }
    }

    private static Node additionOfList(Node l1, Node l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        else{
            if(l1==null){
                return l2;
            }

            else if(l2==null){
                return l1;
            }

            else{

                int sum=0;
                int carray =0;
                int result ;
                Node res = null;
                Node head =null;

                while(l1!=null && l2!=null){

                    result = l1.getData() + l2.getData() + carray;

                    carray = result/10;
                    sum =result%10;

                    if(res==null){
                        res = new Node(sum);
                        res.setNext(null);
                        head = res;
                    }
                    else{
                        Node temp = new Node(sum);
                        res.setNext(temp);
                        res = res.getNext();
                    }

                    l1=l1.getNext();
                    l2= l2.getNext();
                }

                if(l1!=null){

                    while(l1!=null){
                        result = carray + l1.getData();
                        carray = result/10;
                        sum = result%10;
                        Node temp = new Node(sum);
                        res.setNext(temp);

                        l1=l1.getNext();
                    }
                }

                if(l2!=null){

                    result = carray+ l2.getData();
                    sum = result/10;
                    carray = result%10;

                    Node temp = new Node(sum);
                    res.setNext(temp);

                    l2=l2.getNext();
                }


                if(carray!=0){
                    Node car =  new Node(carray);
                    res.setNext(car);
                }
                return head;
            }

        }

    }
}

