import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;


public class duibi {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int m=sc.nextInt();
        int n=sc.nextInt();
        int [][]work=new int[m][2];
        for(int i=0;i<m;i++){
            work[i][0]=sc.nextInt();//工作难度
            work[i][1]=sc.nextInt();//钱
        }
        Arrays.sort(work,new Comparator<int[]>(){//按工作难度来排序
            @Override
            public int compare(int[] num1,int []num2){
                return num1[0]-num2[0];
            }
        });
        //dp来使相应的工作难度获利最大
        //并且把结果存入map中
        for(int i=1;i<m;i++){
            work[i][1]=Math.max(work[i-1][1],work[i][1]);
            map.put(work[i-1][0],work[i-1][1]);
        }
        map.put(work[m-1][0],work[m-1][1]);//最后一项加入（避免出现异常）
        for(int i=0;i<n;i++){//根据难度来找工作
            int dif=sc.nextInt();
            Integer index=map.floorKey(dif);
            if(index!=null)
                System.out.println(map.get(index));
            else
                System.out.println(0);
        }
        
    }              
} 
