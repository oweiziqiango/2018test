package wzq.test.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序树(二叉查找数)
 * @author Administrator
 *
 */
public class BinaryTreeSort {
	
	public Node root;
	public BinaryTreeSort(){
		root = null;
	}
	//按层遍历 二叉树  利用队列实现
	public void print(){
		if(this.root==null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node n = q.poll();
			System.out.print(n.data+" ");
			if(n.left!=null){
				q.add(n.left);
			}
			if(n.right!=null){
				q.add(n.right);
			}
		}
	}
	
	
	
	//在二叉树中插入节点
	public void insert(int data){
		Node newNode = new Node(data);
		if(root == null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent ;
		while(true){
			parent = current;
			//左子树节点值小于父节点的值
			if(data < current.data){
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{//右子树节点值大于父节点的值
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}
		}
		
	}
	//构建二叉树
	public void bulidTree(int[] data){
		for(int i = 0;i < data.length;i++){
			insert(data[i]);
		}
	}
	//中序遍历  左中右
	public void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.left);
			System.out.print(localRoot.data+" ");
			inOrder(localRoot.right);
		}
		
	}
	public void inOrder(){
		this.inOrder(this.root);
	}
	//先序遍历  中左右
	public void preOrder(Node localRoot){
		if(localRoot!=null){
			System.out.print(localRoot.data+" ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	public void preOrder(){
		this.preOrder(this.root);
	}
	//后序遍历  左右中
	public void postOrder(Node localRoot){
		if(localRoot!=null){
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data+" ");
		}
	}
	public void postOrder(){
		this.postOrder(this.root);
	}
	
	
	public static void main(String[] args) {
		BinaryTreeSort b = new BinaryTreeSort();
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		b.bulidTree(data);
		System.out.print("二叉树的中序排列:");
		b.inOrder();
		System.out.println();
		System.out.print("二叉树的先序排列:");
		b.preOrder();
		System.out.println();
		System.out.print("二叉树的后序排列:");
		b.postOrder();
		System.out.println();
		System.out.print("二叉树按层遍历：");
		b.print();
	}
}
class Node{
	public int data;
	public Node left;
	public Node right;
	
	public int leftMaxDistance;
	public int rightMaxDistance;
	
	public Node(int date){
		this.data = date;
		this.left = null;
		this.right = null;
	}
}
