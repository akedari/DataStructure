package trie;

/**
 * Created by abhijeetkedari on 3/18/17.
 */
public class TriOperations {
    public static void main(String[] args){

        Trie tr  = new Trie();
        String name = "Abhijeet";
        String name2 = "Abhishek";
        tr.insertRecur(name2);
        tr.insert(name);
        String country = "India";
    }


}
