package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class QNode {

    private int data;
    private QNode next;


    public QNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public QNode getNext() {
        return next;
    }

    public void setNext(QNode next) {
        this.next = next;
    }
}
