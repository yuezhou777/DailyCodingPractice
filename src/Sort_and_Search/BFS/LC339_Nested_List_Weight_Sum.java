package Sort_and_Search.BFS;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class LC339_Nested_List_Weight_Sum {
    //BFS
    /*
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        int sum = 0;
        int level = 1;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger list : nestedList) { //put first level into queue
            queue.offer(list);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int curSum = 0;
            while (size-- > 0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    curSum += cur.getInteger();
                } else {
                    for (NestedInteger list : cur.getList()) {
                        queue.offer(list);
                    }
                }
            }
            sum += curSum * level;
            level++;
        }

        return sum;
    }

    //DFS
    public int depthSum(List<NestedInteger> nestedList) {
        return DFS(nestedList, 1);
    }

    private int DFS(List<NestedInteger> list, int level) {
        int sum = 0;
        for (NestedInteger cur : list) {
            if (cur.isInteger()) {
                sum += cur.getInteger() * level;
            } else {
                sum += DFS(cur.getList(), level + 1); //注意参数：cur.getList传入下一层而不是本身， level + 1，不能自加一
            }
        }
        return sum;
    }
*/
}


