package Sort_and_Search.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC127_Word_Ladder {
    /*
思路：把单词的一步一步转换看成图的结点BFS遍历，一层一层变
     层数是啥？单词对应的层数代表该词经过了多少次变化得来, 每一层只会有一个单词进行变化
     怎么变？把单词toCharArray(), 每一个单词从a到z轮着换一遍，假如换到了wordList里的词，就做判断：
         第一种情况：换到的词就是最终所求词，则返回该词的层数
         第二种情况：换到的词不是最终求的词，则更新词的层数，入列继续换，同时注意从wordList里删掉它，避免再次换的时候匹配出错

            hit
           /
        hot---dot---dog
        /
      lot---log---cog

综上：实现BFS需要Queue，Set(visited)
     实现单词与层数的对应关系需要HashMap
*/
    //O(n)
    //O(n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //cc
        //for every possible change, if the change == endWord, cut the bfs and return level, else, return 0 or exception;
        //如何记录变化次数（层数）? 1. HashMap<Word, level> 2, HashSet<Word> + int level/*minDist*/ in BFS while loop
        HashSet<String> wordDict = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for (String word : wordList) {
            wordDict.add(word);
        }
        queue.offer(beginWord);
        int minDist = 1;

        //BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curWord = queue.poll();
                char[] wordArr = curWord.toCharArray();
                for (int i = 0; i < wordArr.length; i++) {
                    char temp = wordArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[i] = c;
                        String newWord = String.valueOf(temp);
                        if (c != temp && wordDict.contains(newWord)) { //弄清楚这里的判断条件
                            if (newWord.equals(endWord)) {
                                return minDist + 1; //注意结束状态+1
                            }
                            wordDict.remove(newWord); //思考为什么remove？不remove会无限循环
                            queue.offer(newWord);
                        }
                    }
                    wordArr[i] = temp;
                }
            }
            minDist++;
        }

        return 0; //throw new IllegalStateException("");
    }
}
