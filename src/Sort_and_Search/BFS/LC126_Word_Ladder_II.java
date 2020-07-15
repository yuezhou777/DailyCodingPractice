package Sort_and_Search.BFS;

import java.util.*;
//找的时候从begin到end, 遍历图生成结果时从end到begin
//这样可以提高时间效率，因为可以guarantee从end一定可以一路找到begin，不会lost

public class LC126_Word_Ladder_II {
    /*      A          A
           / \        / \
          B - C  ->  B   C
          \   /       \  /
            D          D
            |          |
            E          E
    */
    //与127的不同在于：127是找到答案立即返回最短距离，这里找到一个答案后不能直接返回当前记录，否则会漏掉其他的答案，
    //例如找到路径A-B-D如果结束BFS或者把D标记为visited, 则C-D就不会执行，所以需要修改visited
    //修改为：在当前层B、C全部都遍历完之后才把D标记为visited, 在B处出其中一个答案时需要标记一下答案，在当前层遍历结束后
    //再记录答案，在经过整个BFS后，图从左边处理成了右边这种，这样就可以将图还原成路径了

    //还原路径时可以优化时间复杂度：
    //找ladder的时候从begin到end, 遍历图生成结果时从end到begin
    //follow up: return any of the answer
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> wordDict = new HashSet<>();
        for (String s : wordList) {
            wordDict.add(s);
        }
        if (!wordDict.contains(endWord)) {
            return res;
        }
        wordDict.remove(beginWord);
        HashMap<String, List<String>> graph = new HashMap<>();
        HashSet<String> visitedThisLevel = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        boolean flag = false; //true: has one solution
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < cur.length(); i++) {
                    char[] chars = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String next = String.valueOf(chars);
                        if (wordDict.contains(next)) {
                            if (next.equals(endWord)) {
                                flag = true;
                            }
                            if (!visitedThisLevel.contains(next)) {
                                visitedThisLevel.add(next);
                                List<String> neis = new ArrayList<>();
                                //graph.put(next,cur); cur可能有多个，因为需要全部答案所以全部需要记录
                                neis.add(cur);
                                graph.put(next, neis);
                                queue.offer(next);
                                //什么时候从dict里删除？ 遍历完这一层之后
                            } else {
                                List<String> neis = graph.get(next);
                                neis.add(cur);
                                graph.put(next, neis);
                                //next在当前层被遍历过，不进queue 例如在B时next为D，遍历到C时就不用进queue, 不然会重复
                            }
                        }
                    }
                }
            }
            wordDict.removeAll(visitedThisLevel);

            if (flag) { //add sol to res
                List<String> sol = new LinkedList<>();
                sol.add(endWord);
                findPath(endWord, beginWord, graph, sol, res);
                return res;
            }
        }

        return res;
    }

    private void findPath (String cur, String end, HashMap<String, List<String>> graph, List<String> sol, List<List<String>> res) { //注意参数顺序：从后往前添加路径
        if (cur.equals(end)) {
            List<String> copy = new LinkedList<>(sol);
            res.add(copy);
            return;
        }
        List<String> neis = graph.get(cur);
        for (String s : neis) {
            sol.add(0, s);
            findPath(s, end, graph, sol, res);
            sol.remove(0);
        }
    }

    //follow up: return any of the answer
    public List<String> findLadder(String beginWord, String endWord, List<String> wordList) {
        List<String> res = new LinkedList<>(); //如果用addFirst需要LinkedList接口
        HashSet<String> wordDict = new HashSet<>();
        for (String s : wordList) {
            wordDict.add(s);
        }
        if (!wordDict.contains(endWord)) {
            return res;
        }
        wordDict.remove(beginWord);
        HashMap<String, String> graph = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (int i = 0; i < cur.length(); i++) {
                char[] chars = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String next = String.valueOf(chars);
                    if (wordDict.contains(next)) {
                        graph.put(next, cur); //因为最后从后往前加答案，所以存的时候顺序是next，cur
                        if (next.equals(endWord)) {
                            String curWord = endWord;
                            while (curWord != null) { //while curWord is not the next of beginWord
                                res.add(0, curWord);
                                curWord = graph.get(curWord);
                            }
                            return res;
                        }
                        queue.offer(next);
                        wordDict.remove(next);
                    }
                }
            }
        }

        return res;
    }
}
