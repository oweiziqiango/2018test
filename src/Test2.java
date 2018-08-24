public class Test2 {
 
    	public static void main(String[] args) {
    	    //String str = "0";
    		String str = null;//为null的话   会报异常
    		str.concat("abc");
    	    str.concat("123");
    	    System.out.println(str);
    	}
    }
