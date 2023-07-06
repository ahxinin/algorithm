package com.ahxinin.datastructure.hash;

import com.ahxinin.datastructure.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于数组简易实现哈希表
 */
public class ArrayHashMap {

    private List<Pair> buckets;

    public ArrayHashMap(){
        //初始化数组，包含100个桶
        buckets = new ArrayList<>();
        for (int i=0; i<100; i++){
            buckets.add(null);
        }
    }

    /*哈希函数 */
    private int hashFunc(int key){
        int index = key % 100;
        return index;
    }

    /*查询操作 */
    public String get(int key){
        int index = hashFunc(key);
        Pair pair = buckets.get(index);
        if (pair == null){
            return null;
        }
        return pair.val;
    }

    /*添加操作 */
    public void put(int key, String val){
        Pair pair = new Pair(key, val);
        int index = hashFunc(key);
        buckets.set(index, pair);
    }

    /*删除操作 */
    public void remove(int key){
        int index = hashFunc(key);
        //置为null，代表删除
        buckets.set(index, null);
    }

    /*获取所有键值对 */
    public List<Pair> pairSet(){
        List<Pair> pairList = new ArrayList<>();
        for (Pair pair : buckets){
            if (pair != null){
                pairList.add(pair);
            }
        }
        return pairList;
    }

    /*获取所有键 */
    public List<Integer> keySet(){
        List<Integer> keyList = new ArrayList<>();
        for (Pair pair : buckets){
            if (pair != null){
                keyList.add(pair.key);
            }
        }
        return keyList;
    }

    /*获取所有值 */
    public List<String> valueSet(){
        List<String> valueList = new ArrayList<>();
        for (Pair pair : buckets){
            if (pair != null){
                valueList.add(pair.val);
            }
        }
        return valueList;
    }
}
