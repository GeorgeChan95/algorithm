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
//            selectSort(arr);
//            bubbleSort(arr);
            insertSort(arr);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("测试结束");
    }

    /**
     * 选择排序
     *
     * @param arr 无序数组
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) { // 极值判断
            return;
        }
        for (int i = 0; i < arr.length; i++) { // 外层循环,每次循环找到一个最小值,并将它排序,数组中有多少元素,就需要循环排序多少次
            int minIndex = i; // 每一次循环中,先初始化一个最小值的位置索引,在后面的循环中再更新这个索引,直到找到最小值所在位置
            for (int j = i + 1; j < arr.length; j++) { // 内层循环目的是:找到数组元素中最小的值所在位置的索引.
                if (arr[minIndex] > arr[j]) { // 如果发现了比minIndex位置的值更小的值,就更新minIndex,这样就保证了minIndex始终是最小元素的索引
                    minIndex = j;
                }
            }
            // 找到外层循环中最小的值后,交换i位置和minIndex位置的值,目的是将最小的值往前放,在下一轮循环中不再遍历它了
            swap(arr, minIndex, i);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) { // 极值判断,无需排序
            return;
        }

        // 外层循环,从后往前遍历,目的是将数组按照从小到大的顺利排列
        // 使用 i>0 而不是 i>=0,是因为这是从后往前遍历,当后面的元素全部已经排好序之后,最后一个元素无需再比较,它只能是最小的那个.
        for (int i = arr.length - 1; i > 0; i--) {
            // 内存循环逐个比较当前元素与后一个元素的大小,如果当前元素大于后一个元素,则交换位置
            // i是数组的元素的个数,使用 j<i,而不是j<=i是因为要把j与j后面的元素比较大小和交换位置,无需遍历到最后一个元素.
            for (int j = 0; j < i; j++) {
                // 如果j大j+1的值,则将j与j+1位置交换
                // 在交换位置后,有开始下一轮for循环,再往后比较和交换每一个值,重复下去,直到找到最大的值放到数组右边
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) { // 极值判断
            return;
        }
        // 将arr数组的第0个元素看作是一个有序数组(就一个元素肯定有序),第1个元素到第arr.length-1个元素看作是无序数组,
        // 外层循环就是遍历这个无序数组,将它们逐个向有序数组中插入.
        for (int i = 1; i < arr.length; i++) {
            // arr数组中i-1位置到0位置是有序的,i位置(也就是j+1)就是本轮内层循环要比较插入的数
            // 内层循环从后向前(从大到小)遍历有序数组的每一个元素与j+1的数进行比较,如果j+1的数小,就往前插
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 交换数组中minIndex位置和curIndex位置的数
     *
     * @param arr      数组
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
