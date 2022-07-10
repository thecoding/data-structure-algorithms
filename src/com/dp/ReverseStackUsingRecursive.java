package com.dp;

import java.util.Stack;

/**
 * 栈的反转，不是用额外的空间，仅仅使用递归
 */
public class ReverseStackUsingRecursive {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        System.out.println(stack);
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()) {
            return;
        }
        int last = f(stack); //拿到最后的元素
        reverse(stack);
        stack.push(last);
    }

    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else{
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
}
