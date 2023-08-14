package com.ahxinin.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*桶排序 */
public class BucketSort {

    void bucketSort(float[] nums){
        //初始化 k = n/2 个桶，预期向每个桶分配 2 个元素
        int k = nums.length / 2;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i=0; i<k; i++){
            buckets.add(new ArrayList<>());
        }

        //将数组元素分配到各个桶中
        for (float num : nums){
            //输入数据范围[0,1),使用 num*k 映射到索引范围 [0, k-1]
            int i = (int) (num * k);
            //将num添加进桶i
            buckets.get(i).add(num);
        }
        //对各个桶进行排序
        for (List<Float> bucket : buckets){
            //使用内置排序函数
            Collections.sort(bucket);
        }
        //遍历桶合并结果
        int i = 0;
        for (List<Float> bucket : buckets){
            for (float num : bucket){
                nums[i++] = num;
            }
        }
    }
}
