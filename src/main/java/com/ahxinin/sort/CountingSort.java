package com.ahxinin.sort;

/*计数排序 */
public class CountingSort {

    //简单实现
    void countingSortNaive(int[] nums){
        //1.统计数组最大元素m
        int m = 0;;
        for (int num : nums){
            m = Math.max(m, num);
        }
        //2.统计各数字的出现次数
        int[] counter = new int[m + 1];
        for (int num : nums){
            counter[num]++;
        }
        //3.遍历counter,将各元素填入原数组nums
        int i = 0;
        for (int num=0; num<m + 1; num++){
            for (int j=0; j<counter[num]; j++,i++){
                nums[i] = num;
            }
        }
    }

    //完整实现，可排序对象
    void countingSort(int[] nums){
        //1.统计数组最大元素m
        int m = 0;
        for (int num : nums){
            m = Math.max(m, num);
        }
        //2.统计各数字的出现次数
        int[] counter = new int[m+1];
        for (int num : nums){
            counter[num]++;
        }
        //3.求counter的前缀和，将出现次数转换为尾索引
        for (int i=0; i<m; i++){
            counter[i+1] += counter[i];
        }
        //4.倒序遍历nums，将各元素填入结果数组res
        int n = nums.length;
        int[] res = new int[n];
        for (int i=n-1; i>=0; i--){
            int num = nums[i];
            res[counter[num]-1] = num;
            counter[num]--;
        }
        //使用结果数组res覆盖原数组nums
        for (int i=0; i<n; i++){
            nums[i] = res[i];
        }
    }
}
