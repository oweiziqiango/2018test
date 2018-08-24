import java.util.Scanner;

/**
 * 平面内有n个矩形, 
 * 第i个矩形的左下角坐标为(x1[i], y1[i]), 
 * 		       右上角坐标为(x2[i], y2[i])。
	如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
	请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
输入包括五行。
第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
输入
2
0 90
0 90
100 200
100 200
	输出
	2
 * @author Administrator
 *
 */
public class test01_20180816 {
	//点计数法，重叠后的矩形左下角坐标一定是{x1[0]~x1[50], y1[0]~y1[50]}这2500个点中产生，只要分别判断这些点在多少矩形中即可
	private static int n;
    private static int[][] rec;
    private static long res = 1;
    public static void main(String[] args){
        int loop = 1;
        //System.setIn(No2.class.getResourceAsStream("2.txt"));
        Scanner scanner = new Scanner(System.in);
        //loop = scanner.nextInt();
        for (int i = 0; i < loop; ++i) {
            n = scanner.nextInt();
            rec = new int[n][4];
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < n; k++) {
                    rec[k][j] = scanner.nextInt();
                }
            }
            solve();
            output();
        }
        scanner.close();
    }
    private static void solve() {
        int x, y, count;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                x = Math.max(rec[i][0], rec[j][0]);
                y = Math.max(rec[i][1], rec[j][1]);
                count = 0;
                for (int k = 0; k < n; k++) {
                    if(x >= rec[k][0] && y >= rec[k][1] && x < rec[k][2] && y < rec[k][3])
                        ++count;
                }
                res = Math.max(count, res);
            }
        }
    }
    private static void output() {
        System.out.println(res);
    }
}
