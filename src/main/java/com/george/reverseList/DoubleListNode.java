package com.george.reverseList;

public class DoubleListNode {

    public int value;
    /**
     * 前一个节点
     */
    public DoubleListNode last;
    /**
     * 下一个节点
     */
    public DoubleListNode next;

    public DoubleListNode(int value) {
        this.value = value;
    }
}
