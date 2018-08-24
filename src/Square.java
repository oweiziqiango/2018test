public class Square {  
    long width;  
    public Square(long l) {   
        width = l;  
        System.out.println(width);
    }  
    public static void main(String arg[]) {   
        Square a, b, c;  
        a = new Square(42L);   
        b = new Square(42L);   
        c = b;   
        long s = 42L;  
       // System.out.println(a==b);
        //System.out.println(s==a);
       // System.out.println(b==c);
       // System.out.println(a.equals(s));
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(s);
    } 
}