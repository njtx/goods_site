package com.nj.util;

import java.security.MessageDigest;

/*
 * ������ַ������ݽ��м���
 */
public class MD5Utils {

	public static String str2MD5(String strs) {
		/*
		 * ������Ҫʹ��JDK���ṩ����
		 */
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] bs = digest.digest(strs.getBytes());
			/*
			 * ���ܺ��������-128 �� 127 ֮������֣��������Ҳ����ȫ�� 
			 * ȡ��ÿ�������ĳЩ������λ����ĳЩ���㣬�õ�һ���µļ��ܽ��
			 * 
			 *  0000 0011 0000 0100 0010 0000 0110 0001
			 * &0000 0000 0000 0000 0000 0000 1111 1111
			 * ---------------------------------------------
			 *  0000 0000 0000 0000 0000 0000 0110 0001
			 * 
			 *  ��ȡ��������ת��ʮ��������
			 */
			for (byte b : bs) {
				int x = b & 255;
				String s = Integer.toHexString(x);
				if (x < 16) {
					sb.append("0");
				}
				sb.append(s);
			}

		} catch (Exception e) {
			System.out.println("����ʧ��");
		}
		return sb.toString();
	}
}

