package com.dingxianginc;

/**
 * @author Moye
 * @version 1.0
 * @date 2021/4/2 1:14
 */
public interface IStackDemo {

    // 判断栈是否为空
    boolean isEmpty();

    // 判断栈是否为满
    boolean isFull();

    //入栈
    void push(Object obj);

    //出栈 删除并返回栈顶元素
    Object pop();

    //获取栈顶元素
    Object getTop();

    //打印栈内元素
    void display();

    //获取栈的容量
    int getStackSize();

    //获取栈中元素个数
    int length();
}
