package com.dingxianginc;

/**
 * @author Moye
 * @version 1.0
 * @date 2021/4/1 22:26
 */
public class CalculatorDemo extends Calculator {
    @Override
    public Object add(Object leftValue, Object rightValue) {
        float left = Float.parseFloat(leftValue.toString());
        float right = Float.parseFloat(rightValue.toString());
        float sum = left + right;
        return String.format("%.2f", sum);
    }

    @Override
    public Object sub(Object leftValue, Object rightValue) {
        float left = Float.parseFloat(leftValue.toString());
        float right = Float.parseFloat(rightValue.toString());
        float dif = left - right;
        return String.format("%.2f", dif);
    }

    @Override
    public Object mul(Object leftValue, Object rightValue) {
        float left = Float.parseFloat(leftValue.toString());
        float right = Float.parseFloat(rightValue.toString());
        float pro = left * right;
        return String.format("%.2f", pro);
    }

    @Override
    public Object div(Object leftValue, Object rightValue) {
        try {
            float left = Float.parseFloat(leftValue.toString());
            float right = Float.parseFloat(rightValue.toString());
            float quo = left / right;
            return String.format("%.2f", quo);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String max(String[] values) {

        //接收转换类型后的数组
        float[] nums = new float[values.length];
        float max = nums[0];

        //转换数组类型 方便查找最大值
        for (int i = 0; i < values.length; i++) {
            nums[i] = Float.parseFloat(values[i]);
        }

        //查找最大值
        for (int j = 0; j < nums.length; j++) {
            if (max < nums[j]) {
                max = nums[j];
            }
        }
        return String.format("%.3f", max);
    }

    /**
     * 给出符号的优先级，//乘除2，加减1
     *
     * @param ch
     * @return
     */
    private static int priority(char ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else if (ch == '+' || ch == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    private static float calc(float num1, float num2, char ch) {
        float result = 0;
        switch (ch) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new RuntimeException("Incorrect symbol");
        }
        return result;
    }

    @Override
    public String mixComputing(String expression) {
        //stack1为存放num的栈
        //stack2存放运算符
        StackDemo stack1 = new StackDemo();
        StackDemo stack2 = new StackDemo();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= 48 && expression.charAt(i) <= 57) {
                //遇到数字，则继续往后找字符，如果仍然是数字或者'.'，则拼接成一个数
                int j = 1;
                while ((i + j) < expression.length() && (expression.charAt(i + j) >= 48 && expression.charAt(i + j) <= 57 || expression.charAt(i + j) == '.')) {
                    j++;
                }
                float num = Float.valueOf(expression.substring(i, i + j));
                stack1.push(num);
                i = i + j - 1;
            } else {
                char ch = expression.charAt(i);
                if (ch == '(') {
                    int countBracket = 0;
                    //定义一个计数器来表示遇到的左括号个数
                    for (int j = i; j < expression.length(); j++) {
                        //从左括号的索引开始，再遍历表达式
                        if (expression.charAt(j) == '(') {
                            //如果遇到左括号，计数器+1
                            countBracket++;
                        }
                        if (expression.charAt(j) == ')') {
                            //如果遇到右括号，计数器-1
                            countBracket--;
                        }
                        if (countBracket == 0) {
                            //当计数器为0时，当前索引就是与左括号对应的右括号
                            stack1.push(mixComputing(expression.substring(i + 1, j)));
                            //递归求出括号内的值
                            i = j;
                            //结束之后，直接跳过括号
                            break;
                            //不再遍历
                        }
                    }
                    continue;
                    //处理完括号 跳过本次循环，进行判断
                }
                //判断符号栈中最顶部的符号和要入栈的符号的优先级
                if (!stack2.isEmpty() && priority(ch) < priority((Character) stack2.getTop())) {
                    //如果要入栈的符号比栈顶符号优先级小
                    //需要将数栈中的最上边两个数取出，进行运算
                    float num1 = (float) stack1.pop();
                    float num2 = (float) stack1.pop();
                    float result = (float) calc(num2, num1, (Character) stack2.pop());
                    //注意，num2要在num1前面
                    stack1.push(result);
                    //计算结果入栈
                    stack2.push(ch);
                    //当前符号入栈
                } else {
                    stack2.push(ch);
                    //如果要入栈的符号比栈顶符号优先级大，则入栈
                }
            }
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            float num1 = Float.parseFloat(stack1.pop().toString());
            float num2 = Float.parseFloat(stack1.pop().toString());
            float result = (float) calc(num2, num1, (Character) stack2.pop());
            stack1.push(result);
        }

        return String.format("%.2f", stack1.pop());
    }

    @Override
    public String[] batchComputing(String[] expression) {
        String[] res = new String[expression.length];
        for (int i = 0; i < expression.length; i++) {
            res[i] = mixComputing(expression[i]);
        }
        return res;
    }
}
