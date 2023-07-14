package person.zh.question;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: joe
 * @dateTime: 2023/2/21 21:08
 * @description: TODO
 * @version: 1.0
 */
/*

序列问题
时间限制: 2000/1000 MS (Java/Others) 内存限制: 65536/65536 K (Java/Others)
问题描述：有一个长度为n的序列A，定义序列中第i个数的prev[i]值为前i-1个数中比A[i]小的最大的值，即(j<i且a[j]<a[i]中最大的a[j])，
        若不存在这样的数，则prev[i]的值为0。现在要计算对于所有的i，prev[i]之和是多少，即Σiprev[i]。

输入描述 第一行是一个整数n表示序列的长度。 接下来一行n个数用空格隔开，第i个数表示A[i]的大小。
输出描述 一行一个整数，表示答案。
输入样例1 5     1 6 3 3 8
输出样例1 39
数据范围和说明 30%的数据保证 n<=20，1<=A[i]<=100。 60%的数据保证 n<=1000，1<=A[i]<=1000。 100%的数据保证 n<=100000，1<=A[i]<=100000。

*/
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

//        String[] strs = line.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(nums);
    }

    public int method(int[] nums) {
        return 0;
    }
}
