package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class Queue {

    private QNode front = null;
    private QNode rear = null;
    private int size = 0;


    public boolean isEmpty(){
        if(front==null){
            return true;
        }
        else {
            return false;
        }
    }

    public void enqueue(int data){
        QNode node = new QNode(data);

        if(rear==null){
            rear=front=node;
        }
        else {
            rear.setNext(node);
            rear=rear.getNext();
        }
        size++;
    }


    public void dqueue(){
        if(front==null){
            System.out.print("Underflow !!!");
        }
        else {
            front = front.getNext();
            size--;
        }

    }

    public int getSize(){
        return size;
    }

    public int peek(){
        if(isEmpty()){
            System.out.print("Empty");
            return Integer.parseInt(null);
        }
        else {
            return front.getData();
        }
    }


}
