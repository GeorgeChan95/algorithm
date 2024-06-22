package com.george.binary;

/**
 * <p>
 *     二进制学习
 * </p>
 *
 * @author George
 * @date 2024.06.22 08:13
 */
public class BinaryTest {
    public static void main(String[] args) {
        // 非负数
        int a = 78;
        System.out.println(a);
        printBinary(a);
        System.out.println("===a===");
        // 负数
        int b = -6;
        System.out.println(b);
        printBinary(b);
        System.out.println("===b===");

        // 直接写二进制的形式定义变量
        int c = 0b0000101110; // 使用 0b 开头，后面是 0和1 定义一个二进制数
        System.out.println(c);
        printBinary(c);
        System.out.println("===c===");
    }

    //
    //

    /**
     * 打印一个int类型的数字，32位进制的状态
     * 左侧是高位，右侧是低位
     * @param num 十进制数值
     */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            // 下面这句写法，可以改成 :
            // System.out.print((a & (1 << i)) != 0 ? "1" : "0");
            // 但不可以改成 :
            // System.out.print((a & (1 << i)) == 1 ? "1" : "0");
            // 因为a如果第i位有1，那么(a & (1 << i))是2的i次方，而不一定是1
            // 比如，a = 0010011
            // a的第0位是1，第1位是1，第4位是1
            // (a & (1<<4)) == 16（不是1），说明a的第4位是1状态
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }


}
