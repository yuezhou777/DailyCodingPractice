package DPI;

import java.util.ArrayList;
import java.util.List;

public class LC118_Pascals_Triangle {
    /*
    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1
    */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int a = res.get(i - 1).get(j - 1);
                    int b = res.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            res.add(list);
        }

        return res;
    }
}
