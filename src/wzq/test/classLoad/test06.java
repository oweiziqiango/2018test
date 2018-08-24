package wzq.test.classLoad;

import java.io.IOException;
import java.io.InputStream;

public class test06 {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader myLoader = new ClassLoader() {
			public Class<?> loadClass(String name)
					throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1)
							+ ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}

					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		/*
		 * 运行结果： class java.lang.Class false 原因：这是虚拟机产生了两个test06类
		 * 一个是系统应用程序类加载器加载的 一个是由我们自定义的类加载器加载的
		 */
		Object obj = myLoader.loadClass("wzq.test.classLoad.test06");
		System.out.println(obj.getClass());
		System.out.println(obj instanceof wzq.test.classLoad.test06);
	}
}
