package cn.itcast.test;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Test;
import org.omg.CORBA.ExceptionList;

import cn.itcast.jdbc.JdbcUtils;

/**
 * jdbcUtils用来connection
 * 依赖于c3p0连接池  用来管理数据源
 * @author Administrator
 *
 */
public class JdbcUtilsTest {
/**
 * 底层用到了c3p0,所以需要c3p0-config.xml配置文件
 * @throws SQLException 
 */
	@Test
	public void testGetConnection() throws SQLException{
		Connection con=JdbcUtils.getConnection();
		System.out.println(con);
		JdbcUtils.releaseConnection(con);
		System.out.println(con.isClosed());
	}
	/**
	 * 还提供了与事务相关的功能  ********还需要多加了解 关于事务的概念
	 */
	@Test
	public void testTransaction(){
		try{
			//开始事务
			JdbcUtils.beginTransaction();
			//多次事务操作
			Connection c1 = JdbcUtils.getConnection();//第一次获取当前线程的事务连接对象
			Connection c2 = JdbcUtils.getConnection();//第二次获取当前线程的事务连接对象
			Assert.assertEquals(true, c1 == c2);//比较两次是否相同
			//提交事务
			JdbcUtils.commitTransaction();
		}catch(Exception e){
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
