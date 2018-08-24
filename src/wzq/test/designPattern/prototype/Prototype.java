package wzq.test.designPattern.prototype;

import java.util.ArrayList;

public class Prototype implements Cloneable {    
	public String pro = "pro";
	public ArrayList<Object> list = new ArrayList<Object>();
	
	
	protected Prototype clone(){    
	       Prototype prototype = null;    
	       try{    
	           prototype = (Prototype)super.clone();    
	       }catch(CloneNotSupportedException e){    
	           e.printStackTrace();    
	       }    
	       return prototype;     
	   } 
	
}  
