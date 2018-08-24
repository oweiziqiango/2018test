package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class offer11 {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        ArrayList<ArrayList<Integer>> print = Print(n1);
        System.out.println(print);
	}
	/*
	 * 之字打印  每次打印完一行  下一行就是从上一行遍历的孩子的最后一个开始
	 * 
	 * 两个栈  一个正着（遍历左子树） 一个反着(遍历右子树) 
	 * 
	 */
	public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Stack<TreeNode> sta1 = new Stack<>();
		Stack<TreeNode> sta2 = new Stack<>();
		if(pRoot==null){
			return ans;
		}
		sta1.push(pRoot);
		ArrayList<Integer> vec;
		while(!sta1.empty()){
			vec = new ArrayList<Integer>();
			while(!sta1.empty()){
				if(sta1.peek().left!=null){
					sta2.push(sta1.peek().left);
				}
				if(sta1.peek().right!=null){
					sta2.push(sta1.peek().right);
				}
				vec.add(sta1.peek().val);
				sta1.pop();
				if(sta1.empty())
					ans.add(vec);
			}
			vec = new ArrayList<Integer>();
			while(!sta2.empty()){
				if(sta2.peek().right!=null){
					sta1.push(sta2.peek().right);
				}
				if(sta2.peek().left!=null){
					sta1.push(sta2.peek().left);
				}
				vec.add(sta2.peek().val);
				sta2.pop();
				if(sta2.empty())
					ans.add(vec);
			}
		}
		
        return ans;
    }
}
