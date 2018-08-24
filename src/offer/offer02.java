package offer;

import java.util.Scanner;



/**
 * 2018/08/07
 * 大家都知道斐波那契数列，
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * @author Administrator
 *
 */
public class offer02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//n<=39
		int n = scanner.nextInt();
		int nOfFibonacci = Fibonacci(n);
		System.out.println(nOfFibonacci);
	}
	public static int Fibonacci(int n) {
		/*
		 * 一般递归
		 */
		/*if(n==1)
			return 1;
		if(n==0)
			return 0;
		return Fibonacci(n-1)+Fibonacci(n-2);*/
		int[] result = {0,1};
		if(n<2)
			return result[n];
		
		int fibMinuOne = 1;
		int fibMinuTwo = 0;
		int fibN = 0;
		for(int i =2 ;i<=n ;i++){
			fibN = fibMinuOne +  fibMinuTwo;
			fibMinuTwo = fibMinuOne;
			fibMinuOne = fibN;
		}
		return fibN;
    }
}
