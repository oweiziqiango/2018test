package cn.itcast.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * TxQueryRunner 是 QueryRunner的子类 QueryRunner属于commons-beanutils
 * 
 * QueryRunner的方法： update-->用于insert update delete query-->用于select
 * batch-->用于批处理
 * 
 * 简化JDBC操作
 * 
 * @author Administrator
 * 
 */
public class TxQueryRunnerTest {
	/**
	 * 测试update(sql,params);
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception{
		String sql = "insert into t_person(pid,pname,age,sex) values(?,?,?,?)";
		Object[] params = { "0000", "zhangsan", 13, "男" };// 给定对应参数
		QueryRunner qr = new TxQueryRunner();// 不给定连接参数 
		qr.update(sql, params);// 执行SQL语句，TxQuerRunner内部使用JdbcUtils，不用操心连接池
	}
	/**
	 * 执行事务，要么完全成功，要么完全失败
	 * @throws Exception
	 */
	@Test
	public void testUpdate2() throws Exception {
		try {
			JdbcUtils.beginTransaction();
			// 多次事务操作
			String sql = "insert into t_person(pid,pname,age,sex) values(?,?,?,?)";
			Object[] params = { "8888", "zhangsan", 13, "男" };// 给定对应参数
			QueryRunner qr = new TxQueryRunner();// 不给定连接参数
			qr.update(sql, params);// 执行SQL语句，TxQuerRunner内部使用JdbcUtils，不用操心连接池
			if (true) {
				throw new Exception();
			}
			params = new Object[] { "7777", "zhangsan", 13, "男" };// 给定对应参数
			qr.update(sql, params);// 执行SQL语句，TxQuerRunner内部使用JdbcUtils，不用操心连接池

			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw e;
		}
	}
	/**
	 * 测试select
	 * @throws Exception
	 */
	
	/*
	 * query（）函数的第二个参数：
	 *  参数ResultSetHaner是一个接口，表示结果映射的类型
	 *  对应的实现类可以是BeanHandler，将ResultSet封装到Bean里面
	 *  但是属于单行操作
	 */
	@Test
	public void testQuery() throws Exception{
		String sql="select * from t_person where pid=?";
		QueryRunner qr=new TxQueryRunner();
		//数据库中的列名与Person的字段名必须一样
		Person p=qr.query(sql, new BeanHandler<Person>(Person.class),"123");
	    System.out.println(p);
	}
	/*
	 * 使用BeanlistHandler
	 * 把多行结果集映射到List<Bean>
	 * 一行结果集对应一行Bean，多行对应List<Bean>
	 */
	@Test
	public void testQuery2() throws Exception{
		String sql="select * from t_person";
		QueryRunner qr=new TxQueryRunner();
		/*
		 * BeanListHander,将ResultSet封装到List<Bean>中
		 */
		List<Person> p=qr.query(sql, new BeanListHandler<Person>(Person.class));
		System.out.println(p);
	}
	/*
	 * 使用MapHandler
	 * 把单行结果集映射到Map中
	 */
	@Test
	public void testQuery3() throws Exception{
		String sql="select * from t_person where pid=?";
		QueryRunner qr=new TxQueryRunner();
		/*
		 * Map<键，值>对应的是Map<列名,列值>
		 * 如果查询列名重复，回覆盖
		 */
		Map<String,Object> map=qr.query(sql, new MapHandler(),"123");
		System.out.println(map);
	}
	/*
	 * MapListHandler把多行结果集转为一个 List<Map> 对象的集合
	 */
	@Test
	public void testQuery4() throws Exception{
		String sql="select * from t_person";
		QueryRunner qr=new TxQueryRunner();
		/*
		 * Map<键，值>对应的是Map<列名,列值>
		 * 如果查询列名重复，回覆盖
		 */
		List<Map<String, Object>> map_list=qr.query(sql, new MapListHandler());
		System.out.println(map_list);
	}
	/*
	 * 使用ScalarHandler 将单行单列的结果集封装到Object中
	 */
	@Test
	public void testQuery5() throws Exception{
		String sql="select count(*) from t_person";
		QueryRunner qr=new TxQueryRunner();
		Object obj=qr.query(sql, new ScalarHandler());
		/*
		 * 对于count(*)结果集一定是个整数
		 * 要转换类型，常见的类型有 Integer,Long,BigInteger
		 * 不同的数据库驱动，结果不一样
		 * 无论是针对哪一种，都是Number类型,强制转换一定没错
		 */
	    Number num=(Number)obj;
	    int cnt=num.intValue();
	    System.out.println(obj);
	    System.out.println(cnt);
	}
	/*
	 * 将多个表的结果集 封装到对于的Bean中
	 * 1.将结果集封装到Map中
	 * 2.将map中部分数据封装到person中
	 * 3.将map中部分数据封装到address中
	 * 4.将person和address建立关系
	 */
	@Test
	public void testQuery6() throws Exception{
		String sql="select * from t_person p,t_address a where p.aid=a.aid and p.aid=?";
		QueryRunner qr=new TxQueryRunner();
		/*
		 * 1.将结果集封装到Map中
		 */
		Map map=qr.query(sql, new MapHandler(),"123");
		
		/*
		 * 2.将map中部分数据封装到person中
		 */
		Person p=CommonUtils.toBean(map, Person.class);
		/*
		 * 3.将map中部分数据封装到address中
		 */
		Address addr=CommonUtils.toBean(map, Address.class);
		/*
		 *  4.将person和address建立关系
		 */
		p.setAddr(addr);
		System.out.println(p);
	
	}
	
	
}
