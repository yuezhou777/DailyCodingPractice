package Sort_and_Search.BFS;

import java.util.*;

public class LC752_Open_The_Lock {
    //Bidirection BFS
    public int openLockBi(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> beginSet = new HashSet<>();
        beginSet.add("0000");
        endSet.add(target);
        int level = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            HashSet<String> nextLevel = new HashSet<>();
            for (String cur : beginSet) {
                if (endSet.contains(cur)) {
                    return level;
                }
                if (dead.contains(cur)) {
                    continue;
                }
                dead.add(cur);
                for (String next : getNext(cur)) {
                    nextLevel.add(next);
                }
            }
            beginSet = nextLevel;
            level++;
        }

        return -1;
    }

    //BFS
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return level;
                }
                if (deadSet.contains(cur)) {
                    continue;
                }
                deadSet.add(cur);
                for (String next : getNext(cur)) {
                    queue.offer(next);
                }
            }
            level++;
        }

        return -1;
    }

    private List<String> getNext(String cur) { //每次变两个nei出来
        List<String> list = new LinkedList<>();
        for (int i = 0; i < cur.length(); i++) {
            char[] arr = cur.toCharArray();
            char c = arr[i];
            arr[i] = c == '9' ? '0' : (char)(c + 1);
            list.add(String.valueOf(arr));
            arr[i] = c == '0' ? '9' : (char)(c - 1);
            list.add(String.valueOf(arr));
        }
        return list;
    }
}
