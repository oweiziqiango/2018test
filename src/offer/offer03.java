package offer;

import java.util.Scanner;

/**
 * 2018/08/07
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author Administrator
 *
 */
public class offer03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int sum = JumpFloor(n);
		System.out.println(sum);
	}
	/*
	 * 
	 * 递归算法实现：
		public int JumpFloor(int target){
		　　if(target<0)
		　　　　return 0;
		　　int[] fib={0,1,2}; 
		　　if(target<3)
		　　　　return fib[target];
		　　return JumpFloor(target-1)+JumpFloor(target-2);
		}
	 */
	/*
	 * 非递归方法
	 *
	 */
	public static int JumpFloor(int target){
		if(target<0)
		return 0;
		int[] fib={0,1,2};
		if(target<3)
		return fib[target];
		int total=0;
		int firstElem=1;
		int secondElem=2;
		for(int i=3;i<=target;i++){  
			total=firstElem+secondElem;
			firstElem=secondElem;
			secondElem=total;  //迭代
		}
		return total;
	}
}
