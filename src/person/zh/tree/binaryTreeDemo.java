package person.zh.tree;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class binaryTreeDemo {
    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(50);
//        TreeNode node2 = new TreeNode(30);
//        TreeNode node3 = new TreeNode(80);
//        TreeNode node4 = new TreeNode(20);
//        TreeNode node5 = new TreeNode(60);
//        TreeNode node6 = new TreeNode(70);
//        BinaryTree binaryTree = new BinaryTree(node1);    // 以node1为根的二叉树
//        node1.setLeft(node2);
//        node1.setRight(node3);
//        node2.setLeft(node4);
//        node2.setRight(node6);
//        node3.setLeft(node5);
////        node5.setRight(node6);
//        System.out.printf("树高: %d \n", binaryTree.height());
//        System.out.printf("树最大宽度: %d \n", binaryTree.width());
//        System.out.print("先序遍历: ");
//        binaryTree.preOrderNoRecursion();
//        System.out.println();
//        System.out.print("中序遍历: ");
//        binaryTree.inOrderNoRecursion();
//        System.out.println();
//        System.out.print("后序遍历: ");
//        binaryTree.postOrderNoRecursion();
//        System.out.println();
//        System.out.print("层序遍历: ");
//        binaryTree.levelOrder();
//        System.out.println();
//        System.out.printf("树节点数: %d \n", binaryTree.size());
//        TreeNode nodeParent = binaryTree.getParent(node2);
//        if (nodeParent != null) {
//            System.out.printf("node的父节点val为: %d \n", nodeParent.getData());
//        } else {
//            System.out.println("找不到");
//        }
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        flatten(root);
        BinaryTree binaryTree = new BinaryTree(root);    // 以node1为根的二叉树
        binaryTree.preOrder();

    }




    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();

    @Test
    public void pathSum() {
        TreeNode node0 = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        // 递归函数返回值及参数 不需要返回值 参数(node, sum, target)
        traceback(node0, 0, 22);
        System.out.println(resList);
    }


    public void traceback(TreeNode node, int sum ,int targetSum) {
        // 递归终止条件
        if (node.left == null && node.right == null) {
            if (sum + node.data == targetSum) {
                pathList.add(node.data);
                resList.add(new ArrayList<Integer>(pathList));
            }
            return;
        }
        // 单层逻辑
        if (node.left != null) {
            pathList.add(node.data);
            sum += node.data;
            traceback(node.left, sum, targetSum);
            sum -= node.data;
            pathList.remove(pathList.size() - 1);
        }
        if (node.right != null) {
            pathList.add(node.data);
            sum += node.data;
            traceback(node.right, sum, targetSum);
            sum -= node.data;
            pathList.remove(pathList.size() - 1);
        }
    }



    /*// morrisPreoder，morris先序
    @Test
    public static void morrisPreoder(TreeNode root){
        TreeNode cur = root;
        while (cur != null){
            //遇到第二类节点直接在这处理只经过一次
            if (cur.left == null){
                System.out.print((char)cur.data + " ");
                cur = cur.right;
            }else {
                TreeNode next = cur.left;
                while (next.right != null && next.right != cur){
                    next = next.right;
                }
                if (next.right == null){
                    next.right = cur;
                    //此时是第一次经过第一类节点
                    System.out.print((char)cur.data + " ");
                    cur = cur.left;
                }else {
                    next.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    // morrisPreoder，morris中序
    @Test
    public static void morrisInorder(TreeNode root){
        TreeNode cur = root;
        while (cur != null){

            if (cur.left == null){
                //第二类节点位置不变
                System.out.print((char)cur.data + " ");
                cur = cur.right;
            }else {
                TreeNode next = cur.left;
                while (next.right != null && next.right != cur){
                    next = next.right;
                }
                if (next.right == null){
                    next.right = cur;
                    cur = cur.left;
                }else {
                    //第二次经过第一类节点时处理第一类节点
                    System.out.print((char)cur.data + " ");
                    next.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    // morrisPreoder，morris后序
    @Test
    public static List<Character> morrisPostOrder(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if(root == null)
            return res;
        TreeNode node = new TreeNode(-1);  //建立临时节点
        node.left = root;    //设置临时节点的左子节点为根节点
        TreeNode cur = node;
        while(cur != null) {
            if(cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode next = cur.left;
                while(next.right != null && next.right != cur)
                    next = next.right;
                if(next.right == null) {
                    next.right = cur;
                    cur = cur.left;
                } else {
                    next.right = null;
                    TreeNode t = cur.left;
                    List<Character> midList = new ArrayList<>();
                    while(t != null) {
                        System.out.println();
                        //注意这里不是尾插，是插到0的位置上
                        midList.add(0, (char) t.data);
                        t = t.right;
                    }
                    res.addAll(midList);
                    cur = cur.right;
                }
            }
        }
        //最终得到了后序遍历顺序的顺序表
        return res;
    }*/



    public static void flatten(TreeNode root) {
        // 思路：递归进行，先递归左子树，再右子树，如果左子树存在，翻转左右子树，然后将左子树拼接到右子树的最后一个节点后
        if (root == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
        }
        if (root.right != null) {
            flatten(root.right);
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode tempNode = null; // 临时节点
        if (root.left != null) {    // 如果左子树存在，反转左右子树
            tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            // 反转完如果左子树还是存在，将左子树插到右子树最右侧
            if (root.left != null) {
                while (tempNode.right != null) {
                    tempNode = tempNode.right;
                }
                tempNode.right = root.left;
                root.left = null;
            }
        }
    }
}

class BinaryTree {
    private TreeNode root;

    // 初始化二叉树
    public BinaryTree() {
    }
    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    // 打印节点
    public void printNode(TreeNode node) {
        if (node == null) {
            System.out.println("#");
        } else {
            System.out.print(node.getData() + " ");
        }
    }

    // 先序遍历二叉树 递归
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    public void preOrder() {
        preOrder(root);
        System.out.println("");
    }
    public void preOrderNoRecursion() {
        // 借助栈实现 往左走，走到底，开始出栈，然后往出栈节点右边走
        Stack<TreeNode> stack= new Stack<>();
        TreeNode temp = root;

        while (true) {
            while (temp != null) {
                // temp向左寻找第一个没有右孩子的节点
                printNode(temp);
                stack.push(temp);
                temp = temp.getLeft();
            }
            if (stack.isEmpty()) { // 如果栈空则代表树为空
                break;
            }
            temp = stack.pop(); // 栈顶元素(树最左边的节点)出栈 并往这个节点右边走
            temp = temp.getRight();
        }

    }

    // 中序遍历二叉树  有点问题
    public void inOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            preOrder(root.getRight());
        }
    }
    public void inOrder() {
        inOrder(root);
        System.out.println("");
    }
    public void inOrderNoRecursion() {
        // 借助栈
        // 用指针从根节点往左寻找第一个没有右孩子的节点 并将遇到的每个节点入栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (true) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }   // while循环完代表 往左寻找到了第一个没有右孩子的节点 并将遇到的每个节点入栈
            if (stack.isEmpty()) {
                break;  // 如果栈空代表树为空树
            }
            temp = stack.pop();
            printNode(temp);
            temp = temp.getRight(); //往右走
        }
    }

    // 后序遍历二叉树
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }
    public void postOrder() {
        postOrder(root);
        System.out.println("");
    }
    public void postOrderNoRecursion() {
        // 后续遍历: 左 → 右 → 中  如果要访问根节点那么上次访问的必定是右孩子或者右孩子为空
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        TreeNode lastVisit = null;
        // curNode向左寻找第一个没有左孩子的节点
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.getLeft();
        }
        if (stack.isEmpty()){
            return;
        }
        while (!stack.isEmpty()) {
            curNode = stack.pop(); // 弹出栈顶元素 弹出栈顶元素不能直接访问 要先判断右孩子存在否 已访问否
            // 根节点被访问的前提是:没有右子树或者右子树已被访问过
            if (curNode.getRight() != null && curNode.getRight() != lastVisit) {
                // 重新入栈
                stack.push(curNode);
                curNode = curNode.getRight();
                // 走到右子树的最左边
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.getLeft();
                }
            } else {
                // 访问 上面已经出栈了 修改上次访问元素
                printNode(curNode);
                lastVisit = curNode;
            }
        } // while
    }

    // 层序遍历
    public void levelOrder(TreeNode node) {
        // 借助队列，
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node); // 根节点先入队
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            printNode(temp);
            if (temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.offer(temp.getRight());
            }
        }
    }
    public void levelOrder() {
        levelOrder(root);
    }

    // 判断二叉树是否为空
    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    // 清空二叉树
    public void clear(TreeNode node) {
        if (node != null) {
            clear(node.getLeft());
            clear(node.getRight());
            node = null;
        }
    }
    public void clear() {
        clear(root);
    }

    // 求二叉树的高度
    public int height(TreeNode node) {
        // 左右子树的高度的最大值+1就是树高 递归实现
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) > height(node.getRight()) ? height(node.getLeft()) + 1 : height(node.getRight()) + 1;
    }
    public int height() {
        return height(root);
    }

    // 利用层序遍历,得到树的最大宽度
    public int width(TreeNode node) {
        // 利用层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        TreeNode temp = null;
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > maxWidth)
                maxWidth = size;
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                if (temp.getLeft() != null) {
                    queue.offer(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.offer(temp.getRight());
                }
            }
        }
        return maxWidth;
    }
    public int width() {
        return width(root);
    }

    // 求二叉树的节点数
    public int size(TreeNode node) {
        // 二叉树的节点数等于左子树的节点数+右子树节点数+1
        if (node == null) {
            return 0;
        }
        return size(node.getLeft()) +size(node.getRight()) + 1;
    }
    public int size() {
        return size(root);
    }

    // 返回某节点的父亲节点
    public TreeNode getParent(TreeNode root, TreeNode node) {
        // 查看节点的左右子树，如果是需要找的寻亲节点，返回此节点
        if (root == null) {
            return null;    // 如果是空子树没有父节点
        }
        if (root.getLeft() == node || root.getRight() == node) {
            return root ;
        }
//        TreeNode parent = null;
        if (getParent(root.getLeft(), node) != null) {
            return getParent(root.getLeft(), node);
        }else {
            return getParent(root.getRight(), node);
        }
    }
    public TreeNode getParent(TreeNode node) {
        return root == null || root == node ? null :  getParent(root, node);
    }

    // 返回左右子树
    public TreeNode getLeftTree(TreeNode node) {
        return node.getLeft();
    }
    public TreeNode getRightTree(TreeNode node) {
        return node.getRight();
    }

    // 二叉树的插入 向某节点插入左右孩子
    public void insertLeft(TreeNode parent, TreeNode newNode) {
        parent.setLeft(newNode);
    }
    public void insertRight(TreeNode parent, TreeNode newNode) {
        parent.setRight(newNode);
    }
}

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}