package Sort_and_Search.Sort.SortingTemplate;

import java.util.ArrayList;
import java.util.List;

/*
    Example:

    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
*/
public class CountingSort_LC75_SortColors {

    //counting sort
    //two pass O(n), O(1)
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int[] count = new int[3];
        for (int num : nums) {
            count[num - 0]++;
        }

        int curIdx = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[curIdx++] = i;
            }
        }
    }

    //one-pass O(n), O(1) - 3 pointers
    //是0就抛到左边，是2就抛到右边，是1就不管接着往前走
    //left一定会被换成0， 所以换完后left++, 换完后cur不会是2所以cur++，因为left的位置<=cur，如果是2肯定已经被换过了
    //right一定会被换成2，所以换完后right--,换完后cur不能确定换过来的是0还是1，所以cur不动
    public void sortColors3(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = 0;
        int curIdx = 0;
        while (curIdx <= right) { //这里是cur <= right
            if (nums[curIdx] == 0) {
                swap(nums, left++, curIdx++);
            } else if (nums[curIdx] == 2) {
                swap(nums, right--, curIdx);
            } else {
                curIdx++;
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //bucket sort
    //two pass O(n), O(n)
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list0.add(nums[i]);
            } else if (nums[i] == 1) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        int idx = 0;
        for (int i = 0; i < list0.size(); i++) {
            nums[idx] = list0.get(i);
            idx++;
        }
        for (int i = 0; i < list1.size(); i++) {
            nums[idx] = list1.get(i);
            idx++;
        }
        for (int i = 0; i < list2.size(); i++) {
            nums[idx] = list2.get(i);
            idx++;
        }
    }

}
