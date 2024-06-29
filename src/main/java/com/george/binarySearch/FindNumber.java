package com.george.binarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 使用二分搜索,完成在一个有序数组中,查找数值num是否存在.
 */
public class FindNumber {


    /**
     * 使用对数器验证二分查找方法exist() 写的是否正确
     * 前提:保证 right() 方法是绝对正确的.
     *
     * @param args
     */
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
            if (right(arr, target) != exist(arr, target)) {
                System.out.println("exist方法存在错误");
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
     * 查找target在arr中是否存在
     *
     * @param arr    有序数组
     * @param target 目标值
     * @return true:表示target在arr中存在, false表示不存在
     */
    public static boolean exist(int[] arr, int target) {
        if (arr == null || arr.length == 0) { // 当数组为空时,无需查找,返回false.
            return false;
        }

        int L = 0; // 查找范围区间左侧的元素的下标,从0开始
        int R = arr.length - 1; // 查找范围区间右侧元素的下标,从arr的末尾开始
        int M = 0; // 中间元素的位置,默认是0

        // <= 表示这是一个 [左闭,右闭] 的区间范围.
        // 不使用 < 是考虑到在查找的过程中会动态调整L和R的值,有可能出现 L和R 重合的情况,即区间范围只有一个值的情况.
        while (L <= R) {
            M = (L + R) / 2; // 获取查询区间的中点
            // 下面这种方式计算结果与上面相同,但是可以避免 L + R 溢出的问题
            // M = L + ((R-L)>>1);

            if (arr[M] == target) { // 中点的值正好等于target,找找到了该元素,返回true.
                return true;
            } else if (arr[M] < target) { // 目标值大于中点的值,则从中点+1的位置往右查找
                L = M + 1;
            } else { // 目标值小于中点的值,则从中点-1的位置往左查找
                R = M - 1;
            }
        }

        // 如果while循环没有找到target,则返回false;
        return false;
    }

    /**
     * 循环便利查找元素是否存在,主要是为了与二分查找做比较,
     * 首先要保证此方法绝对正确.
     *
     * @param sortedArr 有序数组
     * @param num       目标值
     * @return
     */
    public static boolean right(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }
}
