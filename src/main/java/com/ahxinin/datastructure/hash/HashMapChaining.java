package com.ahxinin.datastructure.hash;

import com.ahxinin.datastructure.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 链式地址哈希表
 */
public class HashMapChaining {

    int size;       //键值对数量
    int capacity;   //哈希表容量
    double loadThres;   //触发扩容的负载因子阈值
    int extendRatio;    //扩容倍数
    List<List<Pair>> buckets;   //桶数组

    public HashMapChaining(){
        size = 0;
        capacity = 4;
        loadThres = 2 / 3.0;
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);

        for (int i=0; i<capacity; i++){
            buckets.add(new ArrayList<>());
        }
    }

    /*哈希函数 */
    int hashFuc(int key){
        return key % capacity;
    }

    /*负载因子 */
    double loadFactor(){
        return (double) size / capacity;
    }

    /*查询操作 */
    String get(int key){
        int index = hashFuc(key);
        List<Pair> bucket = buckets.get(index);
        //遍历桶，若找到key则返回对应val
        for (Pair pair : bucket){
            if (pair.key == key){
                return pair.val;
            }
        }
        return null;
    }

    /*添加操作 */
    void put(int key, String val){
        //当负载因子超过阈值，进行扩容
        if (loadFactor() > loadThres){
            extend();
        }

        int index = hashFuc(key);
        List<Pair> bucket = buckets.get(index);
        //遍历桶，若遇到指定key，则更新对应val并返回
        for (Pair pair : bucket){
            if (pair.key == key){
                pair.val = val;
                return;
            }
        }
        //若无该key，则将键值对添加到尾部
        Pair pair = new Pair(key, val);
        bucket.add(pair);
        size++;
    }

    /*删除操作 */
    void remove(int key){
        int index = hashFuc(key);
        List<Pair> bucket = buckets.get(index);
        //遍历桶，删除键值对
        for (Pair pair : bucket){
            if (pair.key == key){
                bucket.remove(pair);
            }
        }
        size--;
    }

    /*扩容哈希表 */
    void extend(){
        //暂存原哈希表
        List<List<Pair>> bucketsTmp = buckets;
        //初始化扩容后的新哈希表
        capacity *= extendRatio;
        buckets = new ArrayList<>(capacity);
        for (int i=0 ; i<capacity; i++){
            buckets.add(new ArrayList<>());
        }
        size = 0;

        //将键值对从原哈希表搬运至新的哈希表
        for (List<Pair> bucket : bucketsTmp){
            for (Pair pair : bucket){
                put(pair.key, pair.val);
            }
        }
    }
}
