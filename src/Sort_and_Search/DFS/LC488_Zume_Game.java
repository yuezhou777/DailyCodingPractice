package Sort_and_Search.DFS;

import java.util.HashMap;

/** 0727更新TestCase
        "RRWWRRBBRR"
        "WB"
    output:-1, expected:2
    用当前的greedy方法解不对
    RRWWRRBBRR -> RRWWRRBBR[W]R -> RRWWRRBB[B]RWR -> RRWWRRRWR -> RRWWWR -> RRR -> empty
 */

public class LC488_Zume_Game {
    class Solution {
        //为啥不用BFS? 状态（board+hand和board+hand）之间的权重不是确定的
        //而且bfs的每个状态里不仅要存board还要存hand，挺麻烦的
        //为什么是图上搜索？搜索过程中可能会出现重复
        //如果board有已经有2个相同, 优先消除这两个
        //dfs的意义：用手里的球炸board, 最少需要多少个球能炸空？
        public int min;
        public int findMinStep(String board, String hand) {
            if (board == null || board.length() == 0) return -1;

            min = hand.length() + 1;
            HashMap<Character, Integer> hands = new HashMap<>();
            for (char c : hand.toCharArray()) {
                hands.put(c, hands.getOrDefault(c, 0) + 1);
            }

            dfs(board, hands, 0);
            return min == hand.length() + 1 ? -1 : min;
        }

        public void dfs(String board, HashMap<Character, Integer> hands, int used) {
            int len = board.length();
            if (len == 0) {
                min = used < min ? used : min;
                return;
            }
            if (hands.size() == 0) return;

            for (int i = 0; i < len; i++) {
                char c = board.charAt(i);
                Integer count = hands.get(c);
                if (count == null) continue;

                if (i + 1 < len && c == board.charAt(i + 1)) { //already 2 balls
                    int newCount = count - 1;
                    if (newCount <= 0) {
                        hands.remove(c);
                    } else {
                        hands.put(c, newCount);
                    }
                    String newBoard = removeBalls(board, i - 1, i + 2);
                    dfs(newBoard, hands, used + 1);
                    hands.put(c, count);
                } else if (count >= 2) { //one ball but we have >= 2  hands
                    int newCount = count - 2;
                    if (newCount == 0) {
                        hands.remove(c);
                    } else {
                        hands.put(c, newCount);
                    }
                    String newBoard = removeBalls(board, i - 1, i + 1);
                    dfs(newBoard, hands, used + 2);
                    hands.put(c, count);
                }
            }
        }

        //WWRRWW
        //  i
        //WWRWW
        //  i
        private String removeBalls(String board, int left, int right) {
            int len = board.length();
            while (left >= 0 && right < len) {
                int count = 0;
                char c = board.charAt(left);

                int l = left;
                while (l >= 0 && board.charAt(l) == c) {
                    l--;
                    count++;
                }

                int r = right;
                while (r < len && board.charAt(r) == c) {
                    r++;
                    count++;
                }
                if (count < 3) {
                    break;
                } else {
                    left = l;
                    right = r;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= left; i++) {
                sb.append(board.charAt(i));
            }
            for (int i = right; i < len; i++) {
                sb.append(board.charAt(i));
            }
            return sb.toString();
        }
    }
}
