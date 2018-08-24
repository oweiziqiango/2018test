import java.util.Scanner;
/**
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
牛牛希望你能帮他计算一共有多少个可能的数对。
 */
public class duibi2 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        long n = scanner.nextLong();
	        long k = scanner.nextLong();
	        int count = 0; 
	        if(k==0){
	            System.out.print(n*n);
	            return ;
	        }
	        for (long y = k+1; y <= n; y++) {
	        /*把所有x可以分成若干区间，区间长度等于y值得大小，利用遍历y值 来寻找符合要求能使得余数大于k的 x的个数
	            例如：用例中n=5，k=2 那么 先确定y值可以取 3/4/5
	            首先先看y=3时：
	把所有符合题目范围但是不一定全部符合题目要求的x值罗列出来并分组： 1,2,3 | 4,5
	            可知所有x值除以y值所得的余数应为（上下对应）                           1 2 0 | 1 2 
	            可以看出在一个区间内的余数是有规律的 只是在范围内的x不一定刚好就是y的整数倍，也就是划分的区间不一定刚好
	            全部是完整的，那么可以分为两部分来计算 把完整区间的符合余数要求的x加起来，再把不是完整区间的符合余数要求的x加上来就是所需总数*/
	            count += (n/y)/*区间数*/*(y-k);//余数大于等于k但是余数一定是小于除数的；
	            //下面就是把不是完整区间的的加上，如果n除以y的余数小于k 那么最后一个区间一定没有符合要求的x 因为n值是最大的 余数还小
	            //于k,不过如果n除以y的余数大于等于k啦那么一定在最后一个区间内还有符合要求的x，
	            //而此时符合要求的个数就是n%y-（k-1）如果余数要求是大于k不是大于等于这里就是-k
	            if(n%y>=k)
	                count+=n%y-(k-1);
	        }
	        System.out.println(count);
	    }
	}