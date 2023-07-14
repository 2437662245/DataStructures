package person.zh.sparsearray;

/*
* 稀疏数组和普通数组之间转换
* */

public class SparseArray {
    public static void main(String[] args) {
        // 创建原数组
        int arr[][] = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[3][5] = 3;
        arr[8][9] = 8;
        // 遍历原数组
        System.out.println("原数组为:");
        for(int[] a : arr) {
            for(int val : a) {
                System.out.print(val + "  ");
            }
            System.out.println("\n");
        }

        // 转为稀疏数组要已知数组中非0个数，行列数
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sum += 1;
                }
            }
        }

        // 创建稀疏数组
        int index = 0;
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[index][0] = 11;
        sparseArr[index][1] = 11;
        sparseArr[index][2] = sum;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j] != 0 && index != sum) {
                        sparseArr[++index][0] = i;
                        sparseArr[index][1] = j;
                        sparseArr[index][2] = arr[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println("转换的稀疏数组为:");
        for(int[] a : sparseArr) {
            for(int val : a) {
                System.out.print(val + "  ");
            }
            System.out.println("\n");
        }

        // 稀疏数组恢复为原始的二维数组
        int arr1[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
                arr1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 打印恢复后的数组
        System.out.println("稀疏数组转为二维数组:");
        for(int[] a : arr1) {
            for(int val : a) {
                System.out.print(val + "  ");
            }
            System.out.println("\n");
        }
    }
}
