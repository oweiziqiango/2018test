package wzq.test.algorithm.sorts;

import java.util.Scanner;
//插入类排序
public class InsertSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = null;
		s = sc.nextLine();
		
		String[] strs = s.split(" ");
		
		int[] seq = new int[strs.length];
		
		for(int i=0;i < strs.length;i++ ){
			seq[i]=Integer.parseInt(strs[i]);
		}
		
		insertSort(seq);//插入排序
		//sort(seq);//希尔排序
		for(int i=0;i < seq.length;i++ ){
			System.out.print(seq[i]+" ");
		}
	}
    //插入排序
	/*
	 * 第一个的值 在第一个
	 * 从第二个开始  依次和之前的比较 把比它大的后移  找到合适的位置 插入进去
	 */
	public static void insertSort(int[] seq) {
		int temp;
		//从第二个开始
		for(int i=1;i<seq.length;i++){
			temp = seq[i];
			int j=i-1;
			//依次与之前的进行比较
			while(j >= 0 && temp <= seq[j]){
				seq[j+1]=seq[j];
				j--;
			}
			seq[j+1]=temp;
		}
	}
	//希尔排序
    /*
     * 
     */
	/**
     * 希尔排序 针对有序序列在插入时采用交换法
     */
    public static void sort(int []arr){
        //增量gap，并逐步缩小增量
       for(int gap=arr.length/2;gap>0;gap/=2){
           //从第gap个元素，逐个对其所在组进行直接插入排序操作
           for(int i=gap;i<arr.length;i++){
               int j = i;
               while(j-gap>=0 && arr[j]<arr[j-gap]){
                   //插入排序采用交换法
                   swap(arr,j,j-gap);
                   j-=gap;
               }
           }
       }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     */
    public static void sort1(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        //移动法
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
    /**
     * 交换数组元素
     */
    // a 5  b 0
    // 13   49   62
    public static void swap(int []arr,int a,int b){
    	//不再开辟新的变量
//        arr[a] = arr[a]+arr[b];
//        arr[b] = arr[a]-arr[b];
//        arr[a] = arr[a]-arr[b];
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
	
}

