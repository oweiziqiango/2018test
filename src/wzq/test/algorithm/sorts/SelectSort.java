package wzq.test.algorithm.sorts;

import java.util.Scanner;
//选择类排序
public class SelectSort {
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
   	 sort(seq);
   	 //heapSort(seq);
   	 for(int i : seq){
   		 System.out.print(i+" ");
   	 }
    }
	//选择排序
	/*
	 * 从前向后查找到比第一个小的  记录 下标信息
	 * 将最小的值和第一个交换
	 * 再从第二个开始 循环 依次
	 * 
	 */
	public static void sort(int[] seq) {
		int temp;
		
		for(int j = 0;j < seq.length;j++)
		{
			int k = j;
			for(int i = j+1;i< seq.length;i++)
			{
				if(seq[k] > seq[i])
				{
					k=i;
				}
			}
			temp = seq[k];
			seq[k] = seq[j];
			seq[j] = temp;
		}
	}
	//堆排序
	public static void heapSort(int[] arr){
		
		//一开始调整 原始堆  使其成为大堆顶
		//arr.length/2-1   是自下向上  自右向左   第一个非叶子节点
		for(int j = arr.length/2-1;j >= 0;j--){
			adjust(arr,j,arr.length);//从第一个非叶子节点开始 调整
		}
		//循环
		//交换 堆定元素和最后一个元素
		//再调整  
		for(int i = arr.length-1;i > 0;i--){
			swap(arr, 0, i);//交换 堆定元素和最后一个元素
			adjust(arr, 0, i);//交换之后  堆顶元素不满足 大顶堆  调整堆顶元素
		}
		
	}
	//调整 大堆顶   自下向上   自右向左
	// k = 2*i+1  i的左孩子
	// k+1  i的右孩子
	public static void adjust(int[] arr,int i,int length){
		int temp = arr[i];//因为可能要多次调整 先保存到temp  
		for(int k = 2*i+1;k < length;k = 2*i+1)
		{
			if(k+1<length && arr[k]<arr[k+1]){//左右孩子相比较 选择较大的
				k++;
			}
			if(arr[k]>temp){
				arr[i] = arr[k];
				i = k;
			}else{
				break;//如果左右孩子都不大于  父节点值  结束循环  不调整
			}
		}
		arr[i]=temp; //确定将temp  放入调整后的位置
	}
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
