package com.zhangyoujie.dec;

import com.zhangyoujie.aug.Aug_27st;
import com.zhangyoujie.tool.ListNode;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/1
 */
public class Dec_1st {

    /**
     * 思路1 : 想通过两个 Map<Integer, Set<Integer>> 把两个行的全部元素和两个列的全部元素维护起来
     * 然后再通过遍历arr去除Set中的元素 如果为空则去返回下标 但是时间复杂度超时
     * <p>
     * 思路2：通过Map<Integer, int[]> 维护元素和下标的关系 然后再用两个数组统计分别统计对应列/行的使用次数
     * 那个先到达上限 就直接返回对应的arr元素下标
     *
     * @param arr
     * @param mat
     * @return
     */
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rowArray = new int[row];
        int[] colArray = new int[col];
        for (int i = 0; i < arr.length; i++) {
            int[] ints = map.get(arr[i]);
            rowArray[ints[0]]++;
            colArray[ints[1]]++;
            if (rowArray[ints[0]] == col || colArray[ints[1]] == row) {
                return i;
            }
        }
        return -1;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> visit = new HashSet<>();
        while (head.next != null) {
            if (visit.contains(head)) {
                return head;
            } else {
                visit.add(head);
            }
            head = head.next;
        }
        return null;
    }


}
