package wzq.test.algorithm.sorts;
//基数排序
public class CardinalSort {

	public static void main(String[] args) {
		int[] nums = new int[]{73,22,93,43,55,14,28,65,39,81};
		radixSort(nums, 100);//100 是不超过数组内最大数字的值
		//sort(nums);
		for(int num:nums){
			System.out.print(num+" ");
		}
	}
	/*public static void sort(int[] seq) {
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
	}*/
	/*
	 * 最低位优先
	 */
	public static void radixSort(int[] array,int d){
		int n=1;//代表位数对应的数：1,10,100...
	    int k=0;//保存每一位排序后的结果用于下一位的排序输入
	    int length=array.length;
	    int[][] bucket=new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
	    int[] order=new int[length];//用于保存每个桶里有多少个数字
	    while(n<d)
	    {
	        for(int num:array) //将数组array里的每个数字放在相应的桶里
	        {
	            int digit=(num/n)%10;
	            bucket[digit][order[digit]]=num;
	            order[digit]++;
	        }
	        for(int i=0;i<length;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
	        {
	            if(order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
	            {
	                for(int j=0;j<order[i];j++)
	                {
	                    array[k]=bucket[i][j];
	                    k++;
	                }
	            }
	            order[i]=0;//将桶里计数器置0，用于下一次位排序
	        }
	        n*=10;
	        k=0;//将k置0，用于下一轮保存位排序结果
	    }
	}
}
