package com.george.binary;

import java.sql.SQLOutput;

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

        // 直接写十六进制的形式定义变量
        // 0100 -> 4
        // 1110 -> e
        // 0x4e -> 01001110
        int d = 0x4e;
        System.out.println(d);
        printBinary(d);
        System.out.println("===d===");

        // ~、相反数
        System.out.println(a); // 打印结果：78
        printBinary(a); // 打印结果：00000000000000000000000001001110
        printBinary(~a); // 打印结果：11111111111111111111111110110001
        int e = ~a + 1;
        System.out.println(e); // 打印结果：-78
        printBinary(e); // 打印结果：11111111111111111111111110110010
        System.out.println("===e===");


        System.out.println(-8^7);
        printBinary(-8^7);
        System.out.println("===^异或===");


        System.out.println(2<<2); // 8
        System.out.println(-8<<2); // -32
        System.out.println("=== <<左移 ===");

        printBinary(8); // 00000000000000000000000000001000
        System.out.println(8>>1); // 4
        printBinary(8>>1); // 00000000000000000000000000000100
//        System.out.println(-8>>1);

        // 无符号右移1位相当于在原数的基础上除以2
        System.out.println(8);	// 8
        System.out.println(8>>1);	// 4
        // 无符号右移2位相当于在原数的基础上除以4
        System.out.println(8);		// 8
        System.out.println(8>>2);	// 2
        // 负数右移规则也适用
        System.out.println(-8>>1); // -4
        System.out.println("=== >>右移 ===");


        // 正数无符号右移
        System.out.println(8>>>1);
        printBinary(8);
        printBinary(8>>>1);
        // 负数无符号右移
        System.out.println(-8>>>1); // 2147483644
        printBinary(-8); // 11111111111111111111111111111000
        printBinary(-8>>>1); // 01111111111111111111111111111100
        System.out.println("=== >>>无符号右移 ===");

        printBinary(1 << 31);
    }

    //
    //

    /**
     * 打印一个int类型的数字，32位进制的状态
     * 左侧是高位，右侧是低位
     * 这里打印的是num的二进制补码。
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
