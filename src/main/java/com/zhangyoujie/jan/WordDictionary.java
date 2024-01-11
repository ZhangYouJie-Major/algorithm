package com.zhangyoujie.jan;

/**
 * @author zhangyoujie
 * @date 2024/1/9
 */
class WordDictionary {

    private Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            Trie child = node.children[ch - 'a'];
            if (null != child && dfs(word, index + 1, child)) {
                return true;
            }

        } else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.children[i];
                if (null != child && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }


}


