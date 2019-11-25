/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class Q066 {

    public static void main(String[] args) {
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//示例 1:
//
//输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
        int[] digits = {1, 2, 3};
        int[] digits2 = new Q066().plusOne(digits);
        System.out.println("digits2="+Arrays.toString(digits2));
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }
}
