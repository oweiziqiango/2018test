package cn.itcast.test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;

import org.junit.Test;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;


public class MailUtilsTest {
/**
 * 实现发送邮件，需要两个架包，mail.jar,activation.jar
 * 1.创建 session,即登录服务器
 * 2.创建mail对象
 *   包括 发件人，收件人，主题，正文，附件
 * 3.发送
 * @throws IOException 
 * @throws MessagingException 
 */
	@Test
	public void testSend() throws MessagingException, IOException{
		/*
		 * 使用mailutils小工具
		 * creatSession（“smtp服务器地址”，“用户名”，“邮箱的第三方授权登录密码（不是登录密码）”）；
		 */
		Session session=MailUtils.createSession("smtp.yeah.net", "ziqiang_wei", "wzq123");
		/*
		 * 创建mail对象，（发送人，接受人，标题，正文）
		 */
		Mail mail=new Mail("ziqiang_wei@yeah.net","757285480@qq.com","测试邮件发送","<a href='http://www.baidu.com'>百度</a>");
		/*
		 * 发送时，需要session和mail对象
		 */
		MailUtils.send(session, mail);
	}
}
