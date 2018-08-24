package wzq.test.algorithm.binaryTree;
/**
 * 已知先序遍历和中序遍历，如何求后序遍历
 * @author Administrator
 *
 */
public class Test1{
	public Node root;
	Test1(){
		this.root=null;
	}
	public static void main(String[] args) {
		//同一个包内可以访问
		Test1 b = new Test1();
		int[] preOrder = {1,2,4,8,9,5,10,3,6,7};
		int[] inOrder = {8,4,9,2,10,5,1,6,3,7};
		
		b.initTree(preOrder,inOrder);
		System.out.print("二叉树后序遍历：");
		b.postOrder();
	}
	public void postOrder(){
		this.postOrder(this.root);
	}
	//后序遍历  左右中
	public void postOrder(Node localRoot){
		if(localRoot!=null){
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data+" ");
		}
	}
	public void initTree(int[] preOrder, int[] inOrder){
		root = this.initTree(preOrder,0,preOrder.length-1, inOrder,0,inOrder.length-1);
	}
	public Node initTree(int[] preOrder,int start1,int end1,int[] inOrder,int start2,int end2){
		if(start1>end1 || start2>end2){
			return null;
		}
		//1、根节点或者父节点
		int rootData = preOrder[start1];
		
		Node head = new Node(rootData);
		//2、找到rootData在 中序数组中的位置
		int rootIndex = findIndexInArray(inOrder, rootData, start2, end2);
		//3、确定 先序遍历数组中  需要的偏移量
		int offSet = rootIndex - start2 - 1;
		//4、构造左子树
		Node left = initTree(preOrder, start1+1, start1+1+offSet, inOrder, start2, rootIndex-1);
		//5、构建右子树
		Node rgiht = initTree(preOrder, start1+offSet+2, end1, inOrder, rootIndex+1, end2);
		
		head.left = left;
		head.right = rgiht;
		//返回头结点
		return head;
	}
	public int findIndexInArray(int[] inOrder,int rootData,int start2,int end2){
		for(int i=start2 ;i <= end2 ;i++){
			if(inOrder[i] == rootData)
				return i;
		}
		return -1;
	}
}
