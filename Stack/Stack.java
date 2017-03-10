package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class Stack {

    private SNode top=null;
    private int size;

    public boolean isEmpty(){
        if(top==null){
            return true;
        }
        else{
            return false;
        }
    }

    public void push(int data){

        SNode temp = new SNode(data);

        if(top==null){
            top=temp;
        }
        else{
            temp.setNext(top);
            top = temp;
        }
        size++;
    }

    public int pop(){
        if(top==null){
            System.out.print("Underflow !!!");
            return Integer.parseInt(null);
        }
        else {
            int temp = top.getData();
            top=top.getNext();
            size--;
            return temp;

        }
    }

    public int peek(){
        if(top==null){
            System.out.print("Underflow !!!");
            return Integer.parseInt(null);
        }
        else {
            int temp = top.getData();
            return temp;
        }
    }

    public int getSize(){
        return size;
    }

}
