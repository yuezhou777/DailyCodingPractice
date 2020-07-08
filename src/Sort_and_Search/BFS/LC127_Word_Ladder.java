package Sort_and_Search.BFS;

import java.util.*;

public class LC127_Word_Ladder {
    // bidirection BFS
    public int ladderLengthBi(String beginWord, String endWord, List<String> wordList) {
        //CC
        HashSet<String> wordDict = new HashSet<String>();
        for (String word : wordList) {
            wordDict.add(word);
        }
        if (!wordDict.contains(endWord)) return 0;//优化：提前结束

        HashSet<String> beginSet = new HashSet<String>();
        HashSet<String> endSet = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int minDist = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            HashSet<String> nextLevel = new HashSet<>();
            for (String str : beginSet) {
                for (int i = 0; i < str.length(); i++) {
                    char[] word = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[i] = c;
                        String newWord = String.valueOf(word);
                        if (endSet.contains(newWord)) {
                            return minDist + 1;
                        }//注意这里两个if并列
                        if (wordDict.contains(newWord)) {
                            nextLevel.add(newWord);
                            wordDict.remove(newWord);
                        }
                    }
                }
            }
            beginSet = nextLevel;
            minDist++;
        }

        return 0;
    }

    //1. HashMap<Word, level>
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> validWords = new HashSet<>(wordList);
        if (!validWords.contains(endWord)) return 0;
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String curWord = queue.poll();
            int curLevel = map.get(curWord);
            for (int i = 0; i < curWord.length(); i++) {
                char[] wordUnit = curWord.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String tempWord = new String(wordUnit); //记住API
                    if (validWords.contains(tempWord)) {
                        if (tempWord.equals(endWord)) {
                            return curLevel + 1;
                        }
                        map.put(tempWord, curLevel + 1);
                        queue.offer(tempWord);
                        validWords.remove(tempWord);
                    }
                }
            }
        }
        return 0;
    }

    //2. HashSet<Word> + int level/*minDist in BFS while loop
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        //cc
        HashSet<String> wordDict = new HashSet<>();
        for (String word: wordList) {
            wordDict.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int minDist = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curWord = queue.poll();
                char[] wordChar = curWord.toCharArray();
                for (int i = 0; i < wordChar.length; i++) {
                    char temp = wordChar[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChar[i] = c;
                        String newWord = String.valueOf(wordChar);
                        if (c != temp && wordDict.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return minDist + 1;
                            }
                            wordDict.remove(newWord);
                            queue.offer(newWord);
                        }
                    }
                    wordChar[i] = temp;
                }
            }
            minDist++;
        }

        return 0; //throw new IllegalStateException("");
    }

}
