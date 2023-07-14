package person.zh.dac;

/**
 * \* Auther: zh
 * \* DateTime: 2022/3/2 15:04
 * \* Description:
 * \
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔上的盘子的移动，从上到下共num个盘子借助b 从a移动到c
     * @param num   盘子数量
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int num, char a, char b ,char c) {
        if (num == 1) { // 只有一个盘子
            System.out.println("第1个盘子: " + a + "->" + c);
        } else {        // 不止有一个盘子
            // 1. 先将上面的num - 1个盘子移动到b，再将最后一个盘子移动到c，最后将上面的盘子移动到c
            hanoiTower(num - 1, a, c, b);
//            hanoiTower(num, a, b, c);
            System.out.println("第" + num + "个盘子: " + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }
}
