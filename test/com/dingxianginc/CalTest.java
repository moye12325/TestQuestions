package com.dingxianginc;

/**
 * @author Moye
 * @version 1.0
 * @date 2021/4/1 23:36
 */
public class CalTest {
    public static void main(String[] args) {
        CalculatorDemo calculatorDemo = new CalculatorDemo();
        if (calculatorDemo.add(8.2, 2.3).equals("10.50")) {
            System.out.println("add method test passed!");
        } else {
            System.out.println("add method test failed!");
        }

        System.out.println("----------------------------------------分隔符----------------------");

        if (calculatorDemo.sub(8.3, 2).equals("6.30")) {
            System.out.println("sub method test passed");
        } else {
            System.out.println("sub method test failed!");
        }

        System.out.println("----------------------------------------分隔符----------------------");

        if (calculatorDemo.mul(8, 2).equals("16.00")) {
            System.out.println("mul method test passed!");
        } else {
            System.out.println("mul method test failed!");
        }

        System.out.println("----------------------------------------分隔符----------------------");

        if (calculatorDemo.div(8, 2).equals("4.00")) {
            System.out.println("div method test passed!");
        } else {
            System.out.println("div method test failed!");
        }
        System.out.println(calculatorDemo.div(9, 0) + "在float中，除数为0时会被作为无穷小，故会输出Infinity");

        System.out.println("----------------------------------------分隔符----------------------");


        String arr[] = {"02", "02", "-1", "12", "12.000", "12.001", "12.0", "12.00"};
        //此处为了校验结果 在max()中保留三位小数
        if (calculatorDemo.max(arr).equals("12.001")) {
            System.out.println("max method test passed!");
        } else {
            System.out.println("max method test failed!");
        }

        System.out.println("----------------------------------------分隔符----------------------");

        if (calculatorDemo.mixComputing("3*(5+3)/2").equals("12.00")) {
            System.out.println("mixComputing method test passed!");
        } else {
            System.out.println("mixComputing method test failed!");
        }

        String[] expr = {"3+2", "2+4/2", "3*3"};
        String[] expr3 = calculatorDemo.batchComputing(expr);
        String[] expr1 = {"5.00", "4.00", "9.00"};

        for (int i = 0; i < expr.length; i++) {
            if (expr3[i].equals(expr1[i])) {
                System.out.println("batchComputing批量计算的第" + (i + 1) + "次的计算正确");
            } else {
                System.out.println("batchComputing批量计算的第" + (i + 1) + "次的计算错误");
            }
        }
    }
}
