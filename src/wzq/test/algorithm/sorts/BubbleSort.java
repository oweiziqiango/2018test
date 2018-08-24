package wzq.test.algorithm.sorts;

import java.util.*;
//交换类排序
public class BubbleSort {
     public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 String s = null;
    	 s = sc.nextLine();
    	 String[] str = s.split(" ");
    	 int n = str.length;
    	 int[] seq = new int[n];
    	 for(int i=0;i < n;i++){
    		 seq[i]=Integer.parseInt(str[i]);
    	 }
    	 //sort(seq); //冒泡排序
    	quickSort(seq,0,seq.length-1);//快速排序
    	 for(int i : seq){
    		 System.out.print(i+" ");
    	 }
     }
     //冒泡排序
      /*
       * 属于交换排序
       * 即依次两两对比，大交换到后面
       */
	 public static void sort(int[] seq) {
		//每次排序的比较的次数
		for(int i=seq.length-1;i>1;i--){
			 int flag = 0;
			 for(int j = 0;j < i;j++){
				 int temp;
				 if(seq[j]>seq[j+1]){
					 temp = seq[j];
					 seq[j] = seq[j+1];
					 seq[j+1] = temp;
					 flag = 1;
				 }
			 }
			 //两两对比之后，如果没有交换，说明已经有序 直接return
			 if(flag == 0){
				 return;
			 }
		 }
	}
	 //快速排序
	 /*
	  * 属于交换排序
	  * 一般指定第一个为 temp 或叫 标兵
	  * 先从后面向前找小的  交换 
	  * 再从前面向后找大的 交换
	  * 当i==j 把temp 放入对应位置
	  * 
	  * 左右两边 再分别 递归 进行快速排序   
	  */
	 public static void quickSort(int[] seq,int l,int r){
		 int temp;
		 int i = l,j = r;//原始是从l =0 ,r= seq.length-1
		 if(l<r){
			 temp = seq[l];
			 //开始遍历
			 while(i!=j)
			 {
				 //从最右边  向前遍历  找到比temp小的位置
 				 while(i<j && seq[j]>temp)
					 --j;
				 if(i<j){
					 seq[i] = seq[j];
					 i++;
				 }
				 //从最左边 向后遍历  找到比temp大的位置
				 while(i<j && seq[i]<temp)
					 i++;
				 if(i<j){
					 seq[j]=seq[i];
					 --j;
				 }
			 }//while
			 //将temp放到i==j的位置
			 seq[i] = temp;
			 quickSort(seq, l, i-1); //递归地  对temp 左边 进行排序
			 quickSort(seq, i+1, r); //递归地  对temp 右边 进行排序
		 }//if(l<r)
	 }
}
