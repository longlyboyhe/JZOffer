package question32;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 14:16
 * Describe: ֮���δ�ӡ������
 * ��Ŀ����ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 */
public class Solution3 {

    /***
     * ʹ������ջ�ֱ�洢�������Լ����ҵ����ӡ����
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null){
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);
        int level = 1;
        while (!stack1.empty() || !stack2.empty()){
            ArrayList<Integer> list1 = new ArrayList<>();
            //������
            if((level & 0x1) == 1){
                while (!stack1.empty()){
                    TreeNode node = stack1.pop();
                    if(node.left != null){
                        stack2.push(node.left);
                    }
                    if(node.right != null){
                        stack2.push(node.right);
                    }
                    list1.add(node.val);
                }
                level++;
            }
            //ż����
            else {
                while (!stack2.empty()){
                    TreeNode node = stack2.pop();
                    if(node.right != null){
                        stack1.push(node.right);
                    }
                    if(node.left != null){
                        stack1.push(node.left);
                    }
                    list1.add(node.val);
                }
                level++;
            }
            list.add(list1);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        TreeNode treeNode1 = new TreeNode(6);
        root.left = treeNode1;
        TreeNode treeNode2 = new TreeNode(10);
        root.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(5);
        treeNode1.left = treeNode3;
        TreeNode treeNode4 = new TreeNode(7);
        treeNode1.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(9);
        treeNode2.left = treeNode5;
        TreeNode treeNode6 = new TreeNode(11);
        treeNode2.right = treeNode6;

        Solution3.Print(root);
    }

}
