package com.zyp.recordyoyo.utils;

/**
 * use on future
 * Created by zyp on 2016/1/26.
 */
public class SortUtil {

    //objects sorted
    void sortVectory(Integer[] objects, int start, int end) {
        while (end > start) {
            int index = quickSort(objects, start, end);
            sortVectory(objects, start, index - 1);
            sortVectory(objects, index + 1, end);
        }
    }

    int quickSort(Integer[] objects, int start, int end) {
        Integer key = objects[end];
        int index = start;
        for (int i = start; i <= end; i++) {
            if (objects[i] < key) {
                objects[index] = objects[index] ^ objects[i];
                objects[i] = key ^ objects[i];
                objects[index] = key ^ objects[i];
                index++;
            }
        }
        objects[index] = objects[index] ^ key;
        key = key ^ objects[index];
        objects[index] = key ^ objects[index];
        return index;
    }
}
