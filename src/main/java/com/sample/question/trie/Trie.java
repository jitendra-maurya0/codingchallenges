package com.sample.question.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root; //Root Node

    //Constructor
    Trie() {
        root = new TrieNode();
    }

    //Function to get the index of a character 't'
    public int getIndex(char t) {
        return t - 'a';
    }

    //Function to get root
    public TrieNode getRoot() {
        return root;
    }

    //Function to insert a key in the Trie
    public void insert(String key) {
        //Null keys are not allowed
        if (key == null) {
            return;
        }
        key = key.toLowerCase(); //Keys are stored in lowercase
        TrieNode currentNode = this.root;
        int index = 0; //to store character index

        //Iterate the Trie with given character index,
        //If it is null, then simply create a TrieNode and go down a level
        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));

            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        //Mark the end character as leaf node
        currentNode.markAsLeaf();
    }

    //Function to search given key in Trie
    public boolean search(String key) {

        if (key == null) return false; //Null Key

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;

        //Iterate the Trie with given character index,
        //If it is null at any point then we stop and return false
        //We will return true only if we reach leafNode and have traversed the
        //Trie based on the length of the key

        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }
        if (currentNode.isEndWord) return true;

        return false;
    }

    //Helper Function to return true if currentNode does not have any children
    private boolean hasNoChildren(TrieNode currentNode) {
        for (int i = 0; i < currentNode.children.length; i++) {
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }

    //Recursive function to delete given key
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level) {
        boolean deletedSelf = false;

        if (currentNode == null) {
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length) {
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)) {
                currentNode = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        } else {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted) {
                //Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currntNode is part of another key
                //and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndWord) {
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)) {
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else {
                    currentNode = null;
                    deletedSelf = true;
                }
            } else {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    //Function to delete given key from Trie
    public void delete(String key) {
        if ((root == null) || (key == null)) {
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }
//    private TrieNode searchNode(String word) {
//        HashMap<Character,TrieNode> children = root.children;
//        TrieNode t = null;
//        for (Character c: word.toCharArray()){
//            if(children.containsKey(c)) {
//                t = children.get(c);
//                children = t.children;
//            }else{
//                return null;
//            }
//
//        }
//        return t;
//
//    }

//    public boolean isStartWith(String prefix){
//        if(searchNode(prefix) == null){
//            return false;
//        }else {
//            return true;
//        }
//    }
//
//    public boolean searchWithRegex(String word){
//        return dfsSearch(root.children,word,0);
//    }
//
//    private boolean dfsSearch(HashMap<Character, TrieNode> children, String word, int start) {
//
//        if (start == word.length()) {
//            if (children.size() == 0) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//
//        char c = word.charAt(start);
//
//        if (children.containsKey(c)) {
//
//            if (start == word.length() - 1 && children.get(c).isLeaf) {
//                return true;
//            }
//               return dfsSearch(children.get(c).children, word, start + 1);
//
//        } else if (c == '.') {
//            boolean result = false;
//
//            for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
//                if (start == word.length() - 1 && child.getValue().isLeaf) {
//                    return true;
//                }
//
//                if (dfsSearch(child.getValue().children, word, start + 1)) {
//                    result = true;
//                }
//            }
//            return result;
//
//        } else {
//            return false;
//        }
//
//    }
//

    /**
     * Find All of the Words in a Trie time complexity is O(n)
     * @param root
     * @param result
     * @param level
     * @param str
     */
    public static void getWords(TrieNode root, ArrayList< String > result, int level, char[] str) {
    //Leaf denotes end of a word
    if (root.isEndWord) {
        //current word is stored till the 'level' in the character array
        String temp = "";
        for (int x = 0; x < level; x++) {
            temp += Character.toString(str[x]);
        }
        result.add(temp);
    }
    for (int i = 0; i < 26; i++) {
        if (root.children[i] != null) {
            //Non-null child, so add that index to the character array
            str[level] = (char)(i + 'a');
            getWords(root.children[i], result, level + 1, str);
        }
    }
}

    public static void main(String[] args) {
        String str = "abc";
        Trie trie = new Trie();
        trie.insert(str);
        System.out.println(trie.search("ab"));
       // System.out.println(trie.isStartWith("ab"));
        //System.out.println(trie.searchWithRegex(".a"));
    }
}
