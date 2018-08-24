package wzq.test.designPattern.prototype;

public class Client {
	  /*public static void main(String[] args) {
        //原型A对象
       // Resume a = new Resume("小李子");
    	Person p = new Person("小李子");
    	//a.setpName(p);
    	Resume a = new Resume(p,"2.16", "男", "XX大学");
    	
        //a.setPersonInfo();
        a.setWorkExperience("2012.09.05", "XX科技有限公司");
        
        //克隆B对象
        Resume b = (Resume) a.clone();
        
        //输出A和B对象
        System.out.println("----------------A--------------");
        a.display();
        System.out.println("----------------B--------------");
        b.display();
        
        
         * 测试A==B?
         * 对任何的对象x，都有x.clone() !=x，即克隆对象与原对象不是同一个对象
         
        System.out.print("A==B?");
        System.out.println( a == b);
        
        
         * 对任何的对象x，都有x.clone().getClass()==x.getClass()，即克隆对象与原对象的类型一样。
         
        System.out.print("A.getClass()==B.getClass()?");
        System.out.println(a.getClass() == b.getClass());
        
        System.out.print("b.equals(a)?");
        System.out.println(b.equals(a));
    }*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcretePrototype cp1 = new ConcretePrototype();
		cp1.list.add(10);
		ConcretePrototype cp3 = (ConcretePrototype) cp1.clone();
		System.out.println("使用clone方法将cp1克隆给cp3");
		System.out.println("cp3操作前"+"\n"+"cp1: "+cp1.pro+","+cp1.Conpro);
		cp3.pro = "pro改变了";cp3.Conpro = "Compro改变了";
		System.out.println("对cp3操作后");
		System.out.println("cp1: "+cp1.pro+","+cp1.Conpro+"\n\n");
		ConcretePrototype cp2 = cp1;
		System.out.println("不使用clone方法直接将cp1赋值给cp2");
		System.out.println("cp2操作前"+"\n"+"cp1: "+cp1.pro+","+cp1.Conpro);
		cp2.pro = "pro改变了";cp2.Conpro = "Compro改变了";
		System.out.println("对cp2操作后");
		System.out.println("cp1: "+cp1.pro+","+cp1.Conpro);
	
	}
}