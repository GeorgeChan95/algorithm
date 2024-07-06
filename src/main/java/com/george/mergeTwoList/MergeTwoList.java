package com.george.mergeTwoList;

/**
 * 合并两个单向链表
 * 测试链接 : https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class MergeTwoList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        ListNode node9 = new ListNode(9);
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node9;

        ListNode node0 = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        node0.next = node2;
        node2.next = node4;
        node4.next = node6;
        node6.next = node8;

        // 测试合并两个单向链表
        ListNode mergeNode = merge(node1, node0);
        while (mergeNode != null) {
            System.out.print(mergeNode.val + " ");
            mergeNode = mergeNode.next;
        }
    }

    /**
     * 合并两个有序列表
     *
     * @param list1 有序链表1, 顺序: 由小到大
     * @param list2 有序链表2, 顺序: 由小到大
     * @return ListNode 合并后的有序链表
     */
    public static ListNode merge(ListNode list1, ListNode list2) {
        // 极值判断
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode cur1 = list1; // list1中当前正在比较的节点
        ListNode cur2 = list2; // list2中当前正在比较的节点
        ListNode head = null; // 已完成合并操作的链表(默认头节点是两个有序链表头节点中较小的一个)
        if (cur1.val <= cur2.val) {
            head = cur1;
            cur1 = cur1.next; // 更新cur1的头节点
        } else {
            head = cur2;
            cur2 = cur2.next; // 更新cur2的头节点
        }

        ListNode pre = head; // 临时节点,开始指向head, 后面通过pre不断调整head节点的next属性的引用

        while (cur1 != null && cur2 != null) { // 仅当两个队列当前操作的节点都不为空时,才需要进行比较与合并操作
            if (cur1.val <= cur2.val) {
                pre.next = cur1; // 当cur1的值小于cur2时,next指向cur1
                cur1 = cur1.next; // cur1节点后移,继续后面节点的比较
            } else {
                pre.next = cur2; // 当cur2的值小于cur1时,将cur2作为待合并的节点
                cur2 = cur2.next; // cur2节点后移,继续后面节点的比较
            }

            // 这一行同时也不断调整了head节点的next属性,扩充了head链表
            pre = pre.next; // 链表指针后移
        }

        // 当其中一个链表(假设是cur1)的最后一个节点完成了合并操作,而另一个链表(假设是cur2)还有剩余节点未合并,
        // 此时就需要将最后完成合并的节点(pre节点)的next指向还有节点未合并的链表(不为空的链表).
        // 这一步是必须存在的,因为两个有序链表合并,必然会存在其中一个节点先完成合并.
        pre.next = cur1 != null ? cur1 : cur2;

        // 返回合并后,完整的有序链表
        return head;
    }
}
