package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class LinkedList {

    private Node head= null;
    private int size =0;

    public void add(int data){
        Node node = new Node(data);

        if(isEmpty()){
            head = node;
        }
        else{
            Node temp = head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(node);
        }
        size ++;
    }

    public void addAsHead(int data){

        Node node = new Node(data);

        if(isEmpty()){
            head =node;
        }
        else{
            node.setNext(head);
            head= node;
        }
        size++;
    }

    public void addAtPosition(int data, int position){
        Node node = new Node(data);

        if(isEmpty()){
            head = node;
        }
        else{

            Node temp =head;
            for(int i=0;i<position-1 && temp!=null;i++){
                temp =temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
            size++;
        }
    }

    public void removeData(int data){
        if(isEmpty()){
            System.out.println("List is Empty !!!");
        }
        else{
            Node temp = head;
            if(head.getData()==data){
                head=head.getNext();
            }
            else {
                Node prev= temp;
                temp = temp.getNext();

                while (temp != null && temp.getData() != data) {
                    temp = temp.getNext();
                    prev=prev.getNext();
                }
                prev.setNext(temp.getNext());

            }
            size--;
        }
    }

    public void removeLast(){
        if(isEmpty()){
            System.out.println("List is Empty !!!");
        }
        else{
            if(head.getNext()==null){
                head =null;
            }
            else{
                Node temp =head;
                while (temp.getNext().getNext()!=null){
                    temp=temp.getNext();
                }
                temp.setNext(null);

            }
            size--;
        }
    }

    public void removeAtPosition(int position){
        if(isEmpty()){
            System.out.println("List is Empty !!!");
        }
        else{
            Node temp = head;

            for(int i=0;i<position-1 && temp!=null;i++){
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            size--;
        }
    }

    public void removeHead(){
        if(isEmpty()){
            System.out.println("List is Empty !!!");
        }
        else{
            if(head.getNext()==null){
                head=null;
            }
            else{
                head=head.getNext();
            }
            size--;
        }
    }

    public int getLast(){
        if(isEmpty()){
            System.out.println("List is Empty !!!");
            return Integer.parseInt(null);
        }
        else{
            if(head.getNext()==null){
                return head.getData();
            }
            else{
                Node temp = head;
                while(temp.getNext()!=null){
                    temp=temp.getNext();
                }
                return temp.getData();
            }
        }
    }

    public boolean isEmpty() {
        if(head==null){
            return true;
        }
        else{
            return  false;
        }
    }

    public int getSize(){
        return size;
    }

    public int getHead(){
        if(isEmpty()){
            return Integer.parseInt(null);
        }
        else{
            return head.getData();
        }
    }

    public int getElementAtPosition(int position){
        if(isEmpty()){
            return Integer.parseInt(null);
        }
        else {
            Node temp = head;
            for(int i=0;i<position-1;i++){
                temp=temp.getNext();
            }
            return temp.getData();
        }
    }

}
