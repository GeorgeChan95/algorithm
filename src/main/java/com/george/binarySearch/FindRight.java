package com.george.binarySearch;

import java.util.Arrays;

/**
 * 查找在有序数组中,最右边(最大下标)位置 num<= 元素的下标值
 */
public class FindRight {
    public static void main(String[] args) {
        int N = 100; // 生成随机数组的最大长度不超过 N;
        int V = 1000; // 生成数组元素的最大值不超过 V
        int testTime = 50000; // 测试次数

        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            // 生成一个不大于N的数,作为数组的长度
            int n = (int) (Math.random() * N);
            // 生成一个随机数组
            int[] arr = randomArray(n, V);
            // 给数组排序
            Arrays.sort(arr);
            int target = (int) (Math.random() * V); // 查询目标值
            if (right(arr, target) != findRight(arr, target)) {
                System.out.println("出现异常");
                System.out.println("对比异常的数组: " + Arrays.toString(args));
                System.out.println("对比异常的目标值: " + target);
            }
        }
        System.out.println("测试结束");
    }


    /**
     * 生成一个随机数组
     *
     * @param size       数组长度
     * @param valueRange 元素最大值边界
     * @return 返回生成的数组
     */
    private static int[] randomArray(int size, int valueRange) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * valueRange); // 生成一个随机数,范围在 [0, valueRange-1] 并添加到数组中
        }
        return arr;
    }

    /**
     * 逐个遍历数组,找到 target<= 最右边(最大)的值的下标,
     * 此方法作为对照组,需保证正确
     *
     * @param arr    查询数组
     * @param target 目标值
     * @return
     */
    public static int right(int[] arr, int target) {
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                ans = i;
            }
        }
        return ans;
    }

    /**
     * 使用二分查找，数组arr中 <=num 最右边的数的下标值
     *
     * @param arr    从小到大的有序数组
     * @param target 要查询的目标值
     * @return
     */
    public static int findRight(int[] arr, int target) {
        int L = 0; // 数组中查找的左侧区间范围，从0开始
        int R = arr.length - 1; // 数组中查找的右侧区间范围,从数组的末尾开始
        int M = 0; // 初始中间位置
        int ans = -1; // 响应结果,-1表示没有找到该元素

        if (arr == null || arr.length == 0) { // 数组为空,不再继续查找
            return ans;
        }

        while (L <= R) { // 确保查找范围区间元素数量 >=1 个
            M = L + (R - L) / 2; // 获取中间位置
            if (arr[M] <= target) { // 中间值与目标值进行比较,如果<=target,则标记下当前位置,继续向右查找,如果 >target则向左继续查找
                ans = M; // 标记当前下标
                L = M + 1; // 左侧查询区间移动到 M+1 位置,继续往右查找
            } else {
                R = M - 1; // 右侧查询区间移动到 M-1 位置,继续往左查找
            }
        }
        // 返回查询结果
        return ans;
    }
}
