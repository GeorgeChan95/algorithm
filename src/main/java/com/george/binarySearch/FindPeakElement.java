package com.george.binarySearch;

/**
 * <p>
 * 查找数组峰值
 * 峰值元素是指其值严格大于左右相邻值的元素
 * 给你一个整数数组 nums，已知任何两个相邻的值都不相等
 * 找到峰值元素并返回其索引
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = 无穷小
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * </p>
 * 测试链接 : https://leetcode.cn/problems/find-peak-element/
 *
 * @author George Chan
 * @date 2024/6/30 11:56
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int arr[] = {1, 10, 30, 4, 5, 6, 7, 80, 70, 6};
        int peak = findPeak(arr);
        System.out.println("找到峰值下标: " + peak + " ,找到峰值: " + arr[peak]); // 找到峰值下标: 7 ,找到峰值: 80
    }

    /**
     * 使用二分查找,找到数组中的峰值
     * @param arr 数组
     * @return
     */
    public static int findPeak(int[] arr) {
        int n = arr.length; // 数组的长度
        if (n == 1) { // 数组长度为1,那么这个元素就是峰值,因为: arr[-1] = arr[n] = 无穷小
            return 0;
        }

        if (arr[0] > arr[1]) { // 满足条件: arr[-1] = 无穷小
            return 0;
        }

        if (arr[n - 1] > arr[n - 2]) { // 满足条件: arr[n] = 无穷小
            return n - 1;
        }

        int L = 1; // 二分查找的左侧区间范围, 从 1 开始
        int R = n - 2; // 二分查找的右侧区间范围, 从 n-2 开始
        int M = 0; // 中间索引,默认:0
        int ans = -1; // 峰值所在位置索引

        while (L <= R) {
            M = L + ((R - L) / 2); // 计算中间值索引
            if (arr[M + 1] > arr[M]) { // M到n-1区域一定存在峰值,向右查找
                L = M + 1;
            } else if (arr[M - 1] > arr[M]) { // 0到M区域一定存在峰值,向左查找
                R = M - 1;
            } else {
                ans = M; // 找到峰值, 跳出循环
                break;
            }
        }
        return ans;
    }
}
