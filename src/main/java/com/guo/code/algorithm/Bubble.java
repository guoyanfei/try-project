package com.guo.code.algorithm;

/**
 * 低效率 冒泡排序法
 *
 */
public class Bubble {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};

        // 让第i（num[0] - nums.length - 1）个数和后面的数依次比较，如果后面的数比较小，则和i交换位置

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 保证nums[i]里面的数字是最小值
                // > 升序
                // < 降序
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        for (int it : nums) {
            System.out.print(it + ",");
        }

    }
}
