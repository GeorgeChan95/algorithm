package com.george.reverseList;

/**
 * 单向节点
 */
public class SinglyNode {
    public int val;

    /**
     * 下一个节点
     */
    public SinglyNode next;

    public SinglyNode(int val) {
        this.val = val;
    }

    public SinglyNode(int val, SinglyNode next) {
        this.val = val;
        this.next = next;
    }
}
