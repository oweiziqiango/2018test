package offer;

import java.util.Scanner;

/**
 * 题目描述
	地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
	但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
	但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author Administrator
 *
 */
public class offer06 {
	public static void main(String[] args) {
		int k;
		int rows;
		int cols;
		Scanner sc  = new Scanner(System.in);
		k = sc.nextInt();
		rows = sc.nextInt();
		cols = sc.nextInt();
		int sum = movingCount(k,rows,cols);
		System.out.println(sum);
	}
	public static int movingCount(int threshold, int rows, int cols)
	{
		if(threshold<0||rows<0||cols<0)
			return 0;
		
		boolean[] visited = new boolean[rows*cols];
		//从（0,0）坐标开始移动  得到能够进入的方格数
		int count = movingCountCore(threshold, rows, cols,0,0,visited);
		
	    return count;    
	}
	//
	private static int movingCountCore(int threshold, int rows, int cols,
			int row, int col, boolean[] visited) {
		int count = 0;
		//如果该坐标能够进入  继续判断上下左右的是否能够进入
		if(check(threshold,rows,cols,row,col,visited)){
			visited[row*cols+col]= true;
			//进入的方格算一个 ，后面回溯  依次判断上下左右的坐标是否能进入
			count = 1 + movingCountCore(threshold, rows, cols, row-1, col, visited)
					+movingCountCore(threshold, rows, cols, row, col-1, visited)
					+movingCountCore(threshold, rows, cols, row+1, col, visited)
					+movingCountCore(threshold, rows, cols, row, col+1, visited);
		}
		return count;
	}
	//检查该方格 能否进入
	public static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited){
		if(row>=0 && row<rows && col>=0 && col<cols 
			&& getDigitSum(row) + getDigitSum(col)<=threshold
			&& !visited[row*cols+col])
			return true;
		return false;
	}
	//获得坐标 的位数 之和
	public static int getDigitSum(int number){
		int sum = 0;
		while(number > 0)
		{
			sum+=number%10;
			number/=10;
		}
		return sum;
	}
}
