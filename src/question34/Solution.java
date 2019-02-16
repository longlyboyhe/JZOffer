package question34;

import java.util.ArrayList;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 15:54
 * Describe:�������к�Ϊĳһֵ��·��
 * ��Ŀ������һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·��
 */
public class Solution {

    /**
     * ˼·��������и��ڵ㵽Ҷ�ӽڵ��ֵ���ڸ��������������Ҫ�ݹ����е�Ҷ�ӽڵ��·����ÿ�α���ʱ��Ҫ����ǰ�ڵ�ֵ����list�У������˵����ڵ�ʱ��Ҫɾ����ǰ�ڵ��listֵ
     *
     * ���ݹ鵽Ҷ�ӽڵ�ʱ�ж���ǰlist�е�·��ֵ�Ƿ���ڸ��������������������lists��
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return lists;
        }
        int count = 0;
        FindPath(root, target, count, lists, list);
        return lists;
    }

    public void FindPath(TreeNode root, int target, int count, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list) {
        if(root == null){
            return;
        }
        count += root.val;
        if(root.left == null && root.right == null){
            if(count == target){
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }

        list.add(root.val);
        FindPath(root.left, target, count, lists, list);
        FindPath(root.right, target, count, lists, list);
        list.remove(list.size()-1);
    }

}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
