/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class Q001 implements Q001IF {

    public static void main(String[] args) {
//给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
        int[] nums1 = {2, 7, 11, 15};
        int target = 9;
        int[] result = new Q001().twoSum(nums1, target);
        System.out.println("result=" + Arrays.toString(result));
        
        nums1 = new int[]{2, 7, 11, 15};
        int[] result2 = new Q001_2().twoSum(nums1, target);
        System.out.println("result=" + Arrays.toString(result2));
    }

    public int[] twoSum(int[] nums, int target) {
        //方法一：暴力法
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int num2 = nums[j];
                if (num2 == complement) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}

interface Q001IF {

    int[] twoSum(int[] nums, int target);
}

class Q001_2 implements Q001IF {

    @Override
    public int[] twoSum(int[] nums, int target) {
//        方法三：一遍哈希表
        //key=value, value=index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int complement = target - num1;
            if (!map.containsKey(complement)) {
                map.put(num1, i);
            } else {
                
                return new int[]{map.get(complement) ,i};
            }
        }
        return null;
    }

}
