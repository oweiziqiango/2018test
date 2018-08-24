package offer;

import java.util.Scanner;

/**
 * 2018.8.10
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * @author Administrator
 *
 */
public class offer07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strs = str.split(",");
		int[] A = new int[strs.length];
		int i = 0;
		for(String s : strs){
			A[i++] = Integer.valueOf(s);
		}
		int[] B = multiply(A);
		for(int j : B){
			System.out.print(j);
		}
	}
	public static int[] multiply(int[] A) {
		int[] B = new int[A.length];
		for(int i = 0;i < A.length;i++){
			B[i]=1;
			for(int j = 0;j < A.length;j++){
				if(j==i){
					continue;
				}
				B[i]*=A[j];
			}
		}
		return B;
    }
}
