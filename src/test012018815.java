import java.util.HashMap;
import java.util.Scanner;

//一般需要修改类名为Main
public class test012018815 {
	public static void main(String[] args) {
		HashMap hashMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int N,M;
		String firstLine = sc.nextLine();
		String[] str = firstLine.split(" ");
		int[] NM = new int[str.length];
		int i=0;
		for(String s:str){
			NM[i++] = Integer.parseInt(s);
		}
		N = NM[0];//工作的数量
		M = NM[1];//小伙伴的数量
		
		int[] Di = new int[N];//工作的难度
		int[] Pi = new int[N];//报酬
		for(i=0;i<N;i++){
			String nLine = sc.nextLine();
			str = nLine.split(" ");
			int j=0;
			int[] temp = new int[2];
			for(String s:str){
				temp[j++] = Integer.parseInt(s);
			}
			Di[i] = temp[0];
			Pi[i] = temp[1];
		}
		
		String mLine = sc.nextLine();
		str = mLine.split(" ");
		int j=0;
		int[] Ai = new int[M];//小伙伴的能力值
		for(String s:str){
			Ai[j++] = Integer.parseInt(s);
		}
		printMaxPi(N,M,Di,Pi,Ai);
		
	}

	public static void printMaxPi(int n, int m, int[] Di, int[] Pi, int[] Ai) {
		for(int i = 0 ; i < m;i++){
			int maxPi = 0;
			for(int j = 0;j < n;j++){
				if(Ai[i] >= Di[j] && maxPi < Pi[j]){
					maxPi = Pi[j];
				}
			}
			System.out.println(maxPi);
		}
	}
}
