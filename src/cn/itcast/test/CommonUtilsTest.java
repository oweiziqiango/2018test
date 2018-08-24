package cn.itcast.test;

import java.util.HashMap;
import java.util.Map;

import cn.itcast.commons.CommonUtils;
import org.junit.*;
/**
 * 测试CommonUtils
 * 依赖commons-beanutils——>commons-logging
 * @author Administrator
 *
 */
public class CommonUtilsTest {
	/**
	 * 生成32位随机数
	 * 1.作为id 数据库表中的id不可重复
	 * 2.作为激活码，不可重复 
	 */
	@Test
	public void testUuid(){
		String s=CommonUtils.uuid();
		System.out.println(s);
	}
	/**
	 * map数据通过toBean封装成对于的Bean对象
	 */
	@Test
	public void testToBean(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pid","123");
		map.put("pname", "zhangsan");
		map.put("age", "23");
		Person p=CommonUtils.toBean(map, Person.class);
		System.out.println(p);
	}
}
