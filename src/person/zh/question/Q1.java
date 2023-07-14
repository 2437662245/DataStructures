package person.zh.question;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/21 21:04
 * @description: TODO
 * @version: 1.0
 */
/*
找数
时间限制: 2000/1000 MS (Java/Others) 内存限制: 65536/65536 K (Java/Others)
问题描述
小美和小团在玩游戏。
小美将会给出n个大小在1到n之间的整数，
然后小美会再告诉小团一个整数k，
小团需要找到一个最小的整数x满足以下条件： l 整数x的大小在1到n之间 l 在小美给出的n个整数中，恰好有k个数比x小
翻译一下：输入一个数组，返回这个数组正序时Index为k的数

输入描述 第一行是一个数T，表示有T组数据。
对于每组数据： 第一行有两个整数n和k，分别表示小美将会给出n个数以及她给出的整数k。
接下来一行有n个用空格隔开的正整数，表示小美给出的n个正整数。

输出描述 对于每组数据：如果存在满足要求的数x，第一行先输出“YES”（不含引号），第二行输出数x的值。
如果不存在满足要求的数x，输出“NO”（不含引号）。

输入样例 输出样例1
1
2
3
4
5
2
6 6
1 6 6 2 1 3
6 3
1 6 5 2 2 5

数据范围和说明:
30%的数据保证 n<=10, 0<=k<=n, T<=10
60%的数据保证 n<=1000, 0<=k<=n, T<=10
100%的数据保证 n<=100000, 0<=k<=n, T<=10
* */

public class Q1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(;t > 0; t--){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            int ans = fun(nums, n, k);
            if(ans == -1) System.out.println("NO");
            else{
                System.out.println("YES");
                System.out.println(ans);
            }
        }
    }

    private static int fun (int[] nums, int n, int k) {
        Arrays.sort(nums);
        for (int x = 1; x <= n; x++) {  // 穷举 x
            int xiao = 0;
            int da   = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] > x) da++;
                if(nums[j] < x) xiao++;
            }
            if(xiao == k) return x;
        }
        return -1;
    }
}
