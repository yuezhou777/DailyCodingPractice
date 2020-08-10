package Tree.Trie;

import java.util.HashMap;

class LC211_Add_and_Search_Word {

    class TrieNode {
        boolean isWord;
        HashMap<Character, TrieNode> childList;
        public TrieNode () {
            isWord = false;
            childList = new HashMap<>();
        }
    }
    //成员变量，因为可能会加多次word, 需要重复使用同一个root
    TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public LC211_Add_and_Search_Word() {
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if(!cur.childList.containsKey(c)) {
                cur.childList.put(c, new TrieNode());
            }
            cur = cur.childList.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode node, int idx) {
        //if the word has all been scanned, return
        if (idx == word.length()) {
            return node.isWord;
        }
        //reach the leaf before finishing scanning the word
        if (node.childList == null || node.childList.size() == 0) {
            return false;
        }
        //if the character at current position is '.',
        //recursive check whether the remaing word is in the trie
        if (word.charAt(idx) == '.') {
            for (Character c : node.childList.keySet()) {
                if (dfs(word, node.childList.get(c), idx + 1)) {
                    return true;
                }
            }
        }
        //if character at position 'idx' is neither equal to the node nor '.', return false
        if (node.childList.containsKey(word.charAt(idx))) {
            return dfs(word, node.childList.get(word.charAt(idx)), idx + 1);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */