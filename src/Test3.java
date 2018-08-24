public class Test3 {
 
    	public static void main(String[] args) {
    		//f[i] = 2*f[i-3] + f[i-4] + f[i-5];
    		int[] a = new int[20 + 5];
            a[0] = 1;
            a[1] = 1;
            a[2] = 1;
            a[3] = 2;
            a[4] = 3;
            for (int i = 5; i <= 20; i++) {
                a[i] = (a[i-3] << 1) + a[i-4] + a[i-5];
                System.out.println(i + "  " + a[i]);
            }
        }
    }
