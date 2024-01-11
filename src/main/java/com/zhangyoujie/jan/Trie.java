package com.zhangyoujie.jan;

/**
 * @author zhangyoujie
 * @date 2024/1/9
 */
public class Trie {

    Trie[] children;

    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return null != trie && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (null == node.children[index]) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
