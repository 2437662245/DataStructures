package person.zh.recursion;

public class EightQueens {
    // 定义一个max表示共有几个皇后
    int max = 8;
    // 定义数组
    int[] array = new int[8];
    static int count = 0;
    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println(count);
    }

    // 编写一个方法，放置n个皇后
    private void check(int n) {
        if (n == 8) {  // n为8时，就放好了8个皇后
            count++;
            print();
            return;
        }
        // 依次放入皇后 判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前的皇后放到改行第i列
            array[n] = i;
            // 判断当放置第n个皇后到第i列时是否会冲突
            if (judge(n)) { // 不冲突
                check(n+1);
            }
            // 如果冲突继续执行array[n] = i，即将第n个皇后，放置在本行后移的一个位置
        }
    }

    // 判断第n个皇后放置时是否与前面的皇后冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(n-i) == Math.abs(array[n]-array[i])) {
                return false;
            }
        }
        return true;
    }

    // 打印数组
    private void print() {
        for (int i = 0; i < 8; i++) {
            System.out.print(array[i]);
        }
        System.out.print("\n");
    }

}
