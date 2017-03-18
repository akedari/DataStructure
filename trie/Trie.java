package trie;

/**
 * Created by abhijeetkedari on 3/18/17.
 */
/*
Source and reference
https://www.youtube.com/watch?v=AXjmTQ8LEoI
 */

public class Trie {

    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }


    //Iterative Insert of trie
    public void insert(String word){
        TrieNode current = root;

        for(int  i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);

            if(node==null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current =node;
        }
    }

    //Recursive insert into Trie
    public void insertRecur(String word){
        insertRecur(root, word,0);
    }

    private void insertRecur(TrieNode current, String word, int index) {

        if(index==word.length()){
            current.isEndOfWord =true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        if(node==null){
            node = new TrieNode();
            current.children.put(ch,node);
        }
        insertRecur(node,word,index+1);
    }

    //Iterative search
    public boolean search(String word){

        TrieNode current  = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);

            if(node==null){
                return false;
            }
            current = node;
        }
        return current.isEndOfWord;
    }

    //Recursive search
    public boolean searchRecur(String word){
        return searchRecur(root,word,0);
    }

    private boolean searchRecur(TrieNode current, String word, int index) {

        if(word.length() == index){
            return current.isEndOfWord;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        if(node==null){
            return false;
        }

        return searchRecur(node,word,index+1);
    }

    public boolean delete(String word){
        return delete(root, word,0);
    }


    //return true if parent should delete the mapping
    private boolean delete(TrieNode current, String word, int index) {


        if(index==word.length()){
            //when reach at end of word only delete if current.isEndofWord is true
            if(!current.isEndOfWord){
                return false;
            }
            current.isEndOfWord =false;

            //if current has no other mapping then return true
            return current.children.size()==0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        if(node==null){
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(node,word,index+1);

        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            return current.children.size()==0;
        }
        return false;
    }
}
