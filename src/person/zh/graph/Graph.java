package person.zh.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * \* Auther: zh
 * \* DateTime: 2022/3/1 15:22
 * \* Description:
 * \
 */
public class Graph {
    private ArrayList<String> vertexList;   // 存储顶点集合
    private int[][] edges;  // 存储边
    private int numOfEdges; // 边数目
    private boolean[] isVisited;

    // 构造器  n个顶点
    public Graph(int n) {
        // 初始化vertexList和edges
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    // 插入顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /** 添加边
     * 添加顶点v1与v2之间的边，边的权重为weight
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    // 返回节点的个数 图中常用的方法
    public int getNumOfVertex() {
        return vertexList.size();
    }
    // 返回边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回节点i对应的数据 0->A 1->B...
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // 返回v1和v2之间边的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 显示图对应的矩阵
    public void showGraph() {
        for (int weights[] : edges) {
            System.out.println(Arrays.toString(weights));
        }
    }

    /**
     * dfs深度优先遍历
     * @param isVisited 数组存放当前节点是否已经访问过
     * @param i 从当前节点往深处遍历
     */
    public void dfs(boolean isVisited[], int i) {
        System.out.print(getValueByIndex(i) + " ->"); // 访问当前节点
        isVisited[i] = true;    // 访问标志改为true
        // 找到第一个邻接点
        int w = getFirstNeighbor(i);    // 第一个邻接点
        while (w != -1) {   // 邻接点存在
            if (!isVisited[w]) {    // 未访问过
                dfs(isVisited, w);
            } else {        // 已访问过
                w = getNextNeighbor(i, w);
            }
        }   // while循环完，第一条道走到底了回退换路线
    }
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }
    public int getFirstNeighbor(int i) {   // 找到i的第一个邻接点
        for (int j = 0; j < getNumOfVertex(); j++) {
            if (edges[i][j] != 0) {
                return j;
            }
        }
        return -1;  // 没有邻接点返回-1
    }
    public int getNextNeighbor(int i, int j) {  // 从j之后找i的邻接点
        for (int k = j + 1; k < getNumOfVertex(); k++){
            if (edges[i][k] != 0) {
                return k;
            }
        }
        return -1;
    }

    /**
     * 广度有限遍历bfs
     * 1. 访问初始节点v并更改访问标志，v入队
     * 2. 访问v的第一个邻接点，如果未访问过，访问并入队，循环访问v的所有邻接点，访问到的都入队，访问完之后队头出队，作为初始节点进行访问
     * @param isVisited
     * @param i
     */
    public void bfs(boolean isVisited[], int i) {
        int u;  // 队列头节点对应下标
        int w;  // 邻接节点w
        System.out.print(getValueByIndex(i) + "->"); // 访问当前节点
        isVisited[i] = true;    // 访问过后访问标志更改为true
        Queue<Integer> queue = new LinkedList<>();  // 借助队列
        queue.offer(i);     // 初始节点v入队
        while (!queue.isEmpty()) {
            u = queue.poll();   // 出队
            w = getFirstNeighbor(u);    // 从0访问
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->"); // 访问当前节点
                    isVisited[w] = true;    // 访问过后访问标志更改为true
                    queue.offer(w);
                }
                w = getNextNeighbor(u, w);
            }
            break;
        }
    }
    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        String vertexValues[] = {"a", "b", "c", "d", "e"};
        // 创建图对象
        Graph graph = new Graph(5);
        // 循环向图中添加顶点
        for (int i = 0; i < vertexValues.length; i++) {
            graph.insertVertex(vertexValues[i]);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(0, 3, 1);
        graph.insertEdge(0, 4, 1);
        graph.showGraph();
//        graph.dfs();
        System.out.println();
        System.out.println("---bfs---");
        graph.bfs();
    }


}
