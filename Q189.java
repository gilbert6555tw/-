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
public class Q189 implements I1 {

    public static void main(String[] args) {
//输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
    int[] input = {1,2,3,4,5,6,7};
    new Q189().rotate(input, 3);
    int[] input2 = {1,2,3,4,5,6,7};
    new Q189_2().rotate(input2, 3);
    int[] input3 = {1,2,3,4,5,6,7};
    new Q189_3().rotate(input3, 3);
    }

    @Override
    public void rotate(int[] nums, int k) {
        //每次将数组旋转 1 个元素
        //temp = nums[nums.length()-1]
        //nums[nums.length()-1] = nums[nums.length()-2] ...
        for (int j = 0; j < k; j++) {
            int temp = nums[nums.length-1];
            for (int i = nums.length-1; i >= 1; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }
        System.out.println("nums="+Arrays.toString(nums));
    }
}
interface I1{
    void rotate(int[] nums, int k);
}
class Q189_2 implements I1 {

    @Override
    public void rotate(int[] nums, int k) {
        //方法 2：使用额外的数组
        int length = nums.length;
        int[] nums2 = new int[length];
        
        for (int i = 0; i < length; i++) {
            int j = (i + k) % length;
            nums2[j] = nums[i];
        }
       for (int i = 0; i < length; i++) {
           nums[i] = nums2[i];
       }
        System.out.println("nums="+Arrays.toString(nums));
    }
    
}
class Q189_3 implements I1 {

    @Override
    public void rotate(int[] nums, int k) {
        if(null == nums || nums.length == 0 ){
            return;
        }
        if(k < 1){
            return;
        }
        //方法 3：三次反转
        //将数组分为两段[0, k % length],[k % length+1 ,length]
        //分为三步:反转第一段 , 反转第二段, 反转整体
        int length = nums.length;
        int iForm1 = 0;
        int iTo1 = (k % length)-1;
        int iForm2 = (k % length);
        int iTo2 = length-1;
        //三次反转
        reverse(nums ,iForm1 ,iTo2);
        reverse(nums ,iForm1 ,iTo1);
//        System.out.println("nums="+Arrays.toString(nums));
        reverse(nums ,iForm2 ,iTo2);
//        System.out.println("nums="+Arrays.toString(nums));
        System.out.println("nums="+Arrays.toString(nums));
    }
    private void reverse(int[] nums, int iFrom ,int iTo) {
        while (iFrom < iTo) {
           swap(nums, iFrom++, iTo--);
        }
    }
    //交换数组的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
