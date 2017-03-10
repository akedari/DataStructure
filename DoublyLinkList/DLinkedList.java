package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class DLinkedList {

    private DNode head = null;
    private DNode tail =null;
    private int size =0;

    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        else {
            return false;
        }
    }

    public void add(int data){
        DNode node = new DNode(data);

        if(head==null){
            head=node;
            tail=head;
        }
        else{
            tail.setNext(node);
            node.setPrev(tail);
            tail=tail.getNext();
        }
        size++;
    }

    public void addAtHead(int data){
        DNode node = new DNode(data);
        if(head==null){
            head= node;
        }
        else{
            node.setNext(head);
            head.setPrev(node);
            head=node;
        }
        size++;

    }

    public void addAtPosition(int position, int data){
        DNode node = new DNode(data);

        if(isEmpty()){
            System.out.print("List is empty");
        }
        else{
            DNode temp =head;

            for(int i=0;i<position-1;i++){
                temp =  temp.getNext();
            }
            if(temp.getNext()==null){
                add(data);
            }
            else {
                temp.getNext().setPrev(node);
                node.setNext(temp.getNext());
                temp.setNext(node);
                node.setPrev(temp);
                size++;
            }
        }

    }


    public void removeEnd(){
        if(isEmpty()){
            System.out.print("List is empty");
        }
        else {
            if(head.getNext()==null){
                head=null;
                tail=null;
            }
            else{
                tail=tail.getPrev();
                tail.setNext(null);
            }

            size--;
        }
    }

    public void removeAtHead(){
        if(isEmpty()){
            System.out.print("List is empty");
        }
        else{
            if(head.getNext()==null){
                head=null;
                tail=null;
            }
            else {
                head.getNext().setPrev(null);
                head=head.getNext();
            }
            size--;
        }
    }

    public void removeAtPosition(int position){
        if(isEmpty()){
            System.out.print("List is empty");
        }
        else{
            if(head.getNext()==null && position==1){
                head=null;
                tail=null;
                size--;
            }
            else if(size<position){
                System.out.println("Invalid position !!!");
            }
            else if(size==position){
                removeEnd();
            }
            else{
                DNode temp = head;
                for(int i=0;i<position-1 && temp!=null;i++){
                    temp=temp.getNext();
                }
                temp.setNext(temp.getNext().getNext());
                temp.getNext().getNext().setPrev(temp);
                size--;
            }
        }
    }

    public int getSize(){
        return size;
    }

    public int getTail(){
        return tail.getData();
    }

    public int getHead(){
        return head.getData();
    }

    public int getElement(int position){
        if(isEmpty()){
            System.out.print("List is empty");
            return Integer.parseInt(null);
        }
        else{
            if(size<position){
                System.out.print("Invalid position or List or shorter than position");
                return Integer.parseInt(null);
            }
            else{
                DNode temp= head;
                for(int i=0;i<position-1 && temp!=null;i++){
                    temp=temp.getNext();
                }
                return temp.getData();

            }
        }
    }
}
