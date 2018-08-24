import java.util.HashMap;
import java.util.Scanner;

//一般需要修改类名为Main
public class test022018815 {
	public static void main(String[] args) {
		HashMap hashMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int N,K;
		String firstLine = sc.nextLine();
		String[] str = firstLine.split(" ");
		int[] NM = new int[str.length];
		int i=0;
		for(String s:str){
			NM[i++] = Integer.parseInt(s);
		}
		N = NM[0];
		K = NM[1];
		int num = numDui(N,K);
		System.out.println(num);
	}

	private static int numDui(int n, int k) {
		//x和y均不大于n, 并且x除以y的余数大于等于k。
		int num = 0;
		for(int x = 0;x <= n ;x++){
			for(int y = 1;y <= n;y++){
				if(x%y>=k){
					num++;
				}
			}
		}
		
		return num;
	}

}
