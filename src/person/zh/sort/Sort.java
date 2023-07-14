package person.zh.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Sort {


    @Test
    public void test() {
        char[] chars = new char[]{2};
        System.out.println(chars[0]);
        System.out.println(chars.length);
    }

    public static void main(String[] args) {
        // 测试次数
        int testTimes = 1000;
        // 最大测试容量
        int maxSize = 20;
        // 最大测试数据
        int maxNum = 30;
        boolean equals = true;
        for (int i = 0; i < testTimes; i++) {

            int arr1[] = generateRandomArray(maxSize, maxNum);
            int arr2[] = copyArr(arr1);

            Arrays.sort(arr1);
//            quickSort3(arr2, 0 , arr2.length - 1);
//            mergeSort3(arr2, 0, arr2.length - 1);
            heapSort2(arr2);

            printArr(arr1);
            printArr(arr2);

            // 比较两数组是否完全相同
            if (!isEquals(arr1, arr2)) {
                // 有不同设为false并结束循环
                equals = false;
                break;
            }
        }
        System.out.println(equals ? "完全ok" : "存在问题");
    }

    /**
     * 冒泡排序
     * @param arr
     * 思想：每次从前往后遍历，遇到更大的就和下一个交换，每遍历一遍，就有一个当前最大的冒泡到数组后面，即其正序位置
     */
    public static void bubbleSort2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    /**
     * 冒泡排序 从小到大
     * @param arr
     * @date 220921
     */
    public static void bubbleSort1(int[] arr) {
        // 每次得到一个位置上的值，每次大小不对就交换，O(n^2)/O(1)

        for (int i = arr.length - 1; i >= 0; i--) {
           boolean flag = false;
           for (int j = 0; j < i; j++) {
               if (arr[j] < arr[j + 1]) {   // 当前元素比后一个元素大 交换
                   swap(arr, j, j + 1);
                   flag = true;
               }
           }
           if (!flag) {
               break;
           }
        }
    }
    // 冒泡排序
    public static void bubbleSort(int arr[]) {
        boolean flag = false;
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {    // 没有交换过代表已经排序好 直接return
                return;
            } else {
                flag = false; // 重置flag进行下次判断
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     * 思想：每次记录当前遍历过程中的最大值的下标，和未排序的最后一个位置交换，确定此位置的元素
     */
    public static void selectSort2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, i);
        }
    }
    /**
     * 选择排序 从小到大
     * @param arr
     * O(n^2)/O(1)
     */
    public static void selectSort1(int[] arr) {
        // 每次记录当前寻找到的最大值的索引 和最后位置的数进行交换
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = i;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[temp]) {
                    temp = j;
                }
            }
            // 上面循环完 temp位置的数是未定数中最大
            swap(arr, temp, i);
        }
    }
    // 选择排序 在(0, len-1)中找到最小的一个和arr[0]交换，再从(1, len-1)中找到最小的和arr[1]交换...
    public static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // minIndex存放最小值的下标
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     * 思想：第一个元素看作有序的，从第二个元素开始，将后面的元素插入到前面的有序部分
     */
    public static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 将当前元素插入到有序部分
            int temp = arr[i];  //记录一下要排序的元素值
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }
    /**
     * 插入排序 从小到大
     * @param arr
     * 第一个有序，从第二个数开始插入到数组中对应位置，需要整体移动元素
     * 不是很熟
     */
    public static void insertSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 从头遍历 给原数组中第i个位置元素寻找应该在的位置
            int temp = arr[i];  // 暂存一下 不然一会儿后移时会被覆盖
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }
    // 插入排序 将数组中元素看作第一个有序，后面n-1个无序，逐个将无序的元素插入到应在的位置上    需练习
    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {  // 从第一个无序元素（第二个元素），开始插入
            int temp = arr[i]; // 保存着这个较小的值
            int j;
            for (j = i - 1; j >= 0; j--) {  // 从此无序元素向前遍历
                if (temp < arr[j]) {        // 比此无序元素大则继续向前，比它小就break，找到了位置在j+1处
                    arr[j +1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * 希尔排序
     * @param arr
     * 思想：增量排序，逐渐缩小排序间距，将间距为k的元素划分为一组，组内插入排序，不断缩小间距
     */
    public static void shellSort3(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) { // gap每次减半
            for (int i = gap; i < arr.length; i++) {        // 对当前组内插入排序
                int cur = arr[i];    // 当前要排序的元素值
                int j = i - gap;
                for (; j >= 0; j -= gap) {
                    if (arr[j] > cur) {
                        arr[j + gap] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + gap] = cur;
            }
        }
    }
    /**
     * 希尔排序 从小到大
     * @param arr
     * 又名缩小增量排序 直接插入排序的改进版
     * 起始增量为arr.length/2，分成若干组，对每组分别进行直接插入排序，每次为原来1/2，直到为1 排完序即为有序
     * 从index为gap处开始插入排序，即为从第一组的第二个元素开始按组插入排序，
     * 确定是哪个元素要排序 确定最终要插入的位置 插入位置后面的元素后移腾出位置
     *
     */
    public static void shellSort1(int[] arr) {
        // 初始增量为arr.length/2
        // 2 3 6 5 8 7 10 4 1 9
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {     // gap依次减半
            for (int i = gap; i < arr.length; i++) {            // 从每组的第二个元素开始插入排序
                // 对每一组进行插入排序
                int j = i;  // 当前要进行排序的元素的下标
                int temp = arr[j];  // 当前要进行排序的元素值
                if (temp < arr[j - gap]) {  //
                    // 寻找当前要进行排序元素应该在的位置
                    while (j >= gap && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;   // j前移寻找位置
                    } // 循环完后，j处位置就是i应该插入的位置 此位置以及后面的元素后移gap
                    arr[j] = temp;
                }
            }
        }
    }
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {     // gap初始值 每次减半
            for (int i = gap; i < arr.length; i++) {            // 从第一组的第二个元素开始按组插入排序
                int j = i, temp = arr[i];                       // 这里要暂存arr[i] 因为移动的时候会被覆盖
                if (temp < arr[i - gap]) {                    // 如果j比之前元素小 才需要排序 不然本来就是有序的 不需要在排了
                    while (j >= gap && temp < arr[j- gap]) { // 后面元素更小时
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
    // 希尔排序 缩小增量排序 交换式和插入式，插入式速度快，交换式没有意义   需练习
    public static void shellSort(int arr[]) {
        // 插入式希尔排序
        for (int gap = arr.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) { // a[i]就是待插入元素
                int j = i;
                int temp = arr[j];
                if (temp < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];  // 大数后移
                        j -= gap;               // 存下当前更合适的位置
                    }
                    // 当退出while后就找到了temp应该插入的位置
                    arr[j] = temp;
                }
            }
        }

        /*交换式
        // 第一层为每次的间隔，每次循环间隔会缩小为原来一半
        for (int gap = arr.length/2; gap >0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        swap(arr, j ,j + gap);
                    }
                }
            }
        }*/
        /* 交换式推导步骤
       for (int i = 5; i < arr.length; i++) {
            // 遍历数组中所有的元素，每组2个数，步长为5
            for (int j = i - 5; j >=0 ; j -= 5) {
                // 比较相距长度为5的两数大小，前面大的则交换
                if (arr[j] > arr[j + 5]) {
                    swap(arr, j, j + 5);
                }
            }
        }
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >=0 ; j-= 2) {
                // 比较相距长度为2的两数大小，前面大的则交换
                if (arr[j] > arr[j + 2]) {
                    swap(arr, j, j + 2);
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >=0 ; j-= 1) {
                // 比较相距长度为1的两数大小，前面大的则交换
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }*/
    }

    /**
     * 快排
     * @param arr
     * 思想：递归+分治的思想，每次确定一个位置的元素值，然后这个确定的元素值两侧再各自快排
     */
    public static void quickSort3(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        Random random = new Random();
        // 产生[left,right + 1)之间随机数
        int pivot = random.nextInt(right - left + 1) + left;
        // 给这个数寻找其正序位置
        swap(arr, pivot, left);

        int i = left;
        int j = right;
        while (i < j) {
            // 从右往左 找比arr[left]小的
            while (i < j && arr[j] >= arr[left]) {
                j--;
            }
            // 从左往右 找比arr[left]大的
            while (i < j && arr[i] <= arr[left]) {
                i++;
            }
            if (i < j) {
                swap(arr, i , j);
            }
        }
        swap(arr, left, j);
        quickSort3(arr, left, j - 1);
        quickSort3(arr, j + 1, right);
    }
    /**
     * 快排 从小到大
     * @param left
     * @param right
     * 快排思想：随机选择一个元素确定其位置，然后递归将它前面部分排序，后面部分排序
     * 随机选择一个元素pivot之后 将其交换到left位置，
     * 然后从left+1 ~ right, 进行对向指针，
     * 右指针寻找比pivot小的，左指针寻找比pivot大的，都找到之后，交换
     * 3 5
     */
    public static void quickSort2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        Random random = new Random();
        int randIndex = random.nextInt(right - left + 1) + left;
        swap(arr, left, randIndex);
        int le = left;
        int ri = right;
        int pivot = arr[left];
        while (le < ri) {
            while (ri > le && arr[ri] >= pivot) {
                ri--;
            }
            while (le < ri && arr[le] <= pivot) {
                le++;
            }
            if (le >= ri) {
                break;
            }
            swap(arr, le, ri);
        }
        // while循环完成 最终le位置就是pivot应该在的位置
        swap(arr, le, left);
        quickSort2(arr, left, le - 1);
        quickSort2(arr, le + 1, right);
    }
    /**
     * 快排 由小到大
     * @param arr   要排序的数组
     * @param left  要排序的数左边界
     * @param right 要排序的右边界
     * 220928
     */
    public static void quickSort1(int arr[], int left, int right) {
        // 递归终止条件
        if (left > right) {
            return;
        }
        // 选出一个分界数组的元素 排完这一趟排序 这个元素的左边都是小的 右边都是大的
        int l = left, r = right;
        int pivot = left;
        while (l < r) {
            while (arr[r] >= arr[pivot] && l < r) {
                r--;
            }
            while (arr[l] <= arr[pivot] && l < r) {
                l++;
            }
            swap(arr, l ,r);
        }
        // 上面交换完之后 l = r 这个位置的左边都是比pivot小的 右边都是比pivot大的 将pivot放到这个位置
        swap(arr, l, pivot);
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }
    // 快速排序 需练习
    public static void quickSort(int arr[], int left, int right) {
        // 以第一个数为基准，左右指针分别向中间遍历，右边先动，右边找比基准小的，左边找比基准大的，找到进行交换，
        // 最终两指针指向的同一位置就是基准所在位置，然后递归完成排序
        if(left > right) {
            return;
        }
        int pivot = arr[left];  // pivot中存放基准数
        int l = left, r = right;
        while (l < r) {
            // 从右往左 找到第一个小于基准的数
            while (arr[r] >= pivot && l < r) {
                r--;
            }
            // 从左往右 找到第一个大于基准的数
            while (arr[l] <= pivot && l < r) {
                l++;
            }
            // 交换
            if (l < r) {
                swap(arr, l, r);
            }
        }
        // 最后将基准为与l和r相等位置的交换
        arr[left] = arr[l];
        arr[l] = pivot;
        quickSort(arr, left, l - 1);
        quickSort(arr, r + 1, right);
    }

    public static void mergeSort3(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort3(arr, start, mid);
        mergeSort3(arr, mid + 1, end);
        merge3(arr, start, mid, end);
    }
    public static void merge3(int[] arr, int start, int mid, int end) {
        // 借助一个数组将start -> end这一段排好序
        int[] helper = new int[end - start + 1];
        int s1 = start;
        int s2 = mid + 1;
        int index = 0;
        while (s1 <= mid && s2 <= end) {
            if (arr[s1] <= arr[s2]) {
                helper[index++] = arr[s1++];
            } else {
                helper[index++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            helper[index++] = arr[s1++];
        }
        while (s2 <= end) {
            helper[index++] = arr[s2++];
        }
        // 将辅助数组中排好序的数复制回原数组
        index = 0;
        for (int i = start; i <= end; i++) {
            arr[i] = helper[index++];
        }
    }
    /**
     * 归并排序2
     * 忘记了函数应该用什么参数
     */
    public static void mergeSort2(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort2(nums, left, mid);
        mergeSort2(nums, mid + 1, right);
        merge2(nums, left, mid, right);
    }
    public static void merge2(int[] nums, int left, int mid, int right) {
        // 借助一个数组将left-mid两部分进行排序合并
        int[] arr = new int[right - left + 1];
        int index = 0;
        int start1 = left;       // 左半部分的起始
        int start2 = mid + 1;    // 右半部分的起始
        while (start1 <= mid && start2 <= right) {
            // 正序
            if (nums[start1] <= nums[start2]) {
                arr[index++] = nums[start1++];
            } else {
                // nums[start1] > nums[start2]
                arr[index++] = nums[start2++];
            }
        }
        while (start1 <= mid) {
            arr[index++] = nums[start1++];
        }
        while (start2 <= right) {
            arr[index++] = nums[start2++];
        }
        for (int i = 0; i < arr.length; i++) {
            nums[left + i] = arr[i];
        }
    }
    /**
     * 归并排序1
     * @param arr
     * @param left
     * @param right
     * 看完思路写的代码
     * 递归划分左右组 划分后的两组再合并为有序
     * 合并时需要借助数组，合并到另外的数组中，再复制回原数组
     */
    public static void mergeSort1(int[] arr, int left, int right) {
        // 分
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort1(arr, left, mid);
        mergeSort1(arr, mid + 1, right);
        // 合并
        merge1(arr, left, mid, right);
    }
    public static void merge1(int[] arr, int left, int mid, int right) {
        // 使用额外数组，将arr的左右部分合并为有序的放在此数组中，排完序复制回arr
        int[] temp = new int[right - left + 1];     // 额外数组
        int l = left, r = mid + 1, index = 0;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[index++] = arr[l++];
            } else {
                temp[index++] = arr[r++];
            }
        }
        while (l <= mid) {
            temp[index++] = arr[l++];
        }
        while (r <= right) {
            temp[index++] = arr[r++];
        }
        index = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = temp[index++];
        }
    }
    // 归并排序
    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;   // 中间索引
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1,right);
            merge(arr, left, mid, right);
        }

    }
    // 归并排序的merge  借助一个数组将两个有序序列合并为一个有序序列
    public static void merge(int arr[], int left, int mid, int right) {
        int temp[] = new int[arr.length];
        int i = left;   // 初始化i，左边有序序列的初始索引
        int j = mid + 1;// 初始化j，右边有序序列的初始索引
        int t = 0;  // 指向temp数组的当前索引

        // 先把两边的有序序列的数据按照顺序填充到temp数组中
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
                temp[t++] = arr[i++];
        }
        while (j <= right) {
                temp[t++] = arr[j++];
        }

        // 将临时数组中的数据copy到arr中 并不是每次都是拷贝全部数据 从左边开始拷
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    /**
     * 堆排序
     * @param arr
     * 大根堆实现 升序排序
     */
    public static void heapSort2(int[] arr) {
        // 构建堆 非叶子节点 挨个heapify
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify2(arr, i, arr.length);
        }
        // 上面构建好了堆之后，进行排序
        for (int i = arr.length - 1; i > 0; i--) {
            // 排序，将堆顶的元素与末尾元素交换，确定这个元素的顺序
            swap(arr, i, 0);
            // 将末尾的元素交换到堆顶之后，重新调整堆 维持堆结构
            heapify2(arr, 0, i);
        }
    }
    /**
     * 调整堆中index位置上的元素，使其维持堆结构
     * @param arr 数组
     * @param index 要调整的元素的位置
     * @param length 数组中无序部分长度
     * index出元素如果比左右孩子小，则下沉，直到比左右孩子都大，或者下沉为叶子节点了
     */
    public static void heapify2(int[] arr, int index, int length) {
        int temp = arr[index];
        // index处的值和叶子节点进行比较
        for (int j = index * 2 + 1; j < length; j = j * 2 + 1) {
            // 比较左右孩子 哪个更大， 让j指向更大的那个孩子
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            // 如果孩子比当前值大
            if (arr[j] > temp) {
                // 这个较大值上浮
                arr[index] = arr[j];
                // index用来记录temp下沉到的位置
                index = j;
            } else {
                break;
            }
        }
        // 上面交换之后temp(要下沉的元素)最终就在index位置
        arr[index] = temp;
    }

    // 基数排序 空间换时间  仅限于正数，有负数的思路是找出最大数的时候也找出最小数，将所有数加上最小数的绝对值，最终再全部减去，
    // 如果有数字很大，取反加溢出的话，考虑正负分开排序，排完拼接
    public static void radixSort(int arr[]) {
        // 1.先找到数组中最大的数，求其位数maxLength(转字符串求length可得)
        // 2.10个桶存放arr中的数，1个桶记录10个桶中各有多少个数，进行maxLength轮排序
        if (arr.length == 0) {
            return;
        }
        int maxNum = arr[0];
        for (int val : arr) {
            if (val > maxNum) {
                maxNum = val;
            }
        }
        int maxLength = (maxNum + "").length(); // 找到最大位数

        for (int i = 0, n = 1; i < maxLength; i++, n*= 10) {
            // 第一轮排序
            int bucket[][] = new int[10][arr.length];       // 10个桶 每个桶要能容下所有的数
            int bucketElementCounts[] = new int[10];        //
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;   //  低位到高位   按照当前位进行排序 入桶  按照从右数第digitOfElement进行排序
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[j];    // 数字入桶
            }
            int index = 0;
            // 取出所有桶中的元素放回arr中
            for (int j = 0; j < 10; j++) {
                if (bucketElementCounts[j] != 0) {  // 桶中有数据
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
            }

        }
    }

    /**
     * 堆排序1
     * @param arr
     * 思路：
     *  1.构建大根堆
     *      构建过程：从后向前遍历非叶子节点（在数组中表示为len/2-1~0）
     *              【如果当前数小于孩子，就让孩子中较大的上浮，自己下沉，直到自己比两个孩子都大，或者成为叶子节点】
     *  2.排序数组
     *      从数组尾到头遍历，每次确定一个未排序的最大值交换到数组尾部
     *      如何确定：
     *          将大根堆的第一个元素与无序部分的最后一个元素交换，就确定了此元素位置
     *          交换过来的值，再进行调整，【如果当前数小于孩子，就让孩子中较大的上浮，自己下沉，直到自己比两个孩子都大，或者成为叶子节点】
     *  【】中部分抽取出来作为一个方法heapify
     */
    public static void heapSort1(int[] arr) {
        // 堆排序
        if (arr.length <= 1) {
            return;
        }

        // 建堆 从后向前数的第一个非叶子节点开始
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // 排序过程，每次将数组第一个元素（最大值） 交换到未排序部分的最后一个位置，此位置元素确定下来
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆顶元素和未排序的末尾进行交换，然后 调整交换过来的元素位置，重新形成堆
            swap(arr, 0, i);
            // 调整过来的元素，index为0  将(0, i)重新调整为堆 heapify的第三个参数为长度
            heapify(arr, 0, i);
        }
    }

    /**
     * heapify 作用是将i处的元素，调整到符合堆规则的位置上
     * @param arr
     * @param i
     * @param length 调整数组的前多少个元素 每次排序会确定最后一个位置的元素
     */
    public static void heapify(int[] arr, int i , int length) {

        int temp = arr[i];
        // i处的值和叶子节点进行比较
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 比较哪个孩子大 取孩子较大的还当前值比较
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            // 孩子中的最大值比当前值大
            if (arr[j] > temp) {
                // 这个较大的上浮
                arr[i] = arr[j];
                /*
                * i: 用来记录temp下沉到的位置
                * 目前temp下沉到j位置, 将j赋给i
                * temp还要和j的孩子们进行比较
                * */
                i = j;
            } else {
                break;
            }
        }
        // 上面交换之后temp最终就在i位置
        arr[i] = temp;
    }

    // 堆排序
    public static void heapSort(int arr[]) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        int temp = 0;

        // 先将无序数组数组调整为大根堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjustHeap(arr, i, arr.length);
            adjustHeap(arr, i, arr.length);
        }


        for (int i = arr.length - 1; i >0 ; i--) {
            // 交换，将数组第一个的最大元素和末尾交换，并重新调整为大根堆
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);  // 对交换后的再进行调整
        }
    }

    /** 调整一个数组为大根堆
     *
     * @param arr   要调整的数组
     * @param i     从哪个元素开始比较 length/2 + 1
     * @param length 调整数组的前多少个元素 因为每次排序会确定最后一个位置的元素
     */
    public static void adjustHeap(int arr[], int i , int length) {
        int temp = arr[i];  // 先记录下当前元素值 比较用
        // 向下比较
        for (int j = i * 2 + 1; j < length; j = j * 2 +1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {  // 左子树值小于右子树
                j += 1;                 // 往右子树走进行比较
            }
            // 下面的元素比上面的更大，下面的上浮
            if (arr[j] > temp) {
                // arr[i]变成了较大的元素
                arr[i] = arr[j];
                // i = j之后 向j的子树进行循环比较(如果有的话)
                i = j;
            } else {
                break;
            }
        }   // for  当for循环结束后，已经将i为父节点的树最大值上浮到了堆顶处
        arr[i] = temp;  // 将temp值放到调整后的位置
    }

    // 交换数组中元素位置
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 打印数组
    public static void printArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("\n");
    }

    // 复制当前数组的一个样本
    public static int[] copyArr(int[] arr) {
        if (arr == null) {
            return null;
        }
        int newArray[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    // 生成一个随机大小，最大数随机的数组
    public static int[] generateRandomArray(int maxSize, int maxNum) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))]; // Math.random生成
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxNum + 1));
//            arr[i] = (int) (Math.random() * (maxNum + 1)) - (int) (Math.random() * maxNum);
        }
        return arr;
    }

    // 判断两数组是否完全相同
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        if (arr1 == null && arr2 != null || arr2 == null && arr1 != null) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // Java封装好的排序
    public static void rightSort(int[] arr) {
        Arrays.sort(arr);
    }

}
