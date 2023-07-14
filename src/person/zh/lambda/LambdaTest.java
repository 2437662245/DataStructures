package person.zh.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: LambdaTest
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/27 10:00
 * @Version: 1.0
 */
public class LambdaTest {

    @Test
    public void test() {
        // 一维数组升序降序，只能是对象数组，不能是基本类型数组
        Integer[] nums = new Integer[]{1, 3, 5, 4, 2, 6, 9, 8, 7};
        Arrays.sort(nums, (num1, num2) -> num1 - num2);
        for(int num : nums) {
            System.out.printf("%d ", num);
        }
    }

    @Test
    public void test2() {
        // 二维数组按照第一个数升序 第二个降序
        int[][] nums = new int[][]{{1,3},{1,2},{5,1},{4,5},{3,3}};
        Arrays.sort(nums, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        for (int[] arr : nums) {
            System.out.println("(" + arr[0] + "," + arr[1] + ")");
        }
    }
    @Test
    public void test3() {
        // 二维数组按照第一个数升序 第二个降序
        int[][] nums = new int[][]{{1,3},{1,2},{5,1},{4,5},{3,3}};
        Arrays.sort(nums, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        for (int[] arr : nums) {
            System.out.println("(" + arr[0] + "," + arr[1] + ")");
        }
    }

}
