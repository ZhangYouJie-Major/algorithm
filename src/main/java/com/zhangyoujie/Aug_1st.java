package com.zhangyoujie;

/**
 * @author zhangyoujie
 * @date 2023/8/1
 */
public class Aug_1st {


//    public int numSubmat(int[][] mat) {
//
//        int[][] dp = new int[mat.length][mat[0].length];
//
//    }

    public static void heapSort(int[] nums, int parent, int length) {
        //父节点的值
        int temp = nums[parent];
        //左孩子
        int child = 2 * parent + 1;
        //如果有右孩子 并且右孩子大于左孩子 则将child指向右孩子
        while (child < length) {
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }
            //如果父节点大于孩子节点 则跳出循环
            if (temp > nums[child]) {
                break;
            }
            //将孩子节点的值赋给父节点
            nums[parent] = nums[child];
            //寻找当前孩子节点的左孩子
            parent = child;
            child = 2 * parent + 1;
        }
        nums[parent] = temp;
    }

    public static void sort(int[] nums) {
        int length = nums.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapSort(nums, i, length);
        }
        for (int i = length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapSort(nums, 0, i);
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
//        heapSort(nums);
//        for (int num : nums) {
//            System.out.println(num);
//        }
    }


}
