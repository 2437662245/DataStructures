package person.zh.recursion;

public class MiGong {
    public static void main(String[] args) {
        // 创建一个二维数组，模拟迷宫
        int map[][] = new int[10][10];
        // 用1表示墙，四周是墙
        for (int i = 0; i < 10; i++) {
            map[0][i] = 1;
            map[9][i] = 1;
            map[i][0] = 1;
            map[i][9] = 1;
        }
        // 设置挡板
        map[1][2] = 1;
        map[3][1] = 1;
        map[3][4] = 1;
        map[3][5] = 1;
        map[3][6] = 1;
        // 输出地图
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j] + "    ");
            }
            System.out.println("\n");
        }
        setWay(map, 1, 1);
        // 输出地图
        System.out.println("走迷宫:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j] + "    ");
            }
            System.out.println("\n");
        }
    }
    // 递归回溯找路
    public static boolean setWay(int[][] map, int i, int j) {
        /*
        * map表示地图
        * 用1表示墙，四周是墙，2代表走的通，3代表走过了但是走不通，0表示未走过的
        * 如果小球能够走到map[9][9]位置 代表走通了
        * i，j表示从哪个位置出发
        * 走迷宫时，需要一个策略，下 -> 右 -> 上 -> 左
        * */
        // 递归出口
        if (map[8][8] == 2) {
            return true;
        }else {
            if (map[i][j] == 0) {
                // 从此处开始回溯
                map[i][j] = 2; // 假设此处走得通
                if (setWay(map, i+1, j)){
                    return true;
                }else if (setWay(map, i, j+1)){
                    return true;
                }else if (setWay(map, i-1, j)){
                    return true;
                }else if (setWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3; // 走不通
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
