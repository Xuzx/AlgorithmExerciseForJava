package com.xuzx.algorithm;

import java.util.Arrays;

public class SortingAlgorithmSample {
    public static void main(String[] args) {
        testBubbleSort();
        testInsertionSort();
        testSelectionSort();
    }

    /**
     * 冒泡排序算法[稳定]
     * 关键点：遍历数组，比较相邻两个元素大小，顺序不对交换位置
     * 最优时间复杂度O(n) 最坏时间复杂度O(n^2) 平均时间复杂度O(n^2)
     * @param array 待排序数组
     * @return 已排序数组（按从小到大排序）
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null)
            return null;

        int[] newArray = Arrays.copyOf(array, array.length); // 创建新数组并拷贝待排序数组数据，以免影响待排序数组数据
        int temp;
        boolean flag; // 是否发生数据交换标志位。若没有，则提前跳出外层循环
        for (int i = 0; i < newArray.length - 1; i++) {
            flag = false;
            for (int j = 1; j < newArray.length - i; j++) {
                if (newArray[j - 1] > newArray[j]) {
                    /*
                      方法一：常规数据交换
                     */
                    temp = newArray[j - 1];
                    newArray[j - 1] = newArray[j];
                    newArray[j] = temp;

                    /*
                      方法二：使用异或位运算符数据交换（无需临时变量）
                     */
                    /*newArray[j - 1] ^= newArray[j];
                    newArray[j] ^= newArray[j - 1];
                    newArray[j - 1] ^= newArray[j];*/
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        return newArray;
    }

    /**
     * 测试冒泡排序算法
     */
    public static void testBubbleSort() {
        System.out.println("测试冒泡排序算法:");
        int[] array = null;
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));

        array = new int[]{};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));

        array = new int[]{1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));

        array = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));

        array = new int[]{6, 5, 3, 1, 2, 1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println("\n");
    }

    /**
     * 插入排序算法[稳定]
     * 关键点：将数组分为已排序区间和未排序区间，遍历取未排序区间元素插入已排序区间
     * 最优时间复杂度O(n) 最坏时间复杂度O(n^2) 平均时间复杂度O(n^2)
     * @param array 待排序数组
     * @return 已排序数组（按从小到大排序）
     */
    public static int[] insertionSort(int[] array) {
        if (array == null) return null;

        int[] newArray = Arrays.copyOf(array, array.length);
        int j, temp;
        for (int i = 1; i < newArray.length; i++) { // 默认将数组第一个元素为已排序区间
            temp = newArray[i];
            j = i - 1;
            for (; j >= 0; j--) { // 从已排序区间尾部查找
                if (newArray[j] > temp) {
                    newArray[j + 1] = newArray[j];
                } else {
                    break; // 当前未排序元素比已排序区间尾部元素大，跳出循环并直接将其归为已排序区间的尾部
                }
            }
            newArray[j + 1] = temp;
        }
        return newArray;
    }

    /**
     * 测试冒泡排序算法
     */
    public static void testInsertionSort() {
        System.out.println("测试插入排序算法:");
        int[] array = null;
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(insertionSort(array)));

        array = new int[]{};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(insertionSort(array)));

        array = new int[]{1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(insertionSort(array)));

        array = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(insertionSort(array)));

        array = new int[]{6, 5, 3, 1, 2, 1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(insertionSort(array)));
        System.out.println("\n");
    }

    /**
     * 选择排序算法[不稳定]
     * 关键点：将数组分为已排序区间和未排序区间，在未排序区间查找最小元素，与已排序区间尾部+1位置元素进行交换
     * 最优时间复杂度O(n^2) 最坏时间复杂度O(n^2) 平均时间复杂度O(n^2)
     * @param array 待排序数组
     * @return 已排序数组（按从小到大排序）
     */
    public static int[] selectionSort(int[] array) {
        if (array == null) return null;

        int[] newArray = Arrays.copyOf(array, array.length);
        int minIndex; // 记录最小元素位置
        int temp;
        for (int i = 0; i < newArray.length - 1; i++) { // 注：临界点为 newArray.length - 1。假如临界点为 newArray.length，就多执行一圈无意义的外循环
            minIndex = i;
            for (int j = i + 1; j < newArray.length; j++) { // 遍历查找未排序区间最小元素
               if (newArray[minIndex] > newArray[j]) {
                   minIndex = j;
               }
            }

            if (i != minIndex) {
                /*
                  方法一：常规数据交换
                 */
                temp = newArray[i];
                newArray[i] = newArray[minIndex];
                newArray[minIndex] = temp;

                /*
                  方法二：使用异或位运算符数据交换（无需临时变量）
                 */
                /*newArray[i] ^= newArray[minIndex];
                newArray[minIndex] ^= newArray[i];
                newArray[i] ^= newArray[minIndex];*/
            }
        }
        return newArray;
    }

    public static void testSelectionSort() {
        System.out.println("测试选择排序算法:");
        int[] array = null;
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(selectionSort(array)));

        array = new int[]{};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(selectionSort(array)));

        array = new int[]{1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(selectionSort(array)));

        array = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(selectionSort(array)));

        array = new int[]{6, 5, 3, 1, 2, 1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(selectionSort(array)));
        System.out.println("\n");
    }
}
