package com.ahdy.xem.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        System.out.println(list);

        int[] srcCopyArray = new int[4];
        srcCopyArray[0] = 1;
        srcCopyArray[1] = 2;
        srcCopyArray[2] = 3;
        srcCopyArray[3] = 4;
        int[] dstArray = new int[10];
        // 源 - 从下表index复制
        int srcCopyBeginIndex = 0;
        // 目标 - 从下表index粘贴
        int dstArrayBeginIndex = 0;
        // 复制长度
        int copyLength = srcCopyArray.length;

        System.arraycopy(srcCopyArray, srcCopyBeginIndex, srcCopyArray, dstArrayBeginIndex + 1, copyLength);
        System.out.println(Arrays.toString(srcCopyArray));

    }
}
