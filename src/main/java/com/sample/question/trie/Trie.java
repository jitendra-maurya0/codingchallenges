package com.sample.question.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    void insert(String word){
        HashMap<Character,TrieNode> children = root.children;
        for(Character c: word.toCharArray()){
            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);

            }else{
                t = new TrieNode(c);
                children.put(c,t);
            }
            children = t.children;

            if(c == word.charAt(word.length()-1)){
               t.isLeaf = true;
            }
        }

    }

    public boolean search(String word){
        TrieNode t = searchNode(word);
        if(t!= null  && t.isLeaf){
            return true;
        }else {
            return false;
        }
    }

    private TrieNode searchNode(String word) {
        HashMap<Character,TrieNode> children = root.children;
        TrieNode t = null;
        for (Character c: word.toCharArray()){
            if(children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }

        }
        return t;

    }

    public boolean isStartWith(String prefix){
        if(searchNode(prefix) == null){
            return false;
        }else {
            return true;
        }
    }

    public boolean searchWithRegex(String word){
        return dfsSearch(root.children,word,0);
    }

    private boolean dfsSearch(HashMap<Character, TrieNode> children, String word, int start) {

        if (start == word.length()) {
            if (children.size() == 0) {
                return true;
            } else {
                return false;
            }
        }

        char c = word.charAt(start);

        if (children.containsKey(c)) {

            if (start == word.length() - 1 && children.get(c).isLeaf) {
                return true;
            }
               return dfsSearch(children.get(c).children, word, start + 1);

        } else if (c == '.') {
            boolean result = false;

            for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
                if (start == word.length() - 1 && child.getValue().isLeaf) {
                    return true;
                }

                if (dfsSearch(child.getValue().children, word, start + 1)) {
                    result = true;
                }
            }
            return result;

        } else {
            return false;
        }

    }

    class TrieNode{
        Character val;
        HashMap<Character,TrieNode> children = new HashMap<>();
        boolean isLeaf = false;

        public TrieNode(char val) {
            this.val = val;
            this.children = new HashMap<>();
        }

        public TrieNode() {
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        Trie trie = new Trie();
        trie.insert(str);
        System.out.println(trie.search("ab"));
        System.out.println(trie.isStartWith("ab"));
        System.out.println(trie.searchWithRegex(".a"));
    }
}
