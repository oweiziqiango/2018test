package offer;

import java.util.Scanner;

/**
 * 2018/08/07
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * (非递减排序)递增排序
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author Administrator
 *
 */
public class offer01 {
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 String arrStr = sc.nextLine();
		 String[] arrString = arrStr.split(" ");
		 
		 int [] arrsOfInt = new int[arrString.length];
		 int i=0;
		 for(String a:arrString){
			 arrsOfInt[i++] = Integer.valueOf(a);
		 }
		 int minNumberInRotateArray = minNumberInRotateArray(arrsOfInt);
		 System.out.println(minNumberInRotateArray);
	}
		
    public static int minNumberInRotateArray(int [] array) {
    	if(array.length==0)
    		return 0;
    	/*
    	 * 暴力比较
    	 */
    	/*int min = array[0];
    	for(int a:array){
    		if(a<min){
    			min=a;
    		}
    	}
    	return min;*/
    	/*
    	 * 利用旋转数组的特性  最小值在两个子序列的分界处
    	 * 使用二分查找
    	 */
    	//下标
    	int index1 = 0;
    	int index2 = array.length-1;
    	//int min = (end+begin)/2;
    	int min = index1;
    	while(array[index1]>=array[index2]){
    		if((index2-index1)==1){
    			min = index2;
    			break;
    		}
    		min = (index2+index1)/2;
    		if(array[min]>=array[index1]){
    			index1 = min;
    		}else if(array[min]<=array[index2]){
    			index2 = min;
    		}
    	}
    	
    	return array[min];
    }

	
}