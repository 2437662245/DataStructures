package person.zh.sorttree;

import javax.xml.soap.Node;

/**
 * \* Auther: zh
 * \* DateTime: 2022/2/28 14:02
 * \* Description: 二叉排序树
 * \
 */
public class binarySortTreeDemo {

    public static void main(String[] args) {
        int arr[] = {9, 3, 5, 7, 1, 11, 6, 2, 8};
        binarySortTree bst = new binarySortTree();
        for (int i = 0; i < arr.length; i++) {
            bst.addNode(new TreeNode(arr[i]));
        }
        bst.inOrder();
        System.out.println();
        bst.delNode(1);
        bst.delNode(2);
        bst.delNode(5);
        bst.delNode(6);
        bst.delNode(7);
        bst.delNode(8);
        bst.delNode(11);
        bst.delNode(9);
        bst.delNode(3);
        bst.inOrder();
    }
}

class binarySortTree {
    TreeNode root;

    binarySortTree() {

    }

    /**
     * 向以node为根的树添加newNode节点
     * @param node
     * @param newNode
     */
    public void addNode(TreeNode node, TreeNode newNode) {
        if (newNode == null) { // 如果添加的是空节点直接返回
            return;
        }
        // 先判断当前节点和要插入节点val的大小关系
        // 当前节点的val更大时，为空就就插到左孩子上，不为空就递归往左子树上插
        if (node.val > newNode.val) {
            if (node.left == null) {
                node.left = newNode;
            } else {
                addNode(node.left, newNode);
            }
        } else {    // 当前节点的val较小时，为空就就插到右孩子上，不为空就递归往右子树上插
            if (node.right == null) {
                node.right = newNode;
            } else {
                addNode(node.right, newNode);
            }
        }
    }
    public void addNode(TreeNode newNode) {
        if (root == null) {     // 如果树为空，那么这个要插入的节点就是根节点
            root = newNode;
            return;
        } else {
            addNode(root, newNode);
        }
    }

    // 递归中序遍历
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }
    public void inOrder() {
        inOrder(root);
    }

    /** 删除val为value的节点
     * 分为三种情况处理:
     * 1. 要删除的节点是叶子节点: 标志是左右孩子都为空。找到val为value的节点，找到其父节点，判断其是父节点的左孩子还是右孩子，置空
     * 2. 要删除的节点只有一个孩子: 标志是一个孩子为空，另外一个孩子不为空。如果只有左孩子，那么该节点的父节点指向该节点的左孩子...右同理
     * 3. 要删除的节点有多个孩子: 标志是既有左孩子又有右孩子，找到其右子树的最左边的孩子(值最大)，其值赋给该节点，递归删除该孩子节点
     * @param value 要删除节点的value值
     */
    public void delNode(int value) {
        TreeNode node = searchNode(value);
        if (node == null) { // 要删除的节点找不到
            return;
        }
        if (node == root) { // 要删除的节点是根节点
            root = null;
            return;
        }
        if (node.left == null && node.right == null) {
            TreeNode parent = searchParent(value);
            if (parent.left == node) {
                parent.left = null;
            }
            if (parent.right == node) {
                parent.right = null;
            }
        } else if (node.left != null && node.right != null) {   // 第三种情况
            int temp = delRightTreeMin(node);
            node.val = temp;
        } else {
            TreeNode parent = searchParent(node.val);   // 找到该节点的父节点
            if (node.left != null) {
                if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            } else {
                if (parent.right == node) {
                    parent.right = node.right;
                } else {
                    parent.left = node.right;
                }
            }
        }
    }

    // 删除右子树
    public int delRightTreeMin(TreeNode node) {
        TreeNode tempNode = node.right; // temp去找node右子树上的最小值
        while (tempNode.left != null) { // while循环找右子树的最小值
            tempNode = tempNode.left;
        }
        delNode(tempNode.val);  // 此时tempNode节点一定是叶子节点或者只有右子树 删除它
        return tempNode.val;
    }
    // 寻找val为value的点
    public TreeNode searchNode(TreeNode node, int value) {
        // 当前节点val为value
        if (node == null) {
            return null;
        }
        if (node.val == value) {
            return node;
        }else if (node.val < value) { // 要寻找的值比当前节点更大，向当前节点右子树寻找 否则向左寻找
            return searchNode(node.right, value);
        } else {
            return searchNode(node.left, value);
        }
    }
    public TreeNode searchNode(int value) {
        return searchNode(root, value);
    }

    // 找到寻找val为value的节点的父节点
    public TreeNode searchParent(TreeNode node, int value) {
        if (node.left != null && node.left.val == value || node.right != null && node.right.val == value) {
            return node;
        } else if (node.left != null && node.val > value) {
            return searchParent(node.left, value);
        } else if (node.right != null && node.val < value) {
            return searchParent(node.right, value);
        } else {
            return null;
        }
    }
    public TreeNode searchParent(int value) {
        if (root == null || root.val == value) {
            return null;
        }
        return searchParent(root, value);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }
    TreeNode(int val) {
        this.val = val;
    }
}

