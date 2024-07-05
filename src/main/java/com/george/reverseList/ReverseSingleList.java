package com.george.reverseList;

/**
 * 单链表反转
 */
public class ReverseSingleList {


    public static void main(String[] args) {
        SinglyNode s1 = new SinglyNode(1);
        SinglyNode s2 = new SinglyNode(2);
        SinglyNode s3 = new SinglyNode(3);
        SinglyNode s4 = new SinglyNode(4);
        SinglyNode s5 = new SinglyNode(5);
        SinglyNode s6 = new SinglyNode(6);
        SinglyNode s7 = new SinglyNode(7);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;

        SinglyNode node = s1;
        System.out.println("原单向链表如下:");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println("===================");

        SinglyNode nodeReversed = reverseSinglyList(s1);
        System.out.println("反转后单向链表如下:");
        while (nodeReversed != null) {
            System.out.print(nodeReversed.val + " ");
            nodeReversed = nodeReversed.next;
        }
    }

    /**
     * 单向链表反转
     * @param head 头节点
     * @return
     */
    public static SinglyNode reverseSinglyList(SinglyNode head) {
        SinglyNode pre = null; // 当前节点的前一个节点,默认是null
        SinglyNode next = null; // 当前节点的下一个节点,默认是null

        while (head != null) {
            next = head.next; // 获取当前节点的下一个节点
            head.next = pre; // 当前节点的前一个节点变成当前的下一个节点(方向反转)

            pre = head; // 当前节点赋值给pre,指针后移
            head = next; // 指针移动到next节点,继续循环
        }
        return pre;
    }
}
