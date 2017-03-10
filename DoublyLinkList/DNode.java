package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class DNode {

    private int data;
    private DNode next;
    private DNode prev;


    public DNode(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }

    public void setNext(DNode newnode){
        this.next=newnode;
        newnode.prev = this;
    }

    public void setPrev(DNode newnode){
        this.prev=newnode;
        newnode.next = this;
    }

    public DNode getNext(){
        return this.next;
    }

    public DNode getPrev(){
        return this.prev;
    }

    public void setData(int data){
        this.data=data;
    }

    public int getData(){
        return this.data;
    }



}
