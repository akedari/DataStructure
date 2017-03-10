package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class Node {

    private int data;
    private Node next;


    public Node(int data){
        this.data = data;
        this.next =null;
    }
    public Node(int data, Node next){
        this.data = data;
        this.next =next;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data =data;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node n){
        this.next = n;
    }

}
