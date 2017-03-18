package trie;

import java.util.HashMap;

/**
 * Created by abhijeetkedari on 3/18/17.
 */
public class TrieNode {

    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;

    TrieNode(){
        children =  new HashMap<>();
        isEndOfWord = false;
    }
}
