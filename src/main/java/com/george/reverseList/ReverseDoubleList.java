package com.george.reverseList;

public class ReverseDoubleList {
    public static void main(String[] args) {

        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleListNode node3 = new DoubleListNode(3);
        DoubleListNode node4 = new DoubleListNode(4);
        DoubleListNode node5 = new DoubleListNode(5);
        DoubleListNode node6 = new DoubleListNode(6);
        DoubleListNode node7 = new DoubleListNode(7);

        node1.last = null;
        node1.next = node2;

        node2.last = node1;
        node2.next = node3;

        node3.last = node2;
        node3.next = node4;

        node4.last = node3;
        node4.next = node5;

        node5.last = node4;
        node5.next = node6;

        node6.last = node5;
        node6.next = node7;

        node7.last = node6;
        node7.next = null;

        // 测试双向链表反转
        DoubleListNode node = reverseList(node1);
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    /**
     * 双向链表反转
     * @param head 头节点
     * @return
     */
    public static DoubleListNode reverseList(DoubleListNode head) {
        DoubleListNode last = null; // 前一个节点
        DoubleListNode next = null; // 下一个节点

        while (head != null) {
            next = head.next; // 获取当前节点的下一个节点

            head.next = last; // 前一个节点变成当前节点的下一个节点(链表方向反转)[原来头节点的last节点为空,反转后在链表末尾,next节点为空]
            head.last = next; // 下一个节点变成当前节点的前一个节点(方向反转)[原链表末尾节next节点为空,反转后变成头节点,last节点为空]

            last = head; // 当前节点变成前一个节点,指针后移
            head = next; // 指针指向下一个节点,进入下一轮循环.
        }
        return last; // 返回前一个节点,last是最后不为空的元素
    }
}
