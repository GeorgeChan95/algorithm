package com.george.binarySearch;

import java.util.Arrays;

/**
 * 查找在有序数组中,最左边(最小下标)位置 >=num 元素的下标值
 */
public class FindLeft {
    public static void main(String[] args) {
        int N = 100; // 生成数组的长度: [0,100)
        int V = 1000; // 生成数的范围: [0,1000)
        int testTime = 500000; // 测试次数

        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            // 生成一个不大于N的数,作为数组的长度
            int n = (int) (Math.random() * N);
            // 生成一个随机数组
            int[] arr = randomArray(n, V);
            // 给数组排序
            Arrays.sort(arr);
//            System.out.println(Arrays.toString(arr)); // 打印生成的数组
            // 生成一个数值,作为查询的目标值,范围在 [0, V-1]
            int target = (int) (Math.random() * V);
            if (right(arr, target) != findLeft(arr, target)) {
                System.out.println("findLeft方法存在错误");
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
     * 使用二分查找法,获取 >=target 的最左边的数的下标
     *
     * @param arr    目标数组, 例如: [1,2,3,4,5,6,7,8,9]
     * @param target 目标值, 例如: 2
     * @return
     */
    public static int findLeft(int[] arr, int target) {
        int L = 0; // 查找范围区间左侧的元素的下标,从0开始
        int R = arr.length - 1; // 查找范围区间右侧元素的下标,从arr的末尾开始
        int M = 0; // 中间元素的位置,默认是0
        int ans = -1; // 查找到的目标值的下标,没有找到则返回-1
        if (arr == null || arr.length == 0) { // 当数组为空时,无需查找,返回 -1.
            return ans;
        }
        while (L <= R) { // 确保查找范围区间元素数量 >=1 个
            M = (L + R) / 2; // 获取查询区间的中点
            // 下面这种方式计算结果与上面相同,但是可以避免 L + R 溢出的问题
            // M = L + ((R-L)>>1);

            if (arr[M] >= target) { // 如果中点元素值 >=target 说明中点往左可能还有别的数也 >=target,此时记录下标值,继续向中点左侧找,直到找到最左边 >=target 的值.
                R = M - 1; // 区间往左搜小
                ans = M; // 记录当前下标值
            } else { // 如果中点元素值 <target, 说明目标元素在中点往右的位置,则需要向右查找
                L = M + 1;
            }
        }
        // >=target最左边的数的下标
        return ans;
    }

    /**
     * 循环便利查找元素是否存在,主要是为了与二分查找做比较,
     * 首先要保证此方法绝对正确.
     *
     * @param sortedArr 有序数组
     * @param num       目标值
     * @return 最左边 >=num 的元素下标
     */
    public static int right(int[] sortedArr, int num) {
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] >= num) {
                return i;
            }
        }
        return -1;
    }
}
