package question37;

/**
 * @author: zhangocean
 * @Date: 2019/2/17 15:22
 * Describe:���л�������
 * ��Ŀ����ʵ�������������ֱ��������л��ͷ����л�������
 */
public class Solution {

    /**
     * ��һ�Ŷ�����ͨ��������������л����ö��Ÿ������ַ�����null�ڵ���#����
     * �����м����ַ���ת���ɶ�����
     */
    String Serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
    }

    void Serialize(TreeNode root, StringBuilder str) {
        if(root == null){
            str.append("#,");
            return ;
        }
        str.append(root.val).append(",");
        Serialize(root.left, str);
        Serialize(root.right, str);
    }

    TreeNode Deserialize(String str) {
        if(str.length() == 0){
            return null;
        }
        String[] strs = str.split(",");
        return  Deserialize(strs);
    }

    int index=-1;

    TreeNode Deserialize(String[] str) {
        index++;
        if(!str[index].equals("$")){

            TreeNode node = new TreeNode(Integer.parseInt(str[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
            return node;
        }
        return null;
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
