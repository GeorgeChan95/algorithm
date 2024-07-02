package com.george.baseSort;

import java.util.Arrays;

/**
 * 选择排序, 冒泡排序, 插入排序
 */
public class SelectBubbleInsert {
    public static void main(String[] args) {
        int N = 20; // 生成数组的长度: [0,100)
        int V = 1000; // 生成数的范围: [0,1000)
        int testTime = 5; // 测试次数

        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            // 生成一个不大于N的数,作为数组的长度
            int n = (int) (Math.random() * N);
            // 生成一个随机数组
            int[] arr = randomArray(n, V);
            System.out.println("生成数组: " + Arrays.toString(arr));

            System.out.println("排序后 ====================");
            // 选择排序
            selectSort(arr);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("测试结束");
    }

    /**
     * 选择排序
     * @param arr 无序数组
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) { // 极值判断
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i; // 默认最小值在数组中的位置索引
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) { // 如果发现了比minIndex位置的值更小的值,就更新minIndex,这样做是为了找到在此轮循环中最小的值的索引
                    minIndex = j;
                }
            }
            // 找到外层循环中最小的值后,交换i位置和minIndex位置的值,目的是将最小的值往前放,在下一轮循环中不再遍历它了
            swap(arr, minIndex, i);
        }
    }

    /**
     * 交换数组中minIndex位置和curIndex位置的数
     * @param arr 数组
     * @param minIndex 最小值所在位置索引
     * @param curIndex 当前值所在位置索引
     */
    public static void swap(int[] arr, int minIndex, int curIndex) {
        int temp = arr[curIndex];
        arr[curIndex] = arr[minIndex];
        arr[minIndex] = temp;
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
}
