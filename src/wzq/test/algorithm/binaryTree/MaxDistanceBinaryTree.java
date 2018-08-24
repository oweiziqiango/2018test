package wzq.test.algorithm.binaryTree;

public class MaxDistanceBinaryTree {

	private static int  maxLen = 0;
	
	private static int max(int a,int b){
		return a>b?a:b;
	}
	
	public static void FindMaxDistance(Node root){
		//如果是空二叉树，直接return
		if(root == null)
			return;
		//如果左子树为空，左子树距离根节点的距离为0
		if(root.left == null)
			root.leftMaxDistance = 0;
		//如果右子树为空,右子树距离根节点的距离为0
		if(root.right == null)
			root.rightMaxDistance = 0;
		
		
		//如果根节点的左子树不为空，递归调用  根节点的左孩子
		if(root.left != null)
			FindMaxDistance(root.left);
		//如果根节点的右子树不为空，递归调用  根节点的左孩子
		if(root.right != null)
			FindMaxDistance(root.right);
		
		if(root.left!=null)
			root.leftMaxDistance = max(root.left.leftMaxDistance,root.left.rightMaxDistance)+1;
		if(root.right!=null)
			root.rightMaxDistance = max(root.right.leftMaxDistance,root.right.rightMaxDistance)+1;
		
		if(root.rightMaxDistance+root.leftMaxDistance>maxLen)
			maxLen = root.leftMaxDistance+root.rightMaxDistance;
	}
	
	public static void main(String[] args) {
		BinaryTreeSort b = new BinaryTreeSort();//实例化一个构建二叉排序树的类
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		b.bulidTree(data);//构建二叉排序树
		FindMaxDistance(b.root);
		//b.print();
		System.out.println("maxLen :"+maxLen);
	}
}
