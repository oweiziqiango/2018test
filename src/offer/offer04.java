package offer;

import java.util.Scanner;
/**
 * 2018/08/07
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * 
 * 分析;
 * 用Fib(n)表示青蛙跳上n阶台阶的跳法数，青蛙一次性跳上n阶台阶的跳法数1(n阶跳)，设定Fib(0) = 1；
       当n = 1 时， 只有一种跳法，即1阶跳：Fib(1) = 1;
       当n = 2 时， 有两种跳的方式，一阶跳和二阶跳：Fib(2) = Fib(1) + Fib(0) = 2;
       当n = 3 时，有三种跳的方式，第一次跳出一阶后，后面还有Fib(3-1)中跳法； 第一次跳出二阶后，后面还有Fib(3-2)中跳法；第一次跳出三阶后，后面还有Fib(3-3)中跳法
        Fib(3) = Fib(2) + Fib(1)+Fib(0)=4;
       当n = n 时，共有n种跳的方式，第一次跳出一阶后，后面还有Fib(n-1)中跳法； 第一次跳出二阶后，后面还有Fib(n-2)中跳法..........................第一次跳出n阶后，后面还有 Fib(n-n)中跳法.
       Fib(n) = Fib(n-1)+Fib(n-2)+Fib(n-3)+..........+Fib(n-n)=Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-1)
      又因为Fib(n-1)=Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-2)
      两式相减得：Fib(n)-Fib(n-1)=Fib(n-1) 
 *
 */
public class offer04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int sum = JumpFloorII(n);
		System.out.println(sum);
	}
	/*
	 * 这个可以用数学来解释
	F(n) = F（n-1）+F(n-2)+...+F(1)
	F(n-1) = F（n-2）+F(n-3)+...+F(1)
	两个式子相减，很容易得出F(n)=2*F(n-1)
	 */
	public static int JumpFloorII(int target) {
        int result=0;
        if(target==0)
        {
        	result=0;
        }else if(target==1)
        {
        	result=1;
        }else{
            result=2*JumpFloorII(target-1);
        }
        return result; 
    }
}
