package offer;

import java.util.Scanner;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
 * 例如 a b c e 
 *    s f c s 
 *    a d e e 
 *    这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子
 */
public class offer05 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String m = sc.nextLine();
		String[] ma = m.split(" ");
		char[] matrix = new char[ma.length];
		int i=0;
		for(String str:ma){
			matrix[i++]=str.charAt(0); 
		}
		
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		sc.nextLine();
		String strline = sc.nextLine();
		String[] stri = strline.split(" ");
		char[] str = new char[stri.length];
		i=0;
		for(String str1:stri){
			str[i++]=str1.charAt(0);
		}
		boolean hasPath = hasPath(matrix,rows,cols,str);
		
		System.out.println(hasPath);
	}
	
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	{
		if(matrix==null||rows<1||cols<1||str==null){
			return false;
		}
		
		boolean[] visited = new boolean[matrix.length];
		
		int pathLength = 0;//标识路径
		//先选定一个 开始判断 ，再判断上下左右。如果最后返回false，则再从下一个开始判断
		for(int row = 0;row < rows;++row){
			for(int col = 0;col < cols;++col){
				if(hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)){
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasPathCore(char[] matrix, int rows, int cols,
			int row, int col, char[] str, int pathLength, boolean[] visited) {
		if(pathLength>(str.length-1)){
			return true;
		}
		
		Boolean hasPath = false;
		
		if(row>=0 && row<rows && col>=0 && col<cols
		 && matrix[row*cols+col]==str[pathLength]
		 && !visited[row*cols+col]){
			pathLength++;
		
			visited[row*cols+col] = true;
			//有一个由true，hashPath值就为true
			hasPath = hasPathCore(matrix,rows,cols,row,col-1,str,pathLength,visited)
					|| hasPathCore(matrix,rows,cols,row-1,col,str,pathLength,visited)
					|| hasPathCore(matrix,rows,cols,row,col+1,str,pathLength,visited)
					|| hasPathCore(matrix,rows,cols,row+1,col,str,pathLength,visited);
			if(!hasPath){//如果返回false,退回一个，再判断
				--pathLength;
				visited[row*cols+col] = false;
			}
		}
		return hasPath;
	}
}