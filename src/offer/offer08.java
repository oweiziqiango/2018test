package offer;

import java.util.Scanner;

public class offer08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		char[] str = string.toCharArray();
		boolean isNumber = isNumeric(str);
		System.out.println(isNumber);

	}

	// 判断字符串中是否包含某个字符串
	public static boolean contains(char[] str, char ch) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ch) {
				return true;
			}
		}
		return false;
	}

	// 截取字符数组中指定[startIndex，endIndex)中的字符
	public static char[] subChars(char[] str, int startIndex, int endIndex) {
		char[] ret = new char[endIndex - startIndex];
		for (int i = startIndex; i < endIndex; i++) {
			ret[i - startIndex] = str[i];
		}
		return ret;
	}

	// 判断一个字符数组是否是纯数字
	public static boolean isDigit(char[] num) {
		for (int i = 0; i < num.length; i++) {
			if (num[i] < '0' || num[i] > '9') {
				return false;
			}
		}
		return true;
	}
	//字符数组以字符ch开头
	public static boolean starWith(char[] str, char ch) {
		if (str[0] == ch)
			return true;
		return false;
	}
	//判断是否为合法的数值（非科学记数法表示）
	public static boolean isDecimal(char[] str) {
		if (starWith(str, '-') || starWith(str, '+')) {
			str = subChars(str, 1, str.length);
		}
		if (contains(str, '.')) {// 如果是小数
			int posE = -1;
			//标记小数点的数组坐标
			for (int i = 0; i < str.length; i++) {
				if (str[i] == '.') {
					posE = i;
					break;
				}
			}
			//.123默认为0.123  123.默认为123.0 或 123
			if (posE == 0 || posE == str.length - 1) {
				return true;
			}
			//拆分整数部分和小数部分
			char[] left = new char[posE];
			char[] right = new char[str.length - posE - 1];
			left = subChars(str, 0, posE);
			right = subChars(str, posE + 1, str.length);
			//拆分之后的两部分 都是纯数字  整数  
			return isDigit(left) && isDigit(right);

		} else {// 如果不是小数
			return isDigit(str);
		}
	}
	/*
	 * boolean contains(char[] str, char ch)：判断字符串中是否包含某个字符
	 * char[] subChars(char[] str, int startIndex, int endIndex)：截取字符数组中指定[startIndex,endIndex)中的字符
	 * boolean isDigit(char[] num)：判断一个字符数组是否是纯数字  整数 不包含小数点
	 * boolean starWith(char[] str, char ch)：字符数组 是否 以字符ch开头
	 * boolean isDecimal(char[] str)：判断是否为合法的数值（非科学记数法表示）
	 */
	public static boolean isNumeric(char[] str) {
		// 如果这个数使用科学计数法表示，将数字分成两部分判断
		int posE = -1;//记录e/E的数组坐标或者标记小数点的数组坐标
		if (contains(str, 'E') || contains(str, 'e')) {
			for (int i = 0; i < str.length; i++) {
				if (str[i] == 'E' || str[i] == 'e') {
					posE = i;
					break;
				}
			}
			// 如果 'E' || 'e'在开始与结尾的位置，说明错误
			if (posE == 0 || posE == str.length - 1) {
				return false;
			}

			char[] left = new char[posE];
			char[] right = new char[str.length - posE - 1];
			left = subChars(str, 0, posE);//截取[start，end)部分的字符数组
			right = subChars(str, posE + 1, str.length);
			// left判断与非科学计数法一样

			// right判断必须为整数
			if (starWith(right, '-') || starWith(right, '+')) {
				right = subChars(right, 1, right.length);
			}
			return isDecimal(left) && isDigit(right);
		} else {
			return isDecimal(str);
		}
	}
}
