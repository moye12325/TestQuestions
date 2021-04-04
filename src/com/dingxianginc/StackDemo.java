package com.dingxianginc;

/**
 * @author Moye
 * @version 1.0
 * @date 2021/4/2 1:15
 */
public class StackDemo implements IStackDemo {

    /*
     * 使用数组模拟栈的实现
     * */

    private Object[] stack;
    //栈的容量
    private int size;
    //栈顶标记
    private int top = -1;

    public StackDemo() {
        this.size = 10;
        stack = new Object[10];
    }

    public StackDemo(int size) {
        this.size = size;
        stack = new Object[this.size];
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    // 判断栈是否为满
    @Override
    public boolean isFull() {
        if (top == (size - 1)) {
            return true;
        }
        return false;
    }

    //入栈
    @Override
    public void push(Object obj) {
        if (!isFull()) {
            stack[++top] = obj;
        } else {
            System.out.println("栈已满");
        }
    }

    //出栈 删除并返回栈顶元素
    @Override
    public Object pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            System.out.println("栈为空");
        }
        return null;
    }

    //获取栈顶元素
    @Override
    public Object getTop() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("栈为空");
        }
        return null;
    }

    //打印栈内元素
    @Override
    public void display() {
        if (!isEmpty()) {
            for (int i = 0; i <= top; i++) {
                System.out.println(stack[i]);
            }
        }
    }

    //获取栈的容量
    @Override
    public int getStackSize() {
        return size;
    }

    //获取栈中元素个数
    @Override
    public int length() {
        return top + 1;
    }

}

